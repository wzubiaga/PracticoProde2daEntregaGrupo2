import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
public class ImportadorDeResultados {

    public static Torneo GetResultadosFromFile(String fileName, Liga equiposParticipantes)throws IOException {

        Path archivoResultado = Paths.get(fileName);
        Scanner lector = new Scanner(archivoResultado);
        lector.useDelimiter("[;\r\n]+");
        Torneo t = new Torneo();
        //nroLinea lo uso como id de partido
        int nroLinea = 1;
        while (lector.hasNext()) {

            //aca validar que los datos vengan bien

            int nroRonda = lector.nextInt();
            String A = lector.next();
            String B = lector.next();
            int golesA = lector.nextInt();
            int golesB = lector.nextInt();

           Partido nuevo = new Partido(nroLinea, equiposParticipantes.getEquipoParticipante(A), equiposParticipantes.getEquipoParticipante(B), golesA, golesB);
           Ronda r = t.existeRonda(nroRonda);
           if (r !=null) {
               r.agregarPartido(nuevo);
           }else{
               Ronda nuevaRonda= new Ronda(nroRonda);
               nuevaRonda.agregarPartido(nuevo);
               t.agregarRonda(nuevaRonda);
            }
              nroLinea++;
        }
        lector.close();
        return t;
    }



   public static Prode GetPronosticoFromFile(String fileName, Liga equiposParticipantes, Torneo t)throws IOException {
        Path archivoPronostico = Paths.get(fileName);
        Scanner lector = new Scanner(archivoPronostico);
        lector.useDelimiter("[;\r\n]+");
        Prode juego = new Prode();
        while (lector.hasNext()) {
            String j = lector.next();
            int dni = lector.nextInt();
            String A = lector.next();
            String ganaA = lector.next();
            String empate = lector.next();
            String ganaB = lector.next();
            String B = lector.next();

            Partido partido = t.BuscarEnfrentamiento(equiposParticipantes.getEquipoParticipante(A), equiposParticipantes.getEquipoParticipante(B));
            if (Objects.equals(partido, null)) {
                lector.close();
                //inventigar si esta bien salir asi de la funcion
                return null;
            }
            Pronostico nuevo = new Pronostico(partido, equiposParticipantes.getEquipoParticipante(A), ganaA, empate, ganaB, equiposParticipantes.getEquipoParticipante(B));

            Participante jugador = juego.existeParticipante(j, dni);
            if (jugador != null) {
                jugador.agregarPronostico(nuevo);
            } else {
                jugador = new Participante(j, dni);
                jugador.agregarPronostico(nuevo);
                juego.agregarParticipante(jugador);
            }
        }
        lector.close();
        return juego;
    }

}
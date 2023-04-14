import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ImportadorDeResultados {

    public static Torneo GetResultadosFromFile(String fileName, Liga equiposParticipantes)throws IOException {
        Torneo t = new Torneo();
        try {
            Path archivoResultado = Paths.get(fileName);
            Scanner lector = new Scanner(archivoResultado);
            lector.useLocale(Locale.forLanguageTag("es-AR"));
            lector.useDelimiter("[;\r\n]+");
            //nroLinea lo uso como id de partido
            int nroLinea = 1;
            while (lector.hasNext()) {
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
        catch (InputMismatchException e) {
            System.out.println("Error en el formato del archivo resultados.csv");
            return null;
        }
    }

    public static Prode GetPronosticoFromFile(String fileName, Liga equiposParticipantes, Torneo t)throws IOException {
        Prode juego = new Prode();
        try {
            Path archivoPronostico = Paths.get(fileName);
            Scanner lector = new Scanner(archivoPronostico);
            lector.useLocale(Locale.forLanguageTag("es-AR"));
            lector.useDelimiter("[;\r\n]+");
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
                    System.out.println("Se cargo una incongruencia en el archivo pronostico, esos equipo no se enfrentaron en la Liga");
                    return null;
                }

                Pronostico nuevo = new Pronostico(partido, equiposParticipantes.getEquipoParticipante(A), (ganaA == "x"), (empate == "x"), (ganaB == "x"), equiposParticipantes.getEquipoParticipante(B));
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
       catch (InputMismatchException e) {
            System.out.println("Error en el formato del archivo pronostico.csv");
            return  null;
        }
    }

}
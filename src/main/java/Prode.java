//Clase que guarda a todos los Participantes(jugadores)
import java.util.ArrayList;

public class Prode {
    private ArrayList<Participante> listaParticipantes;

    public Prode() {
        this.listaParticipantes = new ArrayList<>();
    }

    public void  agregarParticipante(Participante p){
        listaParticipantes.add(p);
    }

    public Participante existeParticipante (String nombreyApellido,int dni ){
        for (Participante j : listaParticipantes) {
            if((j.getDocumento()==dni)&&(nombreyApellido.equals(j.getApellidoYNombre()))) {
                return  j;
            }
        }
        return null;
    }

    public boolean isEmpty(){
        return (this.listaParticipantes.size()==0);
    }

    //Imprime por pantalla el nombre de cada persona, el puntaje total y la cantidad dep ronósticos acertados.
    public String imprimirResultados(Torneo t){
        String resultado = "| Participante | Cant. Pronósticos Acertados | Puntos Extra Ronda | Puntos Extra Fase | Puntaje Total | \n";
        for(Participante p : listaParticipantes){
            resultado +=  String.format("| %-12s | %-27d | %-18d | %-17d | %-13d | \n",
                          p.getApellidoYNombre(),p.pronosticosAcertados(),p.puntosExtraPorRonda(t),p.puntosExtraPorFase(t),p.puntosObtenidos(t) );
        }
        return  resultado;
    }

    public String ImprimirGanadores(Torneo t){
        Participante mayor = null;
        for(Participante p : listaParticipantes){
            if (mayor==null || p.puntosObtenidos(t)> mayor.puntosObtenidos(t)) {
            mayor=p;
            }
        }
        String resultado = "| Nombre y Apellido | Documento | Puntos Obtenidos | \n";
        for(Participante p : listaParticipantes){
            if (p.puntosObtenidos(t) == mayor.puntosObtenidos(t)) {
                resultado +=  String.format("| %-17s | %-9d | %-16d |\n",
                              p.getApellidoYNombre(),p.getDocumento(),p.puntosObtenidos(t));
            }
        }
        return resultado;
    }
}

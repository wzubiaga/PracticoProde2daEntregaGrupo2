//Clase que guarda a todos los Participantes(jugadores)
import java.util.ArrayList;

public class Prode {
    private int PuntosPorAciertoRonda;
    private int PuntosPorAciertoFase;
    private int PuntosPorAciertoPronostico;

    private ArrayList<Participante> listaParticipantes;

    public Prode(int PuntosPorAciertoPronostico,int PuntosPorAciertoRonda,int PuntosPorAciertoFase) {
        this.PuntosPorAciertoPronostico = PuntosPorAciertoPronostico;
        this.PuntosPorAciertoRonda = PuntosPorAciertoRonda;
        this.PuntosPorAciertoFase = PuntosPorAciertoFase;

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

    public int GetPuntosPorAciertoPronostico(){return PuntosPorAciertoPronostico;}

    //Imprime por pantalla el nombre de cada persona, el puntaje total y la cantidad de pronósticos acertados.
    public String imprimirResultados(Torneo t){
        StringBuilder resultado = new StringBuilder("| Participante | Cant. Pronósticos Acertados | Puntos Extra Ronda | Puntos Extra Fase | Puntaje Total | \n");
        for(Participante p : listaParticipantes){
            resultado.append(String.format("| %-12s | %-27d | %-18d | %-17d | %-13d | \n",
                    p.getApellidoYNombre(),
                    p.pronosticosAcertados(PuntosPorAciertoPronostico),
                    p.puntosExtraPorRonda(t,PuntosPorAciertoRonda,PuntosPorAciertoPronostico),
                    p.puntosExtraPorFase(t,PuntosPorAciertoFase,PuntosPorAciertoPronostico),
                    (p.puntosObtenidos(t)+p.puntosExtraPorRonda(t,PuntosPorAciertoRonda,PuntosPorAciertoPronostico))+p.puntosExtraPorFase(t,PuntosPorAciertoFase,PuntosPorAciertoPronostico)));
        }
        return resultado.toString();
    }

    //Imprime por pantalla al primer ganador que encuentra en la lista de participantes
    public String ImprimirGanador(Torneo t){
        StringBuilder resultado = new StringBuilder("| Nombre y Apellido | Documento | Puntos Obtenidos | \n");
        Participante mayor = null;
        for(Participante p : listaParticipantes){
            if (mayor==null || p.puntosObtenidos(t)> mayor.puntosObtenidos(t)) mayor=p;
        }
        if (mayor!=null) {
            resultado.append(String.format("| %-17s | %-9d | %-16d |\n",
                mayor.getApellidoYNombre(), mayor.getDocumento(), mayor.puntosObtenidos(t)));
        }

        return resultado.toString();
    }

    //Imprime por pantalla TODOS los ganadores que encuentra en la lista de participantes
    public String ImprimirGanadores(Torneo t){
        StringBuilder resultado = new StringBuilder("| Nombre y Apellido | Documento | Puntos Obtenidos | \n");
        Participante mayor = null;
        for(Participante p : listaParticipantes){
            if (mayor==null || p.puntosObtenidos(t)> mayor.puntosObtenidos(t)) mayor=p;
        }
        if (mayor!=null) {
            for (Participante p : listaParticipantes) {
                if (p.puntosObtenidos(t) == mayor.puntosObtenidos(t)) {
                    resultado.append(String.format("| %-17s | %-9d | %-16d |\n",
                            p.getApellidoYNombre(), p.getDocumento(), p.puntosObtenidos(t)));
                }
            }
        }
        return resultado.toString();
    }

}

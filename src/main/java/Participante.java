//Clase que guarda un participante con su lista de pronosticos/apuestas
import java.util.ArrayList;

public class Participante {


    private String apellidoYNombre;
    private int documento;
    private ArrayList<Pronostico> pronosticosJugador;

    public Participante(String apellidoYNombre,int documento) {
        this.documento = documento;
        this.apellidoYNombre = apellidoYNombre;
        this.pronosticosJugador = new ArrayList<>();
    }

    public String getApellidoYNombre() {
        return apellidoYNombre;
    }

    public int getDocumento() {
        return documento;
    }

    public void agregarPronostico(Pronostico p){
        pronosticosJugador.add(p);
    }

    public ArrayList<Pronostico> getPronosticosJugador(){
        return  this.pronosticosJugador;
    }

    public int puntosObtenidos(Torneo t){
        int acumular = 0;
        int valor;
        for(Pronostico p : pronosticosJugador){
            valor   = p.getPuntos();
            acumular += valor;
        }
        return acumular; //+puntosExtraPorRonda(t)+puntosExtraPorFase(t);
    }
    public int pronosticosAcertados(int PuntosPorAciertoPronostico){
        int acumular = 0;
        for(Pronostico p : pronosticosJugador){
            if (p.getPuntos()==PuntosPorAciertoPronostico)
                acumular += 1;
        }
        return acumular;
    }

    public Pronostico exitePartido(Partido p){
        for (Pronostico pro: pronosticosJugador){
            if (pro.getPartido().equals(p))
                return pro;
        }
        return null;
    }

    //● Se suman puntos extra cuando se aciertan todos los resultados de una ronda
    public int puntosExtraPorRonda(Torneo t,int PuntosPorAciertoRonda, int PuntosPorAcierto ){
        int valor = 0;
        for (Ronda ron : t.getCampeonato()){
            if (ron.aciertaRonda(this , PuntosPorAcierto))
                valor += PuntosPorAciertoRonda;
       }
        return valor;
    }

    //● Se suman puntos extra cuando se aciertan todos los resultados de una fase
    public int puntosExtraPorFase(Torneo t,int PuntosPorAciertoFase, int PuntosPorAcierto){
        int valor = 0;
        if (t.aciertaFase(this,PuntosPorAcierto))
                valor = PuntosPorAciertoFase;
        return valor;
    }

}

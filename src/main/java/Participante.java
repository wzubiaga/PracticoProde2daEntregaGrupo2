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

    public int puntosObtenidos(){
        int acumular = 0;
        int valor = 0;
        for(Pronostico p : pronosticosJugador){
            valor   = p.getPuntos();
            acumular += valor;
        }
        return acumular;
    }
    public int pronosticosAcertados(){
        int acumular = 0;
        for(Pronostico p : pronosticosJugador){
            if (p.getPuntos()==p.PuntosPorAcierto)
                acumular += 1;
        }
        return acumular;
    }
}

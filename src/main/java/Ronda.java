//Clase que guarda una lista de partidos que hay un una ronda/fecha
import java.util.ArrayList;

public class Ronda {
    private int nro;
    private ArrayList<Partido> listaPartidos;

    public Ronda(int nro) {
        this.nro = nro;
        listaPartidos = new ArrayList<>();
    }

    public int getNro() {
        return nro;
    }

    public ArrayList<Partido> getListaPartidos() {
        return listaPartidos;
    }

    public Partido BuscarEnfrentamiento(Equipo a, Equipo b){
       for (Partido p: listaPartidos)
            {if(((p.getEquipo1().equals(a))&&(p.getEquipo2().equals(b))) || ((p.getEquipo1().equals(b))&&(p.getEquipo2().equals(a)))){
                return p;
                }
            }
        return  null;
    }
    public void agregarPartido(Partido p){
        this.listaPartidos.add(p);
 }
    public String imprimirResultado(){
        StringBuilder resultado = new StringBuilder();
        for (Partido p : listaPartidos) {
            resultado.append(p.imprimirResultado()).append("\n");
        }
    return resultado.toString();
    }

    public boolean aciertaRonda(Participante p, int PuntosPorAciertoPronostico){
        for (Partido partidoEnRonda :listaPartidos){
           if (p.exitePartido(partidoEnRonda).getPuntos()!=PuntosPorAciertoPronostico){
               return false;
           }
        }
        return true;
    }
}

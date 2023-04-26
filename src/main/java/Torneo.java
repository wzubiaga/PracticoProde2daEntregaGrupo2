//Clase que guarda todas las rondas/fechas del Torneo/Campeonato
import java.util.ArrayList;

public class Torneo {

    private ArrayList<Ronda> campeonato;

    public Torneo(){
        this.campeonato = new ArrayList<>();
    }
    public boolean isEmpty(){
        return (this.campeonato.size()==0);
    }
    public String imprimirResultado(){
        StringBuilder resultado = new StringBuilder();
        for (Ronda r : campeonato) {
            resultado.append("Ronda Nro: ").append(r.getNro()).append("\n").append(r.imprimirResultado()).append("\n");
        }
    return resultado.toString();
    }
    public Ronda existeRonda (int nroRonda){
        for (Ronda r : campeonato) {
          if (r.getNro()==nroRonda)
              return  r;
        }
        return null;
    }
    public void agregarRonda(Ronda r){
        campeonato.add(r);
    }
    public Partido BuscarEnfrentamiento(Equipo a, Equipo b){
        for (Ronda r: campeonato)
        { Partido p = r.BuscarEnfrentamiento(a,b);
            if (p!=null){
            return p;
        }
        }
        return  null;
    }
    public Boolean aciertaFase(Participante p, int PuntosPorAcierto){
        for (Ronda r : campeonato) {
            if (r.aciertaRonda(p,PuntosPorAcierto)==false){
                return false;
            }
        }
        return  true;
    }
    public ArrayList<Ronda> getCampeonato(){
        return  this.campeonato;
    }

}


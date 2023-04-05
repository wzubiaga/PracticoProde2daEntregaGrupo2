//Clase que guarda todas las rondas/fechas del Torneo/Campeonato
import java.util.ArrayList;

public class Torneo {

    private ArrayList<Ronda> campeonato;


   // public Torneo(ArrayList<Ronda> campeonato) {        this.campeonato = campeonato;    }

    public Torneo(){
        this.campeonato = new ArrayList<>();
    }
    public boolean isEmpty(){
        return (this.campeonato.size()==0);
    }

    public String imprimirResultado(){
        String resultado = "";
        for (Ronda r : campeonato) {
            resultado += "Ronda Nro: "+ r.getNro()+ "\n" +r.imprimirResultado() + "\n";
        }
    return  resultado;
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
}

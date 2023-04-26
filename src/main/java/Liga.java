import java.util.HashMap;

public class Liga {
    private  HashMap<String,Equipo> equiposParticipantes;

    public Liga() {
        equiposParticipantes = new HashMap<>();
    }

    public void agregarEquipo(Equipo e) {
        equiposParticipantes.put(e.getNombre(), e);
    }

    public Equipo getEquipoParticipante(String nombre){
        return equiposParticipantes.get(nombre);
    }

}

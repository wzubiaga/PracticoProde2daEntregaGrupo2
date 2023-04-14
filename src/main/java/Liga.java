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

    public static Liga getLiga(){
        Liga equiposEnLiga = new Liga();

        Equipo a = new Equipo(1, "Argentina", " ");
        Equipo b = new Equipo(2, "Arabia Saudita", " ");
        Equipo c = new Equipo(3, "Polonia", " ");
        Equipo d = new Equipo(4, "México", " ");

        equiposEnLiga.agregarEquipo(a);
        equiposEnLiga.agregarEquipo(b);
        equiposEnLiga.agregarEquipo(c);
        equiposEnLiga.agregarEquipo(d);

        return equiposEnLiga;

    }
}

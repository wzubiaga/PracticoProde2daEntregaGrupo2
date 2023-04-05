//Clase que guarda a todos los Participantes(jugadores)
import java.util.ArrayList;
public class Prode {
/// se podria hacer hashmap con participante con clave nombre
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

    public String imprimirResultados(){
        //Imprimir por pantalla el nombre de cada persona, el puntaje total y la cantidad de
        //pronósticos acertados.
        String resultado = "";
        for(Participante p : listaParticipantes){
            resultado += "Participante: "+ p.getApellidoYNombre()+"\n"+"Puntaje total:" +p.puntosObtenidos() + " Cantidad de pronósticos acertados:"+p.pronosticosAcertados()+"\n";
        }
        return  resultado;
    }

}

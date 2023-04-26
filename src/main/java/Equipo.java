public class Equipo {

    private int id;
    private String nombre;
    private String descripcion;

    public Equipo(int id,String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public int getID() {return id;}
    public String getNombre() { return nombre; }
    public String getDescripcion() {return descripcion; }
    public boolean equals(Equipo e) {
        return (e.getID() == this.getID()) && (e.getNombre().equals(this.getNombre())) && (e.getDescripcion().equals(this.getDescripcion()));
    }

}

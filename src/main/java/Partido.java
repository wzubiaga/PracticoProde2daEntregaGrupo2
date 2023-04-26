public class Partido {
    private int id;
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;

    public Partido(int id,Equipo a, Equipo b,int golesA, int golesB) {
        this.id = id;
        this.golesEquipo1 = golesA;
        this.golesEquipo2 = golesB;
        this.equipo1 = a;
        this.equipo2 = b;
    }
    public int getId(){return id;}
    public Equipo getEquipo1(){return equipo1;}
    public Equipo getEquipo2(){return equipo2;}
    public  int getGolesEquipo1(){return golesEquipo1;}
    public  int getGolesEquipo2(){return golesEquipo2;}

    public ResultadoEnum Resultado (Equipo equipoApostado){
        int golesEquipoApostado = 0;
        int golesEquipoRival = 0;
        if (equipoApostado.equals(this.equipo1)){
            golesEquipoApostado=this.golesEquipo1;
            golesEquipoRival=this.golesEquipo2;
            }
        else
            if (equipoApostado.equals(equipo2)){
                golesEquipoRival=this.golesEquipo1;
                golesEquipoApostado=this.golesEquipo2;
            }
            else
                System.out.println("El Equipo ingresado no jugo en este partido.");

        if (golesEquipoApostado > golesEquipoRival)
            return  ResultadoEnum.ganador;
            else
                if (golesEquipoApostado < golesEquipoRival)
                    return ResultadoEnum.perdedor;
                else
                    // (golesEquipoApostado = golesEquipoRival)
                    return ResultadoEnum.empate;

   }

    public String imprimirResultado(){
        return  String.format("| %-15s [ %d ] %s [ %d ] %-15s |",
                equipo1.getNombre(),  golesEquipo1, "Vs.", golesEquipo2,equipo2.getNombre());
    }

}

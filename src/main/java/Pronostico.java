//Clase que guarda el pronostico de un jugador para un partido
//en esta clase el jugador toma a un equipo y apuesta si gana o empata
//la apuesta pierde el equipaA se toma como apuesta gana equipoB
public class Pronostico {
    private  int PuntosPorAcierto;
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultadoEnum;
    private int puntos=0;

    public Pronostico(Partido partido, Equipo equipo1,Boolean ganaA,Boolean empate,Boolean ganaB,Equipo equipo2,int PuntosPorAcierto) {
      this.PuntosPorAcierto = PuntosPorAcierto;
      this.partido = partido;
      if (ganaB.equals(false)) {
          this.equipo  =equipo1;
            if (ganaA.equals(false)&&empate) { //el &&empate estaria de mas solo se puso para sacar el warning de variable no usada
                this.resultadoEnum = ResultadoEnum.empate;
            }else {this.resultadoEnum = ResultadoEnum.ganador;}
        }else{
            this.equipo = equipo2;
            this.resultadoEnum = ResultadoEnum.ganador;
        }
        int valor = partido.getGolesEquipo1()- partido.getGolesEquipo2();
        if (valor >0) {
            //gano equipo1
            if ((this.equipo.equals(equipo1))&&(this.resultadoEnum.equals(ResultadoEnum.ganador))){
                this.puntos = PuntosPorAcierto;
            }

        }else{
            if (valor <0) {
                //gano equipo2
                if ((this.equipo.equals(equipo2))&&(this.resultadoEnum.equals(ResultadoEnum.ganador))){
                    this.puntos = PuntosPorAcierto;
                }
            }else{
                //empate
                if (this.resultadoEnum.equals(ResultadoEnum.empate)){
                    this.puntos = PuntosPorAcierto;
                }
            }
        }
    }

    public Partido getPartido(){
        return partido;
    }

    public Equipo getEquipo() { return equipo; }

    public ResultadoEnum getResultadoEnum() { return resultadoEnum; }

    public int getPuntos() { return puntos; }

    public int PuntosPorAcierto(){return PuntosPorAcierto;}

}

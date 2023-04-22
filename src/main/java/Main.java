public class Main {
    public static void main(String[] args) {

        //Liga equiposParticipantes = ImportadorDeResultados.GetEquiposParticipantes("src/main/resources/equipos.csv");
        Liga equiposParticipantes = ImportadorDeResultadosBD.GetEquiposParticipantes();

       //Torneo importarR = ImportadorDeResultados.GetResultadosFromFile("src/main/resources/resultados.csv", equiposParticipantes);
        Torneo torneo = ImportadorDeResultadosBD.GetResultadosFromBD(equiposParticipantes);

       if (torneo == null) return;
       if (torneo.isEmpty()) {
           System.out.println("No se encontraron Resultados.");
       } else {
           System.out.println("Resultado de la Liga: " + "\n" + torneo.imprimirResultado());
           System.out.println("----------------------");
       }

    // Prode importarProde = ImportadorDeResultados.GetPronosticoFromFile("src/main/resources/pronostico.csv", equiposParticipantes, importarR);
       Prode importarProde = ImportadorDeResultadosBD.GetPronosticoFromBD( equiposParticipantes, torneo);
       if (importarProde == null) return;
       if (importarProde.isEmpty()) {
           System.out.println("No se encontraron Pronosticos.");
       } else {
           System.out.println("Pronosticos de los Participantes:" + "\n" + importarProde.imprimirResultados(torneo));
           System.out.println("El Ganador: " + "\n" + importarProde.ImprimirGanadores(torneo));
       }
    }
}

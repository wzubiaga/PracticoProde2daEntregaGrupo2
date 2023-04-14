import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        Liga equiposParticipantes = Liga.getLiga();

       //Torneo importarR = ImportadorDeResultados.GetResultadosFromFile("src/main/resources/resultados.csv", equiposParticipantes);
        Torneo importarR = ImportadorDeResultadosBD.GetResultadosFromBD(equiposParticipantes);

       if (importarR == null) return;
       if (importarR.isEmpty()) {
           System.out.println("No se encontraron Resultados.");
       } else {
           System.out.println("Resultado de la Liga: " + "\n" + importarR.imprimirResultado());
           System.out.println("----------------------");
       }

       //Prode importarP = ImportadorDeResultados.GetPronosticoFromFile("src/main/resources/pronostico.csv", equiposParticipantes, importarR);
       Prode importarP = ImportadorDeResultadosBD.GetPronosticoFromBD( equiposParticipantes, importarR);
       if (importarP == null) return;
       if (importarP.isEmpty()) {
           System.out.println("No se encontraron Pronosticos.");
       } else {
           System.out.println("Pronosticos de los Participantes:" + "\n" + importarP.imprimirResultados());
       }
    }
}

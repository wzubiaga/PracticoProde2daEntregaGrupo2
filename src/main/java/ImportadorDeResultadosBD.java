import java.sql.*;
import java.util.Objects;

public class ImportadorDeResultadosBD {

    public static Liga GetEquiposParticipantes(){
        Liga l = new Liga();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prode", "root", "");
            Statement st = conn.createStatement();
            ResultSet rs =  st.executeQuery("select * from equipo");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");

                Equipo nuevoEquipo = new Equipo(id, nombre, descripcion);
                l.agregarEquipo(nuevoEquipo);
            }
            rs.close();
            conn.close();
            return l;
        } catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public static Torneo GetResultadosFromBD(Liga equiposParticipantes){
        Torneo t = new Torneo();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prode", "root", "");
            Statement st = conn.createStatement();
            ResultSet rs =  st.executeQuery("select * from torneo");
            int nroLinea = 1;
            while (rs.next()) {
                int nroRonda = rs.getInt("nroRonda");
                String A = rs.getString("nombreEquipoA");
                String B  = rs.getString("nombreEquipoB");
                int golesA= rs.getInt("nroGolesA");
                int golesB = rs.getInt("nroGolesB");
                Partido nuevo = new Partido(nroLinea, equiposParticipantes.getEquipoParticipante(A), equiposParticipantes.getEquipoParticipante(B), golesA, golesB);
                Ronda r = t.existeRonda(nroRonda);
                if (r !=null) {
                    r.agregarPartido(nuevo);
                }else{
                    Ronda nuevaRonda= new Ronda(nroRonda);
                    nuevaRonda.agregarPartido(nuevo);
                    t.agregarRonda(nuevaRonda);
                }
                nroLinea++;
            }
            rs.close();
            conn.close();
            return  t;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public static Prode GetPronosticoFromBD(Liga equiposParticipantes, Torneo t) {
        Prode juego;
        int PuntosPorAciertoPronostico=0;
        int PuntosPorAciertoRonda=0;
        int PuntosPorAciertoFase=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prode", "root", "");
            Statement st = conn.createStatement();

            ResultSet rs =  st.executeQuery("select * from configuracionpuntajes");
            while (rs.next()) {
                PuntosPorAciertoPronostico =  rs.getInt("puntosPorAciertoPronostico");
                PuntosPorAciertoRonda =  rs.getInt("puntosPorAciertoRonda");
                PuntosPorAciertoFase =  rs.getInt("puntosPorAciertoFase");
            }
            juego = new Prode(PuntosPorAciertoPronostico,PuntosPorAciertoRonda,PuntosPorAciertoFase );

            rs =  st.executeQuery("select * from pronostico");
            while (rs.next()) {
                String j = rs.getString("apellidoYNombreParticipante");
                int dni =  rs.getInt("dniParticipante");
                String A = rs.getString("nombreEquipoA");
                Boolean ganaA = rs.getBoolean("ganaA");
                Boolean empate = rs.getBoolean("empate");
                Boolean ganaB = rs.getBoolean("ganaB");
                String B = rs.getString("nombreEquipoB");

                Partido partido = t.BuscarEnfrentamiento(equiposParticipantes.getEquipoParticipante(A), equiposParticipantes.getEquipoParticipante(B));
                if (Objects.equals(partido, null)) {
                    rs.close();
                    conn.close();
                    return null;
                }
                Pronostico nuevo = new Pronostico(partido, equiposParticipantes.getEquipoParticipante(A), ganaA, empate, ganaB, equiposParticipantes.getEquipoParticipante(B),1);

                Participante jugador = juego.existeParticipante(j, dni);
                if (jugador != null) {
                    jugador.agregarPronostico(nuevo);
                } else {
                    jugador = new Participante(j, dni);
                    jugador.agregarPronostico(nuevo);
                    juego.agregarParticipante(jugador);
                }
            }
            rs.close();
            conn.close();
            return juego;
        }
        catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}


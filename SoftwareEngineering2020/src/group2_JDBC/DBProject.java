package group2_JDBC;

import group2.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Camilla Carpinelli + Rodolfo Bernardis
 */
public class DBProject {

    public static List<Maintainer> popolaMaintainer(String id, String type) { //Camilla Carpinelli

        ConnectionPostgreSQLSingleton conn = ConnectionPostgreSQLSingleton.getInstance(); //chiamata al singleton
        Connection connection = conn.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        List<Maintainer> l = new ArrayList();

        try {
            if (type.equalsIgnoreCase("planned")) { //Rodolfo Bernardis - Query
                pstm = connection.prepareStatement("select MAN.nome, MAN.username_mantainer, MAN.password_mantainer\n"
                        + "from planned PL, attitudine_p ATTP, competenza COMP, requisito REQ, mantainer MAN\n"
                        + "where PL.id_attivita_p=? and PL.id_attivita_p=ATTP.id_attivita_p\n"
                        + "and ATTP.id_competenza=COMP.id_competenza and COMP.id_competenza=REQ.id_competenza and REQ.id_mantainer=MAN.id_mantainer");

                pstm.setString(1, id);
                rs = pstm.executeQuery();

            } else if (type.equalsIgnoreCase("unplanned")) { //Rodolfo Bernardis - Query
                pstm = connection.prepareStatement("select MAN.nome, MAN.username_mantainer, MAN.password_mantainer\n"
                        + "from unplanned UN, attitudine_un ATTUN, competenza COMP, requisito REQ, mantainer MAN\n"
                        + "where UN.id_attivita_un=? and UN.id_attivita_un=ATTUN.id_attivita_un\n"
                        + "and ATTUN.id_competenza=COMP.id_competenza and COMP.id_competenza=REQ.id_competenza and REQ.id_mantainer=MAN.id_mantainer");

                pstm.setString(1, id);
                rs = pstm.executeQuery();
            }

            while (rs.next()) {
                String username = rs.getString("username_mantainer");
                String password = rs.getString("password_mantainer");
                String name = rs.getString("nome");

                //manca la lista di availability
                Maintainer m = new Maintainer(username, password, "Maintainer", name);
                l.add(m);
            }
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
        return l;
    }

    public static List<Competencies> popolaSkills(String id, String type) { //Camilla Carpinelli
        ConnectionPostgreSQLSingleton conn = ConnectionPostgreSQLSingleton.getInstance(); //chiamata al singleton
        Connection connection = conn.getConnection();
        ResultSet rs = null;
        PreparedStatement pstm = null;

        List<Competencies> cl = new ArrayList();

        try {
            if (type.equalsIgnoreCase("planned")) { //Rodolfo Bernardis - Query
                pstm = connection.prepareStatement("select * from competenza COMP, attitudine_p ATT, planned PL "
                        + "where PL.id_attivita_p=? and PL.id_attivita_p=ATT.id_Attivita_p and ATT.id_competenza=COMP.id_competenza");

                pstm.setString(1, id);
                rs = pstm.executeQuery();
            } else if (type.equalsIgnoreCase("unplanned")) { //Rodolfo Bernardis - Query
                pstm = connection.prepareStatement("select * from competenza COMP, attitudine_un ATT, unplanned UN "
                        + "where UN.id_attivita_un=? and UN.id_attivita_un=ATT.id_attivita_un and ATT.id_competenza=COMP.id_competenza");

                pstm.setString(1, id);
                rs = pstm.executeQuery();
            }
            while (rs.next()) {
                String competencies = rs.getString("descrizione");
                String id_competencies = rs.getString("Id_competenza");

                Competencies c = new Competencies(competencies, id_competencies);
                cl.add(c);
            }
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
        return cl;
    }

    public static List popolaActivity(int w, String type) { //Camilla Carpinelli
        ConnectionPostgreSQLSingleton conn = ConnectionPostgreSQLSingleton.getInstance(); //chiamata al singleton
        Connection connection = conn.getConnection();
        List<PlannedActivity> lp = new ArrayList();
        List<UnplannedActivity> lu = new ArrayList();
        List<Competencies> cl = new ArrayList();
        if (type.equalsIgnoreCase("planned")) {
            try {
                PreparedStatement pstm = connection.prepareStatement("select * from planned where settimana = ?");
                pstm.setInt(1, w);
                ResultSet rs = pstm.executeQuery();

                while (rs.next()) {
                    String ID = rs.getString("id_attivita_p");
                    String site = rs.getString("sito_fabbrica");
                    String area = rs.getString("area");
                    String description = rs.getString("descrizione");
                    boolean interruptbility = rs.getBoolean("interrompibile");
                    int estimatedTime = rs.getInt("tempo_stimato");
                    String tipology = rs.getString("tipologia");
                    int week = rs.getInt("settimana");
                    boolean extraActivity = rs.getBoolean("extra");

                    PlannedActivity a = new PlannedActivity(ID, site, area, description, interruptbility, estimatedTime, tipology, week, extraActivity);
                    lp.add(a);
                }
                return lp;
            } catch (java.sql.SQLException e) {
                System.out.println(e.getMessage());
            }
        } else if (type.equalsIgnoreCase("unplanned")) {
            try {

                PreparedStatement pstm = connection.prepareStatement("select * from unplanned where settimana = ? and ewo = false");
                pstm.setInt(1, w);
                ResultSet rs = pstm.executeQuery();

                while (rs.next()) {
                    String ID = rs.getString("id_attivita_un");
                    String site = rs.getString("sito_fabbrica");
                    String area = rs.getString("area");
                    String description = rs.getString("descrizione");
                    boolean interruptbility = rs.getBoolean("interrompibile");
                    int estimatedTime = rs.getInt("tempo_stimato");
                    String tipology = rs.getString("tipologia");
                    int week = rs.getInt("settimana");
                    boolean ewoActivity = rs.getBoolean("ewo");

                    UnplannedActivity u = new UnplannedActivity(ID, site, area, description, interruptbility, estimatedTime, tipology, week, ewoActivity);
                    lu.add(u);
                }
                return lu;
            } catch (java.sql.SQLException e) {
                System.out.println(e.getMessage());
            }

        } else if (type.equalsIgnoreCase("ewo")) {
            try {
                PreparedStatement pstm = connection.prepareStatement("select * from unplanned where settimana = ? and ewo = true");
                pstm.setInt(1, w);
                ResultSet rs = pstm.executeQuery();

                while (rs.next()) {
                    String ID = rs.getString("id_attivita_un");
                    String site = rs.getString("sito_fabbrica");
                    String area = rs.getString("area");
                    String description = rs.getString("descrizione");
                    boolean interruptbility = rs.getBoolean("interrompibile");
                    int estimatedTime = rs.getInt("tempo_stimato");
                    String tipology = rs.getString("tipologia");
                    int week = rs.getInt("settimana");
                    boolean ewoActivity = rs.getBoolean("ewo");

                    UnplannedActivity u = new UnplannedActivity(ID, site, area, description, interruptbility, estimatedTime, tipology, week, ewoActivity);
                    lu.add(u);
                }
                return lu;

            } catch (java.sql.SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

}

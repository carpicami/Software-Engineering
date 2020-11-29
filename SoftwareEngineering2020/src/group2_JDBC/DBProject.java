/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group2_JDBC;

import group2.*;
import provaDBPG.ConnectionProva;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carpi
 */
public class DBProject {

    static String url = "jdbc:postgresql://localhost/SoftwareEngineering";
    static String user = "postgres";
    static String pwd = "admin";
    static Connection conn = null;
    static Statement stm = null;

    public static void main(String[] args) {
        ConnectionProva connectionProva = new ConnectionProva();
        connectionProva.perform();
/*
        int i;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            stm = conn.createStatement();

            //conn.close(); non va chiusa la connessione, serve nella gui
        } catch (java.sql.SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
*/
    } //mi connetto al DB nella GUI

    public static List<Mantainer> popolaMantainer() {

        List<Mantainer> l = new ArrayList();
        List<Competencies> cl = new ArrayList();

        String query = "select * from mantainer";  //da cambiare, dipende dalla settimana e dalle skills

        try {
            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {
                String username = rs.getString("username_mantainer");
                String password = rs.getString("password_mantainer");
                String name = rs.getString("nome");

                //da fare un'altra query
                String competencies = rs.getString("descrizione");
                String id_competencies = rs.getString("Id_competenza");

                Competencies c = new Competencies(competencies, id_competencies);
                cl.add(c);
                
                //manca la lista di availability
                Mantainer m = new Mantainer(username, password, name, "Mantainer", cl);
                l.add(m);
            }
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return l;
    }

    public static List<PlannedActivity> popolaPlannedActivity(String w) {

        List<PlannedActivity> l = new ArrayList();
        List<Competencies> cl = new ArrayList();

        String query = "select * from plannedactivity where week is ..." + w;  //da cambiare, dipende dalla settimana
        try {

            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {
                String ID = rs.getString("id_attivita_p");
                String site = rs.getString("sito_fabbrica");
                String area = rs.getString("area");
                String description = rs.getString("descrizione");
                boolean interruptbility = rs.getBoolean("interrompibile");
                int estimatedTime = rs.getInt("tempo_stimato");
                String tipology = rs.getString("tipologia");
                int week = rs.getInt("settimana");
                boolean extraActivity = rs.getBoolean("extraActivity"); // da vedere con i ragazzi
                
                //altra query
                String competencies = rs.getString("descrizione");
                String id_competencies = rs.getString("Id_competenza");

                Competencies c = new Competencies(competencies, id_competencies); //skills needed
                cl.add(c);

                PlannedActivity a = new PlannedActivity(ID, site, area, description, cl, interruptbility, estimatedTime, tipology, week, extraActivity);
                l.add(a);
            }
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return l;
    }

    public static List<UnplannedActivity> popolaUnplannedActivity(String w) {

        List<UnplannedActivity> l = new ArrayList();
        List<Competencies> cl = new ArrayList();

        String query = "select * from unplannedactivity where week is ..." + w;  //da cambiare, dipende dalla settimana e dalle skills
        try {

            ResultSet rs = stm.executeQuery(query);

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

                String competencies = rs.getString("descrizione");
                String id_competencies = rs.getString("Id_competenza");

                Competencies c = new Competencies(competencies, id_competencies); //skills needed
                cl.add(c);

                UnplannedActivity u = new UnplannedActivity(ID, site, area, description, cl, interruptbility, estimatedTime, tipology, week, ewoActivity);
                l.add(u);
            }
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return l;
    }
}
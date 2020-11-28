/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group2_JDBC;

import group2.*;

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

    static String url = "jdbc:postgresql://localhost/Software Engineering";
    static String user = "softwareengineering";
    static String pwd = "rodolfo";
    static Connection conn = null;
    static Statement stm = null;

    public static void main(String[] args) {

        int i;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            stm = conn.createStatement();

            //conn.close(); non va chiusa la connessione, serve nella gui
        } catch (java.sql.SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    } //mi connetto al DB nella GUI

    public static List<Mantainer> popolaMantainer() {

        List<Mantainer> l = new ArrayList();
        List<Competencies> cl = new ArrayList();

        String query = "select * from mantainer";  //da cambiare, dipende dalla settimana e dalle skills
        
        try {
            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String ruolo = rs.getString("ruolo");
                String competencies = rs.getString("competencies description");
                String id_competencies = rs.getString("competencies ID");

                Competencies c = new Competencies(competencies, id_competencies);
                cl.add(c);
                //manca la lista di availability
                Mantainer m = new Mantainer(username, password, name, ruolo, cl);
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

    public static List<PlannedActivity> popolaPlannedActivity() {

        List<PlannedActivity> l = new ArrayList();
        List<Competencies> cl = new ArrayList();

        String query = "select * from plannedactiviti where week is ...";  //da cambiare, dipende dalla settimana e dalle skills
        try {

            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {
                String ID = rs.getString("ID");
                String site = rs.getString("site");
                String area = rs.getString("area");
                String description = rs.getString("description");
                boolean interruptbility = rs.getBoolean("interruptbility");
                int estimatedTime = rs.getInt("estimated time");
                String tipology = rs.getString("tipology");
                int week = rs.getInt("week");
                boolean extraActivity = rs.getBoolean("extraActivity");

                String competencies = rs.getString("skills needed");
                String id_competencies = rs.getString("skills ID");

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

    public static List<UnplannedActivity> popolaUnplannedActivity() {

        List<UnplannedActivity> l = new ArrayList();
        List<Competencies> cl = new ArrayList();

        String query = "select * from unplannedactivity where week is ...";  //da cambiare, dipende dalla settimana e dalle skills
        try {

            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {
                String ID = rs.getString("ID");
                String site = rs.getString("site");
                String area = rs.getString("area");
                String description = rs.getString("description");
                boolean interruptbility = rs.getBoolean("interruptbility");
                int estimatedTime = rs.getInt("estimated time");
                String tipology = rs.getString("tipology");
                int week = rs.getInt("week");
                boolean extraActivity = rs.getBoolean("extraActivity");

                String competencies = rs.getString("skills needed");
                String id_competencies = rs.getString("skills ID");

                Competencies c = new Competencies(competencies, id_competencies); //skills needed
                cl.add(c);

                UnplannedActivity u = new UnplannedActivity(ID, site, area, description, cl, interruptbility, estimatedTime, tipology, week, extraActivity);
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

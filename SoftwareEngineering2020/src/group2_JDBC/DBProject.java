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

    private static String url = "";
    private static String user = "";
    private static String psw = "";

    private static Connection conn = null;
    private static Statement stm = null;
    int i;

    public static void main(String[] args) {
        try {
            Class.forName("org.postgres.Driver");
            conn = DriverManager.getConnection(url, user, psw);
            stm = conn.createStatement();

            List<Mantainer> m = popolaMantainer(stm); //questo bisogna farlo in base alla settimana e alle skills
            List<PlannedActivity> a = popolaPlannedActivity(stm); //dipende dalla settimana
            List<UnplannedActivity> b = popolaUnplannedActivity(stm); //dipende dalla settimana

        } catch (java.sql.SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (java.sql.SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static List<Mantainer> popolaMantainer(Statement stm) {

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

    public static List<PlannedActivity> popolaPlannedActivity(Statement stm) {

        List<PlannedActivity> l = new ArrayList();

        return l;
    }
    
    public static List<UnplannedActivity> popolaUnplannedActivity(Statement stm) {

        List<UnplannedActivity> l = new ArrayList();

        return l;
    }
}

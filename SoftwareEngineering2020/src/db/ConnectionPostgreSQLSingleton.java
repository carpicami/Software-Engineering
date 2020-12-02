/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author carpi
 */
public class ConnectionPostgreSQLSingleton {

    private static ConnectionPostgreSQLSingleton instance = null;
    
    private final String url = "jdbc:postgresql://localhost/SoftwareEngineering";
    private final String user = "postgres";
    private final String pwd = "admin";
    private Connection connection;

    public ConnectionPostgreSQLSingleton() {
        try {
            connection = DriverManager.getConnection(url, user, pwd);
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionPostgreSQLSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static ConnectionPostgreSQLSingleton getInstance() {
        // Crea l'oggetto solo se NON esiste:
        if (instance == null) {
            instance = new ConnectionPostgreSQLSingleton();
        }
        return instance;
    }
}

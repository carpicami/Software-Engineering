package group2_JDBC;

import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author Pierluigi Giangiacomi + Camilla Carpinelli
 */
public class ConnectionPostgreSQLSingleton {

    private static ConnectionPostgreSQLSingleton instance = null;
    
    private final String url = "jdbc:postgresql://localhost/SoftwareEngineering";
    private final String user = "postgres";
    private final String pwd = "admin";
    private Connection connection;

    private ConnectionPostgreSQLSingleton() { //IMPLEMENTAZIONE PATTERN SINGLETON - Camilla Carpinelli
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

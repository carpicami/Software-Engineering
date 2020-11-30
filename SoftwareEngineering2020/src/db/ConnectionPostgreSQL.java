package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionPostgreSQL {
    private final String url = "jdbc:postgresql://localhost/SoftwareEngineering";
    private final String user = "postgres";
    private final String pwd = "admin";
    private Connection connection;

    public ConnectionPostgreSQL() {
        try {
            connection = DriverManager.getConnection(url, user, pwd);
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }   
}

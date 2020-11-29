package provaDBPG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionProva {

    public ConnectionProva() {
    }

    public void perform() {
        String url = "jdbc:postgresql://localhost/SoftwareEngineering";
        String user = "postgres";
        String pwd = "oratorio98";
        String query = "select * from mantainer";
        try {
            Connection conn = DriverManager.getConnection(url, user, pwd);
            Class.forName("org.postgresql.Driver");
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery(query);
            while (rst.next()) {
                System.out.println(rst.getString("nome").concat(" "+rst.getString("cognome")));
            }
            conn.close();
        } catch (java.sql.SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

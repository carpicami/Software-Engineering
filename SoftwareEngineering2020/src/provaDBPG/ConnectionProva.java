package provaDBPG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionProva {

    public ConnectionProva() {
    }

    public void perform() {
        String url = "jdbc:postgresql://localhost/SoftwareEngineering";
        String user = "postgres";
        String pwd = "admin";
        
        try {
            Connection conn = DriverManager.getConnection(url, user, pwd);
            Class.forName("org.postgresql.Driver");
            PreparedStatement stmt1 = conn.prepareStatement("select id_attivita_p,descrizione from planned where settimana=?");
            stmt1.setInt(1, 12);
            PreparedStatement stmt2 = conn.prepareStatement("select id_attivita_un,descrizione from unplanned where settimana=?");
            stmt2.setInt(1, 3);
            ResultSet rst1 = stmt1.executeQuery();
            ResultSet rst2 = stmt2.executeQuery();
            while (rst1.next()) {
                System.out.println(rst1.getString("id_attivita_p").concat(" "+rst1.getString("descrizione")));
            }
            while (rst2.next()) {
                System.out.println(rst2.getString("id_attivita_un").concat(" "+rst2.getString("descrizione")));
            }
            conn.close();
        } catch (java.sql.SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package availability;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GiangiacomPi
 */
public class mainProva {

    public static void main(String[] args) {
        
        ServiceAvailability availability = new ServiceAvailability();
        try {
            List<PercentAvail> availabilityPercent = availability.getAvailabilityPercent(2);
            for (PercentAvail p : availabilityPercent) {
                System.out.print(p.getNameM());
                for (Integer p2 : p.getPercent())
                    System.out.print(p2+"\n");
            }
        } catch (Exception ex) {
            Logger.getLogger(mainProva.class.getName()).log(Level.SEVERE, null, ex);
        }
            /*
            try {
            List<WeekAvail> availability2 = availability.getAvailability(2);
            for (WeekAvail elem : availability2) {
            System.out.println(elem.getNameM());
            elem.getMap().forEach((t, u) -> {
            System.out.println(t);
            for (int i : u) {
            System.out.println(i);
            }
            System.out.println("\n");
            });
            }
            } catch (SQLException ex) {
            Logger.getLogger(mainProva.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
            Logger.getLogger(mainProva.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        */
    }
}

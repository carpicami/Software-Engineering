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
        ServiceAvailabilityImpl availabilityImpl = new ServiceAvailabilityImpl();
        try {
            List<WeekAvail> availability = availabilityImpl.getAvailability(2);
            
            for (WeekAvail elem:availability) {
                System.out.println(elem.getNameM());
                elem.getMap().forEach((t, u) -> {
                    System.out.println(t);
                    for (int i:u)
                         System.out.println(i);
                    System.out.println("\n");
                });
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(mainProva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(mainProva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

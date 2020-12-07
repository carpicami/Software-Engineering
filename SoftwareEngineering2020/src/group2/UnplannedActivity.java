/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group2;

import java.util.List;

/**
 *
 * @author carpi
 */
public class UnplannedActivity extends Activity implements Comparable<UnplannedActivity>{

    private boolean ewoActivity;
    
    public UnplannedActivity(String ID, String site, String area, String description,
            boolean interruptbility, int estimatedTime, String tipology, int week, boolean ewoActivity) {
        
        super(ID, site, area, description, interruptbility, estimatedTime, tipology, week);
        this.ewoActivity = ewoActivity;
    }

    @Override
    public void attachSMP(Activity a) {
        //da implementare
    }

    public boolean isEwoActivity() {
        return ewoActivity;
    }

    public void setEwoActivity(boolean ewoActivity) {
        this.ewoActivity = ewoActivity;
    }

    @Override
    public int compareTo(UnplannedActivity t) {
        return this.getID().compareTo(t.getID());
    }
    
}

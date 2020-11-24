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
public class PlannedActivity extends Activity {

    private boolean extraActivity;
    
    public PlannedActivity(String ID, String site, String area, String description, List<Competencies> skills, 
            boolean interruptbility, int estimatedTime, Typology t, boolean extraActivity) {
        
        super(ID, site, area, description, skills, interruptbility, estimatedTime, t);
        this.extraActivity = extraActivity;
    }

    @Override
    public void attachSMP(Activity a) {
        //da implementare
    }

    public boolean isExtraActivity() {
        return extraActivity;
    }

    public void setExtraActivity(boolean extraActivity) {
        this.extraActivity = extraActivity;
    }
    
}

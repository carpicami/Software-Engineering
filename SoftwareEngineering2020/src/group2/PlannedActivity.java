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
public class PlannedActivity extends Activity implements Comparable<PlannedActivity> {

    private boolean extraActivity;

    public PlannedActivity(String ID, String site, String area, String description,
            boolean interruptbility, int estimatedTime, String tipology, int week, boolean extraActivity) {

        super(ID, site, area, description, interruptbility, estimatedTime, tipology, week);
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

    @Override
    public int compareTo(PlannedActivity t) {
        return this.getID().compareTo(t.getID());
    }

}

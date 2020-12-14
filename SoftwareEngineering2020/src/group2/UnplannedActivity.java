package group2;

import java.util.List;

/**
 *
 * @author Camilla Carpinelli + Pierluigi Giangiacomi (implementazione Comparable per Test)
 */
public class UnplannedActivity extends Activity implements Comparable<UnplannedActivity>{

    private boolean ewoActivity;
    
    public UnplannedActivity(String ID, String site, String area, String description,
            boolean interruptbility, int estimatedTime, String tipology, int week, boolean ewoActivity) {
        
        super(ID, site, area, description, interruptbility, estimatedTime, tipology, week);
        this.ewoActivity = ewoActivity;
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

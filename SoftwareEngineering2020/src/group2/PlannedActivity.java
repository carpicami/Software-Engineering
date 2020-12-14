package group2;


/**
 *
 * @author Camilla Carpinelli + Pierluigi Giangiacomi (implementazione Comparable per Test)
 */
public class PlannedActivity extends Activity implements Comparable<PlannedActivity> {

    private boolean extraActivity;

    public PlannedActivity(String ID, String site, String area, String description,
            boolean interruptbility, int estimatedTime, String tipology, int week, boolean extraActivity) {

        super(ID, site, area, description, interruptbility, estimatedTime, tipology, week);
        this.extraActivity = extraActivity;
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

    @Override
    public String toString() {
        return "PlannedActivity{" + "extraActivity=" + extraActivity + '}'+super.toString();
    }
    

}

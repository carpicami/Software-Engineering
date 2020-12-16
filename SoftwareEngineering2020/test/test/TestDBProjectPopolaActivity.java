package test;

import group2.PlannedActivity;
import group2_JDBC.DBProject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Rodolfo Bernardis
 */

public class TestDBProjectPopolaActivity {

    @Before
    public void setUp() {
    }

    @Test
    public void testGetActivityShouldReturnExpectedArray() {
        int settimana = 2;
        List<PlannedActivity> lp = DBProject.popolaActivity(settimana, "planned");
        List<String> expected = new ArrayList<>();
        expected.add("0018");
        expected.add("0020");
        Collections.sort(expected);
        List<String> ids = new ArrayList<>();
        for (PlannedActivity pa : lp) {
            ids.add(pa.getID());
        }
        Collections.sort(ids);
        Assert.assertArrayEquals("UNEXPECTED LIST FOR WEEK " + settimana + "\n", expected.toArray(), ids.toArray());
    }

    @Test
    public void testGetActivityShouldReturnEmptyArray() {
        int settimana = 5;
        List<PlannedActivity> lp = DBProject.popolaActivity(settimana, "planned");
        Assert.assertTrue(lp.isEmpty());
    }
}

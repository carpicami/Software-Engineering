package test;

import group2.*;
import group2_JDBC.DBProject;
import java.util.*;
import org.junit.*;

/**
 *
 * @author Pierluigi Giangiacomi
 */
public class TestDBProjectPopolaMaintainer {

    private Maintainer m0;
    private Maintainer m1;
    private Maintainer m2;
    private Maintainer m3;

    @Before
    public void setUp() {
        m0 = new Maintainer("AlbFil", "password2", "Maintainer", "Alberto");
        m2 = new Maintainer("PippoFranco", "password3", "Maintainer", "Pippo");
        m1 = new Maintainer("Angioletto99", "password1", "Maintainer", "Angelo");
        m3 = new Maintainer("PieroAngela", "password4", "Maintainer", "Piero");
    }

    @Test
    public void testMaintainer1() {
        String id = "0018";
        List<Maintainer> expected = new ArrayList<>();
        expected.add(m0);
        expected.add(m2);
        expected.add(m1);
        Collections.sort(expected);
        List<Maintainer> list = DBProject.popolaMaintainer(id, "planned");
        Collections.sort(list);
        Assert.assertArrayEquals("UNEXPECTED LIST FOR ID " + id + "\n", expected.toArray(), list.toArray());
    }

    @Test
    public void testMaintainer2() {
        String id = "0018";
        List<Maintainer> list = DBProject.popolaMaintainer(id, "unplanned");
        Assert.assertTrue("LIST MUST BE EMPTY FOR ID " + id + "\n", list.isEmpty());
    }

    @Test
    public void testMaintainer3() {
        String id = "0016";
        List<Maintainer> expected = new ArrayList<>();
        expected.add(m0);
        expected.add(m2);
        expected.add(m1);
        expected.add(m1);
        expected.add(m3);
        Collections.sort(expected);
        List<Maintainer> list = DBProject.popolaMaintainer(id, "unplanned");
        Collections.sort(list);
        Assert.assertArrayEquals("UNEXPECTED LIST FOR ID " + id + "\n", expected.toArray(), list.toArray());
    }
}

package test;

import group2.Competencies;
import group2_JDBC.DBProject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Pierluigi Giangiacomi
 */
public class TestDBProjectPopolaSkills {

    private Competencies c0;
    private Competencies c1;
    private Competencies c2;

    private Competencies c3;
    private Competencies c4;
    private Competencies c5;
    private Competencies c6;
    private Competencies c7;

    @Before
    public void setUp() {
        c0 = new Competencies("Pulizia annuale dell\"impianto di riscaldamento", "0005");
        c2 = new Competencies("Capacità di manutenere i tubi della caldaia", "0006");
        c1 = new Competencies("Gestione scarichi dell\"impianto di riscaldamento", "0099");

        c3 = new Competencies("Sostituzione componenti del nastro trasportatore", "0027");
        c4 = new Competencies("Riparazione vulcanizzate della macchina", "0054");
        c5 = new Competencies("Rivestimenti antiusura", "0069");
        c6 = new Competencies("Isperzione visiva dei rulli nel tratto di ritorno", "0469");
        c7 = new Competencies("Isperzione visiva delle guide antisura", "0969");
    }

    @Test
    public void testGetSkillsForPlannedActivityShouldReturnExpectedList() {
        String id = "0018";
        List<Competencies> expected = new ArrayList<>();
        expected.add(c0);
        expected.add(c1);
        expected.add(c2);
        Collections.sort(expected);
        List<Competencies> list = DBProject.popolaSkills(id, "planned");
        Collections.sort(list);
        Assert.assertArrayEquals("UNEXPECTED LIST FOR ID " + id + "\n", expected.toArray(), list.toArray());
    }

    @Test
    public void testGetSkillsForUnplannedActivityShouldReturnExpectedList() {
        String id = "0016";
        List<Competencies> expected = new ArrayList<>();
        expected.add(c3);
        expected.add(c4);
        expected.add(c5);
        expected.add(c6);
        expected.add(c7);
        Collections.sort(expected);
        List<Competencies> list = DBProject.popolaSkills(id, "unplanned");
        Collections.sort(list);
        Assert.assertArrayEquals("UNEXPECTED LIST FOR ID " + id + "\n", expected.toArray(), list.toArray());
    }

    @Test
    public void testGetSkillsForUnplannedActivityShouldReturnEmptyList() {
        String id = "0015";
        List<Competencies> list = DBProject.popolaSkills(id, "unplanned");
        Assert.assertTrue("UNEXPECTED LIST FOR ID " + id + "\n", list.isEmpty());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import group2.*;
import group2_JDBC.DBProject;
import java.util.*;
import org.junit.*;

/**
 *
 * @author GiangiacomPi
 */
public class TestDBProject {

    @Test
    public void testMaintainer() {
        String id = "0018";
        Maintainer m0 = new Maintainer("AlbFil", "password2", "Maintainer", "Alberto");
        Maintainer m2 = new Maintainer("PippoFranco", "password3", "Maintainer", "Pippo");
        Maintainer m1 = new Maintainer("Angioletto99", "password1", "Maintainer", "Angelo");
        List<Maintainer> expected = new ArrayList<>();
        expected.add(m0);
        expected.add(m2);
        expected.add(m1);
        Collections.sort(expected);
        List<Maintainer> list = DBProject.popolaMaintainer(id, "planned");
        Collections.sort(list);
        Assert.assertArrayEquals(expected.toArray(), list.toArray());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import group2_maintainer_availability.PercentAvail;
import group2_maintainer_availability.ServiceAvailability;
import group2_maintainer_availability.WeekAvail;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author GiangiacomPi
 */
public class TestAvailability {
    ServiceAvailability service;
    
    @Before
    public void setUp() {
        service = new ServiceAvailability();
    }
       
    @Test
    public void testGetAvailabilityInMinutesShouldReturnExpectedList() throws Exception {
        List<String> nameNow = new ArrayList<>();
        List<String> nameExp = new ArrayList<>();
        List<WeekAvail> availability = service.getAvailability(10);
        availability.forEach(week -> {
            nameNow.add(week.getNameM());
        });
        nameExp.add("Pippo");
        nameExp.add("Alberto");
        nameExp.add("Angelo");
        nameExp.add("Piero");
        Collections.sort(nameExp);
        Collections.sort(nameNow);
        Assert.assertArrayEquals(nameExp.toArray(), nameNow.toArray());
    }
    
    @Test
    public void testGetAvailabilityInPercentShouldReturnExpectedList() throws Exception {
        List<String> nameNow = new ArrayList<>();
        List<String> nameExp = new ArrayList<>();
        List<PercentAvail> availability = service.getAvailabilityPercent(10);
        availability.forEach(week -> {
            nameNow.add(week.getNameM());
        });
        nameExp.add("Angelo");
        nameExp.add("Piero");
        nameExp.add("Pippo");
        nameExp.add("Alberto");
        Collections.sort(nameExp);
        Collections.sort(nameNow);
        Assert.assertArrayEquals(nameExp.toArray(), nameNow.toArray());
    }
    
    @Test(expected = Exception.class)
    public void testGetIndexShouldThrowException () throws Exception {
        service.getIndex(19);
    }
    
    @Test
    public void testGetIndexSholdReturnExpectedValue() throws Exception {
        int exp = 0;
        int index = service.getIndex(8);
        Assert.assertTrue(exp == index);
    }
    
    
}

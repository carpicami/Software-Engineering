/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group2;

import java.util.*;

/**
 *
 * @author carpi
 */
public class Activity {
    
    private String tipology;
    private String ID;
    private String site;
    private String area;
    private String description;
    private List<Competencies> skills = new ArrayList();
    private boolean interruptbility;
    private int estimatedTime;
    private int week;
    
    public Activity(String ID, String site, String area, String description,
            boolean interruptbility, int estimatedTime, String tipology, int week){
        
        this.ID = ID;
        this.site = site;
        this.area = area;
        this.description = description;
        this.interruptbility = interruptbility;
        this.estimatedTime = estimatedTime;
        this.tipology = tipology;
        this.week = week;
    }

    public String getTipology() {
        return tipology;
    }

    public void setTipology(String tipology) {
        this.tipology = tipology;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Competencies> getSkills() {
        return skills;
    }

    public void setSkills(List<Competencies> skills) {
        this.skills = skills;
    }

    public boolean isInterruptbility() {
        return interruptbility;
    }

    public void setInterruptbility(boolean interruptbility) {
        this.interruptbility = interruptbility;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

}

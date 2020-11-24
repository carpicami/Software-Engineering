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
public abstract class Activity {
    
    public enum Typology {HYDRAULICAL, ELECTRICAL, ELECTRONIC, MECHANICAL};
    private Typology t;
    private String ID;
    private String site;
    private String area;
    private String description;
    private List<Competencies> skills = new ArrayList();
    private boolean interruptbility;
    private int estimatedTime;
    
    public Activity(String ID, String site, String area, String description, List<Competencies> skills,
            boolean interruptbility, int estimatedTime, Typology t){
        
        this.ID = ID;
        this.site = site;
        this.area = area;
        this.description = description;
        this.skills = skills;
        this.interruptbility = interruptbility;
        this.estimatedTime = estimatedTime;
        this.t = t;
    }

    public Typology getT() {
        return t;
    }

    public void setT(Typology t) {
        this.t = t;
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
    
    public abstract void attachSMP(Activity a);
}

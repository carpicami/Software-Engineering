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
public class Mantainer extends User{
    private String name;
    private String ruolo;
    private List<Competencies> list = new ArrayList();
    //private Map<String, Integer> availability = new HashMap<>();
    
    public Mantainer(String username, String password, String name, String ruolo, List<Competencies> list) {
        super(username, password);
        this.name = name;
        this.ruolo = ruolo;
        this.list = list;
    }
    
    @Override
    public void LogIn() { //ipotetico metodo di Login
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    /*public Map<String, Integer> getAvailability() {
        return availability;
    }

    public void setAvailability(Map<String,Integer> availability) {
        this.availability = availability;
    }*/
    
}

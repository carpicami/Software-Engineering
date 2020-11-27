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
public class Mantainer extends User{ //CLASSE MANTAINER CHE ESTENDE USER 
    private String name;
    private List<Competencies> list = new ArrayList();
    //private Map<String, Integer> availability = new HashMap<>();
    
    public Mantainer(String username, String password, String ruolo, String name, List<Competencies> list) {
        super(username, password, ruolo);
        this.name = name;
        this.list = list;
    }
    
    public Mantainer(String username, String password, String ruolo){
        super(username, password, ruolo);
    }
    
    @Override
    public String getRuolo() { //ipotetico metodo di Login
        return "Mantainer";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public Map<String, Integer> getAvailability() {
        return availability;
    }

    public void setAvailability(Map<String,Integer> availability) {
        this.availability = availability;
    }*/
    
}

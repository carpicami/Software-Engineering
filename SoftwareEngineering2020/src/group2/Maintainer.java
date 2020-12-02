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
public class Maintainer extends User{ //CLASSE MANTAINER CHE ESTENDE USER 
    private String name;
    private List<Competencies> list = new ArrayList();
    //private Map<String, Integer> availability = new HashMap<>();
    
    public Maintainer(String username, String password, String ruolo, String name) {
        super(username, password, ruolo);
        this.name = name;
    }
    
    public Maintainer(String username, String password, String ruolo){
        super(username, password, ruolo);
    }
    
    @Override
    public String getRuolo() { //ipotetico metodo di Login
        return "Maintainer";
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

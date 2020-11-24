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
    private Availability availability;
    
    public Mantainer(String username, String password, String name, String ruolo, Availability availability, List<Competencies> list) {
        super(username, password);
        this.name = name;
        this.ruolo = ruolo;
        this.availability = availability;
        this.list = new ArrayList();
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

    public List<Competencies> getList() {
        return list;
    }

    public void setList(List<Competencies> list) {
        this.list = list;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }
    
}

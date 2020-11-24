/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group2;

/**
 *
 * @author carpi
 */
public class Planner extends User {
    
    private String ruolo;
    
    public Planner(String username, String password , String ruolo) {
        super(username, password);
        this.ruolo = ruolo;
    }

    @Override
    public void LogIn() { //ipotetico metodo di Login
    }
    
    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }
    
    //tanti altri metodi da implementare
}

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
public class Planner extends User { //CLASSE PLANNER CHE ESTENDE LA CLASSER USER DEL PATTERN FACTORY METHOD
    
    public Planner(String username, String password , String ruolo) {
        super(username, password, ruolo);
    }

    @Override
    public String getRuolo() { //ipotetico metodo di Login
        return "Planner";
    }
    
    //tanti altri metodi da implementare
}

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
public abstract class User { //CLASSE ASTRATTA DEL PATTERN FACTORY METHOD
    
    private String username;
    private String password; 
    private String ruolo;
    
    public User(String username, String password, String ruolo){
        this.username = username;
        this.password = password;
        this.ruolo = ruolo;
    }
    
    public abstract String getRuolo();
}

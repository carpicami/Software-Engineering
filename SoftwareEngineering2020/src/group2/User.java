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
public abstract class User {
    
    private String username;
    private String password; 
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public abstract void LogIn(); //ipotetico metodo di Login per una possibile implementazione
}

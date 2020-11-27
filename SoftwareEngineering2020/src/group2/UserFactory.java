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
public class UserFactory { //IMPLEMENTAZIONE DEL FACTORY METHOD PER CREARE GLI UTENTI
    
    public User getUserRuolo(String ruolo, String user, String psw){
        if(ruolo == null){
            return null;
        }
        if(ruolo.equalsIgnoreCase("Planner")){
            return new Planner(user,psw,ruolo);
        }
        else if(ruolo.equalsIgnoreCase("Mantainer")){
            return new Mantainer(user,psw,ruolo);
        }
        return null;
    }
    
    /*
    Nel main questo pattern funziona così:
    UserFactory = new UserFactory()
    User u = new getUserRuolo("Planner", "abcd", "1234")
    */
}

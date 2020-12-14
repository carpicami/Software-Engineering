package group2;

/**
 *
 * @author Marianna Farina
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
            return new Maintainer(user,psw,ruolo);
        }
        return null;
    }
    
    /*
    Per istanziare un nuovo Utente:
    UserFactory = new UserFactory()
    User u = new getUserRuolo("Planner", "abcd", "1234")
    */
}

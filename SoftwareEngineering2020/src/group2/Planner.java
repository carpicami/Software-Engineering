package group2;

/**
 *
 * @author Marianna Farina
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

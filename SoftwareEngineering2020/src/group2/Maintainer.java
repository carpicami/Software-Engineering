package group2;

import java.util.*;

/**
 *
 * @author Marianna Farina + Pierluigi Giangiacomi (implementazione Comparable per Test)
 */
public class Maintainer extends User implements Comparable<Maintainer>{ //CLASSE MANTAINER CHE ESTENDE USER 
    private String name;
    private List<Competencies> list = new ArrayList();
    
    public Maintainer(String username, String password, String ruolo, String name) {
        super(username, password, ruolo);
        this.name = name;
    }
    
    public Maintainer(String username, String password, String ruolo){
        super(username, password, ruolo);
    }
    
    @Override
    public String getRuolo() { //ipotetico metodo di Login - Non eseguito (non era nelle prime 2 sprint)
        return "Maintainer";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public int compareTo(Maintainer o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.list);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Maintainer other = (Maintainer) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.list, other.list)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Maintainer{" + "name=" + name + ", list=" + list + '}'+super.toString();
    }
    
}

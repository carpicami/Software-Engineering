/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group2;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", ruolo=" + ruolo + '}';
    }
    
    public abstract String getRuolo();

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.username);
        hash = 97 * hash + Objects.hashCode(this.password);
        hash = 97 * hash + Objects.hashCode(this.ruolo);
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
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.ruolo, other.ruolo)) {
            return false;
        }
        return true;
    }
    
}

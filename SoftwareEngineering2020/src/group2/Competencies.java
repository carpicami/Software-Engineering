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
public class Competencies implements Comparable<Competencies>{
    
    private String descrizione;
    private String ID; 
    
    public Competencies(String descrizione, String ID){
        this.descrizione = descrizione;
        this.ID = ID;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Competencies{" + "descrizione=" + descrizione + ", ID=" + ID + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.descrizione);
        hash = 17 * hash + Objects.hashCode(this.ID);
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
        final Competencies other = (Competencies) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Competencies o) {
        return this.getID().compareTo(o.getID());
    }

    
     
}

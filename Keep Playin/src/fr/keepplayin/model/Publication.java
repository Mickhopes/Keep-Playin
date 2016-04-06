package fr.keepplayin.model ;

import java.util.Date;

public class Publication {
    int id ;
    String message ;
    Utilisateur auteur ;
    Date dateDePublication ;

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Utilisateur getAuteur() {
        return auteur;
    }

    public Date getDateDePublication() {
        return dateDePublication;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAuteur(Utilisateur auteur) {
        this.auteur = auteur;
    }

    public void setDateDePublication(Date dateDePublication) {
        this.dateDePublication = dateDePublication;
    }
}

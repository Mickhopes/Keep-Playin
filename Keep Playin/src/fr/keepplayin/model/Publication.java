package fr.keepplayin.model ;

import java.util.Date;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Publication {
    @Id Long id ;
    String message ;
    Ref<Utilisateur> auteurRef ;
    Date dateDePublication ;

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Ref<Utilisateur> getAuteurRef() {
        return auteurRef;
    }

    public Date getDateDePublication() {
        return dateDePublication;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAuteurRef(Ref<Utilisateur> auteur) {
        this.auteurRef = auteur;
    }

    public void setDateDePublication(Date dateDePublication) {
        this.dateDePublication = dateDePublication;
    }
}

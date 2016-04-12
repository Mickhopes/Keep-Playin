package fr.keepplayin.model ;

import java.io.Serializable;
import java.util.Date;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Commentaire implements Serializable, Comparable<Commentaire>{
    @Id Long id ;
    String message ;
    Ref<Utilisateur> auteurRef ;
    Date dateDeCommentaire ;
    
    public Commentaire() {
    	
    }
    
    public Commentaire(String message, Utilisateur auteur) {
    	this.message = message;
    	this.auteurRef = Ref.create(auteur);
    	
    	dateDeCommentaire = new Date();
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Utilisateur getAuteur() {
        return auteurRef.get();
    }

    public Date getDateDeCommentaire() {
        return dateDeCommentaire;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAuteur(Utilisateur auteur) {
        this.auteurRef = Ref.create(auteur);
    }

    public void setDateDeCommentaire(Date dateDeCommentaire) {
        this.dateDeCommentaire = dateDeCommentaire;
    }

	@Override
	public int compareTo(Commentaire c) {
		return c.getDateDeCommentaire().compareTo(this.dateDeCommentaire);
	}
}

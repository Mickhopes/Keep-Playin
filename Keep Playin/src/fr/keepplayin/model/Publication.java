package fr.keepplayin.model ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Load;

@Entity
public class Publication implements Serializable, Comparable<Publication>{
    private @Id Long id ;
    private String message ;
    private @Load Ref<Utilisateur> auteurRef ;
    private Date dateDePublication ;
    private List<Commentaire> commentaires;
    
    public Publication() {
    	commentaires = new ArrayList<Commentaire>();
    }
    
    public Publication(String message, Utilisateur auteur) {
    	this.message = message;
    	auteurRef = Ref.create(auteur);
    	
    	dateDePublication = new Date();
    	
    	commentaires = new ArrayList<Commentaire>();
    }
    
    public void ajouterCommentaire(Commentaire c) {
    	commentaires.add(c);
    }
    
    public void supprimerCommentaire(Commentaire c) {
    	commentaires.remove(c);
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

    public Date getDateDePublication() {
        return dateDePublication;
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

    public void setDateDePublication(Date dateDePublication) {
        this.dateDePublication = dateDePublication;
    }

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	@Override
	public int compareTo(Publication p) {
		return p.getDateDePublication().compareTo(dateDePublication);
	}
}

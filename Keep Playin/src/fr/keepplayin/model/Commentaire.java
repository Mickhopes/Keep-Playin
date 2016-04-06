package fr.keepplayin.model ;

import java.util.Date;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Commentaire {
    @Id Long id ;
    String message ;
    Ref<Utilisateur> auteurRef ;
    Date dateDeCommentaire ;
    Ref<Publication> publicationCommenteeRef ;

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Ref<Utilisateur> getAuteurRef() {
        return auteurRef;
    }

    public Date getDateDeCommentaire() {
        return dateDeCommentaire;
    }

    public Ref<Publication> getPublicationCommenteeRef() {
        return publicationCommenteeRef;
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

    public void setDateDeCommentaire(Date dateDeCommentaire) {
        this.dateDeCommentaire = dateDeCommentaire;
    }

    public void setPublicationCommenteeRef(Ref<Publication> publicationCommentee) {
        this.publicationCommenteeRef = publicationCommentee;
    }
}

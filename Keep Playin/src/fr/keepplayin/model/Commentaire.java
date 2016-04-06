import java.util.Date;

public class Commentaire {
    int id ;
    String message ;
    Utilisateur auteur ;
    Date dateDeCommentaire ;
    Publication publicationCommentee ;

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Utilisateur getAuteur() {
        return auteur;
    }

    public Date getDateDeCommentaire() {
        return dateDeCommentaire;
    }

    public Publication getPublicationCommentee() {
        return publicationCommentee;
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

    public void setDateDeCommentaire(Date dateDeCommentaire) {
        this.dateDeCommentaire = dateDeCommentaire;
    }

    public void setPublicationCommentee(Publication publicationCommentee) {
        this.publicationCommentee = publicationCommentee;
    }
}

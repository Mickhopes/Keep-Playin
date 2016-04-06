package fr.keepplayin.model ;

import java.util.Date;

public abstract class Demande {
    int id ;
    Utilisateur source ;
    String message ;
    Date dateDemande ;
    boolean acceptee ;

    public int getId() {
        return id;
    }

    public Utilisateur getSource() {
        return source;
    }

    public String getMessage() {
        return message;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public boolean isAcceptee() {
        return acceptee;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSource(Utilisateur source) {
        this.source = source;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public void setAcceptee(boolean acceptee) {
        this.acceptee = acceptee;
    }
}

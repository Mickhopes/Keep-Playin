package fr.keepplayin.model ;

import java.util.Date;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Id;

public abstract class Demande {
    @Id Long id ;
    Ref<Utilisateur> sourceRef ;
    String message ;
    Date dateDemande ;
    boolean acceptee ;

    public Long getId() {
        return id;
    }

    public Ref<Utilisateur> getSourceRef() {
        return sourceRef;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setSourceRef(Ref<Utilisateur> source) {
        this.sourceRef = source;
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

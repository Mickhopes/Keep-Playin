package fr.keepplayin.model ;

import java.io.Serializable;
import java.util.Date;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Load;

@Entity
public class DemandeAmi implements Serializable{
    private @Id Long id ;
    private @Load Ref<Utilisateur> sourceRef ;
    private @Load Ref<Utilisateur> cibleRef ;
    private String message ;
    private Date dateDemande ;
    private boolean acceptee ;
    
    public DemandeAmi() {
    	
    }
    
    public DemandeAmi(Utilisateur source, Utilisateur cible, String message) {
    	this.sourceRef = Ref.create(source);
    	this.cibleRef = Ref.create(cible);
    	this.message = message;
    	
    	dateDemande = new Date();
    	acceptee = false;
    }

    public Long getId() {
        return id;
    }

    public Utilisateur getSource() {
        return sourceRef.get();
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

    public void setSource(Utilisateur source) {
        this.sourceRef = Ref.create(source);
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

    public Utilisateur getCible() {
        return cibleRef.get();
    }

    public void setCible(Utilisateur cible) {
        this.cibleRef = Ref.create(cible);
    }
}

package fr.keepplayin.model ;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Utilisateur {
    int id ;
    String nom ;
    String prenom ;
    String nomDeScene ;
    String email ;
    String mobile ;
    String mdp ; // conserver seulement le hash
    Date dateDeNaissance ;
    String sexe ;
    Departement dpt ;
    Instrument instrumentPrincipal ;
    Date debutApprentissage ;
    Niveau niveauInstrumentPrincipal ;
    Set<Instrument> instrumentsSecondaires ;
    Set<StyleMusical> stylesPreferes ;
    List<Utilisateur> amis ;

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNomDeScene() {
        return nomDeScene;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getMdp() {
        return mdp;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public Departement getDpt() {
        return dpt;
    }

    public Instrument getInstrumentPrincipal() {
        return instrumentPrincipal;
    }

    public Date getDebutApprentissage() {
        return debutApprentissage;
    }

    public Niveau getNiveauInstrumentPrincipal() {
        return niveauInstrumentPrincipal;
    }

    public Set<Instrument> getInstrumentsSecondaires() {
        return instrumentsSecondaires;
    }

    public Set<StyleMusical> getStylesPreferes() {
        return stylesPreferes;
    }

    public List<Utilisateur> getAmis() {
        return amis;
    }

    public void setAmis(List<Utilisateur> amis) {
        this.amis = amis;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNomDeScene(String nomDeScene) {
        this.nomDeScene = nomDeScene;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setDpt(Departement dpt) {
        this.dpt = dpt;
    }

    public void setInstrumentPrincipal(Instrument instrumentPrincipal) {
        this.instrumentPrincipal = instrumentPrincipal;
    }

    public void setDebutApprentissage(Date debutApprentissage) {
        this.debutApprentissage = debutApprentissage;
    }

    public void setNiveauInstrumentPrincipal(Niveau niveauInstrumentPrincipal) {
        this.niveauInstrumentPrincipal = niveauInstrumentPrincipal;
    }

    public void setInstrumentsSecondaires(Set<Instrument> instrumentsSecondaires) {
        this.instrumentsSecondaires = instrumentsSecondaires;
    }

    public void setStylesPreferes(Set<StyleMusical> stylesPreferes) {
        this.stylesPreferes = stylesPreferes;
    }
}

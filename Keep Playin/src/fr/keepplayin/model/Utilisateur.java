package fr.keepplayin.model ;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Utilisateur {
    @Id Long id ;
    @Index String nom ;
    @Index String prenom ;
    @Index String nomDeScene ;
    @Index String email ;
    String mobile ;
    String mdp ; // conserver seulement le hash
    Date dateDeNaissance ;
    String sexe ;
    Departement dpt ;
    Ref<Instrument> instrumentPrincipalRef ;
    Date debutApprentissage ;
    Niveau niveauInstrumentPrincipal ;
    List<Ref<Instrument>> instrumentsSecondairesRefs ;
    List<Ref<StyleMusical>> stylesPreferesRefs ;
    List<Ref<Utilisateur>> amisRefs ;

    public Long getId() {
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

    public Ref<Instrument> getInstrumentPrincipalRef() {
        return instrumentPrincipalRef;
    }

    public Date getDebutApprentissage() {
        return debutApprentissage;
    }

    public Niveau getNiveauInstrumentPrincipal() {
        return niveauInstrumentPrincipal;
    }

    public List<Ref<Instrument>> getInstrumentsSecondairesRefs() {
        return instrumentsSecondairesRefs;
    }

    public List<Ref<StyleMusical>> getStylesPreferesRefs() {
        return stylesPreferesRefs;
    }

    public List<Ref<Utilisateur>> getAmisRefs() {
        return amisRefs;
    }

    public void setAmisRefs(List<Ref<Utilisateur>> amis) {
        this.amisRefs = amis;
    }

    public void setId(Long id) {
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

    public void setInstrumentPrincipalRef(Ref<Instrument> instrumentPrincipal) {
        this.instrumentPrincipalRef = instrumentPrincipal;
    }

    public void setDebutApprentissage(Date debutApprentissage) {
        this.debutApprentissage = debutApprentissage;
    }

    public void setNiveauInstrumentPrincipal(Niveau niveauInstrumentPrincipal) {
        this.niveauInstrumentPrincipal = niveauInstrumentPrincipal;
    }

    public void setInstrumentsSecondairesRefs(List<Ref<Instrument>> instrumentsSecondaires) {
        this.instrumentsSecondairesRefs = instrumentsSecondaires;
    }

    public void setStylesPreferesRefs(List<Ref<StyleMusical>> stylesPreferes) {
        this.stylesPreferesRefs = stylesPreferes;
    }
}

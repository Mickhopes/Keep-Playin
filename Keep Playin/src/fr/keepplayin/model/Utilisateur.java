package fr.keepplayin.model ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;

@Entity
public class Utilisateur implements Serializable, Comparable<Utilisateur>{
    private @Id Long id ;
    private @Index String nom ;
    private @Index String prenom ;
    private @Index String nomDeScene ;
    private @Index String email ;
    private String mobile ;
    private String mdp ; // conserver seulement le hash
    private Date dateDeNaissance ;
    private String sexe ;
    private Departement dpt ;
    private @Load Ref<Instrument> instrumentPrincipalRef ;
    private Date debutApprentissage ;
    private Niveau niveauInstrumentPrincipal ;
    private List<Ref<Instrument>> instrumentsSecondairesRefs ;
    private List<Ref<StyleMusical>> stylesPreferesRefs ;
    private @Index List<Ref<Utilisateur>> amisRefs ;
    private List<Ref<Publication>> publicationsRef;
    private List<Notification> notifications;
    
    public Utilisateur() {
    	instrumentsSecondairesRefs = new ArrayList<Ref<Instrument>>();
    	stylesPreferesRefs = new ArrayList<Ref<StyleMusical>>();
    	amisRefs = new ArrayList<Ref<Utilisateur>>();
    	publicationsRef = new ArrayList<Ref<Publication>>();
    	notifications = new ArrayList<Notification>();
    }

    public Utilisateur(String nom, String prenom, String nomDeScene, String email, String mdp, Date dateDeNaissance, String sexe) {
    	this.nom = nom;
    	this.prenom = prenom;
    	this.nomDeScene = nomDeScene;
    	this.email = email;
    	this.mdp = mdp;
    	this.dateDeNaissance = dateDeNaissance;
    	this.sexe = sexe;
    	
    	instrumentsSecondairesRefs = new ArrayList<Ref<Instrument>>();
    	stylesPreferesRefs = new ArrayList<Ref<StyleMusical>>();
    	amisRefs = new ArrayList<Ref<Utilisateur>>();
    	publicationsRef = new ArrayList<Ref<Publication>>();
    	notifications = new ArrayList<Notification>();
    }
    
    public void ajouterInstrumentSecondaire(Instrument instrumentSecondaire) {
    	instrumentsSecondairesRefs.add(Ref.create(instrumentSecondaire));
    }
    
    public void supprimerInstrumentSecondaire(Ref<Instrument> instrumentSecondaire) {
    	instrumentsSecondairesRefs.remove(instrumentSecondaire);
    }
    
    public void ajouterStylePrefere(StyleMusical styleMusical) {
    	stylesPreferesRefs.add(Ref.create(styleMusical));
    }
    
    public void supprimerStylePrefere(Ref<StyleMusical> styleMusical) {
    	stylesPreferesRefs.remove(styleMusical);
    }
    
    public void ajouterAmi(Utilisateur u) {
    	amisRefs.add(Ref.create(u));
    }
    
    public void supprimerAmi(Ref<Utilisateur> u) {
    	amisRefs.remove(u);
    }
    
    public boolean estAmi(Utilisateur u) {
		return amisRefs.contains(Ref.create(u));
	}
    
    public void ajouterNotification(Notification n) {
    	notifications.add(n);
    }
    
    public void supprimerNotification(Notification n) {
    	notifications.remove(n);
    }
    
    public void ajouterPublication(Publication n) {
    	publicationsRef.add(Ref.create(n));
    }
    
    public void supprimerPublication(Publication n) {
    	publicationsRef.remove(Ref.create(n));
    }
    
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

    public Instrument getInstrumentPrincipal() {
        return instrumentPrincipalRef.get();
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

    public void setInstrumentPrincipal(Instrument instrumentPrincipal) {
        this.instrumentPrincipalRef = Ref.create(instrumentPrincipal);
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

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public List<Publication> getPublications() {
		List<Publication> pList = new ArrayList<Publication>();
		
		for(Ref<Publication> p : publicationsRef) {
			pList.add(p.get());
		}
		
		return pList;
	}

	public void setPublications(List<Publication> publications) {
		List<Ref<Publication>> pList = new ArrayList<Ref<Publication>>();
		
		for(Publication p : publications) {
			pList.add(Ref.create(p));
		}
		
		this.publicationsRef = pList;
	}

	@Override
	public int compareTo(Utilisateur u) {
		return (this.prenom+" "+this.nom).compareTo(u.getPrenom()+" "+u.getNom());
	}
}

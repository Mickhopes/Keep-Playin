package fr.keepplayin.model ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    
    public void supprimerAmi(Utilisateur u) {
    	amisRefs.remove(Ref.create(u));
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
        return instrumentPrincipalRef != null ? instrumentPrincipalRef.get() : null;
    }

    public Date getDebutApprentissage() {
        return debutApprentissage;
    }

    public Niveau getNiveauInstrumentPrincipal() {
        return niveauInstrumentPrincipal;
    }

    public List<Instrument> getInstrumentsSecondaires() {
    	List<Instrument> iList = new ArrayList<Instrument>();
    	
    	for(Ref<Instrument> i : instrumentsSecondairesRefs) {
    		iList.add(i.get());
    	}
    	
        return iList;
    }

    public List<StyleMusical> getStylesPreferes() {
    	List<StyleMusical> sList = new ArrayList<StyleMusical>();
    	
    	for(Ref<StyleMusical> s : stylesPreferesRefs) {
    		sList.add(s.get());
    	}
    	
        return sList;
    }

    public List<Utilisateur> getAmis() {
    	List<Utilisateur> uList = new ArrayList<Utilisateur>();
    	
    	for(Ref<Utilisateur> u : amisRefs) {
    		uList.add(u.get());
    	}
    	
        return uList;
    }

    public void setAmisRefs(List<Utilisateur> amis) {
    	List<Ref<Utilisateur>> uList = new ArrayList<Ref<Utilisateur>>();
    	
    	for(Utilisateur u : amis) {
    		uList.add(Ref.create(u));
    	}
    	
        this.amisRefs = uList;
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
    	if (instrumentPrincipal == null) {
    		this.instrumentPrincipalRef = null;
    	} else {
    		this.instrumentPrincipalRef = Ref.create(instrumentPrincipal);
    	}
    }

    public void setDebutApprentissage(Date debutApprentissage) {
        this.debutApprentissage = debutApprentissage;
    }

    public void setNiveauInstrumentPrincipal(Niveau niveauInstrumentPrincipal) {
        this.niveauInstrumentPrincipal = niveauInstrumentPrincipal;
    }

    public void setInstrumentsSecondaires(List<Instrument> instrumentsSecondaires) {
    	List<Ref<Instrument>> iList = new ArrayList<Ref<Instrument>>();
    	
    	for(Instrument i : instrumentsSecondaires) {
    		iList.add(Ref.create(i));
    	}
    	
        this.instrumentsSecondairesRefs = iList;
    }

    public void setStylesPreferes(List<StyleMusical> stylesPreferes) {
    	List<Ref<StyleMusical>> sList = new ArrayList<Ref<StyleMusical>>();
    	
    	for(StyleMusical s : stylesPreferes) {
    		sList.add(Ref.create(s));
    	}
        this.stylesPreferesRefs = sList;
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

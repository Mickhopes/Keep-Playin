package fr.keepplayin.model ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Instrument implements Serializable{
    @Id Long id;
    TypeInstrument type;
    List<Ref<Utilisateur>> pratiquantsPrincipalRefs ; 
    List<Ref<Utilisateur>> pratiquantsSecondaireRefs ;

    public Instrument() {
    	pratiquantsPrincipalRefs = new ArrayList<Ref<Utilisateur>>();
    	pratiquantsSecondaireRefs = new ArrayList<Ref<Utilisateur>>();
    }
    
    public Instrument(TypeInstrument type) {
    	this.type = type;
    	
    	pratiquantsPrincipalRefs = new ArrayList<Ref<Utilisateur>>();
    	pratiquantsSecondaireRefs = new ArrayList<Ref<Utilisateur>>();
    }
    
    public void ajouterPratiquantPrincipal(Utilisateur u) {
    	pratiquantsPrincipalRefs.add(Ref.create(u));
    }
    
    public void supprimerPratiquantPrincipal(Utilisateur u) {
    	pratiquantsPrincipalRefs.remove(Ref.create(u));
    }
    
    public boolean jouePrincipalement(Utilisateur u) {
    	return pratiquantsPrincipalRefs.contains(Ref.create(u));
    }
    
    public void ajouterPratiquantSecondaire(Utilisateur u) {
    	pratiquantsSecondaireRefs.add(Ref.create(u));
    }
    
    public void supprimerPratiquantSecondaire(Utilisateur u) {
    	pratiquantsSecondaireRefs.remove(Ref.create(u));
    }
    
    public boolean joueSecondairement(Utilisateur u) {
    	return pratiquantsSecondaireRefs.contains(Ref.create(u));
    }
    
    public Long getId() {
        return id;
    }

    public TypeInstrument getType() {
        return type;
    }

    public List<Utilisateur> getPratiquantsPrincipaux() {
    	List<Utilisateur> uList = new ArrayList<Utilisateur>();
    	
    	for(Ref<Utilisateur> u : pratiquantsPrincipalRefs) {
    		uList.add(u.get());
    	}
    	
        return uList;
    }
    
    public List<Utilisateur> getPratiquantsSecondaires() {
    	List<Utilisateur> uList = new ArrayList<Utilisateur>();
    	
    	for(Ref<Utilisateur> u : pratiquantsSecondaireRefs) {
    		uList.add(u.get());
    	}
    	
        return uList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(TypeInstrument type) {
        this.type = type;
    }

    public void setPratiquantsPrincipaux(List<Utilisateur> pratiquants) {
    	List<Ref<Utilisateur>> uList = new ArrayList<Ref<Utilisateur>>();
    	
    	for(Utilisateur u : pratiquants) {
    		uList.add(Ref.create(u));
    	}
    	
        this.pratiquantsPrincipalRefs = uList;
    }
    
    public void setPratiquantsSecondaires(List<Utilisateur> pratiquants) {
    	List<Ref<Utilisateur>> uList = new ArrayList<Ref<Utilisateur>>();
    	
    	for(Utilisateur u : pratiquants) {
    		uList.add(Ref.create(u));
    	}
    	
        this.pratiquantsSecondaireRefs = uList;
    }
    
    @Override
    public boolean equals(Object o) {
    	if (o.getClass().getName().equals("fr.keepplayin.model.Instrument")) {
    		if (((Instrument) o).getType() == this.type) {
    			return true;
    		}
    		return false;
    	}
    	return false;
    }
}

package fr.keepplayin.model ;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Instrument {
    @Id Long id;
    TypeInstrument type;
    List<Ref<Utilisateur>> pratiquantsRefs ; // pratiquants de cet instrument en instrument principal ou en instrument secondaire

    public Instrument() {
    	pratiquantsRefs = new ArrayList<Ref<Utilisateur>>();
    }
    
    public Instrument(TypeInstrument type) {
    	this.type = type;
    	
    	pratiquantsRefs = new ArrayList<Ref<Utilisateur>>();
    }
    
    public void ajouterPratiquant(Utilisateur u) {
    	pratiquantsRefs.add(Ref.create(u));
    }
    
    public void supprimerPratiquant(Ref<Utilisateur> u) {
    	pratiquantsRefs.remove(u);
    }
    
    public Long getId() {
        return id;
    }

    public TypeInstrument getType() {
        return type;
    }

    public List<Ref<Utilisateur>> getPratiquantsRefs() {
        return pratiquantsRefs;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(TypeInstrument type) {
        this.type = type;
    }

    public void setPratiquantsRefs(List<Ref<Utilisateur>> pratiquants) {
        this.pratiquantsRefs = pratiquants;
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

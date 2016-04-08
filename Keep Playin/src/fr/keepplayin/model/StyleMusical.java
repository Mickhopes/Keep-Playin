package fr.keepplayin.model ;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class StyleMusical {
    private @Id Long id ;
    private Style style ;
    private List<Ref<Utilisateur>> amateursRefs ;
    
    public StyleMusical() {
    	amateursRefs = new ArrayList<Ref<Utilisateur>>();
    }
    
    public StyleMusical(Style style) {
    	this.style = style;
    	
    	amateursRefs = new ArrayList<Ref<Utilisateur>>();
    }
    
    public void ajouterAmateur(Utilisateur u) {
    	amateursRefs.add(Ref.create(u));
    }
    
    public void supprimerAmateur(Ref<Utilisateur> u) {
    	amateursRefs.remove(u);
    }

    public Long getId() {
        return id;
    }

    public Style getStyle() {
        return style;
    }

    public List<Ref<Utilisateur>> getAmateursRefs() {
        return amateursRefs;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public void setAmateursRefs(List<Ref<Utilisateur>> amateurs) {
        this.amateursRefs = amateurs;
    }
    
    @Override
    public boolean equals(Object o) {
    	if (o.getClass().getName().equals("fr.keepplayin.model.StyleMusical")) {
    		if (((StyleMusical) o).getStyle() == this.style) {
    			return true;
    		}
    		return false;
    	}
    	return false;
    }
}

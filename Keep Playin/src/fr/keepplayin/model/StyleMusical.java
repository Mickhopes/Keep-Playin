package fr.keepplayin.model ;

import java.util.List;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class StyleMusical {
    @Id Long id ;
    Style style ;
    List<Ref<Utilisateur>> amateursRefs ;
    
    public StyleMusical(Style style) {
    	this.style = style;
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
}

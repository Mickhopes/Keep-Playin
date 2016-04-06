package fr.keepplayin.model ;

import java.util.List;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Instrument {
    @Id Long id;
    TypeInstrument type;
    NomInstrument nom;
    List<Ref<Utilisateur>> pratiquantsRefs ; // pratiquants de cet instrument en instrument principal ou en instrument secondaire

    public Long getId() {
        return id;
    }

    public TypeInstrument getType() {
        return type;
    }

    public NomInstrument getNom() {
        return nom;
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

    public void setNom(NomInstrument nom) {
        this.nom = nom;
    }

    public void setPratiquantsRefs(List<Ref<Utilisateur>> pratiquants) {
        this.pratiquantsRefs = pratiquants;
    }
}

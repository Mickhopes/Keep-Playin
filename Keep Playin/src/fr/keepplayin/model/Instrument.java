package fr.keepplayin.model ;

import java.util.List;

public class Instrument {
    int id;
    TypeInstrument type;
    NomInstrument nom;
    List<Utilisateur> pratiquants ; // pratiquants de cet instrument en instrument principal ou en instrument secondaire

    public int getId() {
        return id;
    }

    public TypeInstrument getType() {
        return type;
    }

    public NomInstrument getNom() {
        return nom;
    }

    public List<Utilisateur> getPratiquants() {
        return pratiquants;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(TypeInstrument type) {
        this.type = type;
    }

    public void setNom(NomInstrument nom) {
        this.nom = nom;
    }

    public void setPratiquants(List<Utilisateur> pratiquants) {
        this.pratiquants = pratiquants;
    }
}

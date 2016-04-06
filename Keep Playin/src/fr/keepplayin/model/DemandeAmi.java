package fr.keepplayin.model ;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;

@Entity
public class DemandeAmi extends Demande{
    Ref<Utilisateur> cibleRef ;

    public Ref<Utilisateur> getCible() {
        return cibleRef;
    }

    public void setCibleRef(Ref<Utilisateur> cible) {
        this.cibleRef = cible;
    }
}

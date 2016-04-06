package fr.keepplayin.model ;

public class DemandeAmi extends Demande{
    Utilisateur cible ;

    public Utilisateur getCible() {
        return cible;
    }

    public void setCible(Utilisateur cible) {
        this.cible = cible;
    }
}

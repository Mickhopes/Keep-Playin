package fr.keepplayin.model ;

public enum Niveau {
    DEBUTANT("Débutant"),
    INTERMEDIAIRE("Intermédiaire"),
    CONFIRME("Confirmé"),
    EXPERT("Expert");
    
    private String nom;
    
    Niveau(String nom) {
    	this.nom = nom;
    }
    
    @Override
    public String toString() {
    	return nom;
    }
}

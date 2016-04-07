package fr.keepplayin.model ;

public enum Style {
    ROCK("Rock"),
    HARDROCK("Hard Rock"),
    METAL("Métal"),
    POP("Pop"),
    POPROCK("Pop Rock"),
    CLASSIQUE("Classique"),
    TECHNO("Techno"),
    REGGAE("Reggae");
    
    private String nom;
    
    Style(String nom) {
    	this.nom = nom;
    }
    
    @Override
    public String toString() {
    	return nom;
    }
}

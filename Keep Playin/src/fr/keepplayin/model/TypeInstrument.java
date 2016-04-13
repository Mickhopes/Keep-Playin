package fr.keepplayin.model ;

public enum TypeInstrument {
    GUITARESECHE("Guitare sèche", "Corde"),
    GUITAREELECTRIQUE("Guitare électrique", "Corde"),
    BASSE("Basse", "Corde"),
    ALTO("Alto", "Corde"),
    VIOLON("Violon", "Corde"),
    VIOLONCELLE("Violoncelle", "Corde"),
    CONTREBASSE("Contrebasse", "Corde"),
    PIANO("Piano", "Corde"),
    HARPE("Harpe", "Corde"),
    BATTERIE("Batterie", "Percussion"),
    THEREMINE("Thérémine", "Electronique"),
    SYNTHETISEUR("Synthétiseur", "Electronique"),
    FLUTE("Flûte", "Vent"),
    FLUTEABEC("Flûte à bec", "Vent"),
    FLUTETRAVERSIERE("Flûte traversière", "Vent"),
    FLUTEDEPAN("Flûte de pan", "Vent");
    
    private String nom;
    private String type;
    
    TypeInstrument(String nom, String type) {
    	this.nom = nom;
    }
    
    public String getNom() {
    	return nom;
    }
    
    public String getType() {
    	return type;
    }
    
    @Override
    public String toString() {
    	return nom;
    }
}

package fr.keepplayin.model ;

public enum NomInstrument {
    GUITARESECHE("Guitare sèche"),
    GUITAREELECTRIQUE("Guitare électrique"),
    BASSE("Basse"),
    ALTO("Alto"),
    VIOLON("Violon"),
    VIOLONCELLE("Violoncelle"),
    CONTREBASSE("Contrebasse"),
    PIANO("Piano"),
    HARPE("Harpe"),
    BATTERIE("Batterie"),
    THEREMINE("Theremine"),
    SYNTHETISEUR("Synthétiseur"),
    FLUTE("Flûte"),
    FLUTEABEC("Flûte à bec"),
    FLUTETRAVERSIERE("Flûte traversière"),
    FLUTEDEPAN("Flûte de pan");
    
    private String nom;
    
    NomInstrument(String nom) {
    	this.nom = nom;
    }
    
    @Override
    public String toString() {
    	return nom;
    }
}

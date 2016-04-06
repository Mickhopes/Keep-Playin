package fr.keepplayin.model ;

public enum Departement {
    AIN("01","Ain","Auvergne-Rhône-Alpes"),
    AISNE("02","Aisne","Nord-Pas-de-Calais-Picardie"),
    ALLIER("03","Allier","Auvergne-Rhône-Alpes"),
    ALPESDEHAUTEPROVENCE("04","Alpes-de-Haute-Provence","Provence-Alpes-Côte-d'Azur"),
    HAUTESALPES("05","Hautes-Alpes","Provence-Alpes-Côte-d'Azur"),
    ALPESMARTITIMES("06","Alpes-Maritimes","Provence-Alpes-Côte-d'Azur"),
    ARDECHE("07","Ardèche","Auvergne-Rhône-Alpes"),
    ARDENNES("08","Ardennes","Alsace-Champagne-Ardenne-Lorraine"),
    ARIEGE("09","Ariège","Languedoc-Roussillon-Midi-Pyrénées"),
    AUBE("10","Aube","Alsace-Champagne-Ardenne-Lorraine"),
    AUDE("11","Aude","Languedoc-Roussillon-Midi-Pyrénées"),
    AVEYRON("12","Aveyron","Languedoc-Roussillon-Midi-Pyrénées"),
    BOUCHESDURHONE("13","Bouches-du-Rhône","Provence-Alpes-Côte-d'Azur"),
    CALVADOS("14","Calvados","Normandie"),
    CANTAL("15","Cantal","Auvergne-Rhône-Alpes"),
    CHARENTE("16","Charente","Aquitaine-Lumousin-Poitou_Charentes"),
    CHARENTEMARITIME("17","Charente-Maritime","Aquitaine-Lumousin-Poitou_Charentes"),
    CHER("18","Cher","Centre-Val de Loire"),
    CORREZE("19","Corrèze","Aquitaine-Lumousin-Poitou_Charentes"),
    CORSEDUSUD("2A","Corse-du-Sud","Corse"),
    HAUTECORSE("2B","Haute-Corse","Corse");

    String code ;
    String dpt ;
    String region ;

    private Departement(String code, String dpt, String region){
        this.code = code ;
        this.dpt = dpt;
        this.region = region ;
    }

    public String getCode() {
        return code;
    }

    public String getDpt() {
        return dpt;
    }

    public String getRegion() {
        return region;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDpt(String dpt) {
        this.dpt = dpt;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}

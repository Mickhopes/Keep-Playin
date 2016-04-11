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
    HAUTECORSE("2B","Haute-Corse","Corse"),
    COTEDOR("21","Côte-d'Or","Bourgogne-Franche-Comté"),
    COTESDARMOR("22","Côtes-d'Armor","Bretagne"),
    CREUSE("23","Creuse","Aquitaine-Lumousin-Poitou_Charentes"),
    DORDOGNE("24","Dordogne","Aquitaine-Lumousin-Poitou_Charentes"),
    DOUBS("25","Doubs","Bourgogne-Franche-Comté"),
    DROME("26","Drôme","Auvergne-Rhône-Alpes"),
    EURE("27","Eure","Normandie"),
    EUREETLOIR("28","Eure-et-Loir","Centre-Val de Loire"),
    FINISTERE("29","Finistère","Bretagne"),
    GARD("30","Gard","Languedoc-Roussillon-Midi-Pyrénées"),
    HAUTEGARONNE("31","Haute-Garonne","Languedoc-Roussillon-Midi-Pyrénées"),
    GERS("32","Gers","Languedoc-Roussillon-Midi-Pyrénées"),
    GIRGONDE("33","Gironde","Aquitaine-Lumousin-Poitou_Charentes"),
    HERAULT("34","Hérault","Languedoc-Roussillon-Midi-Pyrénées"),
    ILLEETVILAINE("35","Ille-et-Vilaine","Bretagne"),
    INDRE("36","Indre","Centre-Val de Loire"),
    INDREETLOIRE("37","Indre-et-Loire","Centre-Val de Loire"),
    ISERE("38","Isère","Auvergne-Rhône-Alpes"),
    JURA("39","Jura","Bourgogne-Franche-Comté"),
    LANDES("40","Landes","Aquitaine-Lumousin-Poitou_Charentes"),
    LOIRETCHER("41","Loir-et-Cher","Centre-Val de Loire"),
    LOIRE("42","Loire","Auvergne-Rhône-Alpes"),
    HAUTELOIRE("43","Haute-Loire","Auvergne-Rhône-Alpes"),
    LOIREATLANTIQUE("44","Loire-Atlantique","Pays de la Loire"),
    LOIRET("45","Loiret","Centre-Val de Loire"),
    LOT("46","Lot","Languedoc-Roussillon-Midi-Pyrénées"),
    LOTETGARONNE("47","Lot-et-Garonne","Aquitaine-Lumousin-Poitou_Charentes"),
    LOZERE("48","Lozère","Languedoc-Roussillon-Midi-Pyrénées"),
    MAINEETLOIRE("49","Maine-et-Loire","Pays de la Loire"),
    MANCHE("50","Manche","Normandie"),
    MARNE("51","Marne","Alsace-Champagne-Ardenne-Lorraine"),
    HAUTEMARNE("52","Haute-Marne","Alsace-Champagne-Ardenne-Lorraine"),
    MAYENNE("53","Mayenne","Pays de la Loire"),
    MEURTHEETMOSELLE("54","Meurthe-et-Moselle","Alsace-Champagne-Ardenne-Lorraine"),
    MEUSE("55","Meuse","Alsace-Champagne-Ardenne-Lorraine"),
    MORBIHAN("56","Morbihan","Bretagne"),
    MOSELLE("57","Moselle","Alsace-Champagne-Ardenne-Lorraine"),
    NIEVRE("58","Nièvre","Bourgogne-Franche-Comté"),
    NORD("59","Nord","Nord-Pas-de-Calais-Picardie"),
    OISE("60","Oise","Nord-Pas-de-Calais-Picardie"),
    ORNE("61","Orne","Normandie"),
    PASDECALAIS("62","Pas-de-Calais","Nord-Pas-de-Calais-Picardie"),
    PUYDEDOME("63","Puy-de-Dôme","Auvergne-Rhône-Alpes"),
    PYRENEESATLANTIQUES("64","Pyrénées-Atlantique","Aquitaine-Lumousin-Poitou_Charentes"),
    HAUTESPYRENEES("65","Hautes-Pyrénées","Languedoc-Roussillon-Midi-Pyrénées"),
    PYRENEESORIENTALES("66","Pyrénées-Orientales","Languedoc-Roussillon-Midi-Pyrénées"),
    BASRHIN("67","Bas-Rhin","Alsace-Champagne-Ardenne-Lorraine"),
    HAUTRHIN("68","Haut-Rhin","Alsace-Champagne-Ardenne-Lorraine"),
    RHONE("69","Rhône","Auvergne-Rhône-Alpes"),
    HAUTESAONE("70","Haute-Saône","Bourgogne-Franche-Comté"),
    SAONEETLOIRE("71","Saône-et-Loire","Bourgogne-Franche-Comté"),
    SARTHE("72","Sarthe","Pays de la Loire"),
    SAVOIE("73","Savoie","Auvergne-Rhône-Alpes"),
    HAUTESAVOIE("74","Haute-Savoie","Auvergne-Rhône-Alpes"),
    PARIS("75","Paris","Ile-de-France"),
    SEINEMARITIME("76","Seine-Maritime","Normandie"),
    SEINEETMARNE("77","Seine-et-Marne","Ile-de-France"),
    YVELINES("78","Yvelines","Ile-de-France"),
    DEUXSEVRES("79","Deux-Sèvres","Aquitaine-Lumousin-Poitou_Charentes"),
    SOMME("80","Somme","Nord-Pas-de-Calais-Picardie"),
    TARN("81","Tarn","Languedoc-Roussillon-Midi-Pyrénées"),
    TARNETGARONNE("82","Tarn-er-Garonne","Languedoc-Roussillon-Midi-Pyrénées"),
    VAR("83","Var","Provence-Alpes-Côte-d'Azur"),
    VAUCLUSE("84","Vaucluse","Provence-Alpes-Côte-d'Azur"),
    VENDEE("85","Vendée","Pays de la Loire"),
    VIENNE("86","Vienne","Aquitaine-Lumousin-Poitou_Charentes"),
    HAUTEVIENNE("87","Haute-Vienne","Aquitaine-Lumousin-Poitou_Charentes"),
    VOSGES("88","Vosges","Alsace-Champagne-Ardenne-Lorraine"),
    YONNE("89","Yonne","Bourgogne-Franche-Comté"),
    TERRITOIREDEBELFORT("90","Territoire de Belfort","Bourgogne-Franche-Comté"),
    ESSONNE("91","Essonne","Ile-de-France"),
    HAUTSDESEINE("92","Hauts-de-Seine","Ile-de-France"),
    SEINESAINTDENIS("93","Seine-Saint-Denis","Ile-de-France"),
    VALDEMARNE("94","Val-de-Marne","Ile-de-France"),
    VALDOISE("95","Val-d'Oise","Ile-de-France"),
    GUADELOUPE("971","Guadeloupe","Guadeloupe"),
    MARTINIQUE("972","Martinique","Martinique"),
    GUYANE("973","Guyane","Guyane"),
    LAREUNION("974","La Réunion","La Réunion"),
    MAYOTTE("976","Mayotte","Mayotte");

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

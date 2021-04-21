package com.example.testrecyclerview;

public class Donnee {

    public static final String[] nomPlanetes = {"Mercure","Venus","Terre","Mars","Jupiter","Saturne","Uranus","Neptune"};
    public static final String[] taillePlanetes = {"2439","6051","6371","3389","69911","58232","25362","24622"};

    private final String nomPlanete;
    private final String taillePlanete;

    Donnee(String nomPlanete, String taillePlanete){
        this.nomPlanete = nomPlanete;
        this.taillePlanete = taillePlanete;
    }

    public String getNomPlanete() {
        return nomPlanete;
    }

    public String getTaillePlanete() {
        return taillePlanete;
    }

}
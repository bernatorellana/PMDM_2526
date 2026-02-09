package com.example.tinderapp.Model;

import java.util.ArrayList;
import java.util.List;

public class Provincia {

    private int codi;
    private String nom;


    private static List<Provincia> _provincies;
    public static List<Provincia> getProvincies(){
        if(_provincies==null){
            _provincies = new ArrayList<>();
            _provincies.add(new Provincia(1,"Barcelona"));
            _provincies.add(new Provincia(2,"Girona"));
            _provincies.add(new Provincia(3,"LLeida"));
            _provincies.add(new Provincia(4,"Tarragona"));
        }
        return _provincies;
    }


    public Provincia(int codi, String nom) {
        this.codi = codi;
        this.nom = nom;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

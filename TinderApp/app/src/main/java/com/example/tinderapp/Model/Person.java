package com.example.tinderapp.Model;

import com.example.tinderapp.R;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private int codi;

    private int imatgeResource;

    private String nom;
    private String NIF;
    private Sexe sexe;
    private Provincia prov;



    private static List<Person> _persons;

    public static List<Person> getPersones(){
        if(_persons==null) {
            _persons = new ArrayList<>();
            _persons.add(new Person(1, R.drawable.homer, "Homer", "12345678A", Sexe.HOME, Provincia.getProvincies().get(0)));
            _persons.add(new Person(2, R.drawable.left, "Margie", "12345678A", Sexe.DONA, Provincia.getProvincies().get(1)));
        }
        return _persons;
    }


    public Person(int codi, int imatgeResource, String nom, String NIF, Sexe sexe, Provincia prov) {
        this.codi = codi;
        this.imatgeResource = imatgeResource;
        this.nom = nom;
        this.NIF = NIF;
        this.sexe = sexe;
        this.prov = prov;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public int getImatgeResource() {
        return imatgeResource;
    }

    public void setImatgeResource(int imatgeResource) {
        this.imatgeResource = imatgeResource;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public Provincia getProv() {
        return prov;
    }

    public void setProv(Provincia prov) {
        this.prov = prov;
    }
}

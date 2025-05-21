package de.hsos.immo.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Adresse extends PanacheEntity {
    private String strasse;
    private int hausnummer;
    private String ort;
    private int postleitzahl;

    public Adresse(String strasse, int postleitzahl, int hausnummer, String ort) {
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.ort = ort;
        this.postleitzahl = postleitzahl;
    }

    public Adresse() {

    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(int hausnummer) {
        this.hausnummer = hausnummer;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public int getPostleitzahl() {
        return postleitzahl;
    }

    public void setPostleitzahl(int postleitzahl) {
        this.postleitzahl = postleitzahl;
    }
}

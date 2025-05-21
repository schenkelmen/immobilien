package de.hsos.immo.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Immo extends PanacheEntity {
    private String name;
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    private Adresse adresse;

    public Immo(String name, String description, Adresse adresse) {
        this.name = name;
        this.description = description;
        this.adresse = adresse;
    }

    public Immo() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}

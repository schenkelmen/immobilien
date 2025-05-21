package de.hsos.immo.boundary.dto;

import de.hsos.immo.entity.Adresse;

public record AdresseDTO(
        String strasse,
        int hausnummer,
        int postleitzahl,
        String ort
) {

    public static AdresseDTO from(Adresse adresse) {
        return new AdresseDTO(adresse.getStrasse(), adresse.getHausnummer(), adresse.getPostleitzahl(), adresse.getOrt());
    }

    public Adresse toEntity() {
        return new Adresse(strasse, hausnummer, postleitzahl, ort);
    }
}

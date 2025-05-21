package de.hsos.immo.boundary.dto;

import de.hsos.immo.entity.Adresse;
import de.hsos.immo.entity.Immo;
import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbTransient;

import java.util.Objects;

public record ImmoDTO(
    long id,
    String name,
    String description,
    AdresseDTO adresse
){
    @JsonbCreator
    public ImmoDTO{
        Objects.requireNonNull(name);
        Objects.requireNonNull(description);
        Objects.requireNonNull(adresse);
    }

    public static ImmoDTO toDTO(Immo immo){
        Adresse adresse = immo.getAdresse();
        AdresseDTO adresseDTO = adresse != null ? AdresseDTO.from(adresse) : null;
        return new ImmoDTO(immo.id, immo.getName(), immo.getDescription(), adresseDTO);
    }

}

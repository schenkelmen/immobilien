package de.hsos.immo.boundary.dto;

import de.hsos.immo.entity.Adresse;
import jakarta.json.bind.annotation.JsonbCreator;

import java.util.Objects;

public record NeuImmoDTO (
        String name,
        String description,
        Adresse adresse
) {
    @JsonbCreator
    public NeuImmoDTO{
        Objects.requireNonNull(name);
        Objects.requireNonNull(description);
        Objects.requireNonNull(adresse);
    }
}

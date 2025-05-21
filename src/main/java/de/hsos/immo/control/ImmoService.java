package de.hsos.immo.control;

import de.hsos.immo.entity.Adresse;
import de.hsos.immo.entity.Immo;

import java.util.Collection;
import java.util.Optional;

public interface ImmoService {
    long neueImmobilieAnlegen(String name, String description, Adresse adresse);
    Optional<Immo> getImmobilieById(long id);
    Collection<Immo> getImmobilieByAdresse(Adresse adresse);
    Collection<Immo> getAllImmobilie();
    void adresseSetzen(long id, Adresse adresse);
    boolean immoLoeschen(long id);
}

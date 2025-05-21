package de.hsos.immo.gateway;

import de.hsos.immo.control.ImmoService;
import de.hsos.immo.entity.Adresse;
import de.hsos.immo.entity.Immo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.Collection;
import java.util.Optional;

@ApplicationScoped
public class ImmoRepository implements ImmoService {

    @Inject
    EntityManager em;

    @Override
    @Transactional
    public long neueImmobilieAnlegen(String name, String description, Adresse adresse) {
        Adresse neuAdresse = new Adresse(adresse.getStrasse(), adresse.getHausnummer(),adresse.getPostleitzahl(),adresse.getOrt());
        Immo immo = new Immo(name, description, neuAdresse);
        em.persist(immo);
        return immo.id;
    }

    @Override
    @Transactional
    public Optional<Immo> getImmobilieById(long id) {
        return Optional.ofNullable(em.find(Immo.class, id));
    }

    @Override
    @Transactional
    public Collection<Immo> getImmobilieByAdresse(Adresse adresse) {
        return em.createQuery("SELECT I FROM Immo I WHERE I.adresse = adresse", Immo.class).getResultList();
    }

    @Override
    @Transactional
    public Collection<Immo> getAllImmobilie() {
        return em.createQuery("SELECT I FROM Immo I", Immo.class).getResultList();
    }

    @Override
    @Transactional
    public void adresseSetzen(long id, Adresse adresse) {
        Immo immo = em.find(Immo.class, id);
        immo.setAdresse(adresse);
        em.merge(immo);
    }

    @Override
    public boolean immoLoeschen(long id) {
        try{
            Immo immo = em.find(Immo.class, id);
            em.remove(immo);
            return true;
        }
        catch(Exception e){
            System.out.println("Fehler beim loeschen der Immo");
            return false;
        }
    }
}

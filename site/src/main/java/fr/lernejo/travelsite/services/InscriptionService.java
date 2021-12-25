package fr.lernejo.travelsite.services;

import fr.lernejo.travelsite.entities.InscriptionEntity;
import fr.lernejo.travelsite.models.Inscription;
import fr.lernejo.travelsite.repositories.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
@ComponentScan({"fr.lernejo.travelsite.repositories"})
@Repository
public class InscriptionService {
    private final InscriptionRepository inscriptionRepository;

    @Autowired
    public InscriptionService(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }

    public void inscription(Inscription inscription) {
        InscriptionEntity inscriptionEntity = new InscriptionEntity();
        inscriptionEntity.userCountry = inscription.userCountry();
        inscriptionEntity.userEmail = inscription.userEmail();
        inscriptionEntity.minimumTemperatureDistance = inscription.minimumTemperatureDistance();
        inscriptionEntity.weatherExpectation = inscription.weatherExpectation();
        inscriptionEntity.userName = inscription.userName();
        inscriptionRepository.save(inscriptionEntity);
    }
}

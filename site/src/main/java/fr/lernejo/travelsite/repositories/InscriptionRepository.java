package fr.lernejo.travelsite.repositories;

import fr.lernejo.travelsite.entities.InscriptionEntity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@ComponentScan({"fr.lernejo.travelsite.services"})
@Repository
public interface InscriptionRepository extends CrudRepository<InscriptionEntity, Long> {
}

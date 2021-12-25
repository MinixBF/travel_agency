package fr.lernejo.travelsite.services;

import fr.lernejo.travelsite.models.Travel;
import fr.lernejo.travelsite.entities.TravelEntity;
import fr.lernejo.travelsite.repositories.TravelRepository;
import org.springframework.stereotype.Service;

@Service
public class TravelService {
    private TravelRepository travelRepository;

    public void save(TravelEntity travel) {
        travelRepository.save(travel);
    }

    public Travel[] getTravels(String userName) {
        Travel[] travels = new Travel[2];
        Travel test = new Travel("test1", 38.5);
        travels[0] = test;
        Travel test2 = new Travel("test1", 38.5);
        travels[1] = test2;
        return travels;
    }
}

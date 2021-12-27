package fr.lernejo.travelsite.services;

import fr.lernejo.travelsite.models.Country;
import fr.lernejo.travelsite.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TravelService {
    private final List<Country> travels = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    public TravelService() {
        travels.add(new Country("France", 18.5));
        travels.add(new Country("Italie", 20.5));
    }

    public void inscription(User user) {
        users.add(user);
    }

    public List<Country> getTravels(String userName) {
        return travels;
    }
}

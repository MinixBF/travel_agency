package fr.lernejo.travelsite.services;

import fr.lernejo.travelsite.models.Country;
import fr.lernejo.travelsite.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SiteService {
    private final List<Country> travels = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    // INSCRIPTION :
    public void inscription(User user) {
        users.add(user);
    }

    // TRAVELS :
    public List<Country> getTravels(String userName) {
        return travels;
    }

}

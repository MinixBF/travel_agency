package fr.lernejo.travelsite.services;

import fr.lernejo.travelsite.models.*;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class SiteService {
    private final List<User> users = new ArrayList<>();

    final PredictionEngineClient predictionEngineClient;
    private final ArrayList<String> countries = new ArrayList<>();


    public SiteService(PredictionEngineClient predictionEngineClient) {
        this.predictionEngineClient = predictionEngineClient;
        try {
            this.countries.addAll(new String(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream("countries.txt")).readAllBytes(), StandardCharsets.UTF_8).lines().toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // INSCRIPTION :
    public void inscription(User user) {
        users.add(user);
    }

    // TRAVELS :
    // Return Country and Temperature
    public Object getTravels(String userName) {
        List<Country> travels = new ArrayList<>();
        User userFind = users.stream().filter(user -> user.userName().equals(userName)).findFirst().orElseThrow();
        double userPrediction = getTemperatureMoy(userFind.userCountry());
        countries.forEach(country -> {
            if (country != null && country.length() > 0 && !country.equals(userFind.userCountry())) {
                double temperature = getTemperatureMoy(country);
                if (userFind.weatherExpectation().equals(WeatherExpectation.COLDER.toString()) && Math.abs(temperature - userFind.minimumTemperatureDistance()) < userPrediction|| userFind.weatherExpectation().equals(WeatherExpectation.WARMER.toString()) && Math.abs(temperature + userFind.minimumTemperatureDistance()) > userPrediction) {
                    travels.add(new Country(country, temperature));
                }
            }
        });
        return travels;
    }

    //GetTemperatureMoy from country
    private double getTemperatureMoy(String country) {
        return Objects.requireNonNull(getTemperature(country)).getTemperature();
    }

    private Prediction getTemperature(String country) {
        try {
            return predictionEngineClient.getTemperature(country).execute().body();
        } catch (IOException e) {
            System.err.println("Error while calling the API : Could not get the temperature for " + country);
            e.printStackTrace();
        }
        return null;
    }

}

package fr.lernejo.travelsite.services;

import fr.lernejo.travelsite.models.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class SiteService {
    private final List<User> users = new ArrayList<>();

    final PredictionEngineClient predictionEngineClient;
    private final List<String> countries;

    public SiteService(PredictionEngineClient predictionEngineClient) {
        this.predictionEngineClient = predictionEngineClient;
        this.countries = getCountries();

    }

    // INSCRIPTION :
    // Return N/A
    // User Properties : String userEmail, String userName, String userCountry, String weatherExpectation , double minimumTemperatureDistance
    public void inscription(User user) {
        users.add(user);
    }

    // TRAVELS :
    // Return Country and Temperature
    public Object getTravels(String userName) {
        List<Country> travels = new ArrayList<>();
        User userFind = users.stream().filter(user -> user.userName().equals(userName)).findFirst().orElseThrow();
        double userPrediction = getTemperatureMoy(userFind.userCountry());
        if (userPrediction != -1) {
            countries.forEach(country -> {
                if (country != null && country.length() > 0 && !country.equals(userFind.userCountry())) {
                    double temperature = getTemperatureMoy(country);
                    if (temperature != -1 && userFind.weatherExpectation().equals(WeatherExpectation.COLDER.toString()) && Math.abs(temperature - userFind.minimumTemperatureDistance()) < userPrediction|| userFind.weatherExpectation().equals(WeatherExpectation.WARMER.toString()) && Math.abs(temperature + userFind.minimumTemperatureDistance()) > userPrediction) {
                        travels.add(new Country(country, temperature));
                    }
                }
            });
        }
        return travels;
    }

    //GetTemperatureMoy from country
    private double getTemperatureMoy(String country) {
        Prediction temp = getTemperature(country);
        return temp != null ? temp.getTemperature() : -1;
    }

    // Country :
    public List<String> getCountries() {
        List<String> countries;
        String fileContent = null;
        try {
            fileContent = new String(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("countries.txt")).readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) { e.printStackTrace(); }
        assert fileContent != null;
        countries = fileContent.lines()
            .filter(Objects::nonNull).toList();
        return countries;
    }

    private Prediction getTemperature(String country) {
        Prediction predictions = null;
        Call<Prediction> call = predictionEngineClient.getTemperature(country);
        try {
            if (call.execute().isSuccessful() && call.execute().body() != null && call.execute().code() == 200) {
                predictions = (call.execute().body());
            }
        } catch (IOException e) {
            e.printStackTrace();
            call.cancel();
        }
        return predictions;
    }

}

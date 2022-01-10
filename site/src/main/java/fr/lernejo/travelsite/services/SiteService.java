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
import java.util.stream.Stream;

@Service
public class SiteService {
    private final List<User> users = new ArrayList<>();

    final PredictionEngineClient predictionEngineClient;
    private final Stream<String> countries;

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
        User userFind = users.stream().filter(user -> user.userName().equals(userName)).findFirst().orElse(null);
        if (userFind == null) {
            return ResponseEntity.status(417).body("Unknown username (CODE 417)");
        }
        double userPrediction = getTemperatureMoy(userFind.userCountry());
        if (userPrediction != -1) {
            countries.forEach(country -> {
                double temperature = getTemperatureMoy(country);
                if (userFind.weatherExpectation().equals(WeatherExpectation.COLDER.toString()) && Math.abs(temperature - userPrediction) < userFind.minimumTemperatureDistance()
                    || userFind.weatherExpectation().equals(WeatherExpectation.WARMER.toString()) && Math.abs(temperature + userPrediction) > userFind.minimumTemperatureDistance()) {
                    travels.add(new Country(country, temperature));
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
    public Stream<String> getCountries() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("countries.txt");
        assert inputStream != null;
        String content = null;
        try {
            content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert content != null;
        return content.lines();
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

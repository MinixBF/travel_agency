package fr.lernejo.travelsite.services;

import fr.lernejo.travelsite.models.Prediction;
import fr.lernejo.travelsite.models.PredictionEngineClient;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.io.IOException;

@Service
public record PredictionEngineService(PredictionEngineClient predictionEngineClient) {

    public Prediction getTemperature(String country) {
        try {
            return predictionEngineClient.getTemperature(country).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

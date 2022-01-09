package fr.lernejo.travelsite.services;

import fr.lernejo.prediction.models.Prediction;
import fr.lernejo.travelsite.models.PredictionEngineClient;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.io.IOException;

@Service
public record PredictionEngineService(PredictionEngineClient predictionEngineClient) {

    public Prediction getTemperature(String Country) {
        Call<Prediction> call = predictionEngineClient.getTemperature(Country);
        try {
            return call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

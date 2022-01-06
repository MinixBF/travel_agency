package fr.lernejo.travelsite.services;

import fr.lernejo.travelsite.models.PredictionEngineClient;
import fr.lernejo.travelsite.models.Country;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.io.IOException;

@Service
public class PredictionEngineService {

    private final PredictionEngineClient predictionEngineClient;

    public PredictionEngineService(PredictionEngineClient predictionEngineClient) {
        this.predictionEngineClient = predictionEngineClient;
    }

    public Country getTemperature(String Country) throws IOException {
        Call<Country> call = predictionEngineClient.getTemperature(Country);
        return call.execute().body();
    }

}

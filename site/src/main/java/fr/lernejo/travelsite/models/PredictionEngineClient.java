package fr.lernejo.travelsite.models;

import fr.lernejo.travelsite.models.Country;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface PredictionEngineClient {

    @GET("/api/predict")
    Call<List<String>> getPredictions();

    @GET("/api/temperature")
    Call<Country> getTemperature(@Query("country") String country);
}


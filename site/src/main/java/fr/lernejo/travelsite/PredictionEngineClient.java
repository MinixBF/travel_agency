package fr.lernejo.travelsite;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface PredictionEngineClient {

    @GET("/api/predict")
    Call<List<String>> getPredictions();
}

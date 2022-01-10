package fr.lernejo.travelsite.models;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import java.util.List;

public interface PredictionEngineClient {

    @GET("/api/temperature")
    @Headers("Accept:application/json")
    Call<Prediction> getTemperature(@Query("country") String country);
}


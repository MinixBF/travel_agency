package fr.lernejo.prediction.models;

import java.util.List;

public class Prediction {
    public String country;
    public List<Temperature> temperatures;

    public Prediction(String country,List<Temperature> temperatures) {
        this.country = country;
        this.temperatures = temperatures;
    }
}

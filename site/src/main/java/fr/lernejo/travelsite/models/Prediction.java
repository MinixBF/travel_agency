package fr.lernejo.travelsite.models;

import java.util.List;

public record Prediction(String country, List<Temperature> temperatures) {
    public double getTemperature() {
        return temperatures.stream().mapToDouble(Temperature::temperature).average().orElse(0);
    }
}

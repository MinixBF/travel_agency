package fr.lernejo.travelsite.models;

import java.util.List;
import java.util.Objects;

public record Prediction(String country, List<Temperature> temperatures) {
    public double getTemperature() {
        return temperatures.stream().filter(Objects::nonNull).mapToDouble(Temperature::temperature).filter(Objects::nonNull).average().orElseThrow();
    }
}

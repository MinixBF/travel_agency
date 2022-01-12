package fr.lernejo.travelsite.models;

import java.util.List;
import java.util.Objects;

public record Prediction(String country, List<Temperature> temperatures) {
}

package fr.lernejo.travelsite.models;

import java.util.List;

public record Prediction(String country, List<Temperature> temperatures) {}

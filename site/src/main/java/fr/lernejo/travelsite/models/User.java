package fr.lernejo.travelsite.models;

public record User(String userEmail, String userName, String userCountry, String weatherExpectation , double minimumTemperatureDistance) {}

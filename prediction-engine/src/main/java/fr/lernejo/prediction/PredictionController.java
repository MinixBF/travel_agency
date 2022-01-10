package fr.lernejo.prediction;

import fr.lernejo.travelsite.models.Prediction;
import fr.lernejo.travelsite.models.Temperature;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PredictionController {

    private final TemperatureService temperatureService;

    public PredictionController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping("/api/temperature")
    public Prediction getTemperature(@RequestParam String country) {
        List<Temperature> temperatures = new ArrayList<>();
        LocalDate dateNow = LocalDate.now();
        temperatures.add(new Temperature(dateNow.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) ,this.temperatureService.getTemperature(country)));
        temperatures.add(new Temperature(dateNow.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) ,this.temperatureService.getTemperature(country)));
        return new Prediction(country,temperatures);
    }
}

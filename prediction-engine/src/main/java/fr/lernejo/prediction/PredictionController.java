package fr.lernejo.prediction;

import fr.lernejo.prediction.models.Prediction;
import fr.lernejo.prediction.models.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PredictionController {

    private final TemperatureService temperatureService;
    private final List<Temperature> temperatures = new ArrayList<>();

    public PredictionController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping("/api/temperature")
    public Prediction getTemperature(@RequestParam String country) {
        var temperature = this.temperatureService.getTemperature(country);
        System.out.println(temperature);
        var temperatures = this.temperatures;
        return new Prediction(country,temperatures);
    }
}

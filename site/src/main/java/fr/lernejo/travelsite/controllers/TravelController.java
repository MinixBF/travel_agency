package fr.lernejo.travelsite.controllers;

import fr.lernejo.travelsite.models.Country;
import fr.lernejo.travelsite.services.TravelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/api/travels")
@RestController
public class TravelController {

    private final TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @ResponseBody
    @GetMapping
    public List<Country> travels(@RequestParam String userName ) {
        return travelService.getTravels(userName);
    }
}

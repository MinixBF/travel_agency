package fr.lernejo.travelsite.controllers;

import fr.lernejo.travelsite.models.Travel;
import fr.lernejo.travelsite.services.TravelService;
import org.springframework.web.bind.annotation.*;

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
    public Travel[] travels(@RequestParam String userName ) {
        return travelService.getTravels(userName);
    }
}

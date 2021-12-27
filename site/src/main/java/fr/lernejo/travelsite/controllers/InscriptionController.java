package fr.lernejo.travelsite.controllers;

import fr.lernejo.travelsite.models.User;
import fr.lernejo.travelsite.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping(value = "/api/inscription")
@RestController
public class InscriptionController {
    private final TravelService travelService;

    @Autowired
    public InscriptionController(TravelService travelService) {
        this.travelService = travelService;
    }

    @PostMapping
    public void inscription(@RequestBody User inscription) {
        this.travelService.inscription(inscription);
    }
}

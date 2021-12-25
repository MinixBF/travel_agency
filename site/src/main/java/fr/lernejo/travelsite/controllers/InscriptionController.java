package fr.lernejo.travelsite.controllers;

import fr.lernejo.travelsite.models.Inscription;
import fr.lernejo.travelsite.services.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping(value = "/api/inscription")
@RestController
public class InscriptionController {
    private final InscriptionService inscriptionService;

    @Autowired
    public InscriptionController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @PostMapping
    public void inscription(@RequestBody Inscription inscription) {
        inscriptionService.inscription(inscription);
    }
}

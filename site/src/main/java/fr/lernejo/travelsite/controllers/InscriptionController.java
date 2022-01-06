package fr.lernejo.travelsite.controllers;

import fr.lernejo.travelsite.models.User;
import fr.lernejo.travelsite.services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping(value = "/api/inscription")
@RestController
public class InscriptionController {
    private final SiteService siteService;

    @Autowired
    public InscriptionController(SiteService siteService) {
        this.siteService = siteService;
    }

    @PostMapping
    public void inscription(@RequestBody User inscription) {
        this.siteService.inscription(inscription);
    }
}

package fr.lernejo.travelsite.controllers;

import fr.lernejo.travelsite.models.User;
import fr.lernejo.travelsite.services.SiteService;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/inscription")
@RestController
public class InscriptionController {
    private final SiteService siteService;

    public InscriptionController(SiteService siteService) {
        this.siteService = siteService;
    }

    @PostMapping
    public void inscription(@RequestBody User inscription) {
        this.siteService.inscription(inscription);
    }
}

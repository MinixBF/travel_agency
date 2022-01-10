package fr.lernejo.travelsite.controllers;

import fr.lernejo.travelsite.models.Country;
import fr.lernejo.travelsite.services.SiteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/travels")
@RestController
public class TravelController {

    private final SiteService siteService;

    public TravelController(SiteService siteService) {
        this.siteService = siteService;
    }

    @ResponseBody
    @GetMapping
    public Object travels(@RequestParam String userName ) {
        return siteService.getTravels(userName);
    }
}

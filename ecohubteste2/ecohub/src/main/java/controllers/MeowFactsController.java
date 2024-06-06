package controllers;

import entity.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import services.InformationService;
import services.MeowFactsService;

import java.util.List;

@RestController
@RequestMapping("/meow-facts")
public class MeowFactsController {
    @Autowired
    private MeowFactsService meowFactsService;

    @Autowired
    private InformationService informationService;

    @PostMapping("/fetch")
    public String fetchMeowFacts() {
        meowFactsService.fetchAndStoreMeowFacts();
        return "Meow facts fetched and stored successfully.";
    }

    @GetMapping
    public List<Information> getAllMeowFacts() {
        return informationService.getAllInformationByCategory("Wildlife");
    }

    @GetMapping("/{id}")
    public Information getMeowFactById(@PathVariable Long id) {
        return informationService.getInformationById(id);
    }
}
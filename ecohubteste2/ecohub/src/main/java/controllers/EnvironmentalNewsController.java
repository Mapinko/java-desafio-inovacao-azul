package controllers;

import entity.Information;
import services.EnvironmentalNewsService;
import services.InformationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/environmental-news")
public class EnvironmentalNewsController {
    @Autowired
    private EnvironmentalNewsService environmentalNewsService;

    @Autowired
    private InformationService informationService;

    @PostMapping("/fetch")
    public String fetchEnvironmentalNews() {
        environmentalNewsService.fetchAndStoreEnvironmentalNews();
        return "Environmental news fetched and stored successfully.";
    }

    @GetMapping
    public List<Information> getAllEnvironmentalNews() {
        return informationService.getAllInformationByCategory("Environment");
    }

}
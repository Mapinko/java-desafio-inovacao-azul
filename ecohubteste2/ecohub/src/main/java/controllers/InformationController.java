package controllers;

import entity.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.InformationService;

import java.util.List;

@RestController
@RequestMapping("/information")
public class InformationController {
    @Autowired
    private InformationService informationService;


    @PostMapping
    public Information createInformation(@RequestBody Information information) {
        return informationService.createInformation(information);
    }

    @GetMapping("/{id}")
    public Information getInformationById(@PathVariable Long id) {
        return informationService.getInformationById(id);
    }

    @PutMapping("/{id}")
    public Information updateInformation(@PathVariable Long id, @RequestBody Information information) {
        return informationService.updateInformation(id, information);
    }

    @DeleteMapping("/{id}")
    public void deleteInformation(@PathVariable Long id) {
        informationService.deleteInformation(id);
    }

    @GetMapping
    public List<Information> getAllInformation() {
        return informationService.getAllInformation();
    }
}
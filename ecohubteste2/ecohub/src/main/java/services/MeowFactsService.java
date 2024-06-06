package services;

import entity.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import repository.InformationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@Service
public class MeowFactsService {
    // URL for the Meow Facts API
    private static final String EXTERNAL_API_URL = "https://meowfacts.herokuapp.com/";

    @Autowired
    private InformationRepository informationRepository;

    @Autowired
    private RestTemplate restTemplate;

    public void fetchAndStoreMeowFacts() {
        Map<String, Object> response = restTemplate.getForObject(EXTERNAL_API_URL, Map.class);
        String fact = (String) response.get("data");

        Information information = new Information();
        information.setTitle("Meow Fact");
        information.setContent(fact);
        information.setCategory("Wildlife");
        information.setCreatedAt(LocalDateTime.now());
        information.setUpdatedAt(LocalDateTime.now());

        informationRepository.save(information);
    }
}
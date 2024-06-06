package services;

import entity.Information;
import repository.InformationRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class EnvironmentalNewsService {
    // URL for the Open Weather API
    private static final String EXTERNAL_API_URL = "https://api.openweathermap.org/data/2.5/weather?q=Sao+Paulo,BR&appid={f253495fcc71b3d32e66e820b90bb3dc}";

    @Autowired
    private InformationRepository informationRepository;

    @Autowired
    private RestTemplate restTemplate;

    public void fetchAndStoreEnvironmentalNews() {
        Map<String, Object> response = restTemplate.getForObject(EXTERNAL_API_URL, Map.class);

        if (response != null) {
            Map<String, Object> coord = (Map<String, Object>) response.get("coord");
            Map<String, Object> main = (Map<String, Object>) response.get("main");
            Map<String, Object> wind = (Map<String, Object>) response.get("wind");
            Map<String, Object> sys = (Map<String, Object>) response.get("sys");
            String weatherDescription = ((Map<String, Object>) ((List<Object>) response.get("weather")).get(0)).get("description").toString();
            String locationName = response.get("name").toString();

            StringBuilder content = new StringBuilder();
            content.append("Location: ").append(locationName).append("\n");
            content.append("Weather: ").append(weatherDescription).append("\n");
            content.append("Temperature: ").append(main.get("temp")).append(" K\n");
            content.append("Humidity: ").append(main.get("humidity")).append(" %\n");
            content.append("Wind Speed: ").append(wind.get("speed")).append(" m/s\n");
            content.append("Longitude: ").append(coord.get("lon")).append("\n");
            content.append("Latitude: ").append(coord.get("lat")).append("\n");
            content.append("Country: ").append(sys.get("country")).append("\n");

            Information information = new Information();
            information.setTitle("Environmental News: " + locationName);
            information.setContent(content.toString());
            information.setCategory("Environment");
            information.setCreatedAt(LocalDateTime.now());
            information.setUpdatedAt(LocalDateTime.now());

            informationRepository.save(information);
        }
    }
}
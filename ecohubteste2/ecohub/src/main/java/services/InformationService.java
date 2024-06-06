package services;

import entity.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.InformationRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InformationService {
    @Autowired
    private InformationRepository informationRepository;

    public Information createInformation(Information information) {
        information.setCreatedAt(LocalDateTime.now());
        information.setUpdatedAt(LocalDateTime.now());
        return informationRepository.save(information);
    }

    public List<Information> getAllInformationByCategory(String category) {
        return informationRepository.findAll().stream()
                .filter(info -> category.equals(info.getCategory()))
                .toList();
    }

    public Information getInformationById(Long id) {
        return informationRepository.findById(id).orElseThrow(() -> new RuntimeException("Information not found"));
    }

    public Information updateInformation(Long id, Information information) {
        Information existingInformation = getInformationById(id);
        existingInformation.setTitle(information.getTitle());
        existingInformation.setContent(information.getContent());
        existingInformation.setCategory(information.getCategory());
        existingInformation.setUpdatedAt(LocalDateTime.now());
        return informationRepository.save(existingInformation);
    }

    public void deleteInformation(Long id) {
        informationRepository.deleteById(id);
    }

    public List<Information> getAllInformation() {
        return informationRepository.findAll();
    }


}
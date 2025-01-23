package mk.com.kinmkd.kinmkdlocationservice.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import mk.com.kinmkd.kinmkdlocationservice.domain.model.Category;
import mk.com.kinmkd.kinmkdlocationservice.domain.model.Location;
import mk.com.kinmkd.kinmkdlocationservice.repository.LocationRepository;
import mk.com.kinmkd.kinmkdlocationservice.service.LocationService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    @Override
    public void insertDataFromJsonFile(String jsonFilePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonContent = Files.readString(Path.of(jsonFilePath));

        try {
            Location[] locationsArray = objectMapper.readValue(jsonContent, Location[].class);

            Arrays.stream(locationsArray)
                    .map(location -> new Location(
                            location.getId(),
                            location.getLat(),
                            location.getLon(),
                            location.getName(),
                            location.getNameEN(),
                            location.getCategoryId())
                    )
                    .forEach(locationRepository::save);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Location> search(Category category, String text) {
        if (category.equals(Category.NONE) && checkIfTextIsEmpty(text)) {
            return locationRepository.findAll();
        } else if (category.equals(Category.NONE) && !checkIfTextIsEmpty(text)) {
            return locationRepository.findAllByNameENContainsIgnoreCaseOrNameContainsIgnoreCase(text, text);
        } else if (!category.equals(Category.NONE) && checkIfTextIsEmpty(text)) {
            return locationRepository.findAllByCategoryId(category);
        } else {
            return locationRepository.findAllByCategoryIdAndNameContainsIgnoreCaseOrCategoryIdAndNameENContainsIgnoreCase(category, text, category, text);
        }
    }

    private boolean checkIfTextIsEmpty(String value) {
        return value == null || value.isEmpty();
    }

    @Override
    public Optional<Location> getById(int id) {
        return locationRepository.findById(id);
    }
}

package mk.com.kinmkd.kinmkdlocationservice.service;

import mk.com.kinmkd.kinmkdlocationservice.domain.model.Category;
import mk.com.kinmkd.kinmkdlocationservice.domain.model.Location;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface LocationService {
    void insertDataFromJsonFile(String jsonFilePath) throws IOException;
    List<Location> search(Category category, String text);
    Optional<Location> getById(int id);
}

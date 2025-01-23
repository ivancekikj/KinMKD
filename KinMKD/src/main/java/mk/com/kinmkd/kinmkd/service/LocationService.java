package mk.com.kinmkd.kinmkd.service;

import mk.com.kinmkd.kinmkd.model.Location;
import java.util.List;

public interface LocationService {
    Location findById(Integer id);
    List<Location> performSearch(String categoryName, String text);
}

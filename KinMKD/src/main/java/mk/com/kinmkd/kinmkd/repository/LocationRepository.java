package mk.com.kinmkd.kinmkd.repository;

import mk.com.kinmkd.kinmkd.model.Category;
import mk.com.kinmkd.kinmkd.model.Location;
import java.util.List;
import java.util.Optional;


public interface LocationRepository {
    List<Location> search(Category category, String keyword);
    Optional<Location> findById(Integer id);
}

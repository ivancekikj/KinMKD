package mk.com.kinmkd.kinmkdlocationservice.repository;

import mk.com.kinmkd.kinmkdlocationservice.domain.model.Category;
import mk.com.kinmkd.kinmkdlocationservice.domain.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    List<Location> findAllByCategoryIdAndNameContainsIgnoreCaseOrCategoryIdAndNameENContainsIgnoreCase(Category category1, String text1, Category category2, String text2);
    List<Location> findAllByNameENContainsIgnoreCaseOrNameContainsIgnoreCase(String text,String text2);
    List<Location> findAllByCategoryId(Category category);
}

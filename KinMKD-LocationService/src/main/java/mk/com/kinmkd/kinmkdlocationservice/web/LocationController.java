package mk.com.kinmkd.kinmkdlocationservice.web;

import lombok.AllArgsConstructor;
import mk.com.kinmkd.kinmkdlocationservice.domain.model.Category;
import mk.com.kinmkd.kinmkdlocationservice.domain.model.Location;
import mk.com.kinmkd.kinmkdlocationservice.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/locations")
public class LocationController {
    private final LocationService locationService;

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable Integer id) {
        return ResponseEntity.ok(locationService.getById(id).orElse(null));
    }

    @GetMapping("")
    public ResponseEntity<List<Location>> searchLocations(@RequestParam Category category,
                                                          @RequestParam(required = false) String keyword) {
        return ResponseEntity.ok(locationService.search(category, keyword));
    }
}

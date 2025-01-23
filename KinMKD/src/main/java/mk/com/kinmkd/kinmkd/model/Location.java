package mk.com.kinmkd.kinmkd.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    private Integer id;
    private Double lat;
    private Double lon;
    private String name;
    private String nameEN;
    private Category categoryId;
    private List<Review> reviews;

    public Location(Double lat, Double lon, String name, String nameEN, Category categoryId) {
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.nameEN = nameEN;
        this.categoryId = categoryId;
        reviews = new ArrayList<>();
    }
}

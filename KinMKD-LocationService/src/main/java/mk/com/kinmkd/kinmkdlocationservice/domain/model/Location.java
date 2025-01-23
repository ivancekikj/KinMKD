package mk.com.kinmkd.kinmkdlocationservice.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "locations")
public class Location {
    @Id
    private Integer id;
    private Double lat;
    private Double lon;
    private String name;
    private String nameEN;

    @Enumerated(EnumType.STRING)
    private Category categoryId;
}

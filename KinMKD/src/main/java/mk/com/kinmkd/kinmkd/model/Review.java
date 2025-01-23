package mk.com.kinmkd.kinmkd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Review {
    private Integer id;
    private Integer rating;
    private String comment;
    private Integer userId;
    private Integer locationId;
    private User user;

    public Review(Integer rating, String comment, Integer userId, Integer locationId) {
        this.rating = rating;
        this.comment = comment;
        this.userId = userId;
        this.locationId = locationId;
    }
}

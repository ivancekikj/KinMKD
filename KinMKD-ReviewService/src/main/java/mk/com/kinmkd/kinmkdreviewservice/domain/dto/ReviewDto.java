package mk.com.kinmkd.kinmkdreviewservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private Integer rating;
    private String comment;
    private Integer userId;
    private Integer locationId;
}

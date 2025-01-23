package mk.com.kinmkd.kinmkd.repository;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ApiUrls {
    @Value("${user.service.url}")
    private String userServiceUrl;

    @Value("${location.service.url}")
    private String locationServiceUrl;

    @Value("${review.service.url}")
    private String reviewServiceUrl;
}

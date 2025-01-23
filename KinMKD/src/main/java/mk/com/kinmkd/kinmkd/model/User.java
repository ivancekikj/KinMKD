package mk.com.kinmkd.kinmkd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private Integer id;
    private String email;
    private String password;

    public User(String email) {
        this.email = email;
    }
}

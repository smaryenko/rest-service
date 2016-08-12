package userService;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = {"id"})
public class User {
    private String name;
    private long id;

    public User(String name) {
        this.name = name;
        this.id = System.currentTimeMillis();
    }
}

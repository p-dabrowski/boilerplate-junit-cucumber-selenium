package utils;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
    String name;
    String password;
    String description;

    public User(String name, String password, String description) {
        this.name = name;
        this.password = password;
        this.description = description;
    }
}

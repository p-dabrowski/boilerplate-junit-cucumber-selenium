package utils;

import java.util.HashMap;
import java.util.Map;

public class UserProvider {
    public static Map<String, User> USER = Map.of(
            "admin", new User("admin", "admin*pass", "Administrator"),
            "user", new User("user1", "user*pass", "Regular user")
    );

}

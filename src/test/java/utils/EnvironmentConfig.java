package utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnvironmentConfig {
    public String url;
    public String alias;

    public EnvironmentConfig(String url, String alias) {
        this.url = url;
        this.alias = alias;
    }
}

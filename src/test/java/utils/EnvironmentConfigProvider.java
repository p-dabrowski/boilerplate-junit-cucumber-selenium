package utils;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

public class EnvironmentConfigProvider {

    private final static List<EnvironmentConfig> ENVIRONMENT_CONFIGS = Arrays.asList(
            new EnvironmentConfig("https://www.wikipedia.org", "prod"),
            new EnvironmentConfig("https://uat.wikipedia.org", "uat"),
            new EnvironmentConfig("https://test.wikipedia.org", "test"),
            new EnvironmentConfig("https://dev.wikipedia.org", "dev")
    );

    public static EnvironmentConfig getEnvData() {
        String cmdlineEnvParameter = System.getProperty("env");

        for (EnvironmentConfig env : ENVIRONMENT_CONFIGS ) {
            if (env.alias.equals(cmdlineEnvParameter)) {
                return env;
            }
        }

        return ENVIRONMENT_CONFIGS.get(0);
    }
}

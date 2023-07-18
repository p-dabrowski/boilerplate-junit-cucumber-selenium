import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/resources/features",
        glue = {"stepdefs"},
        plugin = {"pretty", "json:target/cucumber/cucumber.json"},
        monochrome = true
)

public class CucumberRunner {
}
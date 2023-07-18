import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/resources/features",
        glue = {"stepsdefs"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)

public class CucumberRunner {
}
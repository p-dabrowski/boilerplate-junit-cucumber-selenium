import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/resources/features",
        glue = {"stepdefs"},
        plugin = {"pretty", "json:target/cucumber/cucumber.json"},
        monochrome = true
)

public class CucumberRunner extends AbstractTestNGCucumberTests {
}
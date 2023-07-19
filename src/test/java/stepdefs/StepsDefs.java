package stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.EnvironmentConfig;

import java.time.Duration;

import static utils.EnvironmentConfigProvider.getEnvData;

public class StepsDefs {

    WebDriver driver;


    @Given("I have browser opened")
    public void i_have_browser_opened() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("I go to wiki webpage")
    public void i_go_to_wiki_webpage() {
        String url = getEnvData().getUrl();

        driver.get(url);

    }

    @When("I search for phrase")
    public void i_search_for_phrase() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("phrase" + Keys.ENTER);
        driver.findElement(By.xpath("(//button)[last()]")).click();
    }

    @Then("I get list of results")
    public void i_get_list_of_results() {
        int results = driver.findElements(By.xpath("//div[@class='mw-search-result-heading']")).size();

        Assert.assertTrue(results > 0);
    }

    @After()
    public void tearDown() {
        //driver.quit();
    }
}

package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StepDefs {

    WebDriver driver;

    @Given("I go to google webpage")
    public void i_go_to_google_webpage() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://www.google.pl");
        driver.findElement(By.xpath("(//button)[last()]")).click();
    }

    @When("I search for phrase")
    public void i_search_for_phrase() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("phrase" + Keys.ENTER);
    }

    @Then("I get list of results")
    public void i_get_list_of_results() {
        int results = driver.findElements(By.xpath("//div[@data-hveid]")).size();

        Assert.assertTrue(results > 0);
    }

    @After()
    public void tearDown() {
        driver.quit();
    }
}

package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.PageObjectProvider;

import java.util.concurrent.TimeUnit;

import static utils.EnvironmentConfigProvider.getEnvData;
import static utils.PageObjectProvider.wikiPage;
import static utils.UserProvider.USER;


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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        new PageObjectProvider(driver);
    }

    @Given("I go to wiki webpage")
    public void i_go_to_wiki_webpage() {
        String url = getEnvData().getUrl();

        driver.get(url);
    }

    @When("I search for phrase")
    public void i_search_for_phrase() throws InterruptedException {
        wikiPage.searchForPhrase( "phrase" );
    }

    @When("I search for phrase as admin")
    public void i_search_for_phrase_as_admin() throws InterruptedException {
        wikiPage.searchForPhrase( "I am " + USER.get("admin").getDescription() );
    }

    @Then("I get list of results")
    public void i_get_list_of_results() {
        int results = wikiPage.getResultsNumber();

        Assert.assertTrue(results > 0);
    }

    @After()
    public void tearDown() {
        //driver.quit();
    }
}

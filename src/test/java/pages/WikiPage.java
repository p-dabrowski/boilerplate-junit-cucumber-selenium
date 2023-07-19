package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class WikiPage extends AbstractPage {

    @FindBy(id="username")
    WebElement usernameLocator;
    @FindBy(id="passwd")
    WebElement passwordLocator;
    @FindBy(id="login")
    WebElement loginButtonLocator;
    @FindBy(xpath="//input[@id='searchInput']")
    WebElement searchInput;
    @FindBy(xpath="(//button)[1]")
    WebElement searchButton;
    @FindBy(xpath="//div[@class='mw-search-result-heading']")
    List<WebElement> result;

    public WikiPage(WebDriver driver) {
        super(driver);
    }

    public void searchForPhrase(String phrase) {
        searchInput.sendKeys(phrase);
        searchButton.click();
    }

    public int getResultsNumber() {
        return result.size();
    }
}

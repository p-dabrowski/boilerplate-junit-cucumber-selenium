package utils;

import org.openqa.selenium.WebDriver;
import pages.WikiPage;

public class PageObjectProvider {
    WebDriver driver;
    public static WikiPage wikiPage;

    public PageObjectProvider(WebDriver driver) {
        this.driver = driver;

        wikiPage = new WikiPage(driver);
    }
}

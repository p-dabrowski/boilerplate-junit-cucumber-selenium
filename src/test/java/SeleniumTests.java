
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class SeleniumTests {

    WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
    }

    @Test
    public void firstTest() throws InterruptedException {

    }

    @AfterClass
    public static void tearDown() {

    }
}

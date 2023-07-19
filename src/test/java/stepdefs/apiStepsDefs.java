package stepdefs;

import java.util.List;
import java.util.Map;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;


public class apiStepsDefs {

    private static String TOKEN;
    private static String USERID;

    @Given("I am an authorized user")
    public void i_am_an_authorized_user() {
        USERID = "c510859c-7738-4f4f-bda3-3b94bdf6381d";
        String userName = "PDTest3";
        String password = "Test@@123";
        String baseUrl = "https://bookstore.toolsqa.com";

        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();


        //Step - 1
        //Test will start from generating Token for Authorization
        request.header("Content-Type", "application/json");

        Response response = request.body("{ \"userName\":\"" + userName + "\", \"password\":\"" + password + "\"}")
                .post("/Account/v1/GenerateToken");

        Assert.assertEquals(response.getStatusCode(), 200);

        String jsonString = response.asString();
        Assert.assertTrue(jsonString.contains("token"));

        //This token will be used in later requests
        TOKEN = JsonPath.from(jsonString).get("token");
    }

    @Given("I'm logged in")
    public void i_m_logged_in() {

    }

    @When("I ask for my books list")
    public void i_ask_for_my_books_list() {
        RequestSpecification request = RestAssured.given();

        // Get Books - No Auth is required for this.
        Response response = request.get("/BookStore/v1/Books");
        Assert.assertEquals(response.getStatusCode(), 200);

        String jsonString = response.asString();
        List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
        Assert.assertTrue(books.size() > 0);

        //This bookId will be used in later requests, to add the book with respective isbn
        String bookId = books.get(0).get("isbn");
    }

    @Then("I get my books list")
    public void i_get_my_books_list() {

    }

}

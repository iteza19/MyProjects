package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIStepDef {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static Response response;
    private static String jsonString;

    @Given("user have API list")
    public void userHaveAPIList() {
        System.out.println("given state");
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        response = request.get("/posts/1/comments");
        jsonString = response.asPrettyString();
        System.out.println(jsonString);
    }

    @When("user get some data")
    public void user_get_some_data() {
        System.out.println("when state");
    }

    @Then("user verify the response")
    public void user_verify_the_response() {
        System.out.println("then state");
    }

}
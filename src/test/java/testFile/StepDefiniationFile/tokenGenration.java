package testFile.StepDefiniationFile;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import utiltiy.ConfigReader;
import utiltiy.ConstantHeader;
import utiltiy.ExtentReportManager;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class tokenGenration {
    private Response response;
    private String token;

    @Given("the login API is available")
    public void the_login_api_is_available() {
        ExtentReportManager.setupExtentReport();
        ExtentReportManager.createTest("API URL");

        String baseUrl = ConfigReader.getBaseUrl();
        String loginEndpoint = ConfigReader.getLoginEndpoint();
        baseURI = baseUrl + loginEndpoint;
        ExtentReportManager.getTest().log(Status.INFO, baseURI);
    }

    @When("I send a POST request with valid {string} and {string}")
    public void i_send_a_post_request_with_valid_email_and_password(String email,String password) {

        // Prepare the request payload from the configuration
        String payload = "{\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"password\": \"" + password + "\",\n" +
                "  \"vendorType\": \"" + ConfigReader.getVendorType() + "\"\n" +
                "}";

        // Send the POST request and capture the response
        response = given()
                .header(ConstantHeader.ACCESS, "application/json, text/plain, */*")
                .header(ConstantHeader.CONTENT_TYPE, "application/json")
                .header(ConstantHeader.AUTHORIZATION, "Bearer " + ConfigReader.getAuthToken())
                .body(payload)
                .post();
    }

    @Then("I should receive a token in the response")
    public void i_should_receive_a_token_in_the_response() {
        String tokenPattern = "^[A-Za-z0-9-_]+\\.[A-Za-z0-9-_]+\\.[A-Za-z0-9-_]+$";
        Assert.assertTrue("Token should have a valid format", token.matches(tokenPattern));
        ExtentReportManager.getTest().log(Status.PASS, "Validated Token ID");

    }

    @Then("the token should not be empty")
    public void the_token_should_not_be_empty() {
        token = response.jsonPath().getString("token");
        Assert.assertNotNull("Token should not be null", token);
        ExtentReportManager.getTest().log(Status.INFO, "Get Token" + token);
        ExtentReportManager.flushReport();
    }
}

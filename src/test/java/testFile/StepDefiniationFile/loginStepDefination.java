package testFile.StepDefiniationFile;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStepDefination {


    @Given("I have the login API endpoint")
    public void i_have_the_login_api_endpoint() {
        System.out.println("1");

    }
    @When("I send a POST request with username {string} and password {string}")
    public void i_send_a_post_request_with_username_and_password(String string, String string2) {
        System.out.println(string+ string2);
    }
    @Then("I should get a response with status code {int}")
    public void i_should_get_a_response_with_status_code(Integer int1) {
        System.out.println(int1);

    }
    @Then("the response body should have {string} as {string}")
    public void the_response_body_should_have_as(String string, String string2) {
        System.out.println(string+string2);

    }


}

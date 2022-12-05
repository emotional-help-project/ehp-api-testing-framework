package com.epam.rd.steps.users;

import com.epam.rd.RequestsUtils;
import com.epam.rd.ResponseUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.testng.Assert;

public class UserAuthenticationSteps {
    @When("User registration data {string} firstname, {string} lastname, {string} email, {string} password, {string} gender, {int} age")
    public void userRegistration(String firstname, String lastname, String email, String password, String gender, int age) {
        String body = "{\n" +
                "    \"firstName\":\" " + firstname + " \",\n" +
                "    \"lastName\":\" " + lastname + "\",\n" +
                "    \"email\": \"" + email + "\",\n" +
                "    \"password\":\" " + password + "\",\n" +
                "    \"gender\":\" " + gender + "\",\n" +
                "    \"age\": " + age + "\n" +
                "}";
        RequestsUtils.post("account/signup", body);
        System.out.println(ResponseUtils.getResponse().extract().body());
    }

    @Then("Validate user creation status")
    public void validateUserCreationStatus() {
        int actualStatusCode = ResponseUtils.getStatusCodeFromResponse();
        Assert.assertEquals(actualStatusCode, HttpStatus.SC_OK);
    }

    @Then("Validate the response of user registration request")
    public void validateTheResponseOfUserRegistrationRequest() {
        ResponseUtils.validateResponseAgainstJSONSchema("schemas/usersSchemas/userRegistrationResponseSchema.json");
    }
}

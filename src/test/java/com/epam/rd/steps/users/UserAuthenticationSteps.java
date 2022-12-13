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
    }

    @Then("Validate user creation status")
    public void validateUserCreationStatus() {
        int actualStatusCode = ResponseUtils.getStatusCodeFromResponse();
        Assert.assertEquals(actualStatusCode, HttpStatus.SC_OK, "User registered successfully");
    }

    @Then("Validate the response of user registration request")
    public void validateTheResponseOfUserRegistrationRequest() {
        ResponseUtils.validateResponseAgainstJSONSchema("schemas/usersSchemas/userRegistrationResponseSchema.json");
    }

    @Then("Validate user creation failure status")
    public void validateUserCreationFailureStatus() {
        int actualStatusCode = ResponseUtils.getStatusCodeFromResponse();
        Assert.assertEquals(actualStatusCode, HttpStatus.SC_BAD_REQUEST, "Could not register a user");
    }

    @When("Login with {string} email, {string} password")
    public void loginWithEmailPassword(String email, String password) {
        String body = "{\n" +
                "    \"email\": \"" + email + "\",\n" +
                "    \"password\": \"" + password + "\"\n" +
                "}";
        RequestsUtils.post("account/signin", body);
    }

    @Then("Validate login success response values")
    public void validateLoginSuccessResponseValues() {
        ResponseUtils.validateResponseAgainstJSONSchema("schemas/usersSchemas/loginSuccessResponseSchema.json");
    }

    @Then("Validate login failure response")
    public void validateLoginFailureResponse() {
        Assert.assertEquals(ResponseUtils.getStringFromResponse("message"), "Bad credentials",
                "The email or password is not correct");
    }

    @When("User registration data {string} firstname, {string} lastname, {string} email, {string} password, {string} confirmPassword, {string} gender, {int} age")
    public void userRegistrationDataFirstnameLastnameEmailPasswordConfirmPasswordGenderAgeAge(String firstname, String lastname, String email, String password, String confirmPassword, String gender, int age) {
        String body = "{\n" +
                "    \"firstName\":\" " + firstname + " \",\n" +
                "    \"lastName\":\" " + lastname + "\",\n" +
                "    \"email\": \"" + email + "\",\n" +
                "    \"password\":\" " + password + "\",\n" +
                "    \"confirmPassword\":\" " + confirmPassword + "\",\n" +
                "    \"gender\":\" " + gender + "\",\n" +
                "    \"age\": " + age + "\n" +
                "}";
        RequestsUtils.post("account/signup", body);
    }
}

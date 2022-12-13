package com.epam.rd.steps;

import com.epam.rd.ResponseUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class CommonSteps {

    private static final String BASE_URL = "http://52.89.90.94:8080/";
    private static final String BASE_PATH = "api/";
    private final Logger logger = LoggerFactory.getLogger(CommonSteps.class);

    @Given("Setup Rest Assured")
    public void setupRestAssured() {
        logger.info("The BASE_URL is {}", BASE_URL);
        logger.info("The BASE_PATH is {}", BASE_PATH);
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = BASE_PATH;
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int expectedStatusCode) {
        int actualStatusCode = ResponseUtils.getStatusCodeFromResponse();
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Response could should be " + expectedStatusCode);
    }
}

package com.epam.rd.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonSteps {

    private static final String BASE_URL = "http://5.58.12.93:8095/";
    private static final String BASE_PATH = "api/";
    private final Logger logger = LoggerFactory.getLogger(CommonSteps.class);

    @Given("Setup Rest Assured")
    public void setupRestAssured() {
        logger.info("The BASE_URL is {}", BASE_URL);
        logger.info("The BASE_PATH is {}", BASE_PATH);
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = BASE_PATH;
    }
}

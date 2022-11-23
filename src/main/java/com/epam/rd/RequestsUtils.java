package com.epam.rd;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestsUtils {

    private final static Logger logger = LoggerFactory.getLogger(RequestsUtils.class);

    private static ValidatableResponse response;

    public static ValidatableResponse getResponse() {
        return response;
    }

    public static void get(String endpoint) {
        response = RestAssured
                .given()
                .when()
                .get(endpoint)
                .then();
        logger.info(response.extract().body().asPrettyString());
    }

    public static void delete(String endpoint) {
        response = RestAssured
                .given()
                .when()
                .delete(endpoint)
                .then();
    }

    public static void post(String endpoint, Object body) {
        logger.info(endpoint, body);
        response = RestAssured
                .given()
                .spec(getRequestSpecification())
                .body(body)
                .when()
                .post(endpoint)
                .then();
        logger.info(response.extract().body().asPrettyString());
    }

    private static RequestSpecification getRequestSpecification() {
        RequestSpecBuilder spec = new RequestSpecBuilder();
        return spec
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }
}

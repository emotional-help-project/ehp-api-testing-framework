package com.epam.rd.steps.users;

import com.epam.rd.RequestsUtils;
import com.epam.rd.ResponseUtils;
import com.epam.rd.SharedTestData;
import io.cucumber.java.en.When;

public class AdminFunctionsSteps {
    @When("Admin user gets all tests")
    public void adminUserGetsAllTests() {
        RequestsUtils.get("tests");
    }

    @When("Admin creates a new test")
    public void adminCreatesANewTest() {
        String body = "{\n" +
                "\"title\":\"Test for depression\",\n" +
                "\"testType\":{\n" +
                "\"id\":\"1\",\n" +
                "\"title\":\"Health\"\n" +
                "},\n" +
                "    \"description\": \"Some details for new test\",\n" +
                "    \"imageUrl\": \"http/url/here\"\n" +
                "}";
        RequestsUtils.post("tests", body);
        SharedTestData.setTestId(ResponseUtils.getIntFromResponse("id"));
    }

    @When("Admin updates the test")
    public void adminUpdatesTheTest() {
        String body = "{\n" +
                "\"id\":" + SharedTestData.getTestId() +"\",\n" +
                "\"title\":\"Test for depression updated\",\n" +
                "\"testType\":{\n" +
                "\"id\":\"1\",\n" +
                "\"title\":\"Health\"\n" +
                "},\n" +
                "    \"description\": \"Some details for new test\",\n" +
                "    \"imageUrl\": \"http/url/here\"\n" +
                "}";
        RequestsUtils.put("tests", body);
    }

    @When("Admin deletes the test by id")
    public void adminDeletesTheTestById() {
        RequestsUtils.delete("tests/" + SharedTestData.getTestId());
    }

    @When("Admin user gets a test by id")
    public void adminUserGetsATestById() {
        RequestsUtils.get("tests/1");
    }

    @When("Admin user creates a test type")
    public void adminUserCreatesATestType() {
        String body = "{\n" +
                "\"title\":\"Mental Health\"\n" +
                "}";
        RequestsUtils.post("testTypes", body);
        SharedTestData.setTestTypeId(ResponseUtils.getIntFromResponse("id"));
    }

    @When("Admin user updates a test type")
    public void adminUserUpdatesATestType() {
        String body = "{\n" +
                "    \"id\": "+ SharedTestData.getTestTypeId() +",\n" +
                "    \"title\": \"Mental\"\n" +
                "}";
        RequestsUtils.put("testTypes", body);
    }

    @When("Admin user deletes a test type")
    public void adminUserDeletesATestType() {
        RequestsUtils.delete("testTypes/" + SharedTestData.getTestTypeId());
    }
}

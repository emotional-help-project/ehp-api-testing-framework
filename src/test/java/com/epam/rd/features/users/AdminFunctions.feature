Feature: Admin functionality feature for Emotional Help Project

  Background:
    Given Setup Rest Assured

  Scenario: Admin gets all tests
    When Admin user gets all tests

  Scenario: Admin creates a new test
    When Admin creates a new test

  Scenario: Admin updates the existing test
    When Admin updates the test

  Scenario: Admin deletes the existing test
    When Admin deletes the test by id

  Scenario: Admin gets a test by id
    When Admin user gets a test by id

  Scenario: Admin creates a test type
    When Admin user creates a test type
    Then Status code should be 201

  Scenario: Admin updates test type
    When Admin user updates a test type
    Then Status code should be 200

  Scenario: Admin deletes test type by id
    When Admin user deletes a test type
    Then Status code should be 204


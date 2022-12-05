Feature: User authentication feature for Emotional Help Project

  Background:
    Given Setup Rest Assured

  Scenario Outline: Test user's registration API
    When User registration data "<firstname>" firstname, "<lastname>" lastname, "<email>" email, "<password>" password, "<gender>" gender, <age> age
    Then Validate user creation status
    Then Validate the response of user registration request

    Examples:
      | firstname | lastname   | email           | password   | gender | age |
      | Ron       | Smith      | Test3@email.com | Pass123!   | MALE   | 25  |
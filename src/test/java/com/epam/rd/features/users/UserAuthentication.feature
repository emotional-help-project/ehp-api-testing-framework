Feature: User authentication feature for Emotional Help Project

  Background:
    Given Setup Rest Assured

  Scenario Outline: Test user's registration API
    When User registration data "<firstname>" firstname, "<lastname>" lastname, "<email>" email, "<password>" password, "<confirmPassword>" confirmPassword, "<gender>" gender, <age> age
    Then Validate user creation status
    Then Validate the response of user registration request

    Examples:
      | firstname | lastname   | email             | password   | confirmPassword  |gender | age |
      | John      | Smith      | test14@yahoo.com  | Pass1234*  | Pass1234*        | MALE  | 25  |


  Scenario Outline: User's registration fails when provided data is invalid
    When User registration data "<firstname>" firstname, "<lastname>" lastname, "<email>" email, "<password>" password, "<gender>" gender, <age> age
    Then Validate user creation failure status

    Examples:
      | firstname | lastname | email           | password   | gender | age |
      |           | Smith    | Test3@email.com | Pass123!   | MALE   | 25  |
      |     Ron   |          | Test3@email.com | Pass123!   | MALE   | 25  |
      |     Ron   | Smith    |                 | Pass123!   | MALE   | 25  |
      |     Ron   | Smith    | Test3@email.com |            | MALE   | 25  |
      |     Ron   | Smith    | Test3@email.com | Pass123!   |        | 25  |
      |     Ron   | Smith    | Test3@email.com | Pass123!   | MALE   |   1 |


  Scenario Outline: User with valid credentials is able to login
    When Login with "<email>" email, "<password>" password
    Then Validate login success response values

    Examples:
      | email                      | password   |
      | anidarbinyan14@yahoo.com   | Test1234*  |


  Scenario Outline: User with invalid credentials is not able to login
    When Login with "<email>" email, "<password>" password
    Then Validate login failure response

    Examples:
      | email                      | password   |
      | anidarbinyan14@yahoo.com   | Test11111! |
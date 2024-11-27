@Test

Feature: Login to the Application

  @Test_01
  Scenario Outline: Successfully generate a token with valid credentials
    Given the login API is available
    When I send a POST request with valid "<email>" and "<password>"
    Then I should receive a token in the response
    And the token should not be empty
    Examples:
      | email                | password  |
      | PRODTEST@yopmail.com | Test@1234 |

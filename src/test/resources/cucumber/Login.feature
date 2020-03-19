Feature: Login
  Scenario: User can sign in after registration
    Given a user is registered
    And a user navigates to the sign in page
    When the user provides valid credentials
    Then the user is logged in
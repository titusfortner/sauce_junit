Feature: Sign up works
  Scenario: User can register
    Given a user navigates to the sign up page
    When a user enters valid information
    Then the user is successfully registered
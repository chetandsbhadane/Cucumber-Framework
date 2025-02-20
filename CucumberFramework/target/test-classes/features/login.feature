Feature: Login Functionality

  Scenario Outline: Valid Login Test
    Given User is on Login Page
    When User enters credentials for "<TC_ID>"
    And Clicks the login button
    Then User should be logged in successfully

    Examples:
      | TC_ID  |
      | tc_01  |
      | tc_02  |

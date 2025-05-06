
Feature:
  Background:
   Given User is on login page

  Scenario: Valid login Feature
    When User entered valid user name and password
    And Click on Login Button
    Then User is navigated to home Page
    And Logout button is visible
    And Click on logout button

  Scenario: invalid login Feature
    When User entered invalid user name and password
    And Click on Login Button
    Then User is not navigated to home Page
    And Login error is displayed

  Scenario Outline: invalid login Feature
    When User entered invalid user name as "<userid>" and password as "<password>"
    And Click on Login Button
    Then User is not navigated to home Page
    And Login error is displayed

  Examples:
    |userid|password|
    |admin1|admin1  |
    |admin2|admin2  |
    |admin3|admin3  |

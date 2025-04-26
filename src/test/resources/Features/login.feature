Feature:
  Scenario: Valid login Feature
    Given User is on login page
    When User entered valid user name and password
    And Click on Login Button
    Then User is navigated to home Page
    And Logout button is visible

  Scenario: invalid login Feature
    Given User is on login page
    When User entered invalid user name and password
    And Click on Login Button
    Then User is not navigated to home Page
    And Login error is displayed

  @runthis
  Scenario Outline: invalid login Feature
    Given User is on login page
    When User entered invalid user name as "<userid>" and password as "<password>"
    And Click on Login Button
    Then User is not navigated to home Page
    And Login error is displayed

  Examples:
    |userid|password|
    |admin1|admin1  |
    |admin2|admin2  |
    |admin3|admin3  |
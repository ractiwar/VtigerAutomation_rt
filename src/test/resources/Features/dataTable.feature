Feature:
    Scenario: Create Lead for multiple data
    Given User is on login page
    When User entered valid user name and password
    And Click on Login Button
    When User need to create multiple leads and validate based on data
          |Nadela|Microsoft|
          |Pichai|Google    |
          |Steave|Apple    |
    And Click on logout button


Feature:
  Background:
    Given User is on login page
    When User entered valid user name and password
    And Click on Login Button


  Scenario: Create Lead
    When User click on New lead and fill mandatory information and save
    And lead should be created
    And Click on logout button

  Scenario: Create Lead for multiple data

    When User need to create multiple leads and validate based on data
      |Nadela|Microsoft|
      |Pichai|Google    |
      |Steave|Apple    |
    And Click on logout button
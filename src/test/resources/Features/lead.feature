Feature:
  @lead
  Scenario: Create Lead
    Given User is on login page
    When User entered valid user name and password
    And Click on Login Button
    When User click on New lead and fill mandatory information and save
    And lead should be created
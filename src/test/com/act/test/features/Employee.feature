Feature: Employee
  Responsible for verifying creation of an employee

  Scenario: Create employee with all details
    Given the application is open
    Then click login link
    When enter username and password
      | username | password |
      | admin | password |
    Then click login button
    And click employee list link
    Then click create new button
    And enter details
    | name | salary | durationworked | grade | email |
    | autouser | 4000 | 30         | 1     | autouser@ea.com |
    And click create button

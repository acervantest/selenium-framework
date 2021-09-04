Feature: Login
  This feature is responsible for testing all login scenarios

  Scenario: Check login with correct username and password
    Given the app is open
    Then click login link
    When enter username and password
    | username | password |
    | admin | password |
    Then click login button
    Then username and hello should be displayed

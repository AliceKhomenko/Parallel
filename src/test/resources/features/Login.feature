Feature: Login

  AS user, I want to log in  only with correct credentials  and get access to main page

  Background:
    Given site is opened

  @login
  Scenario: User logged in
    When user inputs correct login
    And user inputs correct password
    And user clicks Login button
    And user accepts 1st alert
    And user accepts 2nd alert
    Then main page is opened

  @login
  Scenario: User doesn't confirm first alert
    When user inputs correct login
    And user inputs correct password
    And user clicks Login button
    And user dismissed 1st alert
    Then main page isn't opened
    And login page is opened

  @login
  Scenario: User doesn't confirm second alert
    When user inputs correct login
    And user inputs correct password
    And user clicks Login button
    And user accepts 1st alert
    And user dismissed 2nd alert
    Then main page isn't opened
    And login page is opened

  @login
  Scenario Outline: User can't logged in with wrong credentials
    When user inputs <login> login
    And user inputs <password> password
    And user clicks Login button
    And user accepts 1st alert
    And user accepts 2nd alert
    Then main page isn't opened
    And login page is shown
    Examples:
      | login     | password  |
      | incorrect | correct   |
      | correct   | incorrect |

  @login
  Scenario: User can't logged with empty fields
    When user clicks login field
    And user clicks password field
    Then howerMeFaster button is disabled

  @login
  Scenario: User can't log in with empty login
    When user clicks login field
    And user inputs correct password
    Then howerMeFaster button is disabled

  @login
  Scenario: User can't log in with empty password
    When user inputs correct password
    And user clicks password field
    Then howerMeFaster button is disabled



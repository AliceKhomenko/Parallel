Feature: Login

  AS user, I want to log in with correct credentials  and get access to

  Background:
    Given browser is opened
    And site is opened

  Scenario: User logged in
    When user inputs correct login
    And user inputs correct password
    And user clicks Login button
  And user accepts 1st alert
  And user accepts 2nd alert
    Then main page is opened


  Scenario: User doesn't confirm first alert
    When user inputs correct login
    And user inputs correct password
    And user clicks Login button
    And user dismissed 1st alert
    Then main page isn't opened
    Then login page is opened


  Scenario: User doesn't confirm first alert
    When user inputs correct login
    And user inputs correct password
    And user clicks Login button
    And user accepts 1st alert
    And user dismissed 2nd alert
    Then main page isn't opened
    Then login page is opened



  Scenario Outline: User can't logged in
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

    Scenario: User can't logged with empty fields
      When user clicks login field
      And user clicks password field
      Then sign in button isn't shown

      Scenario: User can't log in with empty login
        When user clicks login field
        And user inputs correct password
        Then sign in button isn't shown

        Scenario: User can't log in with empty password
          When user inputs correct password
          And user clicks password field
          Then sign in button isn't shown



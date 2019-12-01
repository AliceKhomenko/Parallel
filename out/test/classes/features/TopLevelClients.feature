Feature: Article functionality
  As user I want to get opportunity to get actual info about person, download person info and get person photo
Background:
  Given site is opened
  And user is already logged in
  #And user is authorized


  Scenario: Top level clients block is shown
  When user clicks Top level clients block
    Then Top level clients list is shown
    And Top level clients is added to cookies

    Scenario: Hide Top level clients block
      When user double clicks Top level clients block
      Then top level clients list isn't shown





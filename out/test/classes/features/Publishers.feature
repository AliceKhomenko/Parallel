Feature: Article functionality
  As user I want to get opportunity to get actual info about person, download person info and get person photo
Background:
  Given site is opened
  And user is already logged in
  #And user is authorized


  Scenario: Publishers block is shown
  When user clicks Publishers block
    Then Publishers list is shown
    And Publishers is added to cookies

    Scenario: Hide Publishers block
      When user double clicks Publishers block
      Then Publishers list isn't shown





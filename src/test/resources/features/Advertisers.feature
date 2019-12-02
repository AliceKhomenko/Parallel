Feature: Article functionality
  As user I want to get opportunity to get actual info about person, download person info and get person photo
Background:
  Given site is opened
  And user is already logged in
  #And user is authorized


  Scenario: Advertiser block is shown
  When user clicks Advertiser block
    Then Advertisers list is shown
    And Advertiser is added to cookies

    Scenario: Hide advertiser block
      When user double clicks Advertiser block
      Then advertisers list isn't shown





Feature: Profile page

  Background:
    Given site is opened
    And user is already logged in
    And user clicks avatar icon


  Scenario: Input user info
    When user inputs "Ozzy" in first name field
    And user inputs "Osbourne" in last name field
    And user clicks Save user info button
    Then successful alert is shown
    And "Ozzy" is added to cookie "firstName"
    And "Osbourne" is added to cookie "lastName"


  Scenario: Update user info
    When user inputs "Ozzy" in first name field
    And user inputs "Osbourne" in last name field
    And user clicks Save user info button
    When user inputs "Marilyn" in first name field
    And user inputs "Manson" in last name field
    And user clicks Save user info button
    Then successful alert is shown
    And "Marilyn" is added to cookie "firstName"
    And "Manson" is added to cookie "lastName"
    And "Ozzy" isn't added to cookie "firstName"
    And "Osbourne" isn't added to cookie "lastName"


  @test
  Scenario Outline: Input payment info
    When user clicks Payment Info
    And user inputs "<card>" card number
    And user selects "<system>" Payment system
    And user inputs <day> day of payment
    And user clicks Save Payment Info
   # Then successful payment info saved alert is shown
   # And "<card>" is added to cookie "cardNumber"
   # And "<system>" is added to cookie "paymentSystem"

    Examples:
      | card             | system     |day|
      | 1234123412341234 | Visa       |1  |
#      | 5432543254325432 | MasterCard |15 |
 #     | 12345            | Apple Card |31 |

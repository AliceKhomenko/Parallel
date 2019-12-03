Feature: Profile page

  Background:
    Given site is opened
    And user is already logged in
    And user clicks avatar icon

  Scenario: Input user info
    When user inputs "Hakuna" in first name field
    And user inputs "Matata" in last name field
    And user clicks Save user info button
    Then successful alert is shown
    And "Hakuna" is added to cookie "firstName"
    And "Matata" is added to cookie "lastName"


  Scenario Outline: Input payment info
    When user clicks Payment Info
    And user inputs "<card>" card number
    And user selects "<system>" Payment system
    And user inputs <day> day of payment
    And user clicks Save Payment Info
    Then succesful payment info saved alert is shown
    And "<card>" is added to cookie "cardNumber"
    And "<system>" is added to cookie "paymentSystem"

    Examples:
      | card             | system     |
      | 1234123412341234 | Visa       |
      | 5432543254325432 | MasterCard |
      | 12345            | Apple Card |

Feature: Profile page
As user I want to input and edit personal info and payment info

  Background:
    Given site is opened
    And user is already logged in
    And user clicks avatar icon

@user_info @profile @cookie
  Scenario: Input user info
    When user inputs "Ozzy" in first name field
    And user inputs "Osbourne" in last name field
    And user clicks Save user info button
    Then successful alert is shown
    And "Ozzy" is added to cookie "firstName"
    And "Osbourne" is added to cookie "lastName"

@user_info @profile @cookie
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

  @user_info @profile
  Scenario Outline: Try input empty fields for user info
    When user inputs "<first name>" in first name field
    And user inputs "<last name>" in last name field
    And user clicks Save user info button
    Then validation message "<message>" is shown
    Examples:
      | first name | last name | message                    |
      | Ozzy       |           | Please set your last name  |
      |            | Osbourne  | Please set your first name |
      |            |           | Please set your first name |


  @payment_info @profile @cookie
  Scenario Outline: Input payment info
    When user clicks Payment Info
    And user inputs "<card>" card number
    And user selects "<system>" Payment system
    And user inputs <day> day of payment
    And user clicks Save Payment Info
    Then successful payment info saved alert is shown
    And "<card>" is added to cookie "cardNumber"
    And "<system id>" is added to cookie "paymentSystem"
    And "<day>" is added to cookie "paymentDay"

    Examples:
      | card             | system     | day | system id|
      | 1234123412341234 | Visa       | 1   |1         |
      | 5432543254325432 | MasterCard | 15  |2         |
      | 12345            | Apple Card | 31  |3         |


  @payment_info @profile @cookie
  Scenario Outline: Update payment info
    When user clicks Payment Info
    And user inputs "<card>" card number
    And user selects "<system>" Payment system
    And user inputs <day> day of payment
    And user clicks Save Payment Info
    And user inputs "<new card>" card number
    And user selects "<new system>" Payment system
    And user inputs <new day> day of payment
    And user clicks Save Payment Info
    Then successful payment info saved alert is shown
    And "<new card>" is added to cookie "cardNumber"
    And "<system id>" is added to cookie "paymentSystem"
    And "<new day>" is added to cookie "paymentDay"

    Examples:
      | card             | system     | day | new card   | new system | new day |system id|
      | 1234123412341234 | Visa       | 1   | 1919191991 | MasterCard | 15      |2        |
      | 5432543254325432 | MasterCard | 15  | 0987654321 | Apple Card | 31      |3        |
      | 12345            | Apple Card | 31  | 54321      | Visa       | 1       |1        |

    @payment_info @profile
  Scenario Outline: Try input empty fields for payment info
    When user clicks Payment Info
    And user inputs "<card>" card number
    And user selects "<system>" Payment system
    And user clicks Save Payment Info
    Then validation message "<message>" is shown
    Examples:
      | card  | system     | message                           |
      |       | Visa       | Please set your card number       |
      |       | MasterCard | Please set your card number       |
      |       | Apple Card | Please set your card number       |
      | 12345 |            | Please select your payment system |




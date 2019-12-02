Feature: Check files

  Background:
    Given site is opened
    And user is already logged in


  Scenario Outline: Check files for Advertisers
    When user clicks Advertiser block
    And user clicks "<Advertiser>" Advertiser
    And user downloads file
    Then download file and text on the site is equal

    Examples:
    |Advertiser|
    |Test Advertiser|
    |Adidas         |


  Scenario Outline: Check files for Publishers
    When user clicks Publishers block
    And user clicks "<Publisher>" Publisher
    And user downloads file
    Then download file and text on the site is equal

    Examples:
    |Publisher|
    |Youtube  |
    |Instagram|

  Scenario Outline: Check files for Top level clients
    When user clicks Top level clients block
    And user clicks "<Top level client>" Client
    And user downloads file
    Then download file and text on the site is equal

    Examples:
    |Top level client|
    |Jon Snow        |
    |Artur Fleck     |
    |Tim Cook        |
    |Bugs Bunny      |
    |Sasha Grey      |
    |You             |
    |Leonel Messi    |
    |Tony Stark      |
    |Elon Musk       |
    |Darth Vader    |


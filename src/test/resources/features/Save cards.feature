Feature: Save cards

  Background:
    Given site is opened
    And user is already logged in


  Scenario Outline: Save button is disabled
    When user clicks Advertiser block
    And user clicks "<adver>" Advertiser
    Then Moved to save button is disabled

    Examples:
      | adver           |
      | Test Advertiser |
      | Adidas          |

  Scenario Outline: Publisher info
    When user clicks Publishers block
    And user clicks "<publisher>" Publisher
    Then Moved to save button is disabled


    Examples:
      | publisher |
      | Youtube   |
      | Instagram |


  Scenario Outline: Top level client info
    When user clicks Top level clients block
    And user clicks "<client>" Client
    Then Moved to save button is disabled

    Examples:
      | client       |
      | Jon Snow     |
      | Artur Fleck  |
      | Tim Cook     |
      | Bugs Bunny   |
      | Sasha Grey   |
      | You          |
      | Leonel Messi |
      | Tony Stark   |
      | Elon Musk    |
      | Darth Vader  |


  Scenario Outline: Save button is disabled after scrolling to the middle
    When user clicks Advertiser block
    And user clicks "<adver>" Advertiser
      And user scrolls textarea to the middle
    Then Moved to save button is disabled

    Examples:
      | adver           |
      | Test Advertiser |
      | Adidas          |


  Scenario Outline: Publisher info after scrolling to the middle
    When user clicks Publishers block
    And user clicks "<publisher>" Publisher
    And user scrolls textarea to the middle
    Then Moved to save button is disabled


    Examples:
      | publisher |
      | Youtube   |
      | Instagram |


  Scenario Outline: Top level client info after scrolling to the middle
    When user clicks Top level clients block
    And user clicks "<client>" Client
    And user scrolls textarea to the middle
    Then Moved to save button is disabled

    Examples:
      | client       |
      | Jon Snow     |
      | Artur Fleck  |
      | Tim Cook     |
      | Bugs Bunny   |
      | Sasha Grey   |
      | You          |
      | Leonel Messi |
      | Tony Stark   |
      | Elon Musk    |
      | Darth Vader  |



  Scenario Outline: Save button is disabled after scrolling to the end
    When user clicks Advertiser block
    And user clicks "<adver>" Advertiser
    And user scrolls textarea to the end
    Then Moved to save button is enabled

    Examples:
      | adver           |
      | Test Advertiser |
      | Adidas          |


  Scenario Outline: Publisher info after scrolling to the end
    When user clicks Publishers block
    And user clicks "<publisher>" Publisher
    And user scrolls textarea to the end
    Then Moved to save button is enabled


    Examples:
      | publisher |
      | Youtube   |
      | Instagram |


  Scenario Outline: Top level client info after scrolling to the end
    When user clicks Top level clients block
    And user clicks "<client>" Client
    And user scrolls textarea to the end
    Then Moved to save button is enabled

    Examples:
      | client       |
      | Jon Snow     |
      | Artur Fleck  |
      | Tim Cook     |
      | Bugs Bunny   |
      | Sasha Grey   |
      | You          |
      | Leonel Messi |
      | Tony Stark   |
      | Elon Musk    |
      | Darth Vader  |



    Scenario: Add Advertiser to the saved articles
      When user clicks Advertiser block
      And user clicks "Test Advertiser" Advertiser
      And user scrolls textarea to the end
      And user clicks move to saved button
      And user clicks Advertiser in Saved articles
      Then "Test Advertiser" is shown in Saved Advertiser Articles
      And "Test Advertiser" isn't shown in Advertiser Articles to read
      Then "Test Advertiser" is added to cookies


  Scenario: Add Publisher to the saved articles
    When user clicks Publishers block
    And user clicks "Youtube" Publisher
    And user scrolls textarea to the end
    And user clicks move to saved button
    And user clicks Publisher in Saved articles
    Then "Youtube" is shown in Saved Publisher Articles
    And "Youtube" isn't shown in Publisher Articles to read


  Scenario: Add Top Level Clients to the saved articles
    When user clicks Top level clients block
    And user clicks "Sasha Grey" Client
    And user scrolls textarea to the end
    And user clicks move to saved button
    And user clicks Top level clients in Saved articles
    Then "Sasha Grey" is shown in Saved Top level clients Articles
    And "Sasha Grey" isn't shown in Top Level clients Articles to read









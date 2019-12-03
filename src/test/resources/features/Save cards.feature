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

    Scenario: Add Advertiser to the saved arctivles
      When user clicks Advertiser block
      And user clicks "Test Advertiser" Advertiser
      And user scrolls textarea to the end
      Then user clicks move to saved button
Feature: Card info

  Background:
    Given site is opened
    And user is already logged in


  Scenario Outline: Advertiser info
    When user clicks Advertiser block
    And user clicks "<adver>" Advertiser
    Then card title is "<adver>"
    And card description is equal to <description>
    And card image is on <image_path>
    And card image is shown

    Examples:
      | adver           | description        | image_path                       |
      | Test Advertiser | TestAdvertiser.txt | data/test_advert/test_advert.png |
      | Adidas          | Adidas.txt         | data/adidas/adidas.png           |

  Scenario Outline: Publisher info
    When user clicks Publishers block
    And user clicks "<publisher>" Publisher
    Then card title is "<publisher>"
    And card description is equal to <description>
    And card image is on <image_path>
    And card image is shown

    Examples:
      | publisher | description   | image_path                   |
      | Youtube   | Youtube.txt   | data/youtube/youtube.png     |
      | Instagram | Instagram.txt | data/instagram/instagram.png |


  Scenario Outline: Top level client info
    When user clicks Top level clients block
    And user clicks "<client>" Client
    Then card title is "<client>"
    And card description is equal to <description>
    And card image is on <image_path>
    And card image is shown
    Examples:
      | client       | description     | image_path                         |
      | Jon Snow     | JohnSnow.txt    | data/john_snow/john_snow.png       |
      | Artur Fleck  | ArturFleck.txt  | data/artur_fleck/artur_fleck.png   |
      | Tim Cook     | TimCook.txt     | data/tim_cook/tim_cook.png         |
      | Bugs Bunny   | BugsBunny.txt   | data/bugs_bunny/bugs_bunny.png     |
      | Sasha Grey   | SashaGrey.txt   | data/sasha_gray/sasha_gray.png     |
      | You          | You.txt         | data/you/you.png                   |
      | Leonel Messi | LeonelMessi.txt | data/leonel_messi/leonel_messi.png |
      | Tony Stark   | TonyStark.txt   | data/tony_stark/tony_stark.png     |
      | Elon Musk    | ElonMusk.txt    | data/elon_musk/elon_musk.png       |
      | Darth Vader  | DarthVader.txt  | data/darth_vader/darth_vader.png   |

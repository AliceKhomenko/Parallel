Feature: Save cards
  As user I want to save articles and removed article from saved

  Background:
    Given site is opened
    And user is already logged in

  @advertiser @saved @random
  Scenario: Save button is disabled
    When user clicks Advertiser block
    And user clicks "random" Advertiser
    Then Moved to save button is disabled


  @publisher @saved @random
  Scenario: Publisher info
    When user clicks Publishers block
    And user clicks "random" Publisher
    Then Moved to save button is disabled


  @top_level_client @saved @random
  Scenario: Top level client info
    When user clicks Top level clients block
    And user clicks "random" Client
    Then Moved to save button is disabled


  @advertiser @saved @random
  Scenario: Save button is disabled after scrolling to the middle
    When user clicks Advertiser block
    And user clicks "random" Advertiser
    And user scrolls textarea to the middle
    Then Moved to save button is disabled


  @publisher @saved @random
  Scenario: Publisher info after scrolling to the middle
    When user clicks Publishers block
    And user clicks "random" Publisher
    And user scrolls textarea to the middle
    Then Moved to save button is disabled


  @top_level_client @saved @random
  Scenario: Top level client info after scrolling to the middle
    When user clicks Top level clients block
    And user clicks "random" Client
    And user scrolls textarea to the middle
    Then Moved to save button is disabled


  @advertiser @saved @random
  Scenario: Save button is disabled after scrolling to the end
    When user clicks Advertiser block
    And user clicks "random" Advertiser
    And user scrolls textarea to the end
    Then Moved to save button is enabled


  @publisher @saved @random
  Scenario: Publisher info after scrolling to the end
    When user clicks Publishers block
    And user clicks "random" Publisher
    And user scrolls textarea to the end
    Then Moved to save button is enabled

  @top_level_client @saved @random
  Scenario: Top level client info after scrolling to the end
    When user clicks Top level clients block
    And user clicks "random" Client
    And user scrolls textarea to the end
    Then Moved to save button is enabled


  @advertiser @saved @random
  Scenario: Add random Advertiser to the saved articles
    When user clicks Advertiser block
    And user clicks "random" Advertiser
    And user scrolls textarea to the end
    And user clicks move to saved button
    And user clicks Advertiser in Saved articles
    Then selected Advertiser is shown in Saved Advertiser Articles
    And selected Advertiser isn't shown in Advertiser Articles to read
    And selected Advertiser is added to cookie "saved"

  @publisher @saved @random
  Scenario: Add random Publisher to the saved articles
    When user clicks Publishers block
    And user clicks "random" Publisher
    And user scrolls textarea to the end
    And user clicks move to saved button
    And user clicks Publisher in Saved articles
    Then selected Publisher is shown in Saved Publisher Articles
    And selected Publisher isn't shown in Publisher Articles to read
    And selected Publisher is added to cookie "saved"

  @top_level_client @saved @random
  Scenario: Add Top Level Clients to the saved articles
    When user clicks Top level clients block
    And user clicks "random" Client
    And user scrolls textarea to the end
    And user clicks move to saved button
    And user clicks Top level clients in Saved articles
    Then selected Client is shown in Saved Top level clients Articles
    And selected Client isn't shown in Top Level clients Articles to read
    And selected Client is added to cookie "saved"


  @advertiser @saved @random
  Scenario: Remove Advertiser article from saved articles
    When user clicks Advertiser block
    And user clicks "random" Advertiser
    And user scrolls textarea to the end
    And user clicks move to saved button
    And user clicks Remove from saved button
    Then selected Advertiser isn't shown in Saved Advertiser Articles
    And selected Advertiser is shown in Advertiser Articles to read
    And random Advertiser isn't added in cookie "saved"

  @publisher @saved @random
  Scenario: Remove Publisher from the saved articles
    When user clicks Publishers block
    And user clicks "random" Publisher
    And user scrolls textarea to the end
    And user clicks move to saved button
    And user clicks Remove from saved button
    Then selected Publisher isn't shown in Saved Publisher Articles
    And selected Publisher is shown in Publisher Articles to read
    And selected Publisher isn't added to cookie "saved"

  @top_level_client @saved @random
  Scenario: Remove Top Level Clients from the saved articles
    When user clicks Top level clients block
    And user clicks "random" Client
    And user scrolls textarea to the end
    And user clicks move to saved button
    And user clicks Remove from saved button
    Then selected Client isn't shown in Saved Top level clients Articles
    And selected Client is shown in Top Level clients Articles to read
    And selected Client isn't added to cookie "saved"

  @advertiser @cookie @saved
  Scenario: Try adding article to the saved twice
    When user clicks Advertiser block
    And user clicks "random" Advertiser
    And user scrolls textarea to the end
    And user clicks move to saved button
    And user clicks move to saved button
    And user clicks Advertiser in Saved articles
    Then selected Advertiser is shown in Saved Advertiser Articles
    And Saved Advertiser list hasn't duplicates
    And selected Advertiser is added to cookie "saved" once



















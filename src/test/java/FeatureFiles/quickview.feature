Feature: Purchasing of two items from site

  Scenario: 1. User can use a quick view an item
    Given User is logged into site
    When User selects "Blouse" to view
    And User gets the price for "Blouse"
    And User changes the size of selected item to "M"
    Then Initial size for "M" is displayed on page
    And User adds item to basket
    And User continues to view "PrintedDress"
    And User gets the price for "PrintedDress"
    When User adds item to basket
    And User checks out
#    Then The price for "Blouse" should be as before
#    And The price for "PrintedDress" should be as before
    And The total is sum of the item cost plus shipping
    And User completes payment by wire
    And User logs out of application


  Scenario: 2. Review Previous orders and add message
    Given User is logged into site
    And User navigate to orders page
    And User sorts most recent order
    And User selects an item
    When User posts an order comment
    Then Message is displayed under messages section
    And User signs out of application


  Scenario: 3. Capture Image
    Given User is logged into site
    And User navigate to orders page
    And User sorts most recent order
    When User selects an item
    Then User verifies the color of item selected
    And User signs out of application

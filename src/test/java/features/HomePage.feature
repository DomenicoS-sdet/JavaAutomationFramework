Feature: HomePage

  Scenario: Navigate to the Home Page
    Given I Navigate to the home page
    When I am on the home page
    Then The search button is available

  Scenario: Search for a Hotel
    Given I Navigate to the home page
    When I am on the home page
    And I fill the hotel search with the following data
      | Singapore | 19/10/2019 | 25/10/2019 | 2 | 1 |
    And I click on the button Search
    Then a list of hotels is returned

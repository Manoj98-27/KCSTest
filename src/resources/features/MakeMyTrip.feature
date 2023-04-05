@UI
Feature: Flight search on MakeMyTrip

@test
Scenario: Search for a one-way flight between Ahmedabad and Pune
  Given I am on the MakeMyTrip homepage
  When I enter the details of my one-way flight search
  Then I should see the search results with the correct filters
    And all flight prices should be between 3,486 to 9,000
    And the count of Nonstop flights should match the right-side total flights count

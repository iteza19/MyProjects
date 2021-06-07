Feature: testing an API TEST
  Running testing API

  Scenario: get All data
    Given user have API list
    When user get some data
    Then user verify the response

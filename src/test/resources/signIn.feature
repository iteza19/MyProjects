Feature: testing
@login
  Scenario: sign in using correct account
    Given user already on home page youtube music
    When user click button sign in
    And user login with correct account
    Then user will redirected to home

  Scenario: sign in using incorrect account
    Given user already on home page youtube music
    When user click button sign in
    And user login with incorrect account
    Then user will see error text wrong password
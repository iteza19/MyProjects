@home
Feature: testing epic home

  Scenario: play 1 song from home
    Given user in home page
    When user click thumbnail song from quick picks
    Then user redirect to music screen and song played

  Scenario: verify mini player
    Given user in music screen
    When user click back button
    Then user redirect to previous page and mini player will appear in bottom right of page

  Scenario: play and pause on mini player
    Given user in home page with mini player appear
    When user click pause or play button in mini player
    Then user will see player is paused or played

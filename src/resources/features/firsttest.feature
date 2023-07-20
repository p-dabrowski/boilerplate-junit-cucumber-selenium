Feature: Gui wiki tests

  Background: User has his browser turned on
    Given I have browser opened

  Scenario:
    Given I go to wiki webpage
    When I search for phrase
    Then I get list of results

  Scenario:
    Given I go to wiki webpage
    When I search for phrase as admin
    Then I get list of results
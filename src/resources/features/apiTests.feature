Feature: End to end tests of bookstore api
  Description: The purpose of these tests is to cover End to End customer paths

  Background: User generates token for Authorization
    Given I am an authorized user

  Scenario: Authorized user is able to get books list
    Given I'm logged in
    When I ask for my books list
    Then I get my books list
@version:3.1.5
@version:Sprint-1.1
@issue:
Feature: Login
  As an user
  I want to be able to login system
  So that I can use system

  Scenario Outline: Login success
    Given I open Login page
    When I input my credentials username <username> and password <password>
    Then The system should let me in
  Examples:
    |username|password|
    |9999999|triarrow|
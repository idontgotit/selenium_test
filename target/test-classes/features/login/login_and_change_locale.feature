@version:3.1.5
@version:Sprint-1.1
@issue:
Feature: Change Locale
  As an user
  I want to be able to change the system locale
  So that I can understand system

  Background:
    Given I open Login page
    When I input my credentials username 9999999 and password triarrow
    Then The system should let me in

  Scenario Outline: Login success and change locale
    When I change language to <lang>
    Then The system should change all text to <lang>
    Examples:
      | lang |
      | en   |
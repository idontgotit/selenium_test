@version:3.1.5
@version:Sprint-1.1
@issue:
Feature: Accounting
  As a user
  I want search name card data
  So i can view name card's details

  @LoggedIn
  Scenario Outline: 15. Initialization screen
    When I open submenu <submenuText> of menu <menuText>
    Then The system should open initialization screen of <submenuText> page

    Examples:
      | submenuText       | menuText   |
      | Credit Management | Accounting |

  @LoggedIn
  Scenario Outline: 16. Search customer by name company and id
    When I open submenu <submenuText> of menu <menuText>
    And I fill value <invalidIdNameCard> for input id name card
    And I fill value  for input company name
    And I click search button in Credit management
    Then The system should show table result with no record

    When I fill value <validIdNameCard> for input id name card
    And I fill value  for input company name
    And I click search button in Credit management
    Then The system should show table result with records

    When I fill value  for input id name card
    And I fill value <invalidCompanyName> for input company name
    And I click search button in Credit management
    Then The system should show table result with no record

    When I fill value  for input id name card
    And I fill value <validCompanyName> for input company name
    And I click search button in Credit management
    Then The system should show table result with records

    When I fill value <invalidIdNameCard> for input id name card
    And I fill value <invalidCompanyName> for input company name
    And I click search button in Credit management
    Then The system should show table result with no record

    When I fill value <validIdNameCard> for input id name card
    And I fill value <validCompanyName> for input company name
    And I click search button in Credit management
    Then The system should show table result with records

    When I click checkbox left of a row <rowIndex> into table result
    Then The system should enable select button and highlight row <rowIndex>

    When I click checkbox left of a row <rowIndex> into table result
    Then The system should disable select button and no highlight row <rowIndex>

    When I click a row <rowIndex> into table result
    Then The system should enable select button and highlight row <rowIndex>

    When I click a row <rowIndex> into table result
    Then The system should enable select button and highlight row <rowIndex>

    When In accounting screen, I click button select
    Then The system should show customer details screen

    Examples:
      | submenuText       | menuText   | invalidIdNameCard | validIdNameCard | invalidCompanyName | validCompanyName | rowIndex |
      | Credit Management | Accounting | aaaaa             | EC7B840A        | aaaaa              | コペル株式会社          | 0        |

  @LoggedIn
  Scenario Outline: 17. Change page on paging
    When I open submenu <submenuText> of menu <menuText>
    And I fill value <validIdNameCard> for input id name card
    And I fill value  for input company name
    And I click search button in Credit management
    Then The system should show table result with records

    When In accounting screen, I click button last page on paging
    Then The table result should show last page

    When In accounting screen, I click button first page on paging
    Then The table result should show first page

    When I click page <pageNumberOne> on paging
    Then The system should change table result to selected page <pageNumberOne>

    When In accounting screen, I click button next on paging
    Then The system should change table result to selected page <pageNumberOne> + 1

    When I click page <pageNumberOne> on paging
    Then The system should change table result to selected page <pageNumberOne>

    When In accounting screen, I click button back on paging
    Then The system should change table result to selected page <pageNumberOne> - 1

    When I click a row <rowIndex> into table result
    And I click page <pageNumberTwo> on paging
    Then The system should change table result to selected page <pageNumberTwo>
    And The table result has no selected row
    And The table result show no row selected
    And Button Select disabled

    Examples:
      | submenuText       | menuText   | validIdNameCard | pageNumberOne | pageNumberTwo | rowIndex |
      | Credit Management | Accounting | EC              | 2             | 4             | 0        |

  @LoggedIn
  Scenario Outline: 18. Search customer by code
    When I open submenu <submenuText> of menu <menuText>
    And  I search customer by code <invalidCustomerCode>
    Then The system should show table result with no record

    When I search customer by code <validCustomerCode>
    Then The system should show table result with records

    When I click checkbox left of a row <rowIndex> into table result
    Then The system should enable select button and highlight row <rowIndex>

    When I click checkbox left of a row <rowIndex> into table result
    Then The system should disable select button and no highlight row <rowIndex>

    When I click a row <rowIndex> into table result
    Then The system should enable select button and highlight row <rowIndex>

    When I click a row <rowIndex> into table result
    Then The system should enable select button and highlight row <rowIndex>

    When In accounting screen, I click button select
    Then The system should show customer details screen

    Examples:
      | submenuText       | menuText   | invalidCustomerCode | validCustomerCode | rowIndex |
      | Credit Management | Accounting | a0000000            | a0010000          | 0        |

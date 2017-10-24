@version:3.1.5
@version:Sprint-1.1
@issue:
Feature: Search Daily report by date
  As a user
  I want search daily report by date
  So I can view detail, delete or edit daily report

#-------------------------------------------------------------------------------#

  @LoggedIn
  Scenario Outline: 1. Initialization screen
    When I open submenu <submenuText> of menu <menuText>
    Then The system should show initialization screen of Search by Date page

    Examples:
      | submenuText    | menuText     |
      | Search By Date | Daily Report |

#-------------------------------------------------------------------------------#

  @LoggedIn
  Scenario Outline: 2. Search daily report
    When I open submenu <submenuText> of menu <menuText>
    And In Search by date screen, I choose a branch <branchName> in dropdown Branch
    And In Search by date screen, I type value <employeeInfo> for autocomplete Employee
    And In Search by date screen, I choose <employeeInfo> employee in dropdown of autocomplete Employee
    And In Search by date screen, I click button '<buttonText>'
    Then The system should show table Search by date result with no record found

    When In Search by date screen, I select date <date> in item Date
    And In Search by date screen, I click button '<buttonText>'
    Then The system should show table Search by date result has record found
    And The system should show button Edit and Delete disabled

    When In Search by date screen, I click checkbox Include retired employee
    And In Search by date screen, I choose <employeeInfo> employee in dropdown of autocomplete Employee
    Then The system should show table Search by date result has record found

    Examples:
      | submenuText    | menuText     | buttonText | branchName | employeeInfo | date       |
      | Search By Date | Daily Report | Search     | 福岡         | 40000005     | 2012/11/28 |

#-------------------------------------------------------------------------------#

  @LoggedIn
  Scenario Outline: 3. Toggle
    Given A list of column title need toggle in Search by date
      | Reminder start time |
      | Reminder end time   |
    When I open submenu <submenuText> of menu <menuText>
    Then The system should open '<submenuText>' page

    When In Search by date screen, I select date <date> in item Date
    And In Search by date screen, I choose a branch <branchName> in dropdown Branch
    And In Search by date screen, I type value <employeeInfo> for autocomplete Employee
    And In Search by date screen, I choose <employeeInfo> employee in dropdown of autocomplete Employee
    And In Search by date screen, I click button '<buttonText>'
    And I open toggle menu in table Search by date result
    And I toggle all column in table Search by date result
    Then The system should show table Search by date result has <totalColumn> columns

    Examples:
      | submenuText    | menuText     | totalColumn | buttonText | branchName | employeeInfo | date       |
      | Search By Date | Daily Report | 8           | Search     | 福岡        | 40000005     | 2012/11/28 |

#-------------------------------------------------------------------------------#

  @LoggedIn
  Scenario Outline: 4. Paging
    When I open submenu <submenuText> of menu <menuText>
    Then The system should open '<submenuText>' page

    When In Search by date screen, I select date <date> in item Date
    And In Search by date screen, I choose a branch <branchName> in dropdown Branch
    And In Search by date screen, I type value <employeeInfo> for autocomplete Employee
    And In Search by date screen, I choose <employeeInfo> employee in dropdown of autocomplete Employee
    And In Search by date screen, I click button '<buttonText>'
    Then The system should show table Search by date result has record found

    When In Search by date screen, I click button last page on paging
    Then The table Search by date result should show last page

    When In Search by date screen, I click button first page on paging
    Then The table Search by date result should show first page

    When In Search by date screen, I click page <pageNumberOne> on paging
    Then The table Search by date result should change to selected page <pageNumberOne>

    When In Search by date screen, I click button back on paging
    Then The table Search by date result should change to selected page <pageNumberOne> - 1

    When In Search by date screen, I click button next on paging
    Then The table Search by date result should change to selected page <pageNumberOne>

    Examples:
      | submenuText    | menuText     | buttonText | branchName | employeeInfo | date       | pageNumberOne |
      | Search By Date | Daily Report | Search     | 福岡         | 40000005     | 2012/11/28 | 2             |

#-------------------------------------------------------------------------------#

  @LoggedIn
  Scenario Outline: 5. Show all business detail
    When I open submenu <submenuText> of menu <menuText>
    Then The system should open '<submenuText>' page

    When In Search by date screen, I select date <date> in item Date
    And In Search by date screen, I choose a branch <branchName> in dropdown Branch
    And In Search by date screen, I type value <employeeInfo> for autocomplete Employee
    And In Search by date screen, I choose <employeeInfo> employee in dropdown of autocomplete Employee
    And In Search by date screen, I click button '<buttonSearchText>'
    Then The system should show table Search by date result has record found

    When In Search by date screen, I click button '<buttonShowAllText>'
    Then The table Search by date result should expand all row

    Examples:
      | submenuText    | menuText     | buttonSearchText | branchName | employeeInfo | date       | buttonShowAllText        |
      | Search By Date | Daily Report | Search           | 福岡         | 40000005     | 2012/11/28 | Show all Business Detail |

#-------------------------------------------------------------------------------#

  @LoggedIn
  Scenario Outline: 6. Create a daily report to test
    When I open submenu <submenuText> of menu <menuText>
    Then The system should open '<menuText>' page

    When In Register daily report, I choose category '<categoryType>'
    And I add new Daily report with data below
      | content                                               |
      | Verify create new daily report with category is other |
    Then The system should show message save daily report successfully

    Examples:
      | submenuText | menuText     | categoryType |
      | Register    | Daily Report | Other works  |

#-------------------------------------------------------------------------------#

  @LoggedIn
  Scenario Outline: 7. Verify edit daily report
    When I open submenu <submenuText> of menu <menuText>
    Then The system should open '<submenuText>' page

    When In Search by date screen, I choose a branch <branchName> in dropdown Branch
    And In Search by date screen, I type value <employeeInfo> for autocomplete Employee
    And In Search by date screen, I choose <employeeInfo> employee in dropdown of autocomplete Employee
    And In Search by date screen, I click button '<buttonSearchText>'
    And In Search by date screen, I select row <rowIndex>
    And In Search by date screen, I click button '<editButtonText>'
    Then The system should open '<pageTitle>' page

    Examples:
      | submenuText    | menuText     | buttonSearchText | branchName | employeeInfo | editButtonText | rowIndex | pageTitle    |
      | Search By Date | Daily Report | Search           | 東京         | 4009909      | Edit           | 0        | Daily Report |

#-------------------------------------------------------------------------------#

  @LoggedIn
  Scenario Outline: 8. Verify delete if user is creator of daily report
    When I open submenu <submenuText> of menu <menuText>
    Then The system should open '<submenuText>' page

    When In Search by date screen, I choose a branch <branchName> in dropdown Branch
    And In Search by date screen, I type value <employeeInfo> for autocomplete Employee
    And In Search by date screen, I choose <employeeInfo> employee in dropdown of autocomplete Employee
    And In Search by date screen, I click button '<buttonSearchText>'
    And In Search by date screen, I select row <rowIndex>
    And In Search by date screen, I click button '<deleteButtonText>'
    Then The system should show confirm delete popup

    When In Search by date screen, I click button '<noButtonText>' in confirm delete popup
    Then The system should show table Search by date result has record found

    When In Search by date screen, I click button '<deleteButtonText>'
    And In Search by date screen, I click button '<yesButtonText>' in confirm delete popup
    Then The system should show message delete successfully

    Examples:
      | submenuText    | menuText     | buttonSearchText | branchName | employeeInfo | deleteButtonText | rowIndex | noButtonText | yesButtonText |
      | Search By Date | Daily Report | Search           | 東京        | 4009909      | Delete           | 0        | No           | Yes           |

#-------------------------------------------------------------------------------#

  @LoggedIn
  Scenario Outline: 9. Verify delete if user isn't creator of daily report
    When I open submenu <submenuText> of menu <menuText>
    Then The system should open '<submenuText>' page

    When In Search by date screen, I select date <date> in item Date
    And In Search by date screen, I choose a branch <branchName> in dropdown Branch
    And In Search by date screen, I type value <employeeInfo> for autocomplete Employee
    And In Search by date screen, I choose <employeeInfo> employee in dropdown of autocomplete Employee
    And In Search by date screen, I click button '<buttonSearchText>'
    Then The system should show table Search by date result can not select any row

    Examples:
      | submenuText    | menuText     | buttonSearchText | branchName | employeeInfo | date       |
      | Search By Date | Daily Report | Search           | 北海道        | 濱谷賢児         | 2010/09/14 |

#-------------------------------------------------------------------------------#


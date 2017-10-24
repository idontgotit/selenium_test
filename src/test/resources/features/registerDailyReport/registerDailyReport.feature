@version:3.1.5
@version:Sprint-1.1
@issue:
Feature: register daily report
  As a user
  I want to access register daily report
  So I can add or update daily report

#-------------------------------------------------------------------------------

  @LoggedIn
  Scenario Outline: 1. Initialization screen when create new daily report and verify toggle column
    Given A list of column title need toggle in Register Daily report
      | Purpose             |
      | Reminder start time |
      | Reminder end time   |
    When I open submenu <submenuText> of menu <menuText>
    Then The system should show initialization screen of Register Daily report

    When I open toggle menu in table daily report history
    And I toggle all column in table daily report history
    Then The system should show table daily report history has <totalColumn> columns

    Examples:
      | submenuText | menuText     | totalColumn |
      | Register    | Daily Report | 10          |

#-------------------------------------------------------------------------------

  Scenario Outline: 2. Initialization screen when access from search by date screen
    When I open Login page
    Then I input my credentials username <username> and password <password>
    And I change language to <lang>
    And I open submenu <submenuText> of menu <menuText>
    Then The system should open '<submenuText>' page

    When In Search by date screen, I select date <date> in item Date
    And In Search by date screen, I type value <employeeInfo> for autocomplete Employee
    And In Search by date screen, I choose <employeeInfo> employee in dropdown of autocomplete Employee
    And In Search by date screen, I click button '<buttonText>'
    Then The system should show table Search by date result has record found

    When In Search by date screen, I select row <rowIndex>
    And In Search by date screen, I click button '<editButtonText>'
    Then The system should show initialization screen of Register Daily report when access from Search by date screen

    Examples:
      | username | password | lang | submenuText    | menuText     | buttonText | employeeInfo | date       | rowIndex | editButtonText |
      | 40000005 | 19851129 | en   | Search By Date | Daily Report | Search     | 40000005     | 2012/11/28 | 0        | Edit           |

  Scenario: logout from system
    Given I logout from system

#-------------------------------------------------------------------------------

  Scenario Outline: 3. Paging
    When I open Login page
    Then I input my credentials username <username> and password <password>
    And I change language to <lang>
    And I open submenu <submenuText> of menu <menuText>
    Then The system should open '<menuText>' page

    When In Register daily report, I choose date <date> in calendar date
    And In Table daily report history, I click button last page on paging
    Then The table daily report history should show last page

    When In Table daily report history, I click button first page on paging
    Then The table daily report history should show first page

    When In Table daily report history, I click page <pageNumberOne> on paging
    Then The table daily report history should change to selected page <pageNumberOne>

    When In Table daily report history, I click button back on paging
    Then The table daily report history should change to selected page <pageNumberOne> - 1

    When In Table daily report history, I click button next on paging
    Then The table daily report history should change to selected page <pageNumberOne>

    Examples:
      | username | password | lang | submenuText | menuText     | pageNumberOne | date       |
      | 40000005 | 19851129 | en   | Register    | Daily Report | 2             | 2012/11/28 |

  Scenario: logout from system
    Given I logout from system

#-------------------------------------------------------------------------------

  @LoggedIn
  Scenario Outline: 4. Delete all current daily report
    When I open submenu <submenuText> of menu <menuText>
    Then The system should open '<menuText>' page

    When In Register daily report, I delete all current daily report
    Then The system should show table daily report history has no data

    Examples:
      | submenuText | menuText     |
      | Register    | Daily Report |

#-------------------------------------------------------------------------------

  @LoggedIn
  Scenario Outline: 5. Create new daily report and fill only required fields
    When I open submenu <submenuText> of menu <menuText>
    Then The system should open '<menuText>' page

    When I add new Daily report with data below
      | companyName | content                                                       |
      | CIJ         | Verify create new daily report when fill only required fields |

    Then The system should show message save daily report successfully

    Examples:
      | submenuText | menuText     |
      | Register    | Daily Report |

#-------------------------------------------------------------------------------

  @LoggedIn
  Scenario Outline: 6. Create new daily report with category is other works
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

#-------------------------------------------------------------------------------

  @LoggedIn
  Scenario Outline: 7. Create new daily report and fill all fields
    When I open submenu <submenuText> of menu <menuText>
    Then The system should open '<menuText>' page

    When   I add new Daily report with data below
      | companyName | content                                            | personInCharge | department | businessType | purpose | reminder | projectFlag | openFlag |
      | 北開工営        | Verify create new daily report and fill all fields | 庭田次長           | atv        | ソフトウェア       | クレーム    | ON       | ON          | ON       |
    Then The system should show start time and end time required message

    When I fill Daily report screen with data below
      | reminder | reminderFrom | reminderTo |
      | ON       | 2016/10/19   | 2016/10/20 |
    And In Register daily report, I click button Add
    Then The system should show message save daily report successfully

    Examples:
      | submenuText | menuText     |
      | Register    | Daily Report |

#-------------------------------------------------------------------------------

  @LoggedIn
  Scenario Outline: 8. Update daily report when access from menu
    When I open submenu <submenuText> of menu <menuText>
    Then The system should show table daily report history has data

    When In Register daily report, I choose row <rowIndex> in table daily report history
    Then The system should show daily report can update

    When In Register daily report, I choose category '<categoryType>'
    And I update Daily report with data below
      | content                                                                      |
      | Verify update daily report when change from category business to other works |
    Then The system should show message save daily report successfully

    When In Register daily report, I choose row <rowIndex> in table daily report history
    Then The system should show details like below
      | content                                                                      |
      | Verify update daily report when change from category business to other works |

    When I update Daily report with data below
      | companyName | content                    | personInCharge | department | businessType | purpose | reminder | reminderFrom | reminderTo | projectFlag | openFlag |
      | CIJ         | Verify update daily report | 庭田次長           | atv        | ソフトウェア       | クレーム    | ON       | 2016/10/19   | 2016/10/20 | ON          | ON       |
    Then The system should show message save daily report successfully

    When In Register daily report, I choose row <rowIndex> in table daily report history
    Then The system should show details like below
      | companyName | content                    | personInCharge | department | businessType | purpose | reminder | reminderFrom | reminderTo | projectFlag | openFlag |
      | CIJ         | Verify update daily report | 庭田次長           | atv        | ソフトウェア       | クレーム    | ON       | 2016/10/19   | 2016/10/20 | ON          | ON       |

    Examples:
      | submenuText | menuText     | rowIndex | categoryType |
      | Register    | Daily Report | 0        | Other works  |

#-------------------------------------------------------------------------------

  @LoggedIn
  Scenario Outline: 9. Verify create new company when create daily report
    When I open submenu <submenuText> of menu <menuText>
    Then The system should show link Register now is visible and i can click

    When In Register daily report, I click link Register now
    Then The system should open '<companyPageTitle>' page

    And I set name '<companyName>' for company
    When I input company detail as below
      | companyFullName | workType | listed     | headOffice | branches | website            |
      | Atv             | 土木       | Not Listed | 岩手県        | 東京都, 山梨県 | anlh@arrow-tech.vn |
    And In Company Detail screen, I click '<saveButtonText>' button
    Then The system should save company success
    And The system should open '<dailyReportPageTitle>' page
    And In Register daily report, autocomplete Company should filled value '<companyName>'

    When I fill Daily report screen with data below
      | content                                            |
      | Verify create new company when create daily report |
    And In Register daily report, I click button Add
    Then The system should show message save daily report successfully

    Examples:
      | submenuText | menuText     | companyPageTitle   | saveButtonText | dailyReportPageTitle | companyName |
      | Register    | Daily Report | Company Management | Save           | Daily Report         | Atv         |

#-------------------------------------------------------------------------------

  @LoggedIn
  Scenario Outline: 10. Verify delete daily report
    When I open submenu <submenuText> of menu <menuText>
    Then The system should open '<menuText>' page

    When In Register daily report, I select rows in table daily report history to delete
      | 0 |
      | 1 |
      | 2 |
      | 3 |
    And In Register daily report, I click button Delete
    And In Register daily report, I click button <declineText> in popup confirm delete daily report
    Then The system should show table daily report history has data

    When In Register daily report, I click button Delete
    And In Register daily report, I click button <confirmText> in popup confirm delete daily report
    Then The system should show message delete daily report successfully

    Examples:
      | submenuText | menuText     | declineText | confirmText |
      | Register    | Daily Report | No          | Yes         |

#-------------------------------------------------------------------------------
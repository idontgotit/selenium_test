@version:3.1.5
@version:Sprint-1.1
@issue:
Feature: Verify all menus by user role
  As an user
  I want to be able to change menu when i change role of user
  So that I can understand system

  Background:
    Given I logout from system

  Scenario Outline: 1. Login with role staff of branch
    Given I open Login page
    When I input my credentials username <username> and password <password>
    Then The system should let me in

    When I change language to <lang>
    Then The system should change all text to <lang>

    Given List menu I have permission
      | Company Management   | Common       |
      | Employee Management   | Common       |
      | Branch Management   | Common       |
      | Summary Report       | Report       |
      | Register             | Daily Report |
      | Search History       | Daily Report |
      | Search By Date       | Daily Report |
      | Credit Management    | Accounting   |
      | Notification Setting | Notification |
      | View Notifications   | Notification |

    Then The system should show all menu I have permission
    And The system should show only menu I have permission

    Examples:
      | username | password | lang |
      | 4009911  | 123456   | en   |

#--------------------------------------------------------------------------------

  Scenario Outline: 2. Login with role staff of headquarter
    Given I open Login page
    When I input my credentials username <username> and password <password>
    Then The system should let me in

    When I change language to <lang>
    Then The system should change all text to <lang>

    Given List menu I have permission
      | Company Management   | Common       |
      | Employee Management  | Common       |
      | Summary Report       | Report       |
      | Register             | Daily Report |
      | Search History       | Daily Report |
      | Search By Date       | Daily Report |
      | Credit Management    | Accounting   |
      | Notification Setting | Notification |
      | View Notifications   | Notification |
    Then The system should show all menu I have permission
    And The system should show only menu I have permission

    Examples:
      | username | password | lang |
      | 4009910  | 123456   | en   |

#--------------------------------------------------------------------------------

  Scenario Outline: 3. Login with role manager of branch
    Given I open Login page
    When I input my credentials username <username> and password <password>
    Then The system should let me in

    When I change language to <lang>
    Then The system should change all text to <lang>

    Given List menu I have permission
      | Company Management   | Common        |
      | Employee Management  | Common        |
      | Branch Management    | Common        |
      | Summary Report       | Report        |
      | Register             | Daily Report  |
      | Search History       | Daily Report  |
      | Search By Date       | Daily Report  |
      | Notification Setting | Notification  |
      | View Notifications   | Notification  |
      | BASS Export          | Import/Export |
      | Credit Management    | Accounting    |
      | Maintain Credit Data | Accounting    |

    Then The system should show all menu I have permission
    And The system should show only menu I have permission

    Examples:
      | username | password | lang |
      | 4009909  | 123456   | en   |

#--------------------------------------------------------------------------------

  Scenario Outline: 4. Login with role manager of headquarter
    Given I open Login page
    When I input my credentials username <username> and password <password>
    Then The system should let me in

    When I change language to <lang>
    Then The system should change all text to <lang>

    Given List menu I have permission
      | Credit Management    | Accounting    |
      | Company Management   | Common        |
      | Summary Report       | Report        |
      | Register             | Daily Report  |
      | Search History       | Daily Report  |
      | Search By Date       | Daily Report  |
      | Notification Setting | Notification  |
      | View Notifications   | Notification  |

    Then The system should show all menu I have permission
    And The system should show only menu I have permission

    Examples:
      | username | password | lang |
      | 4009908  | 123456   | en   |

#--------------------------------------------------------------------------------

  Scenario Outline: 5. Login with role system support of branch
    Given I open Login page
    When I input my credentials username <username> and password <password>
    Then The system should let me in

    When I change language to <lang>
    Then The system should change all text to <lang>

    Given List menu I have permission
      | Company Management   | Common       |
      | Summary Report       | Report       |
      | Register             | Daily Report |
      | Search History       | Daily Report |
      | Search By Date       | Daily Report |
      | Notification Setting | Notification |
      | View Notifications   | Notification |
      | Credit Management    | Accounting   |

    Then The system should show all menu I have permission
    And The system should show only menu I have permission

    Examples:
      | username | password | lang |
      | 4009907  | 123456   | en   |

#--------------------------------------------------------------------------------

  Scenario Outline: 6. Login with role system support of headquarter
    Given I open Login page
    When I input my credentials username <username> and password <password>
    Then The system should let me in

    When I change language to <lang>
    Then The system should change all text to <lang>

    Given List menu I have permission
      | Company Management   | Common        |
      | Employee Management  | Common        |
      | Credit Management    | Accounting    |
      | Summary Report       | Report        |
      | Register             | Daily Report  |
      | Search History       | Daily Report  |
      | Search By Date       | Daily Report  |
      | Notification Setting | Notification  |
      | View Notifications   | Notification  |
    Then The system should show all menu I have permission
    And The system should show only menu I have permission

    Examples:
      | username | password | lang |
      | 4009906  | 123456   | en   |

#--------------------------------------------------------------------------------

  Scenario Outline: 7. Login with role officer of headquarter
    Given I open Login page
    When I input my credentials username <username> and password <password>
    Then The system should let me in

    When I change language to <lang>
    Then The system should change all text to <lang>

    Given List menu I have permission
      | Company Management   | Common       |
      | Employee Management  | Common       |
      | Branch Management    | Common       |
      | Summary Report       | Report       |
      | Register             | Daily Report |
      | Search History       | Daily Report |
      | Search By Date       | Daily Report |
      | Credit Management    | Accounting   |
      | Notification Setting | Notification |
      | View Notifications   | Notification |

    Then The system should show all menu I have permission
    And The system should show only menu I have permission

    Examples:
      | username | password | lang |
      | 4009912  | 123456   | en   |

#--------------------------------------------------------------------------------

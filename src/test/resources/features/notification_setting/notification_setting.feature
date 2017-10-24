@version:3.1.5
@version:Sprint-1.1
@issue:
Feature: Notification Setting display
  As an user
  I want to be able use Notification Setting

  Scenario Outline: 1. Open Notification Setting and verify paging last, first, next, previous
    When I open Login page
    And I input my credentials username <number> and password <string>
    And I change language to <lang>
    And I open submenu <notificationMenu> of parent menu <parentMenuText>
    Then The system should open '<parentMenuText>' page
    And In Notification Setting screen, i select more dropdown with value below
      | valueBranch | valuePosition | valueEmpName |
      | random      | All position  | All employee |
    And In Notification Setting screen, I click in <addBtn>

    And In Notification Setting screen, i select more dropdown with value below
      | valueBranch             | valuePosition | valueEmpName |
      | second in list dropdown | All position  | All employee |
    And In Notification Setting screen, I click in <addBtn>

    And In Notification Setting screen, i select more dropdown with value below
      | valueBranch | valuePosition | valueEmpName |
      | 東京          | All position  | All employee |
    And In Notification Setting screen, I click in <addBtn>

    And In Notification Setting screen, I click button <nextPage> page on paging
    Then In Notification Setting screen, Table should show <nextPage> page

    When In Notification Setting screen, I click button <lastPage> page on paging
    Then In Notification Setting screen, Table should show <lastPage> page

    When In Notification Setting screen, I click button <previousPage> page on paging
    Then In Notification Setting screen, Table should show <previousPage> page
    And In Notification Setting screen, Table show result with <numberPaging> results in page

    When In Notification Setting screen, I click button <firstPage> page on paging
    Then In Notification Setting screen, Table should show <firstPage> page
    And In Notification Setting screen, Table show result with <numberPaging> results in page
    And I logout from system

    Examples:
      | notificationMenu     | parentMenuText | nextPage | lastPage | previousPage | firstPage | numberPaging | addBtn | number  | string | lang |
      | Notification Setting | Notification   | next     | last     | previous     | first     | 20           | Add    | 4009912 | 123456 | en   |


  Scenario Outline: 2. Open Notification Setting click check box enable
    When I open Login page
    And I input my credentials username <number> and password <string>
    And I change language to <lang>
    When I open submenu <notificationMenu> of parent menu <parentMenuText>
    Then The system should open '<parentMenuText>' page
    And In Notification Setting screen, I click random checkbox in column enable
    Then In Notification Setting screen, System show list button can not use
      | Add    |
      | Delete |
    And In Notification Setting screen, Table in the left have list select box can select
      | Branch        |
      | Position      |
      | Employee Name |
    And In Notification Setting screen, Table in the right have <numberClm> columns
    And In Notification Setting screen, Table in the right have columns like below
      | Employee Code |
      | Employee Name |
      | Type          |
      | Enable?       |
      | Unread        |
    And I logout from system
    Examples:
      | notificationMenu     | parentMenuText | numberClm | number  | string | lang |
      | Notification Setting | Notification   | 6         | 4009912 | 123456 | en   |

  Scenario Outline: 3. Open Notification Setting and verify start screen have setting
    When I open Login page
    And I input my credentials username <number> and password <string>
    And I change language to <lang>
    And I open submenu <notificationMenu> of parent menu <parentMenuText>
    Then The system should open '<parentMenuText>' page
    And In Notification Setting screen, Table in the right have <numberClm> columns
    And In Notification Setting screen, Table in the right have any record
    And In Notification Setting screen, Table in the right have columns like below
      | Employee Code |
      | Employee Name |
      | Type          |
      | Enable?       |
      | Unread        |
    And In Notification Setting screen, Table in the left have list select box can select
      | Branch        |
      | Position      |
      | Employee Name |
    And In Notification Setting screen, link View Notifications is <statusViewNotifications>
    And I logout from system
    Examples:
      | notificationMenu     | pageTitle    | parentMenuText | numberClm | statusViewNotifications | number  | string | lang |
      | Notification Setting | Notification | Notification   | 6         | Visible                 | 4009912 | 123456 | en   |

  Scenario Outline: 4. Open Notification Setting click view notification
    When I open Login page
    And I input my credentials username <number> and password <string>
    And I change language to <lang>
    And I open submenu <notificationMenu> of parent menu <parentMenuText>
    Then The system should open '<parentMenuText>' page
    And In Notification Setting screen, link View Notifications is <statusViewNotifications>
    And In Notification Setting screen, I click in <viewNotification>
    Then In Notification Setting screen, System show screen View Notification have buttons
      | Mark all as read     |
      | Notification Setting |
    And I logout from system
    Examples:
      | notificationMenu     | parentMenuText | viewNotification   | statusViewNotifications | number  | string | lang |
      | Notification Setting | Notification   | View Notifications | Visible                 | 4009912 | 123456 | en   |


  Scenario Outline: 5. Open Notification Setting and verify start screen with out setting
    When I open Login page
    And I input my credentials username <number> and password <string>
    And I change language to <lang>
    And I open submenu <notificationMenu> of parent menu <parentMenuText>
    Then The system should open '<pageTitle>' page
    And In Notification Setting screen, System show list button can not use
      | Add    |
      | Delete |
    And In Notification Setting screen, Table in the right have <numberClm> columns
    And In Notification Setting screen, Table in the right have columns like below
      | Employee Code |
      | Employee Name |
      | Type          |
      | Enable?       |
      | Unread        |
    And In Notification Setting screen, I delete all in table notification, show message <deleteSuccess>
    And In Notification Setting screen, Table in the right do not have any record
    And In Notification Setting screen, Table in the left have list select box can select
      | Branch        |
      | Position      |
      | Employee Name |
    And I logout from system

    Examples:
      | notificationMenu     | pageTitle    | parentMenuText | numberClm | number   | string   | lang | deleteSuccess       |
      | Notification Setting | Notification | Notification   | 6         | 13000002 | triarrow | en   | Delete successfully |


  Scenario Outline: 6. Open Notification Setting, select one branch, one position, one employee name and add
    When I open Login page
    And I input my credentials username <number> and password <string>
    And I change language to <lang>
    And I open submenu <notificationMenu> of parent menu <parentMenuText>
    Then The system should open '<parentMenuText>' page
    When In Notification Setting screen, I delete all in table notification, show message <deleteSuccess>
    And In Notification Setting screen, i select more dropdown with value below
      | valueBranch | valuePosition           | valueEmpName           |
      | 東北          | second in list dropdown | third in list dropdown |
    And In Notification Setting screen, I click in <addBtn>
    Then In Notification Setting screen, Table in the right have Employee Name selected added
    And In Notification Setting screen, System show message <successSave>
    And In Notification Setting screen, I delete all in table notification, show message <deleteSuccess>

 #    try add again after delete
    When In Notification Setting screen, I click in <addBtn>
    Then In Notification Setting screen, Table in the right have Employee Name selected added
    And In Notification Setting screen, System show message <successSave>
    And In Notification Setting screen, I delete all in table notification, show message <deleteSuccess>
    And I logout from system
    Examples:
      | notificationMenu     | parentMenuText | number   | string   | lang | addBtn | successSave       | deleteSuccess       |
      | Notification Setting | Notification   | 13000002 | triarrow | en   | Add    | Save successfully | Delete successfully |
  Scenario Outline: 7. Open Notification Setting, select one branch, all position, one employee name and add
    When I open Login page
    And I input my credentials username <number> and password <string>
    And I change language to <lang>
    And I open submenu <notificationMenu> of parent menu <parentMenuText>
    Then The system should open '<parentMenuText>' page
    And In Notification Setting screen, i select more dropdown with value below
      | valueBranch | valuePosition | valueEmpName           |
      | 東北          | All position  | third in list dropdown |
    And In Notification Setting screen, I click in <addBtn>
    Then In Notification Setting screen, Table in the right have Employee Name selected added
    And In Notification Setting screen, System show message <successSave>
    And In Notification Setting screen, I delete all in table notification, show message <deleteSuccess>

   #    try add again after delete
    When In Notification Setting screen, I click in <addBtn>
    Then In Notification Setting screen, Table in the right have Employee Name selected added
    And In Notification Setting screen, System show message <successSave>

    When In Notification Setting screen, I click in <addBtn>
    Then In Notification Setting screen, System show message <existedEmpMessage>
    And In Notification Setting screen, I delete all in table notification, show message <deleteSuccess>
    And I logout from system

    Examples:
      | notificationMenu     | parentMenuText | number   | string   | lang | addBtn | successSave       | deleteSuccess       | existedEmpMessage |
      | Notification Setting | Notification   | 13000002 | triarrow | en   | Add    | Save successfully | Delete successfully | Employee existed  |


  Scenario Outline: 8. Open Notification Setting, select one branch, all position, all employee name and add
    When I open Login page
    And I input my credentials username <number> and password <string>
    And I change language to <lang>
    And I open submenu <notificationMenu> of parent menu <parentMenuText>
    Then The system should open '<parentMenuText>' page

    When In Notification Setting screen, I delete all in table notification, show message <deleteSuccess>
    And In Notification Setting screen, i select more dropdown with value below
      | valueBranch | valuePosition | valueEmpName |
      | random      | All position  | All employee |
    And In Notification Setting screen, I click in <addBtn>
    Then In Notification Setting screen, System show message <successSave>
    And In Notification Setting screen, Table in the right have all employee in Employee Name added

    And In Notification Setting screen, I delete random in table notification, show message <deleteSuccess>

      #try add all again after delete
    When In Notification Setting screen, I click in <addBtn>
    And In Notification Setting screen, System show message <successSave>
    Then In Notification Setting screen, Table in the right have all employee in Employee Name added
    And I logout from system


    Examples:
      | notificationMenu     | parentMenuText | number  | string | lang | addBtn | successSave       | deleteSuccess       |
      | Notification Setting | Notification   | 4009912 | 123456 | en   | Add    | Save successfully | Delete successfully |

  Scenario Outline: 9. Open Notification Setting,check button Add with other conditions select dropdown
    When I open Login page
    And I input my credentials username <number> and password <string>
    And I change language to <lang>
    And I open submenu <notificationMenu> of parent menu <parentMenuText>
    Then The system should open '<parentMenuText>' page
    And In Notification Setting screen, i select more dropdown with value below
      | valueBranch | valuePosition | valueEmpName |
      | 東北          |               |              |
    Then In Notification Setting screen, System show list button can not use
      | Add |

    When In Notification Setting screen, i select more dropdown with value below
      | valueBranch | valuePosition           | valueEmpName |
      | 名古屋         | second in list dropdown |              |
    Then In Notification Setting screen, System show list button can not use
      | Add |

    When In Notification Setting screen, i select more dropdown with value below
      | valueBranch            | valuePosition          | valueEmpName |
      | first in list dropdown | first in list dropdown | All employee |
    Then In Notification Setting screen, System show list button can use
      | Add |
    And I logout from system

    Examples:
      | notificationMenu     | parentMenuText | number   | string   | lang |
      | Notification Setting | Notification   | 13000002 | triarrow | en   |
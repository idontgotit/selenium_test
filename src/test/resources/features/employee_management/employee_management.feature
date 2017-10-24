@version:3.1.5
@version:Sprint-1.1
@issue:
Feature: Employee Management display
  As an user
  I want to be able use Employee Management

  @LoggedIn
  Scenario Outline: 1. Open Employee Management and verify when start
    When I open submenu <employeeMenu> of parent menu <parentMenuText>
    Then The system should open '<pageTitle>' page
    And In Employee Management screen, System show list button can use
      | Add           |
      | Toggle Column |
    And In Employee Management screen, System show list button can not use
      | Edit                  |
      | Toggle Working Status |
    And In Employee Management screen, The system should show table Employee
    And In Employee Management screen, Table have <numberClm> columns not hidden

    Examples:
      | employeeMenu        | pageTitle           | parentMenuText | numberClm |
      | Employee Management | Employee Management | Common         | 8         |


  @LoggedIn
  Scenario Outline: 2. Open Employee Management verify check toggle column show hidden column
    When I open submenu <employeeMenu> of parent menu <parentMenuText>
    And In Employee Management screen, I click button with name <toggleBtn>
    And In Employee Management screen, I toggle all column
      | Hire Date |
      | Telephone |
      | Mobile    |
    And In Employee Management screen, I click button with name <toggleBtn>
    Then In Employee Management screen, Table have <numberClm> columns

    Examples:
      | employeeMenu        | parentMenuText | toggleBtn     | numberClm |
      | Employee Management | Common         | Toggle Column | 11        |

  @LoggedIn
  Scenario Outline: 3. Open Employee Management and filter Employee input
    When I open submenu <employeeMenu> of parent menu <parentMenuText>
    And In Employee Management screen, I type <textFilter> in <column> column filter
    Then In Employee Management screen, Table show result in column <column> have <textFilter>
    Examples:
      | employeeMenu        | parentMenuText | column        | textFilter |
      | Employee Management | Common         | Employee Code | 1000       |
      | Employee Management | Common         | Employee Name | シ          |
      | Employee Management | Common         | Email         | tri-arrow  |


  @LoggedIn
  Scenario Outline: 4. Open Employee Management and filter Employee select box
    When I open submenu <employeeMenu> of parent menu <parentMenuText>
    And In Employee Management screen, I choose <textFilter> in <column> column filter
    Then In Employee Management screen, Table show result in column <column> have <textFilter>
    Examples:
      | employeeMenu        | parentMenuText | column      | textFilter |
      | Employee Management | Common         | Head Office | 東京         |
      | Employee Management | Common         | Privilege   | 管理職        |
#      | Employee Management | Common         | Authority   | 拠点         |


  @LoggedIn
  Scenario Outline: 5. Open Employee Management and sort all column
    When I open submenu <employeeMenu> of parent menu <parentMenuText>
    And In Employee Management screen, I sort <empCode> column by <ascending>
    Then In Employee Management screen, Table show result in <empCode> is <ascending>
    When In Employee Management screen, I sort <empCode> column by <descending>
    Then In Employee Management screen, Table show result in <empCode> is <descending>

    When In Employee Management screen, I sort <employeeName> column by <ascending>
    Then In Employee Management screen, Table show result in <employeeName> is <ascending>
    When In Employee Management screen, I sort <employeeName> column by <descending>
    Then In Employee Management screen, Table show result in <employeeName> is <descending>

    When In Employee Management screen, I sort <headOffice> column by <ascending>
    Then In Employee Management screen, Table show result in <headOffice> is <ascending>
    When In Employee Management screen, I sort <headOffice> column by <descending>
    Then In Employee Management screen, Table show result in <headOffice> is <descending>

    When In Employee Management screen, I sort <pos> column by <ascending>
    Then In Employee Management screen, Table show result in <pos> is <ascending>
    When In Employee Management screen, I sort <pos> column by <descending>
    Then In Employee Management screen, Table show result in <pos> is <descending>


    When In Employee Management screen, I sort <email> column by <ascending>
    Then In Employee Management screen, Table show result in <email> is <ascending>
    When In Employee Management screen, I sort <email> column by <descending>
    Then In Employee Management screen, Table show result in <email> is <descending>

    Examples:
      | employeeMenu        | parentMenuText | empCode       | ascending | descending | employeeName  | headOffice  | pos       | email |
      | Employee Management | Common         | Employee Code | ASC       | DESC       | Employee Name | Head Office | Privilege | Email |


  @LoggedIn
  Scenario Outline: 6. Open Employee Management and verify paging
    When I open submenu <employeeMenu> of parent menu <parentMenuText>
    Then In Employee Management screen, Table show result with <numberPaging> results in page

    When In Employee Management screen, I click page <pageNumber1>
    Then In Employee Management screen, Table show result with <numberPaging> results in page

    When In Employee Management screen, I click page <pageNumber2>
    Then In Employee Management screen, Table show result with <numberPaging> results in page
    Examples:
      | employeeMenu        | parentMenuText | numberPaging | pageNumber2 | pageNumber1 |
      | Employee Management | Common         | 20           | 2           | 1           |


  @LoggedIn
  Scenario Outline: 7. Open Employee Management and use toggle working
    When I open submenu <employeeMenu> of parent menu <parentMenuText>
    And In Employee Management screen, I click in number <firstRecord> record can click
    And In Employee Management screen, I click button with name <toggleWorkingStatusBtn>
    Then In Employee Management screen, System show message <successChangeStatus>


    When In Employee Management screen, I click in number <secondRecord> record can click
    And In Employee Management screen, I click button with name <toggleWorkingStatusBtn>
    Then In Employee Management screen, System show message <successChangeStatus>

    When In Employee Management screen, I click in number <firstRecord> record can click
    And In Employee Management screen, I click button with name <toggleWorkingStatusBtn>
    Then In Employee Management screen, System show message <successChangeStatus>

    Examples:
      | employeeMenu        | parentMenuText | firstRecord | secondRecord | toggleWorkingStatusBtn | successChangeStatus        |
      | Employee Management | Common         | 1           | 5            | Toggle Working Status  | Change Status Successfully |

  @LoggedIn
  Scenario Outline: 8. Open Employee Management and add  not success
    When I open submenu <employeeMenu> of parent menu <parentMenuText>
    And In Employee Management screen, I click button with name <addBtn>
    And In Employee Management screen, I click button with name <saveBtn>
    Then In Employee Management screen, System show message <validateRequiredMess>

    Examples:
      | employeeMenu        | parentMenuText | addBtn | saveBtn | validateRequiredMess |
      | Employee Management | Common         | Add    | Save    | Value is required    |

  @LoggedIn
  Scenario Outline: 9. Open Employee Management and edit
    When I open submenu <employeeMenu> of parent menu <parentMenuText>
    And In Employee Management screen, I click in number <firstRecord> record can click
    And In Employee Management screen, I click in number <secondRecord> record can click
    Then In Employee Management screen, System show button can not use <editBtn>

    When In Employee Management screen, I click in number <secondRecord> record can click
    And In Employee Management screen, I click button with name <editBtn>
    And In Employee Management screen, I click button with name <saveBtn>
    Then In Employee Management screen, System show message <successSave>

    Examples:
      | employeeMenu        | parentMenuText | editBtn | firstRecord | secondRecord | saveBtn | successSave       |
      | Employee Management | Common         | Edit    | 1           | 2            | Save    | Save successfully |

  @LoggedIn
  Scenario Outline: 10. Open Employee Management and add new
    When I open submenu <employeeMenu> of parent menu <parentMenuText>
    And In Employee Management screen, I click button with name <addBtn>
    And In Employee Management screen, I click button with name <saveBtn>
    Then In Employee Management screen, System show message <validateFailMes>

    When I open submenu <employeeMenu> of parent menu <parentMenuText>
    And In Employee Management screen, I click button with name <addBtn>
    And In Employee Management screen, I fill all data as below with employee name auto generate
      | hireDate   | status  | baseLocation | privilege | email                |
      | 2016/07/01 | Working | 東京           | 管理職       | ngocpt@arrow-tech.vn |
    And In Employee Management screen, I click button with name <saveBtn>
    Then In Employee Management screen, System show message <successSave>

    Examples:
      | employeeMenu        | parentMenuText | addBtn | saveBtn | validateFailMes   | successSave       |
      | Employee Management | Common         | Add    | Save    | Value is required | Save successfully |


  @LoggedIn
  Scenario Outline: 11. Open Employee Management and edit
    When I open submenu <employeeMenu> of parent menu <parentMenuText>
    And In Employee Management screen, I select record create in scenario before
    And In Employee Management screen, I click button with name <editBtn>
    And In Employee Management screen, I fill all data as below with employee name auto generate
      | tel          | mobile        |
      | 03-1234-5678 | 090-1234-5678 |
    And In Employee Management screen, I click button with name <saveBtn>
    Then In Employee Management screen, System show message <validateFailMess>

    And In Employee Management screen, I fill all data as below with employee name auto generate
      | hireDate   | status  | baseLocation | privilege | email                |
      | 2016/07/01 | Working | 東京           | 管理職       | ngocpt@arrow-tech.vn |
    And In Employee Management screen, I click button with name <saveBtn>
    Then In Employee Management screen, System show message <successSave>
    Examples:
      | employeeMenu        | parentMenuText | editBtn | saveBtn | successSave       | validateFailMess  |
      | Employee Management | Common         | Edit    | Save    | Save successfully | Value is required |


  @LoggedIn
  Scenario Outline: 12. Open Employee Management and delete with user full permission
    When I open submenu <employeeMenu> of parent menu <parentMenuText>
    And In Employee Management screen, I select record create in scenario before
    And In Employee Management screen, I click button with name <editBtn>
    And In Employee Management screen, I click button with name <deleteBtn>
    And In Employee Management screen, I confirm delete
    Then In Employee Management screen, The system should show table Employee
    And In Employee Management screen, System show message <successDelete>

    Examples:
      | employeeMenu        | parentMenuText | deleteBtn | successDelete       | editBtn |
      | Employee Management | Common         | Delete    | Delete successfully | Edit    |

  @LoggedIn
  Scenario Outline: 13. Open Employee Management and edit and back
    When I open submenu <employeeMenu> of parent menu <parentMenuText>
    And In Employee Management screen, I click in number <firstRecord> record can click
    And In Employee Management screen, I click button with name <editBtn>
    And In Employee Management screen, I fill all data as below with employee name auto generate
      | hireDate   | status  | baseLocation | privilege | email                | tel          | mobile        |
      | 2016/05/01 | Working | 東京           | 管理職       | ngocpt@arrow-tech.vn | 03-1234-5678 | 090-1234-5678 |
    And In Employee Management screen, I click back button
    Then In Employee Management screen, The system should show table Employee

    Examples:
      | employeeMenu        | parentMenuText | editBtn | firstRecord |
      | Employee Management | Common         | Edit    | 1           |


  @LoggedIn
  Scenario Outline: 14. Open Employee Management and add
    When I open submenu <employeeMenu> of parent menu <parentMenuText>
    And In Employee Management screen, I click button with name <addBtn>
    And In Employee Management screen, I fill all data as below with employee name auto generate
      | hireDate   | status  | baseLocation | privilege | email                | tel          | mobile        |
      | 2016/05/01 | Working | 東京           | 管理職       | ngocpt@arrow-tech.vn | 03-1234-5678 | 090-1234-5678 |
    And In Employee Management screen, I click button with name <saveBtn>
    Then In Employee Management screen, System show message <successSave>

    Examples:
      | employeeMenu        | parentMenuText | addBtn | saveBtn | successSave       |
      | Employee Management | Common         | Add    | Save    | Save successfully |


  @LoggedIn
  Scenario Outline: 15. Open Employee Management and delete with user full permission
    When I open submenu <employeeMenu> of parent menu <parentMenuText>
    And In Employee Management screen, I select record create in scenario before
    And In Employee Management screen, I click button with name <editBtn>
    And In Employee Management screen, I click button with name <deleteBtn>
    And In Employee Management screen, I confirm delete
    Then In Employee Management screen, The system should show table Employee
    And In Employee Management screen, System show message <successDelete>

    Examples:
      | employeeMenu        | parentMenuText | deleteBtn | successDelete       | editBtn |
      | Employee Management | Common         | Delete    | Delete successfully | Edit    |


  @LoggedIn
  Scenario Outline: 16. Open Employee Management and add and back
    When I open submenu <employeeMenu> of parent menu <parentMenuText>
    And In Employee Management screen, I click button with name <addBtn>
    And In Employee Management screen, I fill all data as below with employee name auto generate
      | hireDate   | status  | baseLocation | privilege | email                | tel          | mobile        |
      | 2016/05/01 | Working | 東京           | 管理職       | ngocpt@arrow-tech.vn | 03-1234-5678 | 090-1234-5678 |
    And In Employee Management screen, I click back button
    Then In Employee Management screen, The system should show table Employee

    Examples:
      | employeeMenu        | parentMenuText | addBtn |
      | Employee Management | Common         | Add    |

  @LoggedIn
  Scenario Outline: 17. Open Employee Management verify screen when add new employee and click button reset
    When I open submenu <employeeMenu> of parent menu <parentMenuText>
    And In Employee Management screen, I click button with name <addBtn>
    And In Employee Management screen, I fill all data as below with employee name auto generate
      | hireDate   | status  | baseLocation | privilege | email                | tel          | mobile        |
      | 2016/06/09 | Working | 東京           | 管理職       | ngocpt@arrow-tech.vn | 03-1234-5678 | 090-1234-5678 |
    And In Employee Management screen, I click button with name <resetBtn>
    Then In Employee Management screen, The system should show all field is old value

    Examples:
      | employeeMenu        | parentMenuText | addBtn | resetBtn |
      | Employee Management | Common         | Add    | Reset    |


  @LoggedIn
  Scenario Outline: 18. Open Employee Management verify screen when edit new employee and click button reset
    When I open submenu <employeeMenu> of parent menu <parentMenuText>
    And In Employee Management screen, I click in number <firstRecord> record can click
    And In Employee Management screen, I click button with name <editBtn>
    And In Employee Management screen, I fill all data as below with employee name auto generate
      | hireDate   | status  | baseLocation | privilege | email                | tel          | mobile        |
      | 2016/08/08 | Working | 東京           | 管理職       | ngocpt@arrow-tech.vn | 03-1234-5678 | 090-1234-5678 |
    And In Employee Management screen, I click button with name <resetBtn>
    Then In Employee Management screen, The system should show all field is old value

    Examples:
      | employeeMenu        | parentMenuText | firstRecord | resetBtn | editBtn | resetBtn |
      | Employee Management | Common         | 1           | Reset    | Edit    | Reset    |


  @LoggedIn
  Scenario Outline: 19. Open Employee Management and verify paging last, first, next, previous
    When I open submenu <employeeMenu> of parent menu <parentMenuText>
    And In Employee Management screen, I click button <nextPage> page on paging
    Then In Employee Management screen, Table should show <nextPage> page

    When In Employee Management screen, I click button <lastPage> page on paging
    Then In Employee Management screen, Table should show <lastPage> page

    When In Employee Management screen, I click button <previousPage> page on paging
    Then In Employee Management screen, Table should show <previousPage> page

    When In Employee Management screen, I click button <firstPage> page on paging
    Then In Employee Management screen, Table should show <firstPage> page

    Examples:
      | employeeMenu        | parentMenuText | nextPage | lastPage | previousPage | firstPage |
      | Employee Management | Common         | next     | last     | previous     | first     |

  @LoggedIn
  Scenario Outline: 20. Open Employee Management and verify when select 1 record, change page and back
    When I open submenu <employeeMenu> of parent menu <parentMenuText>
    And In Employee Management screen, I click in number <firstRecord> record can click
    And In Employee Management screen, I click page <pageNumber>
    And In Employee Management screen, I click page <pageNumber1>
    Then In Employee Management screen, Table should show <firstRecord> is selected

    Examples:
      | employeeMenu        | parentMenuText | firstRecord | pageNumber | pageNumber1 |
      | Employee Management | Common         | 1           | 2          | 1           |

  @LoggedIn
  Scenario Outline: 21. Open Employee Management and verify when select 1 record, change page and back
    When I open submenu <employeeMenu> of parent menu <parentMenuText>
    And In Employee Management screen, I click button with name <addBtn>
    Then In Employee Management screen, Verify input field <empName> with max length <empMaxLength>
    And  In Employee Management screen, Verify input field <email> with max length <emailMaxLength>
    And In Employee Management screen, Verify input field <mobile> with max length <mobileMaxLength>
    And In Employee Management screen, Verify input field <tel> with max length <telMaxLength>

    Examples:
      | employeeMenu        | parentMenuText | addBtn | empName       | empMaxLength | email | emailMaxLength | tel  | telMaxLength | mobile | mobileMaxLength |
      | Employee Management | Common         | Add    | Employee Name | 32           | Email | 32             | Tel. | 13           | Mobile | 13              |
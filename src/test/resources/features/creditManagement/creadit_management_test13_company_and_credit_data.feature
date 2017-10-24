@version:3.1.5
@version:Sprint-1.1
@issue:
Feature: Credit management test 1-3
  As a user
  I want use Credit management


  @LoggedIn
  Scenario Outline: 1. Search customer by id , not mapping sansan with credit data
    When I open submenu <submenuText> of menu <menuText>
    And I fill value <validIdNameCard> for input id name card
    And I click search button in Credit management
    And The system should show table result with records
    And I click checkbox left of a row <rowIndex> into table result
    And In accounting screen, I click button select
    Then The system should show customer details screen
    And In Credit Management page, Table Credit History no record
    And In Credit Management page, System show list button can use
      | New report |
      | Back       |
    And In Credit Management page, fields required can input
      | Customer code (index) |
      | Company name          |
      | Company name in Kana  |
    And In Credit Management page, fields can select
      | Client code status |
    And In Credit Management page, fields not required can input
      | Year of starting business      |
      | Year of official establishment |
    And In Credit Management page, I click button <btnBack>

    Examples:
      | submenuText       | menuText   | validIdNameCard                  | rowIndex | btnBack |
      | Credit Management | Accounting | A28088961BA2D90F3C3C3CBBEC55BC4D | 0        | Back    |


  Scenario Outline: 2. Search customer by customer code , mapping sansan with credit data and Credit Investigation
    When I open Login page
    And I input my credentials username <number> and password <string>
    And I change language to <lang>
    When I open submenu <submenuText> of menu <menuText>
    And  I search customer by code <validCustomerCode>
    And I click checkbox left of a row <rowIndex> into table result
    And In accounting screen, I click button select
    Then The system should show customer details screen
    And In Credit Management page, System show list button can not use
      | New report |
    And In Credit Management page, fields required can not input
      | Customer code (index) |
      | Company name          |
      | Company name in Kana  |
    And In Credit Management page, fields can not select
      | Client code status |
    And In Credit Management page, fields not required can not input
      | Year of starting business      |
      | Year of official establishment |
    And I logout from system
    Examples:
      | submenuText       | menuText   | validCustomerCode | rowIndex | number  | string | lang |
      | Credit Management | Accounting | A567              | 0        | 4009906 | 123456 | en   |


  Scenario Outline: 3. Search customer by code , mapping sansan with credit data but not have Credit Investigation
    When I open Login page
    And I input my credentials username <number> and password <string>
    And I change language to <lang>
    When I open submenu <submenuText> of menu <menuText>
    And  I search customer by code <validCustomerCode>
    And The system should show table result with records
    And I click checkbox left of a row <rowIndex> into table result
    And In accounting screen, I click button select
    And In Credit Management page, Table Credit History no record
    And In Credit Management page, I click button <newRpBtn>
    And In Credit Management page, I select in <surveySelect> is <valueSurvey>
    And In Credit Management page, I select date in <indexSelect> is <valueIndex>
    And In Credit Management page, I type in <indexAccounting> is <valueIndexAccounting>
    And In Credit Management page, I select in <tradingCondition> is <valueTrading>
    And In Credit Management page, I click button <btnSaveDraft>
    And In Credit Management page, System show message <successSave>
    And In Credit Management page, I click record <rowIndexCreditHistory> in table Credit History in bottom
    And In Credit Management page, I click button <btnEdit>
    And In Credit Management page, I click button <btnReject>
    And In Credit Management page, I confirm action
    And In Credit Management page, System show message <successReject>
    Then In Credit Management page, Table Credit History no record
    And In Credit Management page, System show list button can use
      | New report |
      | Back       |
    And In Credit Management page, System show list button can not use
      | Edit      |
      | View      |
      | Duplicate |
    And In Credit Management page, fields required can input
      | Customer code (index) |
      | Company name          |
      | Company name in Kana  |
    And In Credit Management page, fields can select
      | Client code status |
    And In Credit Management page, fields not required can input
      | Year of starting business      |
      | Year of official establishment |
    And In Credit Management page, I click button <btnBack>
    And I logout from system
    Examples:
      | submenuText       | menuText   | validCustomerCode | rowIndex | newRpBtn   | surveySelect                            | indexSelect    | indexAccounting             | valueSurvey | valueIndex | valueIndexAccounting | btnSaveDraft | rowIndexCreditHistory | btnEdit | btnReject | btnBack | successSave       | successReject     | tradingCondition           | valueTrading | number  | string | lang |
      | Credit Management | Accounting | a555              | 0        | New report | Survey institute and information source | Date of survey | Index for accounting system | 帝国データ       | 2016/10/18 | 12                   | Save draft   | 0                     | Edit    | Reject    | Back    | Save successfully | Reject successful | Trading condition category | 通常取引         | 4009912 | 123456 | en   |

  @LoggedIn
  Scenario Outline: 4. Verify screen View->Duplicate is same
    When I open submenu <submenuText> of menu <menuText>
    And  I search customer by code <validCustomerCode>
    And I click checkbox left of a row <rowIndex> into table result
    And In accounting screen, I click button select
    And In Credit Management page, I click record <rowIndex2CreditHistory> in table Credit History in bottom with View enable
    And In Credit Management page, I click button <btnView>
    And In Credit Management page, I save data in this page
    And In Credit Management page, I click button <btnDuplicate>
    Then In Credit Management page, page Duplicate is same page View
    And In Credit Management page, I click button <btnBack>

    Examples:
      | submenuText       | menuText   | validCustomerCode | rowIndex | btnBack | rowIndex2CreditHistory | btnView | btnDuplicate |
      | Credit Management | Accounting | A567              | 0        | Back    | 0                      | View    | Duplicate    |

  @LoggedIn
  Scenario Outline: 5. Select record -> duplicate start screen
    When I open submenu <submenuText> of menu <menuText>
    And  I search customer by code <validCustomerCode>
    And I click checkbox left of a row <rowIndex> into table result
    And In accounting screen, I click button select
    And In Credit Management page, I click record <rowIndex2CreditHistory> in table Credit History in bottom with View enable
    And In Credit Management page, I click button <btnDuplicate>

    Then In Credit Management page, System show list button can use
      | Back               |
      | Save draft         |
      | Reset              |
      | Choose file upload |
    And In Credit Management page, System show list button can not use
      | Upload |
      | Cancel |
    And In Credit Management page, fields required can input
      | Index for accounting system |
      | Credit score number         |
    And In Credit Management page, textarea can input
      | Cause of decision    |
      | Additional direction |
      | Accountant direction |

    When In Credit Management page, I select tab have name is <tabBusiness>
    Then In Credit Management page, System show list button can use
      | Back               |
      | Save draft         |
      | Reset              |
      | Choose file upload |
    And In Credit Management page, fields required can input
      | Index for accounting system |
      | Zip code of HQ              |
      | Address of HQ (all)         |
      | Tel.                        |
    And In Credit Management page, fields can select
      | Fiscal closing month |
    And In Credit Management page, fields not required can input
      | Company index of research institute |
      | Fax.                                |
      | Number of employees                 |
      | Capital fund                        |
      | Url                                 |
    When In Credit Management page, I select tab have name is <tabIndustryClassification>
    And In Credit Management page, fields not required can input
      | Rank of the same sector (Nation wide)         |
      | Population of the same industry (Nation wide) |
      | Rank of the same sector (Prefecture)          |
      | Population of the same industry (Prefecture)  |

    When In Credit Management page, I select tab have name is <tabInputFinance>
    Then In Credit Management page, System show list button can use
      | Back       |
      | Save draft |
      | Reset      |
      | Add new    |
    And In Credit Management page, System show list button can not use
      | Edit   |
      | Delete |

    When In Credit Management page, I select tab have name is <tabInputCustomer>
    Then In Credit Management page, System show list button can use
      | Back       |
      | Save draft |
      | Reset      |
    And In Credit Management page, System show list button can not use
      | Edit   |
      | Delete |
      | Cancel |
    And In Credit Management page, autocomplete fields can input
      | Branch of request user |
      | Request user account   |
    And In Credit Management page, fields can select
      | Survey institute and information source |
    And In Credit Management page, fields required can input
      | Index for accounting system |
    And In Credit Management page, tab Input customer data textarea can input
    And In Credit Management page, I click button <btnBack>

    Examples:
      | submenuText       | menuText   | validCustomerCode | rowIndex | btnBack | rowIndex2CreditHistory | tabBusiness      | btnDuplicate | tabIndustryClassification | tabInputFinance    | tabInputCustomer    |
      | Credit Management | Accounting | A567              | 0        | Back    | 0                      | Business factors | Duplicate    | Industry classification   | Input finance data | Input customer data |


  @LoggedIn
  Scenario Outline: 6. Select record -> duplicate -> back
    When I open submenu <submenuText> of menu <menuText>
    And  I search customer by code <validCustomerCode>
    And I click checkbox left of a row <rowIndex> into table result
    And In accounting screen, I click button select
    And In Credit Management page, I click record <rowIndex2CreditHistory> in table Credit History in bottom with View enable
    And In Credit Management page, I memory data in table
    And In Credit Management page, I click button <btnDuplicate>
    And In Credit Management page, I click button <btnBack>
    Then In Credit Management page, System show list button can use
      | Back       |
      | New report |
      | View       |
      | Duplicate  |
    Then In Credit Management page, System show list button can not use
      | Edit |
    And In Credit Management page, fields required can not input
      | Customer code (index) |
      | Company name          |
      | Company name in Kana  |
    And In Credit Management page, fields can not select
      | Client code status |
    And In Credit Management page, fields not required can not input
      | Year of starting business      |
      | Year of official establishment |
    And In Credit Management page, data in table when back is same before

    Examples:
      | submenuText       | menuText   | validCustomerCode | rowIndex | btnBack | rowIndex2CreditHistory | btnDuplicate |
      | Credit Management | Accounting | A567              | 0        | Back    | 0                      | Duplicate    |
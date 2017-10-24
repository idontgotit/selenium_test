@version:3.1.5
@version:Sprint-1.1
@issue:
Feature: Credit management add and edit
  As a user
  I want use Credit management

  @LoggedIn
  Scenario Outline: 11. Verify tab input customer data
    And I open submenu <submenuText> of menu <menuText>
    And  I search customer by code <validCustomerCode>
    And I click checkbox left of a row <rowIndex> into table result
    And In accounting screen, I click button select
    And In Credit Management page, I click button <btnNewReport>
    And In Credit Management page, I select tab have name is <tabInputCustomer>
    And In Credit Management page, I type <textInput> in Input related company and choose type is <typeInput>
    And In Credit Management page, System show list button can use
      | Generate in input customer data |
    Then In Credit Management page, System show list button can not use
      | Edit in input customer data   |
      | Delete in input customer data |
    And In Credit Management page, I click button <btnGenerate>
    Then In Credit Management page, Table have data like <textInput> and <typeInput>
    And In Credit Management page, I click record <index> in table Input Customer Data
    Then In Credit Management page, System show list button can not use
      | Generate in input customer data |
    Then In Credit Management page, System show list button can use
      | Edit in input customer data   |
      | Delete in input customer data |
    When In Credit Management page, I click record <index> in table Input Customer Data
    Then In Credit Management page, System show list button can not use
      | Edit in input customer data     |
      | Delete in input customer data   |
      | Generate in input customer data |
    When In Credit Management page, I click record <index> in table Input Customer Data
    And In Credit Management page, I click button <btnEditInputCustomerData>
    Then In Credit Management page, in table Input Customer Data have data is <emptyData> record
    And In Credit Management page, in Input related company have <textInput> and choose type is <typeInput>

    When In Credit Management page, I type <textInput> in Input related company and choose type is <typeInput>
    And In Credit Management page, I click button <btnGenerate>
    And In Credit Management page, I type <textInput> in Input related company and choose type is <typeInput>
    And In Credit Management page, I click button <btnGenerate>
    Then In Credit Management page, System show message <duplicateMessage>: <textInput>

    When In Credit Management page, I click record <index> in table Input Customer Data
    And In Credit Management page, I click button <btnDeleteInputCustomerData>
    And In Credit Management page, I confirm action
    Then In Credit Management page, System show message <deleteSuccess>
    Then In Credit Management page, in table Input Customer Data have data is <lessThan1> record

    When In Credit Management page, I type <textInput> in Input related company and choose type is <typeInput>
    And In Credit Management page, I click button <btnGenerate>
    Then In Credit Management page, Table have data like <textInput> and <typeInput>
    And In Credit Management page, I select tab have name is <tabInputCustomer>
    And In Credit Management page, I select tab have name is <tabBussi>
    And In Credit Management page, I click button <btnBack>

    Examples:
      | submenuText       | menuText   | validCustomerCode | rowIndex | textInput   | typeInput | btnGenerate                     | index | btnNewReport | btnBack | btnEditInputCustomerData    | emptyData | btnDeleteInputCustomerData    | deleteSuccess            | lessThan1   | tabInputCustomer    | duplicateMessage                | tabBussi         |
      | Credit Management | Accounting | a567              | 0        | name1,name2 | Provider  | Generate in input customer data | 0     | New report   | Back    | Edit in input customer data | 0         | Delete in input customer data | Delete data successfully | less Than 1 | Input customer data | There are some duplicated items | Business factors |


  Scenario Outline: 12. Select record draft -> approve
    When I open Login page
    And I input my credentials username <number> and password <string>
    And I change language to <lang>
    And I open submenu <submenuText> of menu <menuText>
    And  I search customer by code <validCustomerCode>
    And I click checkbox left of a row <rowIndex> into table result
    And In accounting screen, I click button select
    And In Credit Management page, I click record <rowIndex> in table Credit History in bottom with View enable
    And In Credit Management page, I click button <btnDuplicate>
    And In Credit Management page, I change survey date to next day of selected record
    And In Credit Management page, I click button <btnSaveDraft>
    And I open submenu <submenuText> of menu <menuText>
    And  I search customer by code <validCustomerCode>
    And I click checkbox left of a row <rowIndex> into table result
    And In accounting screen, I click button select
    And In Credit Management page, I click record <rowIndex> in table Credit History in bottom
    And In Credit Management page, I click button <btnEdit>
    And In Credit Management page, I select in <surveySelect> is <valueSurvey>
    And In Credit Management page, I change survey date to next day of selected record
    And In Credit Management page, I type in <indexAccounting> is <valueIndexAccounting>
    And In Credit Management page, I type in <creditScore> is <valueCreditScore>
    And In Credit Management page, I select in <tradingCondition> is <valueTrading>
    And In Credit Management page, textarea can input
      | Cause of decision    |
      | Additional direction |
      | Accountant direction |
    And In Credit Management page, I select tab have name is <tabBussi>
    And In Credit Management page, I type in <zipCode> is <valueZipCode>
    And In Credit Management page, I type in <address> is <valueZipCode>
    And In Credit Management page, I type in <tel> is <valueTel>
    And In Credit Management page, I select in <fiscal> is <valueFiscal>
    And In Credit Management page, fields not required can input
      | Company index of research institute |
      | Fax.                                |
      | Number of employees                 |
      | Capital fund                        |
      | Url                                 |
    And In Credit Management page, I select tab have name is <tabIndustry>
    And In Credit Management page, fields required can input
      | Industry category code (main)       |
      | Industry category code (subsidiary) |
    And In Credit Management page, fields not required can input
      | Rank of the same sector (Nation wide)         |
      | Population of the same industry (Nation wide) |
      | Rank of the same sector (Prefecture)          |
      | Population of the same industry (Prefecture)  |
    And In Credit Management page, I select tab have name is <tabInputCustomer>
    And In Credit Management page, I type <textInput> in Input related company and choose type is <typeInput>
    And In Credit Management page, I click button <btnGenerate>
    And In Credit Management page, I click button <btnApprove>
    And In Credit Management page, I confirm action
    Then In Credit Management page, System show message <successSave>
    And I logout from system

    Examples:
      | submenuText       | menuText   | validCustomerCode | rowIndex | surveySelect                            | indexAccounting             | valueSurvey | valueIndexAccounting | btnEdit | creditScore         | valueCreditScore | tradingCondition           | valueTrading | zipCode        | valueZipCode | address             | tel  | valueTel     | fiscal               | valueFiscal | tabBussi         | btnApprove | successSave       | btnDuplicate | btnSaveDraft | tabIndustry             | btnGenerate                     | tabInputCustomer    | textInput   | typeInput | number  | string | lang |
      | Credit Management | Accounting | a567              | 0        | Survey institute and information source | Index for accounting system | 帝国データ       | 12                   | Edit    | Credit score number | 10               | Trading condition category | 通常取引         | Zip code of HQ | 111-1111     | Address of HQ (all) | Tel. | 023-345-3212 | Fiscal closing month | 01月         | Business factors | Approve    | Save successfully | Duplicate    | Save draft   | Industry classification | Generate in input customer data | Input customer data | name1,name2 | Provider  | 4009912 | 123456 | en   |


  Scenario Outline: 13. Verify approve required data
    When I open Login page
    And I input my credentials username <number> and password <string>
    And I change language to <lang>
    And I open submenu <submenuText> of menu <menuText>
    And  I search customer by code <validCustomerCode>
    And I click checkbox left of a row <rowIndex> into table result
    And In accounting screen, I click button select
    And In Credit Management page, I click record <rowIndex> in table Credit History in bottom with View enable
    And In Credit Management page, I click button <btnNewReport>
    And In Credit Management page, I click button <btnApprove>
    And In Credit Management page, I confirm action
    Then In Credit Management page, System show first message <surveySelect> <isRequired>

    When In Credit Management page, I select in <surveySelect> is <valueSurvey>
    And In Credit Management page, I click button <btnApprove>
    And In Credit Management page, I confirm action
    Then In Credit Management page, System show first message <tradingCondition> <isRequired>

    When In Credit Management page, I select in <tradingCondition> is <valueTrading>
    And In Credit Management page, I click button <btnApprove>
    And In Credit Management page, I confirm action
    Then In Credit Management page, System show first message <dateOfSurvey> <isRequired>

    When In Credit Management page, I change survey date to next day of selected record
    And In Credit Management page, I click button <btnApprove>
    And In Credit Management page, I confirm action
    Then In Credit Management page, System show first message <indexAccounting> <isRequired>

    When In Credit Management page, I type in <indexAccounting> is <valueIndexAccounting>
    And In Credit Management page, I click button <btnApprove>
    And In Credit Management page, I confirm action
    Then In Credit Management page, System show first message <zipCode> <isRequired>

    When In Credit Management page, I type in <creditScore> is <valueCreditScore>
    And In Credit Management page, I click button <btnApprove>
    And In Credit Management page, I confirm action


    When In Credit Management page, I select tab have name is <tabBussi>
    And In Credit Management page, I type in <zipCode> is <valueZipCode>
    And In Credit Management page, I click button <btnApprove>
    And In Credit Management page, I confirm action
    Then In Credit Management page, System show first message <address> <isRequired>

    When In Credit Management page, I select tab have name is <tabBussi>
    And In Credit Management page, I type in <address> is <valueZipCode>
    And In Credit Management page, I click button <btnApprove>
    And In Credit Management page, I confirm action
    Then In Credit Management page, System show first message <tel> <isRequired>

    When In Credit Management page, I select tab have name is <tabBussi>
    And In Credit Management page, I type in <tel> is <valueTel>
    And In Credit Management page, I click button <btnApprove>
    And In Credit Management page, I confirm action
    Then In Credit Management page, System show first message <fiscal> <isRequired>

    When In Credit Management page, I select tab have name is <tabBussi>
    And In Credit Management page, I select in <fiscal> is <valueFiscal>
    And In Credit Management page, I click button <btnApprove>
    And In Credit Management page, I confirm action
    Then In Credit Management page, System show message <successSave>
    And I logout from system
    Examples:
      | submenuText       | menuText   | validCustomerCode | rowIndex | surveySelect                            | indexAccounting             | valueSurvey | valueIndexAccounting | dateOfSurvey   | creditScore         | valueCreditScore | tradingCondition           | valueTrading | zipCode        | valueZipCode | address             | tel  | valueTel     | fiscal               | valueFiscal | tabBussi         | btnApprove | successSave       | tabIndustry             | btnNewReport | isRequired  | industryMain                  | industrySub                         | number  | string | lang |
      | Credit Management | Accounting | a567              | 0        | Survey institute and information source | Index for accounting system | 帝国データ       | 12                   | Date of survey | Credit score number | 10               | Trading condition category | 通常取引         | Zip code of HQ | 111-1111     | Address of HQ (all) | Tel. | 023-345-3212 | Fiscal closing month | 01月         | Business factors | Approve    | Save successfully | Industry classification | New report   | is required | Industry category code (main) | Industry category code (subsidiary) | 4009912 | 123456 | en   |



  Scenario Outline: 14. Verify approve full data
    When I open Login page
    And I input my credentials username <number> and password <string>
    And I change language to <lang>
    And I open submenu <submenuText> of menu <menuText>
    And  I search customer by code <validCustomerCode>
    And I click checkbox left of a row <rowIndex> into table result
    And In accounting screen, I click button select
    And In Credit Management page, I click record <rowIndex> in table Credit History in bottom with View enable
    And In Credit Management page, I click button <btnNewReport>
    And In Credit Management page, I select in <surveySelect> is <valueSurvey>
    And In Credit Management page, I change survey date to next day of selected record
    And In Credit Management page, I type in <indexAccounting> is <valueIndexAccounting>
    And In Credit Management page, I type in <creditScore> is <valueCreditScore>
    And In Credit Management page, I select in <tradingCondition> is <valueTrading>
    And In Credit Management page, textarea can input
      | Cause of decision    |
      | Additional direction |
      | Accountant direction |
    And In Credit Management page, I select tab have name is <tabBussi>
    And In Credit Management page, I type in <zipCode> is <valueZipCode>
    And In Credit Management page, I type in <address> is <valueZipCode>
    And In Credit Management page, I type in <tel> is <valueTel>
    And In Credit Management page, I select in <fiscal> is <valueFiscal>
    And In Credit Management page, fields not required can input
      | Company index of research institute |
      | Fax.                                |
      | Number of employees                 |
      | Capital fund                        |
      | Url                                 |
    And In Credit Management page, I select tab have name is <tabIndustry>
    And In Credit Management page, fields required can input
      | Industry category code (main)       |
      | Industry category code (subsidiary) |
    And In Credit Management page, fields not required can input
      | Rank of the same sector (Nation wide)         |
      | Population of the same industry (Nation wide) |
      | Rank of the same sector (Prefecture)          |
      | Population of the same industry (Prefecture)  |
    And In Credit Management page, I select tab have name is <tabInputCustomer>
    And In Credit Management page, I type <textInput> in Input related company and choose type is <typeInput>
    And In Credit Management page, I click button <btnGenerate>
    And In Credit Management page, I click button <btnApprove>
    And In Credit Management page, I confirm action
    Then In Credit Management page, System show message <successSave>
    And I logout from system
    Examples:
      | submenuText       | menuText   | validCustomerCode | rowIndex | surveySelect                            | indexAccounting             | valueSurvey | valueIndexAccounting | creditScore         | valueCreditScore | tradingCondition           | valueTrading | zipCode        | valueZipCode | address             | tel  | valueTel     | fiscal               | valueFiscal | tabBussi         | btnApprove | successSave       | tabIndustry             | btnNewReport | btnApprove | tabInputCustomer    | textInput   | typeInput | btnGenerate                     | number  | string | lang |
      | Credit Management | Accounting | a567              | 0        | Survey institute and information source | Index for accounting system | 帝国データ       | 12                   | Credit score number | 10               | Trading condition category | 通常取引         | Zip code of HQ | 111-1111     | Address of HQ (all) | Tel. | 023-345-3212 | Fiscal closing month | 01月         | Business factors | Approve    | Save successfully | Industry classification | New report   | Approve    | Input customer data | name1,name2 | Provider  | Generate in input customer data | 4009912 | 123456 | en   |



@version:3.1.5
@version:Sprint-1.1
@issue:
Feature: 8-10. Maintain credit data
  As an user
  I want to be able to use Maintain credit data


  @LoggedIn
  Scenario Outline: 8. Open Maintain credit data, search by Other conditions - Unassociated, select record and link it. Find again with customer code
    When I open submenu <maintainMenu> of parent menu <parentMenuText>
    And The system should open '<pageTitle>' page
    When In Maintain credit data screen, I choose radio button have name is <otherConditions>
    And In Maintain credit data screen, I choose radio button have name is <unassociated>
    And In Maintain credit data screen, I type <validCompanyName> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, I click button <searchBtn>
    And In Maintain credit data screen, I click select checkbox row <rowSelect>
    And In Maintain credit data screen, I click button <selectBtn>
    And In Maintain credit data screen, in search Company Sansan I type <validCompanyName> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, in search Company Sansan I click button <searchBtn>
    And In Maintain credit data screen, in search Company Sansan I click one record can click
    And  In Maintain credit data screen, in search Company Sansan I memory data in Trade name of customer
    And  In Maintain credit data screen, I click button <btnSave>
    And I open submenu <maintainMenu> of parent menu <parentMenuText>
    And The system should open '<pageTitle>' page
    And In Maintain credit data screen, I retype memory data in Trade name of customer in input field have name is <fieldCustomer>
    And In Maintain credit data screen, I click button <searchBtn>
    Then In Maintain credit data screen, Table below have <only1> record
    And In Maintain credit data screen, I verify memory data in Trade name of customer in field <fieldSansanCompanyId> and <fieldCompanyName>

    #recheck , make data like before test
    When In Maintain credit data screen, I click select checkbox row <rowSelect>
    And In Maintain credit data screen, I click button <selectBtn>
    And In Maintain credit data screen, in search Company Sansan I click check box <rowSelect> in table
    Then In Maintain credit data screen, I click button <btnSave>
    Then In Maintain credit data screen, System show message <successSave>

    Examples:
      | maintainMenu         | pageTitle                          | parentMenuText | fieldCustomer | btnSave | searchBtn | selectBtn | rowSelect | only1 | fieldSansanCompanyId | fieldCompanyName | validCompanyName | unassociated | otherConditions  | successSave       |
      | Maintain Credit Data | Maintenance accounting data screen | Accounting     | Customer code | Save    | Search    | Select    | 0         | 1     | Sansan Company ID    | Company name     | N                | Unassociated | Other conditions | Save successfully |


  @LoggedIn
  Scenario Outline: 9. Open Maintain credit data, search by Other conditions - associated, change link. Find again with this customer code
    When I open submenu <maintainMenu> of parent menu <parentMenuText>
    And The system should open '<pageTitle>' page
    And In Maintain credit data screen, I choose radio button have name is <otherConditions>
    And In Maintain credit data screen, I choose radio button have name is <associated>
    And In Maintain credit data screen, I type <validCompanyName> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, I click button <searchBtn>
    And In Maintain credit data screen, I click select checkbox row <rowSelect>
    And In Maintain credit data screen, I click button <selectBtn>
    And In Maintain credit data screen, in search Company Sansan I type <validCompanyName> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, in search Company Sansan I type <emptyString> in input field have name is <fieldIdNamecard>
    And In Maintain credit data screen, in search Company Sansan I type <emptyString> in input field have name is <fieldSansanCompanyId>
    And In Maintain credit data screen, in search Company Sansan I click button <searchBtn>
    And In Maintain credit data screen, in search Company Sansan I type <validCompanyName> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, in search Company Sansan I type <emptyString> in input field have name is <fieldIdNamecard>
    And In Maintain credit data screen, in search Company Sansan I type <emptyString> in input field have name is <fieldSansanCompanyId>
    And In Maintain credit data screen, in search Company Sansan I click button <searchBtn>
    Then In Maintain credit data screen, in search Company Sansan I memory data in Trade name of customer

    When In Maintain credit data screen, in search Company Sansan I click one record can click
    And  In Maintain credit data screen, in search Company Sansan I memory data in Trade name of customer
    And  In Maintain credit data screen, I click button <btnSave>
    And I open submenu <maintainMenu> of parent menu <parentMenuText>
    And The system should open '<pageTitle>' page
    And In Maintain credit data screen, I retype memory data in Trade name of customer in input field have name is <fieldCustomer>
    And In Maintain credit data screen, I click button <searchBtn>
    Then In Maintain credit data screen, Table below have <only1> record
    And In Maintain credit data screen, I verify memory data in Trade name of customer in field <fieldSansanCompanyId> and <fieldCompanyName>

    #recheck make data like before test
    And In Maintain credit data screen, I click select checkbox row <rowSelect>
    And In Maintain credit data screen, I click button <selectBtn>
    And In Maintain credit data screen, I retype memory data in Trade name of customer in input field have name is <fieldSansanCompanyId>
    When In Maintain credit data screen, in search Company Sansan I type <emptyString> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, in search Company Sansan I type <emptyString> in input field have name is <fieldIdNamecard>
    And In Maintain credit data screen, in search Company Sansan I click button <searchBtn>
    And In Maintain credit data screen, in search Company Sansan I click check box <rowSelect> in table
    And  In Maintain credit data screen, I click button <btnSave>
    Then In Maintain credit data screen, System show message <successSave>

    Examples:
      | maintainMenu         | pageTitle                          | parentMenuText | fieldCustomer | btnSave | searchBtn | selectBtn | rowSelect | only1 | fieldIdNamecard | emptyString | fieldSansanCompanyId | fieldCompanyName | validCompanyName | associated | otherConditions  | successSave       |
      | Maintain Credit Data | Maintenance accounting data screen | Accounting     | Customer code | Save    | Search    | Select    | 0         | 1     | Id Name Card    |             | Sansan Company ID    | Company name     | N                | Associated | Other conditions | Save successfully |

  @LoggedIn
  Scenario Outline: 10. Open Maintain credit data, search by Other conditions - associated, unlink. Find again in unassociated
    When I open submenu <maintainMenu> of parent menu <parentMenuText>
    And The system should open '<pageTitle>' page
    And In Maintain credit data screen, I choose radio button have name is <otherConditions>
    And In Maintain credit data screen, I choose radio button have name is <associated>
    And In Maintain credit data screen, I type <validCompanyName> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, I click button <searchBtn>
    And In Maintain credit data screen, I click select checkbox row <rowSelect>
    And In Maintain credit data screen, I click button <selectBtn>
    And In Maintain credit data screen, in search Company Sansan I memory data in Trade name of customer
    And In Maintain credit data screen, in search Company Sansan I click check box <rowSelect> in table
    Then  In Maintain credit data screen, I click button <btnSave>


    When I open submenu <maintainMenu> of parent menu <parentMenuText>
    And The system should open '<pageTitle>' page
    When In Maintain credit data screen, I choose radio button have name is <otherConditions>
    And In Maintain credit data screen, I choose radio button have name is <unassociated>
    And In Maintain credit data screen, I retype memory data in Trade name of customer in input field have name is <fieldCompanyName>


    And In Maintain credit data screen, I click button <searchBtn>
    Then In Maintain credit data screen, Table below have record

    #recheck make data like before test
    When In Maintain credit data screen, I click select checkbox row <rowSelect>
    And In Maintain credit data screen, I click button <selectBtn>

    And In Maintain credit data screen, I retype memory data in Trade name of customer in input field have name is <fieldSansanCompanyId>
    And In Maintain credit data screen, in search Company Sansan I type <emptyString> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, in search Company Sansan I type <emptyString> in input field have name is <fieldIdNamecard>
    And In Maintain credit data screen, in search Company Sansan I click button <searchBtn>

    And In Maintain credit data screen, in search Company Sansan I click check box <rowSelect> in table
    Then  In Maintain credit data screen, I click button <btnSave>
    And In Maintain credit data screen, System show message <successSave>

    Examples:
      | maintainMenu         | pageTitle                          | parentMenuText | btnSave | searchBtn | selectBtn | rowSelect | only1 | fieldIdNamecard | emptyString | fieldSansanCompanyId | fieldCompanyName | validCompanyName | associated | otherConditions  | unassociated | successSave       |
      | Maintain Credit Data | Maintenance accounting data screen | Accounting     | Save    | Search    | Select    | 0         | 1     | Id Name Card    |             | Sansan Company ID    | Company name     | N                | Associated | Other conditions | Unassociated | Save successfully |


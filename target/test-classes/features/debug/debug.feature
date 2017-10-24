@version:3.1.5
@version:Sprint-1.1
@issue:
Feature: Run feature for debugging
  As an developer
  I want to be able to run simplified feature
  So that I can debug quickly
  Exception

  @LoggedIn
  Scenario Outline: 4. Open Maintain credit data, search by customer code, select record, unselect, change page...
    When I open submenu <maintainMenu> of parent menu <parentMenuText>
    And The system should open '<pageTitle>' page
    And In Maintain credit data screen, I type <validCustomerCode> in input field have name is <fieldCustomer>
    And In Maintain credit data screen, I click button <searchBtn>
    And In Maintain credit data screen, Table below have <only1> record
    And In Maintain credit data screen, I click select checkbox row <rowSelect>
    And In Maintain credit data screen, I click button <selectBtn>
    And In Maintain credit data screen, in search Company Sansan I type <validCompanyName> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, in search Company Sansan I type <emptyString> in input field have name is <fieldIdNamecard>
    And In Maintain credit data screen, in search Company Sansan I type <emptyString> in input field have name is <fieldSansanCompanyId>
    And In Maintain credit data screen, in search Company Sansan I click button <searchBtn>
    Then In Maintain credit data screen, in search Company Sansan Table below have <fullRecord> record

    When In Maintain credit data screen, in search Company Sansan I click one record can click
    Then In Maintain credit data screen, in search Company Sansan I verify field in Trade name of customer

    When In Maintain credit data screen, in search Company Sansan I try select this record again
    Then In Maintain credit data screen, in search Company Sansan I verify field in Trade name of customer

    When In Maintain credit data screen, in search Company Sansan I try select this record again
    And In Maintain credit data screen, in search Company Sansan table I go to <next> page
    And In Maintain credit data screen, in search Company Sansan table I go to <previous> page
    Then In Maintain credit data screen, in search Company Sansan record selected still there

    Examples:
      | maintainMenu         | pageTitle                          | parentMenuText | validCustomerCode | fieldCustomer | searchBtn | selectBtn | rowSelect | only1 | fieldIdNamecard | next | emptyString | fieldSansanCompanyId | previous | fieldCompanyName | fullRecord | validCompanyName |
      | Maintain Credit Data | Maintenance accounting data screen | Accounting     | A001              | Customer code | Search    | Select    | 0         | 1     | Id Name Card    | next |             | Sansan Company ID    | previous | Company name     | 5          | NTT              |


  @LoggedIn
  Scenario Outline: 5. Open Maintain credit data, search by Other conditions - Unassociated, select record, unselect, change page...
    When I open submenu <maintainMenu> of parent menu <parentMenuText>
    And The system should open '<pageTitle>' page
    When In Maintain credit data screen, I choose radio button have name is <otherConditions>
    And In Maintain credit data screen, I choose radio button have name is <unassociated>
    And In Maintain credit data screen, I type <validCompanyName> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, I click button <searchBtn>
    And In Maintain credit data screen, I click select checkbox row <rowSelect>
    And In Maintain credit data screen, I click button <selectBtn>
    Then In Maintain credit data screen, in search Company Sansan Table below have <empty> record
    And In Maintain credit data screen, in Trade name of customer I verify <SansanCompanyID> and <SansanCompanyName>  have value is not available

    When In Maintain credit data screen, in search Company Sansan I type <validCompanyName> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, in search Company Sansan I type <emptyString> in input field have name is <fieldIdNamecard>
    And In Maintain credit data screen, in search Company Sansan I type <emptyString> in input field have name is <fieldSansanCompanyId>
    And In Maintain credit data screen, in search Company Sansan I click button <searchBtn>
    Then In Maintain credit data screen, in search Company Sansan Table below have <fullRecord> record

    When In Maintain credit data screen, in search Company Sansan I click one record can click
    Then In Maintain credit data screen, in search Company Sansan I verify field in Trade name of customer

    When In Maintain credit data screen, in search Company Sansan I try select this record again
    Then In Maintain credit data screen, in search Company Sansan I verify field in Trade name of customer

    When In Maintain credit data screen, in search Company Sansan I try select this record again
    And In Maintain credit data screen, in search Company Sansan table I go to <next> page
    And In Maintain credit data screen, in search Company Sansan table I go to <previous> page
    Then In Maintain credit data screen, in search Company Sansan record selected still there

    Examples:
      | maintainMenu         | pageTitle                          | parentMenuText | empty | SansanCompanyID   | SansanCompanyName   | searchBtn | selectBtn | rowSelect | only1 | fieldIdNamecard | next | emptyString | fieldSansanCompanyId | previous | fieldCompanyName | fullRecord | validCompanyName | unassociated | otherConditions  |
      | Maintain Credit Data | Maintenance accounting data screen | Accounting     | 0     | Sansan Company ID | Sansan company name | Search    | Select    | 0         | 1     | Id Name Card    | next |             | Sansan Company ID    | previous | Company name     | 5          | NTT              | Unassociated | Other conditions |

  @LoggedIn
  Scenario Outline: 6. Open Maintain credit data, search by Other conditions - Associated, select record, unselect, change page...
    When I open submenu <maintainMenu> of parent menu <parentMenuText>
    And The system should open '<pageTitle>' page
    When In Maintain credit data screen, I choose radio button have name is <otherConditions>
    And In Maintain credit data screen, I choose radio button have name is <associated>
    And In Maintain credit data screen, I type <validCompanyName> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, I click button <searchBtn>
    And In Maintain credit data screen, I click select checkbox row <rowSelect>
    And In Maintain credit data screen, I click button <selectBtn>
    Then In Maintain credit data screen, in search Company Sansan Table below have <only1> record
    And In Maintain credit data screen, in search Company Sansan I verify field in Trade name of customer

    When In Maintain credit data screen, in search Company Sansan I type <validCompanyName> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, in search Company Sansan I type <emptyString> in input field have name is <fieldIdNamecard>
    And In Maintain credit data screen, in search Company Sansan I type <emptyString> in input field have name is <fieldSansanCompanyId>
    And In Maintain credit data screen, in search Company Sansan I click button <searchBtn>
    Then In Maintain credit data screen, in search Company Sansan Table below have <fullRecord> record

    When In Maintain credit data screen, in search Company Sansan I click one record can click
    Then In Maintain credit data screen, in search Company Sansan I verify field in Trade name of customer

    When In Maintain credit data screen, in search Company Sansan I try select this record again
    Then In Maintain credit data screen, in search Company Sansan I verify field in Trade name of customer

    When In Maintain credit data screen, in search Company Sansan I try select this record again
    And In Maintain credit data screen, in search Company Sansan table I go to <next> page
    And In Maintain credit data screen, in search Company Sansan table I go to <previous> page
    Then In Maintain credit data screen, in search Company Sansan record selected still there

    Examples:
      | maintainMenu         | pageTitle                          | parentMenuText | searchBtn | selectBtn | rowSelect | only1 | fieldIdNamecard | next | emptyString | fieldSansanCompanyId | previous | fieldCompanyName | fullRecord | validCompanyName | associated | otherConditions  |
      | Maintain Credit Data | Maintenance accounting data screen | Accounting     | Search    | Select    | 0         | 1     | Id Name Card    | next |             | Sansan Company ID    | previous | Company name     | 5          | NTT              | Associated | Other conditions |

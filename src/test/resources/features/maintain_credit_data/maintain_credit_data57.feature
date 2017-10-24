@version:3.1.5
@version:Sprint-1.1
@issue:
Feature: 5-7. Maintain credit data
  As an user
  I want to be able to use Maintain credit data


  @LoggedIn
  Scenario Outline: 1. Open Maintain credit data, search by customer code, select one record and verify value start screen
    When I open submenu <maintainMenu> of parent menu <parentMenuText>
    Then The system should open '<pageTitle>' page
    And In Maintain credit data screen, System show list button can not use
      | Search |

    When In Maintain credit data screen, I type <validCustomerCode> in input field have name is <fieldCustomer>
    And In Maintain credit data screen, I click button <searchBtn>
    Then In Maintain credit data screen, Table below have <only1> record
    And In Maintain credit data screen, I click button <toggleBtn>
    And In Maintain credit data screen, I toggle all column
      | Year of starting business      |
      | Year of official establishment |
      | Last Export                    |
    And In Maintain credit data screen, I click button <toggleBtn>
    And In Maintain credit data screen, I memory data in this table
    And In Maintain credit data screen, I click select checkbox row <rowSelect>
    And In Maintain credit data screen, I click button <selectBtn>
    Then In Maintain credit data screen, I verify Table below have value like row select
    And In Credit Management page, System show list button can use
      | Search |
      | Cancel |
      | Save   |
    And In Maintain credit data screen, System show field can input
      | Customer code                  |
      | Id Name Card                   |
      | Company name in Kana           |
      | Year of starting business      |
      | Year of official establishment |

    Examples:
      | maintainMenu         | pageTitle                          | parentMenuText | validCustomerCode | fieldCustomer | searchBtn | selectBtn | rowSelect | only1 | toggleBtn     |
      | Maintain Credit Data | Maintenance accounting data screen | Accounting     | A001              | Customer code | Search    | Select    | 0         | 1     | Toggle Column |

  @LoggedIn
  Scenario Outline: 2. Open Maintain credit data, search by customer code, select one record and try save and cancel immediately
    When I open submenu <maintainMenu> of parent menu <parentMenuText>
    And The system should open '<pageTitle>' page
    And In Maintain credit data screen, I type <validCustomerCode> in input field have name is <fieldCustomer>
    And In Maintain credit data screen, I click button <searchBtn>
    And In Maintain credit data screen, Table below have <only1> record
    And In Maintain credit data screen, I click select checkbox row <rowSelect>
    And In Maintain credit data screen, I click button <selectBtn>
    And In Maintain credit data screen, I click button <cancelBtn>
    Then In Credit Management page, System show list button can use
      | Select |

    When In Maintain credit data screen, I click button <selectBtn>
    And In Maintain credit data screen, I click button <saveBtn>
    Then In Maintain credit data screen, System show message <saveSuccess>

    Examples:
      | maintainMenu         | pageTitle                          | parentMenuText | validCustomerCode | fieldCustomer | searchBtn | selectBtn | rowSelect | only1 | saveSuccess       | saveBtn | cancelBtn |
      | Maintain Credit Data | Maintenance accounting data screen | Accounting     | A001              | Customer code | Search    | Select    | 0         | 1     | Save successfully | Save    | Cancel    |


  @LoggedIn
  Scenario Outline: 3. Open Maintain credit data, search by customer code, select one record and verify search Company Sansan
    When I open submenu <maintainMenu> of parent menu <parentMenuText>
    And The system should open '<pageTitle>' page
    And In Maintain credit data screen, I type <validCustomerCode> in input field have name is <fieldCustomer>
    And In Maintain credit data screen, I click button <searchBtn>
    And In Maintain credit data screen, Table below have <only1> record
    And In Maintain credit data screen, I click select checkbox row <rowSelect>
    And In Maintain credit data screen, I click button <selectBtn>
    And In Maintain credit data screen, in search Company Sansan I type <validIdNameCard> in input field have name is <fieldIdNamecard>
    And In Maintain credit data screen, in search Company Sansan I type <emptyString> in input field have name is <fieldSansanCompanyId>
    And In Maintain credit data screen, in search Company Sansan I type <emptyString> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, in search Company Sansan I click button <searchBtn>
    Then In Maintain credit data screen, in search Company Sansan Table below have <only1> record

    When In Maintain credit data screen, in search Company Sansan I type <invalidIdNameCard> in input field have name is <fieldIdNamecard>
    And In Maintain credit data screen, in search Company Sansan I click button <searchBtn>
    Then In Maintain credit data screen, in search Company Sansan Table below have <emptyRecord> record

    When In Maintain credit data screen, in search Company Sansan I type <invalidSansanID> in input field have name is <fieldSansanCompanyId>
    And In Maintain credit data screen, in search Company Sansan I type <emptyString> in input field have name is <fieldIdNamecard>
    And In Maintain credit data screen, in search Company Sansan I click button <searchBtn>
    Then In Maintain credit data screen, in search Company Sansan Table below have <emptyRecord> record

    When In Maintain credit data screen, in search Company Sansan I type <validSansanID> in input field have name is <fieldSansanCompanyId>
    And In Maintain credit data screen, in search Company Sansan I click button <searchBtn>
    Then In Maintain credit data screen, in search Company Sansan Table below have <only1> record

    When In Maintain credit data screen, in search Company Sansan I type <invalidCompanyName> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, in search Company Sansan I type <emptyString> in input field have name is <fieldSansanCompanyId>
    And In Maintain credit data screen, in search Company Sansan I click button <searchBtn>
    Then In Maintain credit data screen, in search Company Sansan Table below have <emptyRecord> record

    When In Maintain credit data screen, in search Company Sansan I type <validCompanyName> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, in search Company Sansan I click button <searchBtn>
    Then In Maintain credit data screen, in search Company Sansan Table below have <fullRecord> record

    When In Maintain credit data screen, in search Company Sansan I type <validSansanID> in input field have name is <fieldSansanCompanyId>
    And In Maintain credit data screen, in search Company Sansan I type <validCompanyName> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, in search Company Sansan I click button <searchBtn>
    Then In Maintain credit data screen, in search Company Sansan Table below have <only1> record

    When In Maintain credit data screen, in search Company Sansan I type <validSansanID> in input field have name is <fieldSansanCompanyId>
    And In Maintain credit data screen, in search Company Sansan I type <validCompanyName> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, in search Company Sansan I type <validIdNameCard> in input field have name is <fieldIdNamecard>
    And In Maintain credit data screen, in search Company Sansan I click button <searchBtn>
    Then In Maintain credit data screen, in search Company Sansan Table below have <only1> record

    When In Maintain credit data screen, in search Company Sansan I type <validSansanID> in input field have name is <fieldSansanCompanyId>
    And In Maintain credit data screen, in search Company Sansan I type <invalidCompanyName> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, in search Company Sansan I type <validIdNameCard> in input field have name is <fieldIdNamecard>
    And In Maintain credit data screen, in search Company Sansan I click button <searchBtn>
    Then In Maintain credit data screen, in search Company Sansan Table below have <emptyRecord> record

    When In Maintain credit data screen, in search Company Sansan I type <validSansanID> in input field have name is <fieldSansanCompanyId>
    And In Maintain credit data screen, in search Company Sansan I type <invalidCompanyName> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, in search Company Sansan I type <emptyString> in input field have name is <fieldIdNamecard>
    And In Maintain credit data screen, in search Company Sansan I click button <searchBtn>
    Then In Maintain credit data screen, in search Company Sansan Table below have <emptyRecord> record


    Examples:
      | maintainMenu         | pageTitle                          | parentMenuText | validCustomerCode | fieldCustomer | searchBtn | selectBtn | rowSelect | only1 | fieldIdNamecard | validIdNameCard                  | emptyString | fieldSansanCompanyId | invalidSansanID | fieldCompanyName | emptyRecord | fullRecord | invalidIdNameCard | validSansanID                    | invalidCompanyName | validCompanyName |
      | Maintain Credit Data | Maintenance accounting data screen | Accounting     | A001              | Customer code | Search    | Select    | 0         | 1     | Id Name Card    | DE10708481BF3FF2657B92EB68A6711F |             | Sansan Company ID    | 99999()         | Company name     | 0           | 5          | 13123123          | 307A5FC95E0E34AD88C41762A52BF564 | Tast789            | NTT              |

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

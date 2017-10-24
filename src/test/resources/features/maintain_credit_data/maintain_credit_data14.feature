@version:3.1.5
@version:Sprint-1.1
@issue:
Feature: 1-4. Maintain credit data
  As an user
  I want to be able to use Maintain credit data

  @LoggedIn
  Scenario Outline: 1. Open Maintain credit data and verify when start
    When I open submenu <maintainMenu> of parent menu <parentMenuText>
    Then The system should open '<pageTitle>' page
    And In Maintain credit data screen, System show list button can not use
      | Search |
    And In Maintain credit data screen, System show field can input
      | Customer code |

    When In Maintain credit data screen, I choose radio button have name is <otherConditions>
    Then In Maintain credit data screen, System show field can input
      | Company name |
    And In Maintain credit data screen, System show field can not input
      | Sansan Company ID |

    When In Maintain credit data screen, I choose radio button have name is <associated>
    And In Maintain credit data screen, I type <emptyString> in input field have name is <fieldCompanyName>
    Then In Maintain credit data screen, System show list button can not use
      | Search |

    And In Maintain credit data screen, System show field can input
      | Company name      |
      | Sansan Company ID |
    Examples:
      | maintainMenu         | pageTitle                          | parentMenuText | otherConditions  | associated | fieldCompanyName | emptyString |
      | Maintain Credit Data | Maintenance accounting data screen | Accounting     | Other conditions | Associated | Company name     |             |


  @LoggedIn
  Scenario Outline: 2. Open Maintain credit data and search customer code
    When I open submenu <maintainMenu> of parent menu <parentMenuText>
    Then The system should open '<pageTitle>' page
    And In Maintain credit data screen, System show list button can not use
      | Search |

    When In Maintain credit data screen, I type <invalidCustomerCode> in input field have name is <fieldCustomer>
    And In Maintain credit data screen, I click button <searchBtn>
    Then In Maintain credit data screen, Table below have <empty> record

    When In Maintain credit data screen, I type <validCustomerCode> in input field have name is <fieldCustomer>
    And In Maintain credit data screen, I click button <searchBtn>
    Then In Maintain credit data screen, Table below have <numberOfRecord> record


    Examples:
      | maintainMenu         | pageTitle                          | parentMenuText | validCustomerCode | fieldCustomer | searchBtn | invalidCustomerCode | empty | numberOfRecord |
      | Maintain Credit Data | Maintenance accounting data screen | Accounting     | A211              | Customer code | Search    | p665                | 0     | 1              |

  @LoggedIn
  Scenario Outline: 3. Open Maintain credit data and search customer code by other conditions
    When I open submenu <maintainMenu> of parent menu <parentMenuText>
    And The system should open '<pageTitle>' page
    And In Maintain credit data screen, I choose radio button have name is <otherConditions>
    And In Maintain credit data screen, I click button <searchBtn>
    Then In Maintain credit data screen, Table below have <numberOfRecord> record

    When In Maintain credit data screen, I type <invalidCompanyName> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, I click button <searchBtn>
    Then In Maintain credit data screen, Table below have <empty> record

    When In Maintain credit data screen, I type <validCompanyName> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, I click button <searchBtn>
    Then In Maintain credit data screen, Table below have <numberOfRecord> record


    When In Maintain credit data screen, I choose radio button have name is <associated>
    And In Maintain credit data screen, I type <invalidCompanyName> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, I click button <searchBtn>
    Then In Maintain credit data screen, Table below have <empty> record

    When In Maintain credit data screen, I type <validCompanyName> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, I click button <searchBtn>
    Then In Maintain credit data screen, Table below have <numberOfRecord> record

    When In Maintain credit data screen, I type <validId> in input field have name is <fieldSansanId>
    When In Maintain credit data screen, I type <emptyString> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, I click button <searchBtn>
    Then In Maintain credit data screen, Table below have <only1> record

    When In Maintain credit data screen, I type <invalidId> in input field have name is <fieldSansanId>
    And In Maintain credit data screen, I click button <searchBtn>
    Then In Maintain credit data screen, Table below have <empty> record

    When In Maintain credit data screen, I type <validId> in input field have name is <fieldSansanId>
    And In Maintain credit data screen, I type <emptyString> in input field have name is <fieldCompanyName>
    And In Maintain credit data screen, I click button <searchBtn>
    Then In Maintain credit data screen, Table below have <only1> record

    When In Maintain credit data screen, I type <invalidId> in input field have name is <fieldSansanId>
    And In Maintain credit data screen, I click button <searchBtn>
    Then In Maintain credit data screen, Table below have <empty> record

    Examples:
      | maintainMenu         | pageTitle                          | parentMenuText | validCompanyName | fieldCompanyName | searchBtn | invalidCompanyName | empty | numberOfRecord | otherConditions  | associated | validId                          | fieldSansanId     | only1 | invalidId                         | emptyString |
      | Maintain Credit Data | Maintenance accounting data screen | Accounting     | F                | Company name     | Search    | companynotexist    | 0     | 5              | Other conditions | Associated | 992272FF67A8A53A9FFE5ABE9EAFCD25 | Sansan Company ID | 1     | TEST272FF67A8A53A9FFE5ABE9EAFCD25 |             |


  @LoggedIn
  Scenario Outline: 4. Open Maintain credit data, search and use toggle column
    When I open submenu <maintainMenu> of parent menu <parentMenuText>
    Then The system should open '<pageTitle>' page
    And In Maintain credit data screen, I type <validCustomerCode> in input field have name is <fieldCustomer>
    And In Maintain credit data screen, I click button <searchBtn>
    And In Maintain credit data screen, Table below have <only1> record

    And In Maintain credit data screen, I click button <toggleBtn>
    And In Maintain credit data screen, I toggle all column
      | Year of starting business      |
      | Year of official establishment |
      | Last Export                    |
    And In Maintain credit data screen, I click button <toggleBtn>
    Then In Maintain credit data screen, Table below have <numberClm> columns

    Examples:
      | maintainMenu         | pageTitle                          | parentMenuText | validCustomerCode | fieldCustomer | searchBtn | numberClm | only1 | toggleBtn     |
      | Maintain Credit Data | Maintenance accounting data screen | Accounting     | A211              | Customer code | Search    | 10        | 1     | Toggle Column |

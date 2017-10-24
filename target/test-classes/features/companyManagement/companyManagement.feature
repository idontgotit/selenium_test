@version:3.1.5
@version:Sprint-1.1
@issue:
Feature: company management
  As a user
  I want to manage company
  So I can view, add new, edit and delete companies

#-------------------------------------------------------------------------------#

#  @LoggedIn
#  Scenario Outline: 1. Initialization screen
#    When I open submenu <submenuText> of menu <menuText>
#    Then The system should show initialization screen of Company management page
#
#    When In Company management screen, I click button Expand Branch
#    Then The system should expand all row in table company
#
#    Examples:
#      | submenuText        | menuText |
#      | Company Management | Common   |
#
##-------------------------------------------------------------------------------#
#
#  @LoggedIn
#  Scenario Outline: 2. Paging
#    When I open submenu <submenuText> of menu <menuText>
#    Then The system should open '<submenuText>' page
#
#    When In Company management screen, I click button last page on paging
#    Then The table company should show last page
#
#    When In Company management screen, I click button first page on paging
#    Then The table company should show first page
#
#    When In Company management screen, I click page <pageNumberOne> on paging
#    Then The table company should change to selected page <pageNumberOne>
#
#    When In Company management screen, I click button next
#    Then The table company should change to selected page <pageNumberOne> + 1
#
#    When In Company management screen, I click button back
#    Then The table company should change to selected page <pageNumberOne>
#
#    Examples:
#      | submenuText        | menuText | pageNumberOne |
#      | Company Management | Common   | 2             |
#
##-------------------------------------------------------------------------------#
#
#  @LoggedIn
#  Scenario Outline: 3. Search company
#    When I open submenu <submenuText> of menu <menuText>
#    And I fill value <invalidSearchText> for input search in Company management screen
#    And In Company management screen, I click button Search
#    Then In Company management screen, the system should show table company with no record found
#
#    When I fill value <validSearchText> for input search in Company management screen
#    And In Company management screen, I click button Search
#    Then The system should show table company with record found
#
#    Examples:
#      | submenuText        | menuText | invalidSearchText | validSearchText |
#      | Company Management | Common   | aaaaa             | a               |
#
##-------------------------------------------------------------------------------#
#
#  @LoggedIn
#  Scenario Outline: 4. Filter
#    When I open submenu <submenuText> of menu <menuText>
#    And In Company management screen, I fill value '<filterText>' for filter in column '<columnCompanyNameTitle>'
#    Then Table Company should show only records contain text '<filterText>' in column '<columnCompanyNameTitle>'
#
#    When In Company management screen, I fill value '<filterText>' for filter in column '<columnCompanyNameTitle>' and enter
#    Then Table Company should show only records contain text '<filterText>' in column '<columnCompanyNameTitle>'
#
#    When In Company management screen, I fill value '<filterText>' for filter in column '<columnCustomerCodeTitle>'
#    Then Table Company should show only records contain text '<filterText>' in column '<columnCustomerCodeTitle>'
#
#    When In Company management screen, I fill value '<filterText>' for filter in column '<columnCustomerCodeTitle>' and enter
#    Then Table Company should show only records contain text '<filterText>' in column '<columnCustomerCodeTitle>'
#
#    When In Company management screen, I choose value '<headOfficeFilterText>' for dropdown filter in column '<columnHeadOfficeTitle>'
#    Then Table Company should show only records contain text '<headOfficeFilterText>' in column '<columnHeadOfficeTitle>'
#
#    When In Company management screen, I choose value '<workTypeFilterText>' for dropdown filter in column '<columnWorkTypeTitle>'
#    Then Table Company should show only records contain text '<workTypeFilterText>' in column '<columnWorkTypeTitle>'
#
#    Examples:
#      | submenuText        | menuText | filterText | columnCompanyNameTitle | columnCustomerCodeTitle | columnHeadOfficeTitle | columnWorkTypeTitle | headOfficeFilterText | workTypeFilterText |
#      | Company Management | Common   | a          | Company name           | Customer code           | Head office           | Work type           | 東京都                  | ソフトウェア             |
#
##-------------------------------------------------------------------------------#
#
#  @LoggedIn
#  Scenario Outline: 5. Sorter
#    Given A list of column title need toggle in Company management
#      | Website |
#    When I open submenu <submenuText> of menu <menuText>
#    And I open toggle menu in table company
#    And I toggle all column in table company
#    And In Company management screen, I sort <columnCompanyNameTitle> column by <sortType>
#    Then The system should show table company sorted by column <columnCompanyNameTitle> and <sortType>
#
#    When In Company management screen, I sort <columnCompanyNameTitle> column by <sortType>
#    Then The system should show table company sorted by column <columnCompanyNameTitle> and <descending>
#
#    When In Company management screen, I sort <columnCustomerCodeTitle> column by <sortType>
#    Then The system should show table company sorted by column <columnCustomerCodeTitle> and <sortType>
#
#    When In Company management screen, I sort <columnCustomerCodeTitle> column by <sortType>
#    Then The system should show table company sorted by column <columnCustomerCodeTitle> and <descending>
#
#    When In Company management screen, I sort <columnHeadOfficeTitle> column by <sortType>
#    Then The system should show table company sorted by column <columnHeadOfficeTitle> and <sortType>
#
#    When In Company management screen, I sort <columnHeadOfficeTitle> column by <descending>
#    Then The system should show table company sorted by column <columnHeadOfficeTitle> and <descending>
#
#    When In Company management screen, I sort <columnWorkTypeTitle> column by <sortType>
#    Then The system should show table company sorted by column <columnWorkTypeTitle> and <sortType>
#
#    When In Company management screen, I sort <columnWorkTypeTitle> column by <descending>
#    Then The system should show table company sorted by column <columnWorkTypeTitle> and <descending>
#
#    When In Company management screen, I sort <columnListedTitle> column by <sortType>
#    Then The system should show table company sorted by column <columnListedTitle> and <sortType>
#
#    When In Company management screen, I sort <columnListedTitle> column by <sortType>
#    Then The system should show table company sorted by column <columnListedTitle> and <descending>
#
#    When In Company management screen, I sort <columnWebsiteTitle> column by <sortType>
#    Then The system should show table company sorted by column <columnWebsiteTitle> and <sortType>
#
#    When In Company management screen, I sort <columnWebsiteTitle> column by <sortType>
#    Then The system should show table company sorted by column <columnWebsiteTitle> and <descending>
#
#    Examples:
#      | submenuText        | menuText | columnCompanyNameTitle | columnCustomerCodeTitle | columnHeadOfficeTitle | columnWorkTypeTitle | columnListedTitle | columnWebsiteTitle | sortType | descending |
#      | Company Management | Common   | Company name           | Customer code           | Head office           | Work type           | Listed            | Website            | ASC      | DESC       |
#
##-------------------------------------------------------------------------------#
#
#  @LoggedIn
#  Scenario Outline: 6. Add new company and fill only required field
#    When I open submenu <submenuText> of menu <menuText>
#    And I create new company with name '<companyName>'
#    And I input company detail as below
#      | companyFullName | workType | listed   | headOffice |
#      | Test company    | 土木       | Type One | 岩手県        |
#    And In Company Detail screen, I click '<buttonText>' button
#    Then The system should save company success
#
#    When In Company management screen, I fill value '<filterText>' for filter in column '<columnCompanyNameTitle>'
#    Then The system should show table company with record found
#
#    Examples:
#      | submenuText        | menuText | companyName  | buttonText | filterText   | columnCompanyNameTitle |
#      | Company Management | Common   | Test company | Save       | Test company | Company name           |
#
##-------------------------------------------------------------------------------#
#
#  @LoggedIn
#  Scenario Outline: 7. Delete company by select after filter
#    When I open submenu <submenuText> of menu <menuText>
#    Then The system should open '<submenuText>' page
#
#    When In Company management screen, I fill value '<filterText>' for filter in column '<columnCompanyNameTitle>'
#    And In Company management screen, I select row '<rowIndex>'
#    Then In Company management screen, the system should show button delete
#
#    When In Company management screen, I click button Delete
#    And In Company management screen, I confirm delete company
#    Then The system should save company success
#
#    Examples:
#      | submenuText        | menuText | filterText   | columnCompanyNameTitle | rowIndex |
#      | Company Management | Common   | Test company | Company name           | 0        |
#
##-------------------------------------------------------------------------------#
#
#  Scenario Outline: 8. Add new company and fill all fields
#    When I open Login page
#    And I input my credentials username <username> and password <password>
#    And I change language to <lang>
#    When I open submenu <submenuText> of menu <menuText>
#    Then The system should open '<submenuText>' page
#
#    When I create new company with name '<companyName>'
#    And I input company detail as below
#      | companyFullName | workType | listed   | headOffice | customerCode | branches | website            |
#      | Test company    | 土木       | Type One | 岩手県        | a777         | 東京都, 山梨県 | anlh@arrow-tech.vn |
#    And In Company Detail screen, I click '<buttonText>' button
#    Then The system should save company success
#
#    When In Company management screen, I fill value '<filterText>' for filter in column '<columnCompanyNameTitle>'
#    Then The system should show table company with record found
#
#    Examples:
#      | username | password | lang | submenuText        | menuText | companyName  | buttonText | filterText   | columnCompanyNameTitle |
#      | 4009912  | 123456   | en   | Company Management | Common   | Test company | Save       | Test company | Company name           |
#
#  Scenario: logout from system
#    When I logout from system
#
##-------------------------------------------------------------------------------#
#
#  @LoggedIn
#  Scenario Outline: 9. Verify recent activities
#    When I open submenu <submenuText> of menu <menuText>
#    Then The system should open '<submenuText>' page
#
#    When In Company management screen, I fill value '<filterText>' for filter in column '<columnCompanyNameTitle>'
#    And In Company management screen, I select row '<rowIndex>'
#    And In Company management screen, I click button Edit
#    And In Company Detail screen, I view recent activities with company
#    Then The system should open recent activities screen
#
#    When In Company Detail screen, I close recent activities screen
#    And In Company Detail screen, I click button back
#    Then The system should show table company with record found
#
#    Examples:
#      | submenuText        | menuText | filterText   | columnCompanyNameTitle | rowIndex |
#      | Company Management | Common   | Test company | Company name           | 0        |
#
##-------------------------------------------------------------------------------#
#
#  @LoggedIn
#  Scenario Outline: 10. Save immediately after open edit screen
#    When I open submenu <submenuText> of menu <menuText>
#    And In Company management screen, I select row '<rowIndex>'
#    And In Company management screen, I click button Edit
#    And In Company Detail screen, I click '<buttonText>' button
#    Then The system should save company success
#
#    Examples:
#      | submenuText        | menuText | rowIndex | buttonText |
#      | Company Management | Common   | 0        | Save       |
#
##-------------------------------------------------------------------------------#
#
#  @LoggedIn
#  Scenario Outline: 11. Edit company with only required fields
#    When I open submenu <submenuText> of menu <menuText>
#    Then The system should open '<submenuText>' page
#
#    When In Company management screen, I fill value '<filterText>' for filter in column '<columnCompanyNameTitle>'
#    And In Company management screen, I select row '<rowIndex>'
#    And I edit company with name <companyName>
#    And I input company detail as below
#      | companyFullName     | workType | listed     | headOffice |
#      | Test company edited | コールセンター  | Other Type | 静岡県        |
#    And In Company Detail screen, I click '<buttonText>' button
#    Then The system should save company success
#
#    Examples:
#      | submenuText        | menuText | filterText   | columnCompanyNameTitle | rowIndex | buttonText | companyName         |
#      | Company Management | Common   | Test company | Company name           | 0        | Save       | Test company edited |
#
##-------------------------------------------------------------------------------#
#
#  Scenario Outline: 12. Edit company and fill all field
#    When I open Login page
#    And I input my credentials username <username> and password <password>
#    And I change language to <lang>
#    When I open submenu <submenuText> of menu <menuText>
#    Then The system should open '<submenuText>' page
#
#    When In Company management screen, I fill value '<filterText>' for filter in column '<columnCompanyNameTitle>'
#    And In Company management screen, I select row '<rowIndex>'
#    And I edit company with name <companyName>
#    And I input company detail as below
#      | companyFullName | workType | listed   | headOffice | customerCode | branches | website            |
#      | Test company    | 土木       | Type One | 岩手県        | z999         | 静岡県, 岡山県 | anlh2207@gmail.com |
#    And In Company Detail screen, I click '<buttonText>' button
#    Then The system should save company success
#
#    Examples:
#      | username | password | lang | submenuText        | menuText | filterText   | columnCompanyNameTitle | rowIndex | buttonText | companyName  |
#      | 4009912  | 123456   | en   | Company Management | Common   | Test company | Company name           | 0        | Save       | Test company |
#
#  Scenario: logout from system
#    When I logout from system
#
##-------------------------------------------------------------------------------#
#
#  @LoggedIn
#  Scenario Outline: 13. Delete company after edit company
#    When I open submenu <submenuText> of menu <menuText>
#    Then The system should open '<submenuText>' page
#
#    When In Company management screen, I fill value '<filterText>' for filter in column '<columnCompanyNameTitle>'
#    And In Company management screen, I select row '<rowIndex>'
#    Then In Company management screen, the system should show button delete
#
#    When In Company management screen, I click button Delete
#    And In Company management screen, I confirm delete company
#    Then The system should save company success
#
#    Examples:
#      | submenuText        | menuText | filterText | columnCompanyNameTitle | rowIndex |
#      | Company Management | Common   | z999       | Customer code          | 0        |
#
##-------------------------------------------------------------------------------#
#
#  Scenario Outline: 14. Cannot delete a company if user is not admin
#    When I open Login page
#    And I input my credentials username <username> and password <password>
#    And I change language to <lang>
#    And I open submenu <submenuText> of menu <menuText>
#    Then In Company management screen, the system should not show button delete
#
#    Examples:
#      | username | password | lang | submenuText        | menuText |
#      | 4009907  | 123456   | en   | Company Management | Common   |
#
#  Scenario: logout from system
#    When I logout from system
#
##-------------------------------------------------------------------------------#
#
#  Scenario Outline: 15. When add new company, click reset after fill all fields
#    When I open Login page
#    And I input my credentials username <username> and password <password>
#    And I change language to <lang>
#    When I open submenu <submenuText> of menu <menuText>
#    And I create new company with name '<companyName>'
#    And I input company detail as below
#      | companyFullName | workType | listed   | headOffice | customerCode | branches | website            |
#      | Test company    | 土木       | Type One | 岩手県        | z111         | 東京都, 山梨県 | anlh@arrow-tech.vn |
#    And In Company Detail screen, I click '<buttonText>' button
#    Then The system should show initialization screen of Company details
#
#    Examples:
#      | username | password | lang | submenuText        | menuText | companyName  | buttonText |
#      | 4009912  | 123456   | en   | Company Management | Common   | Test company | Reset      |
#
#  Scenario: logout from system
#    When I logout from system
#
##-------------------------------------------------------------------------------#
#
#  Scenario Outline: 16. When add new company, click cancel after fill all fields
#    When I open Login page
#    And I input my credentials username <username> and password <password>
#    And I change language to <lang>
#    When I open submenu <submenuText> of menu <menuText>
#    Then The system should open '<submenuText>' page
#
#    When I create new company with name '<companyName>'
#    And I input company detail as below
#      | companyFullName | workType | listed   | headOffice | customerCode | branches | website            |
#      | Test company    | 土木       | Type One | 岩手県        | z111         | 東京都, 山梨県 | anlh@arrow-tech.vn |
#    And In Company Detail screen, I click button back
#    Then The system should show initialization screen of Company management page
#
#    Examples:
#      | username | password | lang | submenuText        | menuText | companyName  |
#      | 4009912  | 123456   | en   | Company Management | Common   | Test company |
#
#  Scenario: logout from system
#    When I logout from system
#
##-------------------------------------------------------------------------------#
#
#  Scenario Outline: 17. When edit company, click reset after fill all data
#    When I open Login page
#    And I input my credentials username <username> and password <password>
#    And I change language to <lang>
#    When I open submenu <submenuText> of menu <menuText>
#    Then The system should open '<submenuText>' page
#
#    When In Company management screen, I fill value '<filterText>' for filter in column '<columnCompanyNameTitle>'
#    And In Company management screen, I select row '<rowIndex>'
#    And I edit company with name <companyName>
#    And I input company detail as below
#      | companyFullName | workType | listed   | headOffice | customerCode | branches | website            |
#      | Test company    | 土木       | Type One | 岩手県        | z999         | 静岡県, 岡山県 | anlh2207@gmail.com |
#    And In Company Detail screen, I click '<buttonText>' button
#    Then The system should reset Company Detail screen
#
#    Examples:
#      | username | password | lang | submenuText        | menuText | filterText | columnCompanyNameTitle | rowIndex | companyName  | buttonText |
#      | 4009912  | 123456   | en   | Company Management | Common   | CIJ        | Company name           | 0        | Test company | Reset      |
#
#  Scenario: logout from system
#    When I logout from system
#
##-------------------------------------------------------------------------------#
#
#  Scenario Outline: 18. When edit company, click cancel after fill all data
#    When I open Login page
#    And I input my credentials username <username> and password <password>
#    And I change language to <lang>
#    When I open submenu <submenuText> of menu <menuText>
#    And In Company management screen, I fill value '<filterText>' for filter in column '<columnCompanyNameTitle>'
#    And In Company management screen, I select row '<rowIndex>'
#    And I edit company with name <companyName>
#    And I input company detail as below
#      | companyFullName | workType | listed   | headOffice | customerCode | branches | website            |
#      | Test company    | 土木       | Type One | 岩手県        | z999         | 静岡県, 岡山県 | anlh2207@gmail.com |
#    And In Company Detail screen, I click button back
#    Then The system should show table company with record found
#
#    Examples:
#      | username | password | lang | submenuText        | menuText | filterText | columnCompanyNameTitle | rowIndex | companyName  |
#      | 4009912  | 123456   | en   | Company Management | Common   | CIJ        | Company name           | 0        | Test company |
#
#  Scenario: logout from system
#    When I logout from system

#-------------------------------------------------------------------------------#

  Scenario Outline: 19. Open edit company, clear customer code and save
    When I open Login page
    And I input my credentials username <username> and password <password>
    And I change language to <lang>
    And I open submenu <submenuText> of menu <menuText>
    And In Company management screen, I select row '<rowIndex>'
    And In Company management screen, I click button Edit
    And In Company Detail screen, I clear customer code
    And In Company Detail screen, I click '<buttonText>' button
    Then The system should save company success

    When In Company management screen, I select row '<rowIndex>'
    And In Company management screen, I click button Edit
    Then In Company Detail screen, the system should show customer code empty

    Examples:
      | username | password | lang | submenuText        | menuText | rowIndex | buttonText |
      | 4009912  | 123456   | en   | Company Management | Common   | 0        | Save       |

  Scenario: logout from system
    When I logout from system

#-------------------------------------------------------------------------------#

#  Scenario Outline: 20. Open edit company, type invalid customer code and save
#    When I open Login page
#    And I input my credentials username <username> and password <password>
#    And I change language to <lang>
#    And I open submenu <submenuText> of menu <menuText>
#    And In Company management screen, I select row '<rowIndex>'
#    And In Company management screen, I click button Edit
#    And In Company Detail screen, I input Customer code <customerCode>
#    And In Company Detail screen, I click '<buttonText>' button
#    Then The system should save company unsuccess
#
#    Examples:
#      | username | password | lang | submenuText        | menuText | rowIndex | buttonText | customerCode|
#      | 4009912  | 123456   | en   | Company Management | Common   | 0        | Save       | A           |
#
#  Scenario: logout from system
#    When I logout from system

#-------------------------------------------------------------------------------#


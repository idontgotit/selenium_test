@version:3.1.5
@version:Sprint-1.1
@issue:
Feature: Bass export display
  As an user
  I want to be able see screen BASS Export

  @LoggedIn
  Scenario Outline: 1. Open bass export and verify
    When I open submenu <menuText> of parent menu <parentMenuText>
    Then The system should open '<pageTitle>' page
    And In Bass export screen, System show button <exportBtn>

    When In Bass export screen, I click button <exportBtn> 
    Then System show table <tableName> with 6 download link
    And In Bass export screen, System show button <downloadAllButton>
    And System show downloaded location <location> and can not edit
    And In Bass export screen, System show button <copyBtn>
    And In Bass export screen, System show button <editBtn>



    Examples:
      | menuText    | parentMenuText | pageTitle   | exportBtn | tableName      | downloadAllButton | location           | copyBtn | editBtn |
      | BASS Export | Import/Export  | BASS Export | Export    | Files Exported | Download all      | Download location: | Copy    | Edit    |


  @LoggedIn
  Scenario Outline: 2. Open bass export and use download location
    When I open submenu <menuText> of parent menu <parentMenuText>
    And  In Bass export screen, I click button <exportBtn>
    And In Bass export screen, I click button <editBtn>
    Then In Bass export screen, System show button <saveBtn>
    And In Bass export screen, System show button <cancelBtn>
    And System hide button <editBtn>
    And System show downloaded location <location> and can edit

    When In Bass export screen, I click button <cancelBtn>
    Then In Bass export screen, System show button <editBtn>
    And System hide button <saveBtn>
    And System hide button <cancelBtn>
    And System show downloaded location <location> and can not edit


    When In Bass export screen, I click button <editBtn>
    And In Bass export screen, I click button <saveBtn>
    Then In Bass export screen, System show button <editBtn>
    And System hide button <saveBtn>
    And System hide button <cancelBtn>
    And System show downloaded location <location> and can not edit


    When I open submenu <menuText> of parent menu <parentMenuText>
    And  In Bass export screen, I click button <exportBtn>
    And In Bass export screen, I click button <editBtn>
    And I save path in download location to new variable
    And I type <textValue> in downloaded location
    And In Bass export screen, I click button <cancelBtn>
    Then In Bass export screen, System show button <editBtn>
    And System hide button <saveBtn>
    And System hide button <cancelBtn>
    And System show downloaded location <location> and can not edit
    And System show downloaded location with old path

    Examples:
      | menuText    | parentMenuText | location           | editBtn | saveBtn | cancelBtn | exportBtn | textValue |
      | BASS Export | Import/Export  | Download location: | Edit    | Save    | Cancel    | Export    | !@#$%     |


  @LoggedIn
  Scenario Outline: 3. Open bass export use save path
    When I open submenu <menuText> of parent menu <parentMenuText>
    And  In Bass export screen, I click button <exportBtn>
    And In Bass export screen, I click button <editBtn>
    And I save path in download location to new variable
    And I type <textValue> in downloaded location
    And In Bass export screen, I click button <saveBtn>
    Then In Bass export screen, System show button <editBtn>
    And System hide button <saveBtn>
    And System hide button <cancelBtn>
    And System show downloaded location <location> and can not edit
    And System show downloaded location with new path <textValue>

    Examples:
      | menuText    | parentMenuText | location           | editBtn | saveBtn | cancelBtn | exportBtn | textValue     |
      | BASS Export | Import/Export  | Download location: | Edit    | Save    | Cancel    | Export    | var/sars/bass |



  @LoggedIn
  Scenario Outline: 4. Open bass export and use button Copy download location
    When I open submenu <menuText> of parent menu <parentMenuText>
    And  In Bass export screen, I click button <exportBtn>
    And In Bass export screen, I click button <copyBtn>
    Then System copy value in download location in clipboard


    Examples:
      | menuText    | parentMenuText | exportBtn | copyBtn |
      | BASS Export | Import/Export  | Export    | Copy    |


  @LoggedIn
  Scenario Outline: 5. Open bass export and verify link download api
    When I open submenu <menuText> of parent menu <parentMenuText>
    And In Bass export screen, I click button <exportBtn>
    And I create all link download by API
    Then System show link can download

    Examples:
      | menuText    | parentMenuText | exportBtn |
      | BASS Export | Import/Export  | Export    |

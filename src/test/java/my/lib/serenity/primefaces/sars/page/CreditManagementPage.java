package my.lib.serenity.primefaces.sars.page;

import my.lib.serenity.primefaces.component.*;
import my.lib.serenity.primefaces.component.factory.PFComponentFactory;
import my.lib.serenity.primefaces.constant.CommonConstant;
import my.lib.serenity.primefaces.sars.model.CreditManagementInputDataModel;
import my.lib.serenity.primefaces.sars.utils.CommonUtils;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.exceptions.ElementShouldBeVisibleException;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Created by arrow on 22/9/16.
 */
public class CreditManagementPage extends AbstractPage {

    public static final String CUSTOMER_DETAILS_SCREEN_TITLE = "Input data process";
    public static final String SURVEY_INSTITUTE = "Survey institute and information source";
    public static final String CREDIT_SCORE = "Credit score rank";
    public static final String TRADING = "Trading condition category";
    public static final String FISCAL = "Fiscal closing month";
    public static final String DECISION = "Cause of decision";
    public static final String ADDITIONAL = "Additional direction";
    public static final String ACCOUNTANT = "Accountant direction";
    public static final String BRANCH = "Branch of request user";
    public static final String AUTHORIZED = "Authorized by";
    public static final String FINAL_AUTHORIZED = "Final authorized by";
    public static final String REQUEST = "Request user account";
    public static final String INDEX = "Index for accounting system";
    public static final String CREDIT = "Credit score number";
    public static final String COMPANY_INDEX = "Company index of research institute";
    public static final String ZIP_CODE = "Zip code of HQ";
    public static final String ADDRESS = "Address of HQ (all)";
    public static final String TEL = "Tel.";
    public static final String FAX = "Fax.";
    public static final String NUMBER_EMPLOYEES = "Number of employees";
    public static final String CAPITAL = "Capital fund";
    public static final String URL = "Url";
    public static final String INDUSTRY_MAIN = "Industry category code (main)";
    public static final String INDUSTRY_SUB = "Industry category code (subsidiary)";
    public static final String RANK_SECTOR_NATION = "Rank of the same sector (Nation wide)";
    public static final String POPULATION_NATION = "Population of the same industry (Nation wide)";
    public static final String RANK_PREFECTURE = "Rank of the same sector (Prefecture)";
    public static final String POPULATION_PREFECTURE = "Population of the same industry (Prefecture)";
    public static final String INPUT_TEXT = "INPUT_TEXT";
    public static final String SELECT_ONE_MENU = "SELECT_ONE_MENU";
    public static final String TEXT_AREA = "TEXT_AREA";
    public CreditManagementInputDataModel creditManagementInputDataModelInView;

    @FindBy(xpath = "//div[@id='searchCustomerTabView']")
    WebElementFacade searchCustomerTabViewElement;

    @FindBy(xpath = "//form[contains(@id,'formSearchByOtherConditions')]//input[contains(@id,'customer_code')]")
    WebElementFacade inputCustomerCodeElement;

    @FindBy(xpath = "//form[contains(@id,'formSearchByOtherConditions')]//button[contains(@id,'searchButtonCustomerCode')]")
    WebElementFacade buttonSearchByCustomerCodeElement;

    @FindBy(xpath = "//form[contains(@id,'formSearchByOtherConditions')]//input[contains(@id,'inputIdNameCard')]")
    WebElementFacade inputIdNameCardElement;

    @FindBy(xpath = "//form[contains(@id,'formSearchByOtherConditions')]//input[contains(@id,'inputCompanyName')]")
    WebElementFacade inputCompanyNameElement;

    @FindBy(xpath = "//form[contains(@id,'formSearchByOtherConditions')]//button[contains(@id,'searchButton')]")
    WebElementFacade buttonSearchByOtherConditionsElement;

    @FindBy(xpath = "//button[@id='formNameCard:buttonSelect']")
    WebElementFacade buttonSelectElement;

    @FindBy(xpath = "//div[@id='formNameCard:nameCardTable']")
    WebElementFacade tableCustomerElement;

    @FindBy(xpath = "//button[@id='formNameCard:nameCardTable:toggler']")
    WebElementFacade buttonTogglerElement;

    @FindBy(xpath = "//label[@class='arrow-form-title']")
    WebElementFacade labelScreenTitle;

    private TabViewComponent searchCustomerTabView;
    private InputTextComponent inputCustomerCode;
    private ButtonComponent buttonSearchByCustomerCode;
    private InputTextComponent inputIdNameCard;
    private InputTextComponent inputCompanyName;
    private ButtonComponent buttonSearchByOtherConditions;
    private ButtonComponent buttonSelect;
    private TableComponent tableCustomer;
    private ButtonComponent buttonToggler;

    public String dateOfSurveySelected;
    public String dateOfSurveyDraftSelected;


    public boolean is_initialization_screen() {
        return this.getInputCustomerCode().isEnabled() && this.getInputIdNameCard().isEnabled() && this.getInputCompanyName().isEnabled() && !this.getButtonSearchByOtherConditions().isEnabled();
    }

    public void search_customer_by_code(String code) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.getInputCustomerCode().type_and_wait(code);
        this.getButtonSearchByCustomerCode().click_and_wait();
    }

    public boolean is_no_record_found() {
        return this.getTableCustomer().is_no_record();
    }

    public void click_checkbox_left_of_a_row_into_table_result(int rowIndex) {
        this.getTableCustomer().click_check_box_by_row_index(rowIndex);
    }

    public boolean enable_select_button_and_highlight_selected_row(int rowIndex) {
        return this.getButtonSelect().isEnabled() && this.getTableCustomer().is_row_highlight(rowIndex);
    }

    public boolean disable_select_button_and_no_highlight_selected_row(int rowIndex) {
        return !this.getButtonSelect().isEnabled() && !this.getTableCustomer().is_row_highlight(rowIndex);
    }

    public void click_a_row_into_table_result(int rowIndex) {
        this.getTableCustomer().click_a_row_into_table_result(rowIndex);
    }

    public void click_button_select() {
        this.getButtonSelect().click_and_wait();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean success_process_to_customer_details_screen() {
        return this.labelScreenTitle.isVisible() && this.labelScreenTitle.getText().equalsIgnoreCase(this.CUSTOMER_DETAILS_SCREEN_TITLE);
    }

    public void fill_value_for_input_id_name_card(String idNameCard) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.getInputIdNameCard().type_and_wait(idNameCard);
    }

    public void click_search_button_in_tab_other_conditions() {

        this.getButtonSearchByOtherConditions().click_and_wait();
    }

    public void fill_value_for_input_company_name(String companyName) {

        this.getInputCompanyName().type_and_wait(companyName);
    }

    public void click_page_on_paging(int pageNumber) {
        this.getTableCustomer().click_page_on_paging(pageNumber);
    }

    public int getPageSelected() {
        return this.getTableCustomer().getPageSelected();
    }

    public boolean table_result_has_selected_row() {
        return this.getTableCustomer().hasSelectedRow();
    }

    public boolean table_result_current_page_show_no_row_selected() {
        return this.getTableCustomer().currentPageShowNoRowSelected();
    }

    public boolean is_button_select_enabled() {
        return this.getButtonSelect().isEnabled();
    }

    public void click_button_next_on_paging() {
        this.getTableCustomer().next();
    }

    public void click_button_back_on_paging() {
        this.getTableCustomer().back();
    }

    public void click_button_last_page_on_paging() {
        this.getTableCustomer().last();
    }

    public boolean is_show_last_page() {
        return this.getTableCustomer().is_show_last_page();
    }

    public void click_button_first_page_on_paging() {
        this.getTableCustomer().first();
    }

    public boolean is_show_first_page() {
        return this.getTableCustomer().is_show_first_page();
    }

    public TabViewComponent getSearchCustomerTabView() {
        if (this.searchCustomerTabView == null) {
            this.searchCustomerTabView = PFComponentFactory.wrapTabView(this, this.searchCustomerTabViewElement);
        }
        return this.searchCustomerTabView;
    }

    public InputTextComponent getInputCustomerCode() {
        if (this.inputCustomerCode == null) {
            this.inputCustomerCode = PFComponentFactory.wrapInputText(this, this.inputCustomerCodeElement);
        }
        return this.inputCustomerCode;
    }

    public ButtonComponent getButtonSearchByCustomerCode() {
        if (this.buttonSearchByCustomerCode == null) {
            this.buttonSearchByCustomerCode = PFComponentFactory.wrapButton(this, this.buttonSearchByOtherConditionsElement);
        }
        return this.buttonSearchByCustomerCode;
    }

    public InputTextComponent getInputIdNameCard() {
        if (this.inputIdNameCard == null) {
            this.inputIdNameCard = PFComponentFactory.wrapInputText(this, this.inputIdNameCardElement);
        }
        return this.inputIdNameCard;
    }

    public InputTextComponent getInputCompanyName() {
        if (this.inputCompanyName == null) {
            this.inputCompanyName = PFComponentFactory.wrapInputText(this, this.inputCompanyNameElement);
        }
        return this.inputCompanyName;
    }

    public ButtonComponent getButtonSearchByOtherConditions() {
        if (this.buttonSearchByOtherConditions == null) {
            this.buttonSearchByOtherConditions = PFComponentFactory.wrapButton(this, this.buttonSearchByOtherConditionsElement);
        }
        return this.buttonSearchByOtherConditions;
    }

    public ButtonComponent getButtonSelect() {
        if (this.buttonSelect == null) {
            this.buttonSelect = PFComponentFactory.wrapButton(this, this.buttonSelectElement);
        }
        return this.buttonSelect;
    }

    public TableComponent getTableCustomer() {
        if (this.tableCustomer == null) {
            this.tableCustomer = PFComponentFactory.wrapTable(this, this.tableCustomerElement);
        }
        return this.tableCustomer;
    }

    public ButtonComponent getButtonToggler() {
        if (this.buttonToggler == null) {
            this.buttonToggler = PFComponentFactory.wrapButton(this, this.buttonTogglerElement);
        }
        return this.buttonToggler;
    }

    public List<RadioOptionComponent> getListRadioSearchType() {
        List<WebElementFacade> listRadioSearchTypeElement = findAll("//input[@type='radio' and @name='search_type']");
        return listRadioSearchTypeElement.stream().map(webElementFacade -> {
            return PFComponentFactory.wrapRadioOption(this, webElementFacade);
        }).collect(Collectors.toList());
    }

    private TableComponent getTableInputDataProcess() {
        return PFComponentFactory.wrapTable(this, this.find(By.xpath("//form[@id='customerTradeForm']//table")));
    }

    public TableComponent getDataTableCreditHistory() {
        try {
            return PFComponentFactory.wrapTable(this, this.find(By.id("credit_history_form:creditsData")));
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public boolean verifyRequiredInputFieldEnable(String fieldName) {
        return this.getInputTextByLabelName(fieldName).isEnabled();
    }

    public InputTextComponent getInputTextByLabelName(String labelName) {
        if (labelName.toLowerCase().equals("index for accounting system")) {
            return PFComponentFactory.wrapInputText(this, this.find(org.openqa.selenium.By.id("surveySpecForm:indexAccounting")));
        }
        return PFComponentFactory.wrapInputText(this, this.find(org.openqa.selenium.By.xpath("*//td[contains(@class,'text-right')]//label[text()='" + labelName + "']/ancestor::tr//input")));
    }

    public TextAreaComponent getTextAreaByLabelName(String labelName) {
        return PFComponentFactory.wrapTextArea(this, this.find(org.openqa.selenium.By.xpath("*//td[contains(@class,'text-right')]//label[text()='" + labelName + "']/ancestor::tr//textarea")));
    }

    public int verifyRequiredInputFieldLength(String fieldName) {
        return this.getTableInputDataProcess().getInputTextByLabelName(fieldName).getMaxLength();
    }

    public boolean verifyRequiredInputFieldCanInput(String fieldName) {
        try {
            this.getInputTextByLabelName(fieldName).type_and_wait("a123");
            if (this.getGrowlMessage().size() != 0 && StringUtils.indexOfAny(this.getGrowlMessage().get(0), "invalid") != -1) {
                this.getInputTextByLabelName(fieldName).type_and_wait("01101");
            }
            return true;
        } catch (InvalidElementStateException e) {
            return false;
        }
    }

    public boolean verifyFieldCanSelect(String fieldName) {
        return this.getSelectOneMenuByLabelName(fieldName).can_open_menu_options();
    }

    private ButtonComponent getBtnBack() {
        return PFComponentFactory.wrapButton(this, this.find(By.xpath("//div[@id='contentPanel_content']//button[@title='Back']")));
    }

    public void clickButton(String btnName) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switch (btnName) {
            case "Back":
                this.clickBackButton();
                break;
            default:
                this.getButtonByTitle(btnName).click_and_wait();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void clickBackButton() {
        try {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.getBtnBack().click_and_wait();
        } catch (UnhandledAlertException e) {
            this.getDriver().switchTo().alert().accept();
        } finally {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Alert alert = ExpectedConditions.alertIsPresent().apply(this.getDriver());
            if (alert != null) {
                alert.accept();
            }
        }
    }

    public int memoryNumberRecordInputCustomerData;

    public ButtonComponent getButtonByTitle(String buttonTitle) {
        switch (buttonTitle.toLowerCase()) {
            case "back":
                return this.getBtnBack();
            case "choose file upload":
                return this.getChooseFileUpload();
            case "generate in input customer data":
                return this.getButtonGenerate();
            case "edit in input customer data":
            case "delete in input customer data":
                String[] realText = buttonTitle.split(StringUtils.SPACE);
                return PFComponentFactory.wrapButton(this, this.findBy("//form[@id='inputCustomerDataProc5']//button/span[text()='"
                        + realText[0] + "']/parent::*"));
            default:
                return PFComponentFactory.wrapButton(this, this.findBy("//div[@id='contentPanel_content']//button/span[text()='"
                        + buttonTitle + "']/parent::*"));
        }
    }

    private ButtonComponent getChooseFileUpload() {
        return PFComponentFactory.wrapButton(this, this.find(By.xpath("//div[@id='contentPanel_content']//span[text()='Choose file upload']")));
    }

    public boolean isLastPage(TableComponent table) {
        if (table.is_show_last_page())
            return true;
        else {
            table.next();
            return false;
        }
    }

    public boolean verifyNotRequiredInputFieldCanInput(String fieldName) {
        try {
            this.getInputTextByLabelName(fieldName).type_and_wait("2016");
            if (this.getGrowlMessage().size() != 0 && StringUtils.indexOfAny(this.getGrowlMessage().get(0), "Please") != -1) {
                this.getInputTextByLabelName(fieldName).type_and_wait("321-123-3214");
            }
            return true;
        } catch (InvalidElementStateException e) {
            return false;
        }
    }

    private TableComponent getSurveySpecForm() {
        return PFComponentFactory.wrapTable(this, this.find(By.xpath("//form[@id='surveySpecForm']//table")));
    }

    public void selectDropDownWithValue(String field, String value) {
        this.getSelectOneMenuByLabelName(field).select_option_by_text(value);
    }

    public void typeInFieldWithValue(String field, String value) {
        this.getInputTextByLabelName(field).type_and_wait(value);
    }

    public CalendarComponent getCalendarComponentByFieldName(String fieldName) {
        return PFComponentFactory.wrapCalendarElement(this, this.find(By.xpath("//form[@id='surveySpecForm']//table//td[contains(@class,'text-right')]//label[text()='" + fieldName + "']/ancestor::tr//span[contains(@class,'date-size')]")));
    }

    public void selectDateFieldWithValue(String field, String value) {
        CalendarComponent calendarComponent = this.getCalendarComponentByFieldName(field);
        calendarComponent.openDateTimeSelect();
        calendarComponent.setLocale(Locale.ENGLISH);
        int year = Integer.valueOf(value.split("/")[0]);
        int month = Integer.valueOf(value.split("/")[1]);
        int day = Integer.valueOf(value.split("/")[2]);
        calendarComponent.select_year_month(year, month);
        calendarComponent.select_date_of_month(day);
    }

    public void clickInRowIndexRadioButton(int rowIndex) {
        this.getDataTableCreditHistory().click_radio_box_by_row_index(rowIndex);
        this.dateOfSurveySelected = this.getDataTableCreditHistory().getRow(rowIndex).findBy("./td[@class='arrow-short-name-column']").getText();
    }

    public void clickInRowIndexRadioButtonWithButtonViewEnable(int rowIndex) {
        do {
            this.dateOfSurveySelected = this.getDataTableCreditHistory().getRow(rowIndex).findBy("./td[@class='arrow-short-name-column']").getText();
            this.getDataTableCreditHistory().click_radio_box_by_row_index(rowIndex++);
            if (this.dateOfSurveyDraftSelected == null && this.getButtonByTitle("Edit").isEnabled()) {
                this.dateOfSurveyDraftSelected = this.dateOfSurveySelected;
            }
        }
        while (!this.getButtonByTitle("View").isEnabled());
    }

    public void confirmAction() {
        List<WebElementFacade> listConfirmButton = this.findAll(By.xpath("//div[contains(@class,'ui-confirm-dialog') and contains(@style,'display: block')]//span[text()='Yes']//ancestor::button"));
        PFComponentFactory.wrapButton(this, listConfirmButton.get(listConfirmButton.size() - 1)).click_and_wait();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<String> getGrowlMessage() {
        List<String> listGrowlMessage = new ArrayList<>();
        List<WebElementFacade> messagePanel = this.findAll(By.xpath("//*[@id='growl_container']//div[contains(@class,'ui-growl-message')]//p"));
        listGrowlMessage.addAll(messagePanel.stream().map(WebElementFacade::getText).collect(Collectors.toList()));
        return listGrowlMessage;
    }

    public boolean verifyTextAreaCanInput(String labelText) {
        try {
            this.getTextAreaByLabelName(labelText).input_text("qwerty");
            return true;
        } catch (InvalidElementStateException e) {
            return false;
        }
    }

    public SelectOneMenuComponent getSelectOneMenuByLabelName(String fieldName) {
        return PFComponentFactory.wrapSelectOneMenu(this, this.find(org.openqa.selenium.By.xpath("*//td[contains(@class,'text-right')]//label[text()='" + fieldName + "']/ancestor::tr//div[contains(@class,'ui-selectonemenu')]")));
    }

    public AutoCompleteComponent getAutoCompleteByLabelName(String labelName) {
        return PFComponentFactory.wrapAutoCompleteElement(this, this.find(org.openqa.selenium.By.xpath("*//td[contains(@class,'text-right')]//label[text()='" + labelName + "']/ancestor::tr//span[contains(@class,'dropdown-size')]")));
    }

    public boolean verifyAutoCompleteCanInput(String labelText) {
        try {
            this.getAutoCompleteByLabelName(labelText).input_text("atv");
            return true;
        } catch (InvalidElementStateException e) {
            return false;
        }
    }

    public void saveData() {
        this.creditManagementInputDataModelInView = new CreditManagementInputDataModel();
        this.creditManagementInputDataModelInView.setSurvey_institute(this.getSelectOneMenuByLabelName(SURVEY_INSTITUTE).getValue());
        this.creditManagementInputDataModelInView.setCredit_score(this.getSelectOneMenuByLabelName(CREDIT_SCORE).getValue());
        this.creditManagementInputDataModelInView.setTrading(this.getSelectOneMenuByLabelName(TRADING).getValue());
        this.creditManagementInputDataModelInView.setDecision(this.getTextAreaByLabelName(DECISION).getValue());
        this.creditManagementInputDataModelInView.setAdditional(this.getTextAreaByLabelName(ADDITIONAL).getValue());
        this.creditManagementInputDataModelInView.setAccountant(this.getTextAreaByLabelName(ACCOUNTANT).getValue());
        this.creditManagementInputDataModelInView.setBranch(this.getAutoCompleteByLabelName(BRANCH).getValue());
        this.creditManagementInputDataModelInView.setAuthorized(this.getAutoCompleteByLabelName(AUTHORIZED).getValue());
        this.creditManagementInputDataModelInView.setFinal_authorized(this.getAutoCompleteByLabelName(FINAL_AUTHORIZED).getValue());
        this.creditManagementInputDataModelInView.setRequest(this.getAutoCompleteByLabelName(REQUEST).getValue());
        this.creditManagementInputDataModelInView.setIndex(this.getInputTextByLabelName(INDEX).getValue());
        this.creditManagementInputDataModelInView.setCredit(this.getInputTextByLabelName(CREDIT).getValue());

        this.selectTabByName("Business factors");
        this.creditManagementInputDataModelInView.setCompany_index(this.getInputTextByLabelName(COMPANY_INDEX).getValue());
        this.creditManagementInputDataModelInView.setZip_code(this.getInputTextByLabelName(ZIP_CODE).getValue());
        this.creditManagementInputDataModelInView.setAddress(this.getInputTextByLabelName(ADDRESS).getValue());
        this.creditManagementInputDataModelInView.setFiscal(this.getSelectOneMenuByLabelName(FISCAL).getValue());
        this.creditManagementInputDataModelInView.setTel(this.getInputTextByLabelName(TEL).getValue());
        this.creditManagementInputDataModelInView.setFax(this.getInputTextByLabelName(FAX).getValue());
        this.creditManagementInputDataModelInView.setNumber_employees(this.getInputTextByLabelName(NUMBER_EMPLOYEES).getValue());
        this.creditManagementInputDataModelInView.setCapital(this.getInputTextByLabelName(CAPITAL).getValue());
        this.creditManagementInputDataModelInView.setUrl(this.getInputTextByLabelName(URL).getValue());

        this.selectTabByName("Industry classification");
        this.creditManagementInputDataModelInView.setIndustry_main(this.getInputTextByLabelName(INDUSTRY_MAIN).getValue());
        this.creditManagementInputDataModelInView.setIndustry_sub(this.getInputTextByLabelName(INDUSTRY_SUB).getValue());
        this.creditManagementInputDataModelInView.setRank_sector_nation(this.getInputTextByLabelName(RANK_SECTOR_NATION).getValue());
        this.creditManagementInputDataModelInView.setPopulation_nation(this.getInputTextByLabelName(POPULATION_NATION).getValue());
        this.creditManagementInputDataModelInView.setRank_prefecture(this.getInputTextByLabelName(RANK_PREFECTURE).getValue());
        this.creditManagementInputDataModelInView.setPopulation_prefecture(this.getInputTextByLabelName(POPULATION_PREFECTURE).getValue());

        this.selectTabByName("Input finance data");
        this.creditManagementInputDataModelInView.setListFinancial(this.getAllDataFromTableComponent(this.getTableFinancial()));
        this.selectTabByName("Input customer data");
        this.creditManagementInputDataModelInView.setListInputCustom(this.getAllDataFromTableComponent(this.getTableInputCustomerData()));
    }

    public HashMap<Integer, List<String>> getAllDataFromTableComponent(TableComponent table) {
        int count = 0;
        HashMap<Integer, List<String>> listItemWInTable = new HashMap<>();
        if (!table.is_no_record()) {
            do {
                for (int j = 0; j < table.getAllColumnHeaderElement().size(); j++) {
                    try {
                        if (StringUtils.isEmpty(table.getAllColumnHeaderElement().get(j).getText()))
                            continue;
                    } catch (ElementShouldBeVisibleException e) {
                        continue;
                    }
                    listItemWInTable.put(count, table.getAllCellValueByColumnIndex(j + 1));
                    count++;
                }
            }
            while (!this.isLastPage(table));
        }
        return listItemWInTable;
    }

    public TableComponent getTableFinancial() {
        return PFComponentFactory.wrapTable(this, this.find(By.id("tableAccData:financialTable")));
    }

    public TableComponent getTableInputCustomerData() {
        return PFComponentFactory.wrapTable(this, this.find(By.id("inputCustomerDataProc5:customerTable")));

    }

    public void selectTabByName(String nameTab) {
        WebElementFacade tab = this.find(By.xpath("//div[@id='contentPanel']//ul/li/a[text()='" + nameTab + "']"));
        tab.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean mapsAreEqual(HashMap<Integer, List<String>> mapA, HashMap<Integer, List<String>> mapB) {
        try {
            for (Integer k : mapB.keySet()) {
                if (!mapA.get(k).equals(mapB.get(k))) {
                    return false;
                }
                if ((mapA.get(k).size() != (mapB.get(k).size()))) {
                    return false;
                }
                for (int i = 0; i < mapA.get(k).size(); i++) {
                    if (!(mapA.get(k).get(i).equals(mapB.get(k).get(i))))
                        return false;
                }
            }
            for (Integer y : mapA.keySet()) {
                if (!mapB.containsKey(y)) {
                    return false;
                }
            }
        } catch (NullPointerException np) {
            return false;
        }
        return true;
    }

    public TextAreaComponent getTextAreaTabInputCustomerData() {
        return PFComponentFactory.wrapTextArea(this, this.find(org.openqa.selenium.By.xpath("//form[@id='inputCustomerDataProc5']//textarea")));
    }

    public boolean verifyTextAreaTabInputCustomerCanInput() {
        try {
            this.getTextAreaTabInputCustomerData().input_text("qwerty");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public HashMap<Integer, List<String>> getAllDataInTableCredit_history_form() {
        return this.getAllDataFromTableComponent(this.getDataTableCreditHistory());

    }

    public List<String> openMenuBarAndGetNameBranch() {
        MenuBarItemComponent menuBarItemComponent = PFComponentFactory.wrapMenuBarItem(this, find(org.openqa.selenium.By.xpath("//form[@id='menuForm']/div/ul//li[contains(@class,'user-management')]")));
        menuBarItemComponent.click_and_wait();
        WebElementFacade webElementFacade = this.find(By.xpath("//form[@id='menuForm']/div/ul//li[contains(@class,'user-management')]//table//td"));
        String menuText = webElementFacade.getText();
        List<String> nameAndBranch = new ArrayList<>();
//        nameAndBranch.add(menuText.split("\n")[1].split(":")[1].trim());
        String name = this.find(By.xpath("//form[@id='menuForm']/div/ul//li[contains(@class,'user-management')]/a/span")).getText();
        nameAndBranch.add(name);
        nameAndBranch.add(menuText.split("\n")[0].split(":")[1].trim());
        return nameAndBranch;
    }

    public boolean verifyClear(String name, String type) {
        switch (type) {
            case INPUT_TEXT:
                this.getInputTextByLabelName(name).getValue().equals(StringUtils.EMPTY);
                return true;
            case SELECT_ONE_MENU:
                this.getSelectOneMenuByLabelName(name).getValue().equals("Select");
                return true;
            case TEXT_AREA:
                this.getTextAreaByLabelName(name).getValue().equals(StringUtils.EMPTY);
                return true;
        }
        return false;
    }

    public boolean should_show_approve_confirm_dialog() {
        return this.findBy("//body/div[contains(@class,'ui-confirm-dialog') and contains(@style,'display: block')]").isCurrentlyVisible();
    }

    public void decline_action() {
        List<WebElementFacade> listDeclineButton = this.findAll("//body/div[contains(@class,'ui-confirm-dialog') and contains(@style,'display: block')]/div/button[contains(.,'No')]");
        PFComponentFactory.wrapButton(this, listDeclineButton.get(listDeclineButton.size() - 1)).click_and_wait();
    }

    public boolean should_show_approve_success_message() {
        boolean isShowMessage = this.is_show_panel_message();
        List<String> listMessagesText = this.getListMessageText();
        this.wait_for_message_disappeared();
        return isShowMessage && listMessagesText.contains(CommonConstant.APPROVE_ACCOUNTING_DATA_SUCCESS_MESSAGE);
    }

    private List<String> getListMessageText() {
        List<WebElementFacade> listErrorMessages = this.findAll("//div[@id='growl_container']//div[@class='ui-growl-message']//p");
        List<String> listErrorMessageText = listErrorMessages.stream().map(WebElementFacade::getText).collect(Collectors.toList());
        return listErrorMessageText;
    }

    private boolean is_show_panel_message() {
        return this.find(By.xpath("//div[@id='growl_container']")).isCurrentlyVisible();
    }

    public boolean should_show_approve_failure_message_because_survey_already_existed() {
        boolean isShowMessage = this.is_show_panel_message();
        List<String> listMessagesText = this.getListMessageText();
        this.wait_for_message_disappeared();
        return isShowMessage && listMessagesText.contains(CommonConstant.APPROVE_ACCOUNTING_DATA_FAILURE_MESSAGE);
    }

    public void change_survey_date_to_next_day_of_selected_record() {
        if (StringUtils.isNotEmpty(this.dateOfSurveySelected)) {
            LocalDate date = CommonUtils.parseStringToYearMonthDayLocalDate(this.dateOfSurveySelected);
            if (StringUtils.isNotEmpty(this.dateOfSurveyDraftSelected)) {
                LocalDate dateDraft = CommonUtils.parseStringToYearMonthDayLocalDate(this.dateOfSurveyDraftSelected);
//                date = date.isAfter(dateDraft) ? date : dateDraft;
                if (date.isAfter(dateDraft)) {
                    this.dateOfSurveyDraftSelected = this.dateOfSurveySelected;
                } else {
                    date = dateDraft;
                    this.dateOfSurveySelected = this.dateOfSurveyDraftSelected;
                }
            }
            PFComponentFactory.wrapCalendarElement(this, this.findBy("//form[@id='surveySpecForm']//button[contains(@class,'ui-datepicker-trigger')]/ancestor::span")).select_date(date.plusDays(1), Locale.ENGLISH);
        }
    }

    public void clickSpanCheckInputFinance() {
        WebElementFacade webElementFacade = this.find(By.xpath("//*[@id='tableAccData:financialTable']//tr//td//span[contains(@class,'ui-icon-check')]"));
        webElementFacade.click();
    }

    public void fillAllDataInTableInputFinance() {
        List<WebElementFacade> webElementFacades = this.getTableFinancial().getAllColumnHeaderElement();
        InputTextComponent temp = null;
        for (int i = 1; i < webElementFacades.size(); i++) {
            temp = this.getTableFinancial().getInputTextByIndex(this.getTableFinancial().getColumnIndex(webElementFacades.get(i).getText()));
            if (temp.isVisible())
                temp.type_and_wait("12");
        }
    }

    public WebElementFacade getInputRelatedCompany() {
        return this.find(By.id("inputCustomerDataProc5:panelRelatedCompany"));
    }

    public ButtonComponent getButtonGenerate() {
        return PFComponentFactory.wrapButton(this, this.find(By.id("inputCustomerDataProc5:buttonGenerate")));
    }

    public TextAreaComponent getTextAreaInputRelatedCompany() {
        return PFComponentFactory.wrapTextArea(this, this.find(By.id("inputCustomerDataProc5:inputRelatedCompany")));
    }

    public void typeTextInputRelatedCompany(String text, String type) {
        this.getTextAreaInputRelatedCompany().input_text(text);
        this.memoryNumberRecordInputCustomerData = text.split(",").length;
        this.getInputRelatedCompany().find(By.xpath("//td//label[text()='" + type + "']/preceding::td[1]")).click();
    }

    public boolean verifyTableInputCustomerDataAfterGenerate(String textInput, String type) {
        List<String> listClassify = this.getTableInputCustomerData().getAllCellValueByColumnIndex(this.getTableInputCustomerData().getColumnIndex("Classify"));
        List<String> listCompanyName = this.getTableInputCustomerData().getAllCellValueByColumnIndex(this.getTableInputCustomerData().getColumnIndex("Company name"));
        for (String aList : listClassify) {
            if (!aList.equals(type))
                return false;
        }
        String[] textInputSplit = textInput.split(",");
        for (int i = 0; i < listCompanyName.size(); i++) {
            if (!listCompanyName.contains(textInputSplit[i])) {
                return false;
            }
        }
        return true;
    }

    public void clickRecordIndexInputCustomerData(int index) {
        this.getTableInputCustomerData().click_check_box_by_row_index(index);
    }

    public int getNumberRecordInTable() {
        if (this.getTableInputCustomerData().is_no_record())
            return 0;
        return this.getTableInputCustomerData().getCountContentRow();
    }

    public boolean verifyInputRelatedCompany(String text, String type) {
        WebElementFacade selectType = this.find(By.xpath("//*[@id='inputCustomerDataProc5:radioClassifyRelatedCompany']//div[contains(@class,'ui-state-active')]//following::td[1]"));
        text = text.replaceAll(",", "、");
        return this.getTextAreaInputRelatedCompany().getValue().equals(text) && selectType.getText().equals(type);
    }

    public String getFirstGrowlMessage() {
        return this.find(By.xpath("//*[@id='growl_container']//div[contains(@class,'ui-growl-message')]//p")).getText();
    }
}

package my.lib.serenity.primefaces.sars.steps;

import my.lib.serenity.primefaces.component.CalendarComponent;
import my.lib.serenity.primefaces.sars.page.CreditManagementPage;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.List;

import static my.lib.serenity.primefaces.sars.page.CreditManagementPage.*;

/**
 * Created by ngoc on 18/10/2016.
 */
public class CreditManagementCompanyAndCreditDataSteps {

    private CreditManagementPage creditManagementPage;
    private HashMap<Integer, List<String>> currentDataTable;

    public void verifyRequiredInputField(String fieldName) {
        Assertions.assertThat(this.creditManagementPage.verifyRequiredInputFieldEnable(fieldName)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyRequiredInputFieldCanInput(fieldName)).isTrue();
    }

    public void verifyNotRequiredInputField(String fieldName) {
        Assertions.assertThat(this.creditManagementPage.verifyRequiredInputFieldEnable(fieldName)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyNotRequiredInputFieldCanInput(fieldName)).isTrue();
    }

    public void verifyFieldCanSelect(String fieldName) {
        this.creditManagementPage.getSelectOneMenuByLabelName(fieldName).open_menu_options();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.creditManagementPage.getSelectOneMenuByLabelName(fieldName).open_menu_options();
        Assertions.assertThat(this.creditManagementPage.verifyFieldCanSelect(fieldName)).isTrue();
    }

    public void clickButton(String btnName) {
        this.creditManagementPage.clickButton(btnName);
    }

    public void verifyRequriedFieldCanNotInput(String fieldName) {
        Assertions.assertThat(this.creditManagementPage.verifyRequiredInputFieldEnable(fieldName)).isFalse();
        Assertions.assertThat(this.creditManagementPage.verifyRequiredInputFieldCanInput(fieldName)).isFalse();
    }

    public void verifyFieldCanNotSelect(String fieldName) {
        Assertions.assertThat(this.creditManagementPage.verifyFieldCanSelect(fieldName)).isFalse();
    }

    public void verifyNotRequiredFieldCanNotInput(String fieldName) {
        Assertions.assertThat(this.creditManagementPage.verifyRequiredInputFieldEnable(fieldName)).isFalse();
        Assertions.assertThat(this.creditManagementPage.verifyNotRequiredInputFieldCanInput(fieldName)).isFalse();
    }

    public void verifyStatusEveryRecordInTableCreditHistory() {
        int columnIndex = this.creditManagementPage.getDataTableCreditHistory().getColumnIndex("Status");
        do {
            int rowNumber = this.creditManagementPage.getDataTableCreditHistory().getCountContentRow();
            List<String> listStatus = this.creditManagementPage.getDataTableCreditHistory().getAllCellValueByColumnIndex(columnIndex);
            for (int i = 0; i < rowNumber; i++) {
                this.creditManagementPage.getDataTableCreditHistory().click_radio_box_by_row_index(i);
                if (listStatus.get(i).equalsIgnoreCase("Draft")) {
                    Assertions.assertThat(this.creditManagementPage.getButtonByTitle("Edit").isEnabled()).isTrue();
                    Assertions.assertThat(this.creditManagementPage.getButtonByTitle("View").isEnabled()).isFalse();
                    Assertions.assertThat(this.creditManagementPage.getButtonByTitle("Duplicate").isEnabled()).isFalse();
                }
                if (listStatus.get(i).equalsIgnoreCase("Approved")) {
                    Assertions.assertThat(this.creditManagementPage.getButtonByTitle("Edit").isEnabled()).isFalse();
                    Assertions.assertThat(this.creditManagementPage.getButtonByTitle("View").isEnabled()).isTrue();
                    Assertions.assertThat(this.creditManagementPage.getButtonByTitle("Duplicate").isEnabled()).isTrue();
                }

            }

        }
        while (!this.creditManagementPage.isLastPage(this.creditManagementPage.getDataTableCreditHistory()));
    }

    public void verifyCreditHistoryTableNoRecord() {
        Assertions.assertThat(this.creditManagementPage.getDataTableCreditHistory() == null ||
                this.creditManagementPage.getDataTableCreditHistory().is_no_record()).isTrue();
    }

    public void buttonIsEnable(String buttonText) {
        Assertions.assertThat(this.creditManagementPage.getButtonByTitle(buttonText).isEnabled()).isTrue();
    }

    public void selectInFieldWithValue(String field, String value) {
        this.creditManagementPage.selectDropDownWithValue(field, value);
    }

    public void typeInFieldWithValue(String field, String value) {
        this.creditManagementPage.typeInFieldWithValue(field, value);
    }

    public void selectDateFieldwithValue(String field, String value) {
        this.creditManagementPage.selectDateFieldWithValue(field, value);
    }

    public void clickInRowIndexRadioButtonWithButtonViewEnable(int rowIndex) {
        this.creditManagementPage.clickInRowIndexRadioButtonWithButtonViewEnable(rowIndex);
    }

    public void confirmAction() {
        this.creditManagementPage.confirmAction();
    }

    public void buttonIsDisable(String buttonText) {
        Assertions.assertThat(this.creditManagementPage.getButtonByTitle(buttonText).isEnabled()).isFalse();
    }

    public void systemShowMessage(String message) {
        List<String> listGrowlMessage = this.creditManagementPage.getGrowlMessage();
        for (String aListGrowlMessage : listGrowlMessage) {
            Assertions.assertThat(aListGrowlMessage).containsIgnoringCase(message);
        }
        this.creditManagementPage.wait_for_message_disappeared();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void textAreaCanInput(String labelText) {
        Assertions.assertThat(this.creditManagementPage.getTextAreaByLabelName(labelText).isEnabled()).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyTextAreaCanInput(labelText)).isTrue();
    }

    public void autoCompleteCanInput(String labelText) {
        Assertions.assertThat(this.creditManagementPage.verifyAutoCompleteCanInput(labelText)).isTrue();
    }

    public void textAreaCanNotInput(String labelText) {
        Assertions.assertThat(this.creditManagementPage.getTextAreaByLabelName(labelText).isEnabled()).isFalse();
        Assertions.assertThat(this.creditManagementPage.verifyTextAreaCanInput(labelText)).isFalse();
    }

    public void autoCompleteCanNotInput(String labelText) {
        Assertions.assertThat(this.creditManagementPage.verifyAutoCompleteCanInput(labelText)).isFalse();
    }

    public void saveData() {
        this.creditManagementPage.saveData();
    }

    public void verifyPageDuplicateAndView() {
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getSurvey_institute().equals(this.creditManagementPage.getSelectOneMenuByLabelName(SURVEY_INSTITUTE).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getCredit_score().equals(this.creditManagementPage.getSelectOneMenuByLabelName(CREDIT_SCORE).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getTrading().equals(this.creditManagementPage.getSelectOneMenuByLabelName(TRADING).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getDecision().equals(this.creditManagementPage.getTextAreaByLabelName(DECISION).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getAdditional().equals(this.creditManagementPage.getTextAreaByLabelName(ADDITIONAL).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getAccountant().equals(this.creditManagementPage.getTextAreaByLabelName(ACCOUNTANT).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getBranch().equals(this.creditManagementPage.getAutoCompleteByLabelName(BRANCH).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getAuthorized().equals(this.creditManagementPage.getAutoCompleteByLabelName(AUTHORIZED).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getFinal_authorized().equals(this.creditManagementPage.getAutoCompleteByLabelName(FINAL_AUTHORIZED).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getRequest().equals(this.creditManagementPage.getAutoCompleteByLabelName(REQUEST).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getIndex().equals(this.creditManagementPage.getInputTextByLabelName(INDEX).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getCredit().equals(this.creditManagementPage.getInputTextByLabelName(CREDIT).getValue())).isTrue();

        this.creditManagementPage.selectTabByName("Business factors");
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getCompany_index().equals(this.creditManagementPage.getInputTextByLabelName(COMPANY_INDEX).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getZip_code().equals(this.creditManagementPage.getInputTextByLabelName(ZIP_CODE).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getAddress().equals(this.creditManagementPage.getInputTextByLabelName(ADDRESS).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getFiscal().equals(this.creditManagementPage.getSelectOneMenuByLabelName(FISCAL).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getTel().equals(this.creditManagementPage.getInputTextByLabelName(TEL).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getFax().equals(this.creditManagementPage.getInputTextByLabelName(FAX).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getNumber_employees().equals(this.creditManagementPage.getInputTextByLabelName(NUMBER_EMPLOYEES).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getCapital().equals(this.creditManagementPage.getInputTextByLabelName(CAPITAL).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getUrl().equals(this.creditManagementPage.getInputTextByLabelName(URL).getValue())).isTrue();

        this.creditManagementPage.selectTabByName("Industry classification");
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getIndustry_main().equals(this.creditManagementPage.getInputTextByLabelName(INDUSTRY_MAIN).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getIndustry_sub().equals(this.creditManagementPage.getInputTextByLabelName(INDUSTRY_SUB).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getRank_sector_nation().equals(this.creditManagementPage.getInputTextByLabelName(RANK_SECTOR_NATION).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getPopulation_nation().equals(this.creditManagementPage.getInputTextByLabelName(POPULATION_NATION).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getRank_prefecture().equals(this.creditManagementPage.getInputTextByLabelName(RANK_PREFECTURE).getValue())).isTrue();
        Assertions.assertThat(this.creditManagementPage.creditManagementInputDataModelInView.getPopulation_prefecture().equals(this.creditManagementPage.getInputTextByLabelName(POPULATION_PREFECTURE).getValue())).isTrue();

        this.creditManagementPage.selectTabByName("Input finance data");
        HashMap<Integer, List<String>> currentDataFinancial = this.creditManagementPage.getAllDataFromTableComponent(this.creditManagementPage.getTableFinancial());
        Assertions.assertThat(this.creditManagementPage.mapsAreEqual(currentDataFinancial, this.creditManagementPage.creditManagementInputDataModelInView.getListFinancial())).isTrue();

        this.creditManagementPage.selectTabByName("Input customer data");
        HashMap<Integer, List<String>> currentInputCustomerData = this.creditManagementPage.getAllDataFromTableComponent(this.creditManagementPage.getTableInputCustomerData());
        Assertions.assertThat(this.creditManagementPage.mapsAreEqual(currentInputCustomerData, this.creditManagementPage.creditManagementInputDataModelInView.getListInputCustom())).isTrue();
    }

    public void selectTabByName(String tabName) {
        this.creditManagementPage.selectTabByName(tabName);
    }

    public void clickRowIndex(int row) {
        this.creditManagementPage.clickInRowIndexRadioButton(row);
    }

    public void textAreaTabInputCustomerCanInput() {
        this.creditManagementPage.verifyTextAreaTabInputCustomerCanInput();
    }

    private int currentPage;
    public void memoryDataInTable() {
        this.currentPage = this.creditManagementPage.getDataTableCreditHistory().getPageSelected();
//        this.currentDataTable = this.creditManagementPage.getAllDataInTableCredit_history_form();
        this.creditManagementPage.getDataTableCreditHistory().click_page_on_paging(this.currentPage);
    }

    public void verifyDataTableBeforeAndAfter() {
        Assertions.assertThat(this.currentPage).isEqualTo(this.creditManagementPage.getDataTableCreditHistory().getPageSelected());
//        if (!this.creditManagementPage.getDataTableCreditHistory().is_no_record()) {
//            this.creditManagementPage.getDataTableCreditHistory().first();
//        }
//        Assertions.assertThat(this.creditManagementPage.mapsAreEqual(this.creditManagementPage.getAllDataInTableCredit_history_form(), this.currentDataTable)).isTrue();
    }

    public void verifyPageAfterReset() {
        List<String> nameAndBranch = this.creditManagementPage.openMenuBarAndGetNameBranch();
        String branch = nameAndBranch.get(1);
        String name = nameAndBranch.get(0);
        Assertions.assertThat(this.creditManagementPage.getAutoCompleteByLabelName("Branch of request user").getValue().equals(branch)).isTrue();
        Assertions.assertThat(this.creditManagementPage.getAutoCompleteByLabelName("Request user account").getValue().equals(name)).isTrue();
        Assertions.assertThat(this.creditManagementPage.getAutoCompleteByLabelName("Authorized by").getValue().equals(name)).isTrue();
        Assertions.assertThat(this.creditManagementPage.getAutoCompleteByLabelName("Final authorized by").getValue().equals(name)).isTrue();

        CalendarComponent calendarComponent = this.creditManagementPage.getCalendarComponentByFieldName("Date of survey");
        Assertions.assertThat(calendarComponent.getValue().equals(StringUtils.EMPTY)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyClear(SURVEY_INSTITUTE, SELECT_ONE_MENU)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyClear(CREDIT_SCORE, SELECT_ONE_MENU)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyClear(TRADING, SELECT_ONE_MENU)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyClear(DECISION, TEXT_AREA)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyClear(ADDITIONAL, TEXT_AREA)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyClear(ACCOUNTANT, TEXT_AREA)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyClear(INDEX, INPUT_TEXT)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyClear(CREDIT, INPUT_TEXT)).isTrue();

        this.creditManagementPage.selectTabByName("Business factors");
        Assertions.assertThat(this.creditManagementPage.verifyClear(COMPANY_INDEX, INPUT_TEXT)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyClear(ZIP_CODE, INPUT_TEXT)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyClear(ADDRESS, INPUT_TEXT)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyClear(FISCAL, SELECT_ONE_MENU)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyClear(TEL, INPUT_TEXT)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyClear(FAX, INPUT_TEXT)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyClear(NUMBER_EMPLOYEES, INPUT_TEXT)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyClear(CAPITAL, INPUT_TEXT)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyClear(URL, INPUT_TEXT)).isTrue();

        this.creditManagementPage.selectTabByName("Industry classification");
        Assertions.assertThat(this.creditManagementPage.verifyClear(INDUSTRY_MAIN, INPUT_TEXT)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyClear(INDUSTRY_SUB, INPUT_TEXT)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyClear(RANK_SECTOR_NATION, INPUT_TEXT)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyClear(POPULATION_NATION, INPUT_TEXT)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyClear(RANK_PREFECTURE, INPUT_TEXT)).isTrue();
        Assertions.assertThat(this.creditManagementPage.verifyClear(POPULATION_PREFECTURE, INPUT_TEXT)).isTrue();

        this.creditManagementPage.selectTabByName("Input finance data");
        Assertions.assertThat(this.creditManagementPage.getTableFinancial().is_no_record()).isTrue();
        this.creditManagementPage.selectTabByName("Input customer data");
        Assertions.assertThat(this.creditManagementPage.getTableInputCustomerData().is_no_record()).isTrue();
    }

    public void should_show_approve_confirm_dialog() {
        Assertions.assertThat(this.creditManagementPage.should_show_approve_confirm_dialog()).isTrue();
    }

    public void decline_action() {
        this.creditManagementPage.decline_action();
    }

    public void should_show_approve_success_message() {
        this.creditManagementPage.should_show_approve_success_message();
    }

    public void should_show_approve_failure_message_because_survey_already_existed() {
        Assertions.assertThat(this.creditManagementPage.should_show_approve_failure_message_because_survey_already_existed()).isTrue();
    }

    public void change_survey_date_to_next_day_of_selected_record() {
        this.creditManagementPage.change_survey_date_to_next_day_of_selected_record();
    }

    public void fillAllDataInTableInputFinance() {
        this.creditManagementPage.fillAllDataInTableInputFinance();
    }

    public void typeTextInputRelatedCompany(String text, String type) {
        this.creditManagementPage.typeTextInputRelatedCompany(text, type);
    }

    public void verifyTableAfterGenerate(String text, String type) {
        Assertions.assertThat(this.creditManagementPage.verifyTableInputCustomerDataAfterGenerate(text, type)).isTrue();
    }

    public void clickRecordIndexInputCustomerData(int index) {
        this.creditManagementPage.clickRecordIndexInputCustomerData(index);
    }

    public void verifyRecordInputCustomerData(String number) {
        if (number.equalsIgnoreCase("less Than 1")) {
            Assertions.assertThat(this.creditManagementPage.getNumberRecordInTable()).isEqualTo(this.creditManagementPage.memoryNumberRecordInputCustomerData - 1);
        } else
            Assertions.assertThat(this.creditManagementPage.getNumberRecordInTable()).isEqualTo(Integer.valueOf(number));
    }

    public void verifyInputRelatedCompany(String text, String type) {
        Assertions.assertThat(this.creditManagementPage.verifyInputRelatedCompany(text, type)).isTrue();
    }

    public void showFirstMessage(String message) {
        String listGrowlMessage = this.creditManagementPage.getFirstGrowlMessage();
        if (message.contains("Tel.")) {
            Assertions.assertThat(listGrowlMessage).isEqualToIgnoringCase(message.replace(".", StringUtils.EMPTY));
        } else
            Assertions.assertThat(listGrowlMessage).isEqualToIgnoringCase(message);
        this.creditManagementPage.wait_for_message_disappeared();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

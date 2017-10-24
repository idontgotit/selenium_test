package my.lib.serenity.primefaces.sars.definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my.lib.serenity.primefaces.sars.steps.CreditManagementCompanyAndCreditDataSteps;
import net.thucydides.core.annotations.Steps;

import java.util.List;

/**
 * Created by ngoc on 18/10/2016.
 */
public class CreditManagementCompanyAndCreditDataScenarioSteps {

    @Steps
    private CreditManagementCompanyAndCreditDataSteps creditManagementCompanyAndCreditDataSteps;

    @And("^In Credit Management page, fields required can input$")
    public void inCreditManagementPageFieldsRequiredCanInput(List<String> listLabel) throws Throwable {
        for (int i = 0; i < listLabel.size(); i++) {
            this.creditManagementCompanyAndCreditDataSteps.verifyRequiredInputField(listLabel.get(i));
        }
    }

    @And("^In Credit Management page, fields not required can input$")
    public void inCreditManagementPageFieldsNotRequiredCanInput(List<String> listLabel) throws Throwable {
        for (int i = 0; i < listLabel.size(); i++) {
            this.creditManagementCompanyAndCreditDataSteps.verifyNotRequiredInputField(listLabel.get(i));
        }
    }

    @And("^In Credit Management page, fields can select$")
    public void inCreditManagementPageFieldCanSelect(List<String> listLabel) throws Throwable {
        for (int i = 0; i < listLabel.size(); i++) {
            this.creditManagementCompanyAndCreditDataSteps.verifyFieldCanSelect(listLabel.get(i));
        }
    }

    @And("^In Credit Management page, I click button (.*)$")
    public void inCreditManagementPageIClickBack(String btnName) throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.clickButton(btnName);
    }

    @And("^In Credit Management page, fields required can not input$")
    public void inCreditManagementPageFieldsRequiredCanNotInput(List<String> listLabel) throws Throwable {
        for (int i = 0; i < listLabel.size(); i++) {
            this.creditManagementCompanyAndCreditDataSteps.verifyRequriedFieldCanNotInput(listLabel.get(i));
        }
    }

    @And("^In Credit Management page, fields can not select$")
    public void inCreditManagementPageFieldsCanNotSelect(List<String> listLabel) throws Throwable {
        for (int i = 0; i < listLabel.size(); i++) {
            this.creditManagementCompanyAndCreditDataSteps.verifyFieldCanNotSelect(listLabel.get(i));
        }
    }

    @And("^In Credit Management page, fields not required can not input$")
    public void inCreditManagementPageFieldsNotRequiredCanNotInput(List<String> listLabel) throws Throwable {
        for (int i = 0; i < listLabel.size(); i++) {
            this.creditManagementCompanyAndCreditDataSteps.verifyNotRequiredFieldCanNotInput(listLabel.get(i));
        }
    }

    @And("^In Credit Management page, I verify status edit, view, duplicate every record in table Credit History is true$")
    public void inCreditManagementPageIVerifyStatusEditViewDuplicateEveryRecordInTableIsTrue() throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.verifyStatusEveryRecordInTableCreditHistory();
    }

    @And("^In Credit Management page, Table Credit History no record$")
    public void inCreditManagementPageTableCreditHistoryNoRecord() throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.verifyCreditHistoryTableNoRecord();
    }

    @And("^In Credit Management page, System show list button can use$")
    public void inCreditManagementPageSystemShowListButtonCanUse(List<String> listBtnName) throws Throwable {
        for (int i = 0; i < listBtnName.size(); i++) {
            this.creditManagementCompanyAndCreditDataSteps.buttonIsEnable(listBtnName.get(i));
        }
    }

    @And("^In Credit Management page, I select in (.*) is (.*)$")
    public void inCreditManagementPageISelectInSurveySelectIsValueSurvey(String field, String value) throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.selectInFieldWithValue(field, value);
    }

    @And("^In Credit Management page, I type in (.*) is (.*)$")
    public void inCreditManagementPageITypeInIndexAccoutingIsValueIndexAccouting(String field, String value) throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.typeInFieldWithValue(field, value);
    }

    @And("^In Credit Management page, I select date in (.*) is (.*)$")
    public void inCreditManagementPageISelectDateInIndexSelectIsValueIndex(String field, String value) throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.selectDateFieldwithValue(field, value);
    }

    @And("^In Credit Management page, I click record (.*) in table Credit History in bottom with View enable$")
    public void inCreditManagementPageIClickRecordRowInTableCreditHistoryInBottom(int rowIndex) throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.clickInRowIndexRadioButtonWithButtonViewEnable(rowIndex);
    }

    @And("^In Credit Management page, I confirm action$")
    public void inCreditManagementPageIConfirmAction() throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.confirmAction();
    }

    @Then("^In Credit Management page, System show list button can not use$")
    public void inCreditManagementPageSystemShowListButtonCanNotUse(List<String> listBtnName) throws Throwable {
        for (int i = 0; i < listBtnName.size(); i++) {
            this.creditManagementCompanyAndCreditDataSteps.buttonIsDisable(listBtnName.get(i));
        }
    }

    @And("^In Credit Management page, System show message (.*)$")
    public void inCreditManagementPageSystemShowMessageSuccessDelete(String message) throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.systemShowMessage(message);
        Thread.sleep(1000);
    }

    @And("^In Credit Management page, textarea can input$")
    public void inCreditManagementPageTextareaCanInput(List<String> listLabel) throws Throwable {
        for (int i = 0; i < listLabel.size(); i++) {
            this.creditManagementCompanyAndCreditDataSteps.textAreaCanInput(listLabel.get(i));
        }
    }

    @And("^In Credit Management page, autocomplete fields can input$")
    public void inCreditManagementPageAutocompleteFieldsCanInput(List<String> listLabel) throws Throwable {
        for (int i = 0; i < listLabel.size(); i++) {
            this.creditManagementCompanyAndCreditDataSteps.autoCompleteCanInput(listLabel.get(i));
        }
    }

    @And("^In Credit Management page, textarea can not input$")
    public void inCreditManagementPageTextareaCanNotInput(List<String> listLabel) throws Throwable {
        for (int i = 0; i < listLabel.size(); i++) {
            this.creditManagementCompanyAndCreditDataSteps.textAreaCanNotInput(listLabel.get(i));
        }
    }

    @And("^In Credit Management page, autocomplete fields can not input$")
    public void inCreditManagementPageAutocompleteFieldsCanNotInput(List<String> listLabel) throws Throwable {
        for (int i = 0; i < listLabel.size(); i++) {
            this.creditManagementCompanyAndCreditDataSteps.autoCompleteCanNotInput(listLabel.get(i));
        }
    }

    @And("^In Credit Management page, I save data in this page$")
    public void inCreditManagementPageISaveDataInThisPage() throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.saveData();
    }

    @Then("^In Credit Management page, page Duplicate is same page View$")
    public void inCreditManagementPagePageDuplicateIsSamePageView() throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.verifyPageDuplicateAndView();
    }

    @When("^In Credit Management page, I select tab have name is (.*)$")
    public void inCreditManagementPageISelectTabHaveNameIsTabBussiness(String tabName) throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.selectTabByName(tabName);
    }

    @When("^In Credit Management page, I click record (.*) in table Credit History in bottom$")
    public void inCreditManagementPageIClickRecordRowIndexCreditHistoryInTableCreditHistoryInBottom(int row) throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.clickRowIndex(row);
    }

    @And("^In Credit Management page, tab Input customer data textarea can input$")
    public void inCreditManagementPageTabInputCustomerDataTextareaCanInput() throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.textAreaTabInputCustomerCanInput();
    }

    @And("^In Credit Management page, I memory data in table$")
    public void inCreditManagementPageIMemoryDataInTable() throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.memoryDataInTable();
    }

    @And("^In Credit Management page, data in table when back is same before$")
    public void inCreditManagementPageDataInTableWhenBackIsSameBefore() throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.verifyDataTableBeforeAndAfter();
    }

    @Then("^In Credit Management page, verify page after reset$")
    public void inCreditManagementPageVerifyPageAfterReset() throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.verifyPageAfterReset();
    }

    @Then("^The system should show approve confirm dialog$")
    public void then_the_system_should_show_approve_confirm_dialog() {
        this.creditManagementCompanyAndCreditDataSteps.should_show_approve_confirm_dialog();
    }

    @When("^In Credit Management page, I decline action$")
    public void when_in_credit_management_page_i_decline_action() {
        this.creditManagementCompanyAndCreditDataSteps.decline_action();
    }

    @Then("^The system should show approve failure message because survey already existed$")
    public void then_the_system_should_show_approve_failure_message_because_survey_already_existed() {
        this.creditManagementCompanyAndCreditDataSteps.should_show_approve_failure_message_because_survey_already_existed();
    }

    @Then("^The system should show approve success message$")
    public void then_the_system_should_show_approve_success_message() {
        this.creditManagementCompanyAndCreditDataSteps.should_show_approve_success_message();
    }

    @When("^In Credit Management page, I change survey date to next day of selected record$")
    public void when_in_credit_management_page_i_change_survey_date_to_next_day_of_selected_record() {
        this.creditManagementCompanyAndCreditDataSteps.change_survey_date_to_next_day_of_selected_record();
    }


    @And("^In Credit Management page, I type (.*) in Input related company and choose type is (.*)$")
    public void inCreditManagementPageITypeTextInputInInputRelatedCompany(String text, String type) throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.typeTextInputRelatedCompany(text, type);
    }

    @Then("^In Credit Management page, Table have data like (.*) and (.*)$")
    public void inCreditManagementPageTableHaveDataLikeTextInput(String text, String type) throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.verifyTableAfterGenerate(text, type);
    }

    @And("^In Credit Management page, I click record (.*) in table Input Customer Data$")
    public void inCreditManagementPageIClickRecordIndexInTableInputCustomerData(int index) throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.clickRecordIndexInputCustomerData(index);
    }

    @Then("^In Credit Management page, in table Input Customer Data have data is (.*) record$")
    public void inCreditManagementPageInTableInputCustomerDataHaveDataIsEmptyDataRecord(String number) throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.verifyRecordInputCustomerData(number);
    }

    @And("^In Credit Management page, in Input related company have (.*) and choose type is (.*)$")
    public void inCreditManagementPageInInputRelatedCompanyHaveTextInputAndChooseTypeIsTypeInput(String text, String type) throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.verifyInputRelatedCompany(text, type);
    }

    @Then("^In Credit Management page, System show first message (.*)$")
    public void inCreditManagementPageSystemShowFirstMessageSurveySelectIsRequired(String message) throws Throwable {
        this.creditManagementCompanyAndCreditDataSteps.showFirstMessage(message);
    }
}


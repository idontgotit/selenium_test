package my.lib.serenity.primefaces.sars.definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my.lib.serenity.primefaces.sars.steps.MaintainCreditDataSteps;
import net.thucydides.core.annotations.Steps;

import java.util.List;

/**
 * Created by ngoc on 04/11/2016.
 */
public class MaintainCreditDataScenarioSteps {

    @Steps
    private MaintainCreditDataSteps maintainCreditDataSteps;

    @And("^In Maintain credit data screen, System show list button can use$")
    public void inMaintainCreditDataScreenSystemShowListButtonCanUse(List<String> listName) throws Throwable {
        for (int i = 0; i < listName.size(); i++) {
            this.maintainCreditDataSteps.buttonIsEnable(listName.get(i));
        }
    }

    @And("^In Maintain credit data screen, I choose radio button have name is (.*)$")
    public void inMaintainCreditDataScreenIChooseRadioButtonHaveNameIsOtherConditions(String name) throws Throwable {
        this.maintainCreditDataSteps.clickRadioByName(name);
    }

    @And("^In Maintain credit data screen, System show field can input$")
    public void inMaintainCreditDataScreenSystemShowFieldCanInput(List<String> listField) throws Throwable {
        for (int i = 0; i < listField.size(); i++) {
            this.maintainCreditDataSteps.fieldCanInput(listField.get(i));
        }
    }

    @And("^In Maintain credit data screen, System show list button can not use$")
    public void inMaintainCreditDataScreenSystemShowListButtonCanNotUse(List<String> listName) throws Throwable {
        for (int i = 0; i < listName.size(); i++) {
            this.maintainCreditDataSteps.buttonIsDisable(listName.get(i));
        }
    }

    @And("^In Maintain credit data screen, System show field can not input$")
    public void inMaintainCreditDataScreenSystemShowFieldCanNotInput(List<String> listField) throws Throwable {
        for (int i = 0; i < listField.size(); i++) {
            this.maintainCreditDataSteps.fieldCanNotInput(listField.get(i));
        }
    }

    @And("^In Maintain credit data screen, I click button (.*)$")
    public void inMaintainCreditDataScreenIClickButtonSearchBtn(String btnName) throws Throwable {
        this.maintainCreditDataSteps.clickBtnByName(btnName);
    }

    @When("^In Maintain credit data screen, I type (.*) in input field have name is (.*)$")
    public void inMaintainCreditDataScreenITypeInvalidCustomerCodeInInputFieldHaveNameIsFieldCustomer(String input, String fieldname) throws Throwable {
        this.maintainCreditDataSteps.typeToInputField(input, fieldname);
    }

    @Then("^In Maintain credit data screen, Table below have (.*) record$")
    public void inMaintainCreditDataScreenTableBelowHaveNumberOfRecordRecord(int numberRc) throws Throwable {
        this.maintainCreditDataSteps.tableHaveNumberRecord(numberRc);
    }

    @Then("^In Maintain credit data screen, Table below have (.*) columns$")
    public void inMaintainCreditDataScreenTableBelowHaveNumberClmColumns(int numberClm) throws Throwable {
        this.maintainCreditDataSteps.tableHaveNumberClm(numberClm);
    }

    @And("^In Maintain credit data screen, I toggle all column$")
    public void inMaintainCreditDataScreenIToggleAllColumn(List<String> listClm) throws Throwable {
        this.maintainCreditDataSteps.toggleAllColumn(listClm);
    }

    @And("^In Maintain credit data screen, I memory data in this table$")
    public void inMaintainCreditDataScreenIMemoryDataInThisTable() throws Throwable {
        this.maintainCreditDataSteps.memoryDataInAccountTable();
    }

    @And("^In Maintain credit data screen, I click select checkbox row (.*)$")
    public void inMaintainCreditDataScreenIClickSelectCheckboxRowRowSelect(int rowSelect) throws Throwable {
        this.maintainCreditDataSteps.selectCheckBoxByRow(rowSelect);
    }

    @Then("^In Maintain credit data screen, I verify Table below have value like row select$")
    public void inMaintainCreditDataScreenIVerifyTableBelowHaveValueLikeRowSelect() throws Throwable {
        this.maintainCreditDataSteps.verifyTableLikeRowSelect();
    }

    @Then("^In Maintain credit data screen, System show message (.*)$")
    public void inMaintainCreditDataScreenSystemShowMessageSaveSuccess(String message) throws Throwable {
        this.maintainCreditDataSteps.systemShowMessage(message);
    }

    @And("^In Maintain credit data screen, in search Company Sansan I type (.*) in input field have name is (.*)$")
    public void inMaintainCreditDataScreenInSearchCompanySansanITypeIdNameCardInInputFieldHaveNameIsFieldIdNamecard(String input, String field) throws Throwable {
        this.maintainCreditDataSteps.typeToInputFieldInSearchSansan(input, field);
    }

    @And("^In Maintain credit data screen, in search Company Sansan I click button (.*)$")
    public void inMaintainCreditDataScreenInSearchCompanySansanIClickButtonSearchBtn(String name) throws Throwable {
        this.maintainCreditDataSteps.clickBtnByNameInSearchSansan(name);
    }

    @And("^In Maintain credit data screen, in search Company Sansan Table below have (.*) record$")
    public void inMaintainCreditDataScreenInSearchCompanySansanTableBelowHaveEmptyRecordRecord(int numberRc) throws Throwable {
        this.maintainCreditDataSteps.tableBelowSearchSansanHaveNumberRecord(numberRc);
    }

    @When("^In Maintain credit data screen, in search Company Sansan I click one record can click$")
    public void inMaintainCreditDataScreenInSearchCompanySansanIClickOneRecordCanClick() throws Throwable {
        this.maintainCreditDataSteps.clickOneRecordCanClickSearchSansan();
    }

    @Then("^In Maintain credit data screen, in search Company Sansan I verify field in Trade name of customer$")
    public void inMaintainCreditDataScreenInSearchCompanySansanIVerifyFieldInTradeNameOfCustomer() throws Throwable {
        this.maintainCreditDataSteps.verifyFieldTradeNameAfterSelect();
    }

    @When("^In Maintain credit data screen, in search Company Sansan I try select this record again$")
    public void inMaintainCreditDataScreenInSearchCompanySansanIUnselectRecordClickBefore() throws Throwable {
        this.maintainCreditDataSteps.unselectRecord();
    }

    @And("^In Maintain credit data screen, in search Company Sansan table I go to (.*) page$")
    public void inMaintainCreditDataScreenInSearchCompanySansanTableIGoToNextPage(String valuePage) throws Throwable {
        this.maintainCreditDataSteps.gotoPageWithValue(valuePage);
    }

    @Then("^In Maintain credit data screen, in search Company Sansan record selected still there$")
    public void inMaintainCreditDataScreenInSearchCompanySansanRecordSelectedStillThere() throws Throwable {
        this.maintainCreditDataSteps.verifyRecordSelectedBeforeChangePage();
    }

    @And("^In Maintain credit data screen, in Trade name of customer I verify (.*) and (.*)  have value is not available$")
    public void inMaintainCreditDataScreenInSearchCompanySansanIVerifySansanCompanyIDAndSansanCompanyNameHaveValueIsNotAvailable(String fieldId, String fieldName) throws Throwable {
        this.maintainCreditDataSteps.verifyFieldHaveValueNotAvailable(fieldId, fieldName);
    }

    @And("^In Maintain credit data screen, I memory data in column Customer code in row (.*)$")
    public void inMaintainCreditDataScreenIMemoryDataInColumnCustomerCodeInRowRowSelect() throws Throwable {

    }

    @And("^In Maintain credit data screen, in search Company Sansan I memory data in Trade name of customer$")
    public void inMaintainCreditDataScreenInSearchCompanySansanIMemoDataInFieldTradeNameOfCustomer() throws Throwable {
        this.maintainCreditDataSteps.memoDataInTradeNameOfCustomer();
    }

    @And("^In Maintain credit data screen, I retype memory data in Trade name of customer in input field have name is (.*)$")
    public void inMaintainCreditDataScreenIRetypeMemoryDataInTradeNameOfCustomerInInputFieldHaveNameIsFieldCustomer(String fieldName) throws Throwable {
        this.maintainCreditDataSteps.retypeMemoDataInTradeNameOfCustomer(fieldName);
    }

    @And("^In Maintain credit data screen, I verify memory data in Trade name of customer in field (.*) and (.*)$")
    public void inMaintainCreditDataScreenIVerifyMemoryDataInTradeNameOfCustomerInFieldFieldSansanCompanyIdAndFieldCompanyName(String fieldId, String fieldCompanyName) throws Throwable {
        this.maintainCreditDataSteps.verifyDataInTradeNameOfCustomerInField(fieldId, fieldCompanyName);
    }

    @And("^In Maintain credit data screen, in search Company Sansan I click check box (.*) in table$")
    public void inMaintainCreditDataScreenInSearchCompanySansanIClickCheckBoxRowSelectInTalbe(int rowIndex) throws Throwable {
        this.maintainCreditDataSteps.clickCheckBoxInSearchSansan(rowIndex);
    }

    @Then("^In Maintain credit data screen, Table below have record$")
    public void inMaintainCreditDataScreenTableBelowHaveRecord() throws Throwable {
        this.maintainCreditDataSteps.tableHaveRecord();
    }
}

package my.lib.serenity.primefaces.sars.definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my.lib.serenity.primefaces.sars.model.EmployeeManagementModel;
import my.lib.serenity.primefaces.sars.steps.EmployeeManagementSteps;
import net.thucydides.core.annotations.Steps;

import java.util.List;

/**
 * Created by ngoc on 27/09/2016.
 */


public class EmployeeManagementScenarioSteps {
    @Steps
    private EmployeeManagementSteps employeeManagementSteps;

    private String employeeName;

    @Then("^In Employee Management screen, System show button can use (.*)$")
    public void should_show_button(String buttonText) throws Throwable {
        this.employeeManagementSteps.buttonIsEnable(buttonText);
    }

    @Then("^In Employee Management screen, System show list button can use$")
    public void should_show_list_button(List<String> listColumnTitle) throws Throwable {
        for (int i = 0; i < listColumnTitle.size(); i++) {
            this.employeeManagementSteps.buttonIsEnable(listColumnTitle.get(i));
        }
    }

    @And("^In Employee Management screen, System show list button can not use$")
    public void inEmployeeManagementScreenSystemShowListButtonCanNotUse(List<String> listColumnTitle) throws Throwable {
        for (int i = 0; i < listColumnTitle.size(); i++) {
            this.employeeManagementSteps.buttonIsDisable(listColumnTitle.get(i));
        }
    }

    @And("^In Employee Management screen, The system should show table Employee$")
    public void theSystemShouldShowTableEmployeeTable() throws Throwable {
        this.employeeManagementSteps.tableIsVisible();
    }

    @And("^In Employee Management screen, I type (.*) in (.*) column filter$")
    public void iTypeTextFilterEmpCodeInEmpCodeColumnFilter(String textSend, String columnName) throws Throwable {
        this.employeeManagementSteps.typeTextToFilterColumn(textSend, columnName);
    }

    @Then("^In Employee Management screen, Table show result in column (.*) have (.*)$")
    public void tableShowResultHaveTextFilterEmpCode(String columnName, String resultText) throws Throwable {
        this.employeeManagementSteps.compareResult(columnName, resultText);
    }

    @And("^In Employee Management screen, I choose (.*) in (.*) column filter$")
    public void iChoosenTextFilterHeadOfficeInHeadOfficeColumnFilter(String textFilter, String columnTitle) throws Throwable {
        this.employeeManagementSteps.chooseTextInSelectBoxByColumnTitle(textFilter, columnTitle);
    }

    @And("^In Employee Management screen, I sort (.*) column by (.*)$")
    public void iSortEmpCodeColumnByAscending(String columnName, String typeSort) throws Throwable {
        this.employeeManagementSteps.clickSortPage(columnName, typeSort);
    }

    @Then("^In Employee Management screen, Table show result with (.*) results in page$")
    public void tableShowResultWithNumberPagingResultsInPage(int numberOfRs) throws Throwable {
        this.employeeManagementSteps.compareNumberResultInPage(numberOfRs);
    }

    @When("^In Employee Management screen, I click page (.*)$")
    public void inEmployeeManagementScreenIClickButtonPageNumber(int numberButtonPage) throws Throwable {
        this.employeeManagementSteps.clickPage(numberButtonPage);
    }

    @And("^In Employee Management screen, I click in number (.*) record$")
    public void inEmployeeManagementScreenIClickInFirstRecord(int indexRecord) throws Throwable {
        this.employeeManagementSteps.selectRecord(indexRecord);
    }

    @Then("^In Employee Management screen, System show message (.*)$")
    public void systemShowMessage(String message) throws Throwable {
        this.employeeManagementSteps.systemShowMessage(message);
        Thread.sleep(1000);
    }

    @Then("^In Employee Management screen, System show button can not use (.*)$")
    public void inEmployeeManagementScreenSystemShowButtonCanNotUseToogleColumnBtn(String buttonTitle) throws Throwable {
        this.employeeManagementSteps.checkButtonCanNotUse(buttonTitle);
    }

    @Then("^In Employee Management screen, Table show result in (.*) is (.*)$")
    public void tableShowResultInColumnIsAscending(String columnName, String typeSort) throws Throwable {
        this.employeeManagementSteps.verifyResultAfterSort(columnName, typeSort);
    }

    @And("^In Employee Management screen, Table have (.*) columns$")
    public void tableHaveNumberClmColumns(int numberColumn) throws Throwable {
        this.employeeManagementSteps.compareColumn(numberColumn);
    }

    @Then("^The system should show table employee$")
    public void theSystemShouldShowTableEmployee() throws Throwable {
        this.employeeManagementSteps.checkTableEmployeeShow();
    }

    @And("^In Employee Management screen, I click button with name (.*)$")
    public void inEmployeeManagementScreenIClickButtonEditBtn(String buttonTitle) throws Throwable {
        this.employeeManagementSteps.selectButton(buttonTitle);
    }

    @And("^In Employee Management screen, I click back button$")
    public void inEmployeeManagementScreenIClickBackButton() throws Throwable {
        this.employeeManagementSteps.selectBackButton();
    }

    @Then("^In Employee Management screen, The system should show all field is old value$")
    public void inEmployeeManagementScreenTheSystemShouldShowAllFieldIsOldValue() throws Throwable {
        this.employeeManagementSteps.compareResultTableAfterReset();
    }

    @And("^In Employee Management screen, I confirm delete$")
    public void iConfirmDelete() throws Throwable {
        this.employeeManagementSteps.confirmDelete();
    }

    @And("^In Employee Management screen, I fill all data as below with employee name auto generate$")
    public void inEmployeeManagementScreenIFillAllDataAsBelow(List<EmployeeManagementModel> params) throws Throwable {
        this.employeeManagementSteps.fillAllDataInEmployeeManagementModel(params.get(0));
    }

    @And("^In Employee Management screen, I find number 2 record have name is (.*) and select$")
    public void inEmployeeManagementScreenIFindNumberRecordHaveNameIsNameAndSelect(String name) throws Throwable {
        this.employeeManagementSteps.findRecordWithNameAndSelect(name);
    }

    @And("^In Employee Management screen, I select record create in scenario before$")
    public void inEmployeeManagementScreenISelectRecordCreateInScenarioBefore() throws Throwable {
        this.employeeManagementSteps.selectRecordCreateBefore();
    }

    @And("^In Employee Management screen, I click in number (.*) record can click$")
    public void inEmployeeManagementScreenIClickInNumberFirstRecordRecordCanClick(int index) throws Throwable {
        this.employeeManagementSteps.selectIndexRecordCanClick(index);
    }

    @And("^In Employee Management screen, I toggle all column$")
    public void inEmployeeManagementScreenIToggleAllColumn(List<String> listColumnTitle) throws Throwable {
        this.employeeManagementSteps.toggleAllColumn(listColumnTitle);
    }

    @And("^In Employee Management screen, Table have (.*) columns not hidden$")
    public void inEmployeeManagementScreenTableHaveNumberClmColumnsNotHidden(int numberColumn) throws Throwable {
        this.employeeManagementSteps.compareColumnNotHidden(numberColumn);
    }

    @And("^In Employee Management screen, I click button (.*) page on paging$")
    public void inEmployeeManagementScreenIClickButtonNamePagePageOnPaging(String namePage) throws Throwable {
        this.employeeManagementSteps.clickPageWithNameOnPaging(namePage);
    }

    @Then("^In Employee Management screen, Table should show (.*) page$")
    public void inEmployeeManagementScreenTableShouldShowNamePagePage(String namePage) throws Throwable {
        this.employeeManagementSteps.verifyPageAfterClick(namePage);
    }

    @Then("^In Employee Management screen, Table should show (.*) is selected$")
    public void inEmployeeManagementScreenTableShouldShowFirstRecordIsSelected(int index) throws Throwable {
        this.employeeManagementSteps.verifyRecordSelected(index);
    }

    @Then("^In Employee Management screen, Verify input field (.*) with max length (.*)$")
    public void inEmployeeManagementScreenVerifyMaxLengthForInputFieldEmpNameWithMaxLengthEmpMaxLength(String name, Integer maxLength) throws Throwable {
        this.employeeManagementSteps.verifyMaxLengthInputField(name, maxLength);
    }
}

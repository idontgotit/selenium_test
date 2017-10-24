package my.lib.serenity.primefaces.sars.definition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my.lib.serenity.primefaces.sars.steps.SearchHistoryByDateSteps;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by arrow on 11/10/16.
 */
public class SearchDailyReportByDateFeatureScenarioSteps {

    @Steps
    SearchHistoryByDateSteps searchHistoryByDateSteps;

    private List<String> listColumnNeedToggle;

    @Then("The system should show initialization screen of Search by Date page")
    public void then_the_system_should_show_initialization_screen_of_search_by_date_page() {
        this.searchHistoryByDateSteps.show_initialization_screen_of_search_by_date_page();
    }

    @When("^In Search by date screen, I click button '(.*)'$")
    public void when_in_search_by_date_screen_i_click_button(String buttonText) {
        this.searchHistoryByDateSteps.search_by_date_screen_i_click_button(buttonText);
    }

    @Then("^The system should show required branch and employee error message$")
    public void then_the_system_should_show_required_branch_and_employee_error_message() {
        this.searchHistoryByDateSteps.should_show_required_branch_and_employee_error_message();
    }

    @When("In Search by date screen, I toggle dropdown Branch")
    public void when_in_search_by_date_screen_i_toggle_dropdown_branch() {
        this.searchHistoryByDateSteps.toggle_dropdown_branch();
    }

    @When("In Search by date screen, I choose a branch (.*) in dropdown Branch")
    public void when_in_search_by_date_screen_i_choose_a_branch_in_dropdown_branch(String branchName) {
        this.searchHistoryByDateSteps.choose_a_branch_in_dropdown_branch(branchName);
    }

    @When("In Search by date screen, I type value (.*) for autocomplete Employee")
    public void when_in_search_by_date_screen_i_type_value_for_autocomplete_employee(String employeeInfo) {
        this.searchHistoryByDateSteps.type_value_for_autocomplete_employee(employeeInfo);
    }

    @When("In Search by date screen, I choose (.*) employee in dropdown of autocomplete Employee")
    public void when_in_search_by_date_screen_i_choose_employee_in_dropdown_of_autocomplete_employee(String employeeInfo) {
        this.searchHistoryByDateSteps.choose_employee_in_dropdown_of_autocomplete_employee(employeeInfo);
    }

    @Then("The system should show table Search by date result with no record found")
    public void then_the_system_should_show_table_search_by_date_result_with_no_record_found() {
        this.searchHistoryByDateSteps.should_show_table_search_by_date_result_with_no_record_found();
    }

    @When("In Search by date screen, I select date (.*) in item Date")
    public void when_in_search_by_date_screen_i_select_date_in_item_date(String date) {
        this.searchHistoryByDateSteps.select_date_in_item_date(date);
    }

    @Then("The system should show table Search by date result has record found")
    public void then_the_system_should_show_tabel_search_by_date_result_has_record_found() {
        this.searchHistoryByDateSteps.should_show_tabel_search_by_date_result_has_record_found();
    }

    @When("In Search by date screen, I click checkbox Include retired employee")
    public void when_in_search_by_date_screen_i_click_checkbox_include_retired_employee() {
        this.searchHistoryByDateSteps.click_checkbox_include_retired_employee();
    }

    @Then("The system should show required employee error message")
    public void then_the_system_should_show_required_employee_error_message() {
        this.searchHistoryByDateSteps.should_show_required_employee_error_message();
    }

    @When("In Search by date screen, I click button last page on paging")
    public void when_in_search_by_date_screen_i_click_button_last_page_on_paging() {
        this.searchHistoryByDateSteps.click_button_last_page_on_paging();
    }

    @Then("The table Search by date result should show last page")
    public void then_the_table_search_by_date_result_should_show_last_page() {
        this.searchHistoryByDateSteps.table_search_by_date_result_should_show_last_page();
    }

    @When("In Search by date screen, I click button first page on paging")
    public void when_in_search_by_date_screen_i_click_button_first_page_on_paging() {
        this.searchHistoryByDateSteps.click_button_first_page_on_paging();
    }

    @Then("The table Search by date result should show first page")
    public void then_the_table_search_by_date_result_should_show_first_page() {
        this.searchHistoryByDateSteps.table_search_by_date_result_should_show_first_page();
    }

    @When("In Search by date screen, I click page (.*) on paging")
    public void when_in_search_by_date_screen_i_click_page_on_paging(int pageIndex) {
        this.searchHistoryByDateSteps.click_page_on_paging(pageIndex);
    }

    @Then("The table Search by date result should change to selected page (\\d)(\\W*)(\\d*)")
    public void then_the_table_search_by_date_result_should_change_to_selected_page(int pageNumber, String character, Integer delta) {
        int increase = 0;
        if (StringUtils.isNotEmpty(character) && delta != null) {
            increase = character.trim().equals("+") ? delta : -delta;
        }
        this.searchHistoryByDateSteps.should_change_to_selected_page(pageNumber + increase);
    }

    @When("In Search by date screen, I click button next on paging")
    public void when_in_search_by_date_screen_i_click_button_next_on_paging() {
        this.searchHistoryByDateSteps.click_button_next_on_paging();
    }

    @When("In Search by date screen, I click button back on paging")
    public void when_in_search_by_date_screen_i_click_button_back_on_paging() {
        this.searchHistoryByDateSteps.click_button_back_on_paging();
    }

    @Then("The table Search by date result should expand all row")
    public void then_the_table_search_by_date_result_should_expand_all_row() {
        this.searchHistoryByDateSteps.table_search_by_date_result_should_expand_all_row();
    }

    @Given("A list of column title need toggle in Search by date")
    public void given_a_list_of_column_title_need_toggle_in_search_by_date(List<String> listColumnNeedToggle) {
        this.listColumnNeedToggle = listColumnNeedToggle;
    }

    @When("I open toggle menu in table Search by date result")
    public void when_i_open_toggle_menu_in_table_search_by_date_result() {
        this.searchHistoryByDateSteps.open_toggle_menu_in_table_search_by_date_result();
    }

    @When("I toggle all column in table Search by date result")
    public void when_i_toggle_all_column_in_table_search_by_date_result() {
        for(String columnTitle: this.listColumnNeedToggle) {
            this.searchHistoryByDateSteps.toggle_column_by_title(columnTitle);
        }
    }

    @Then("The system should show table Search by date result has (.*) columns")
    public void then_the_system_should_show_table_search_by_date_result_has_columns(int totalColumn) {
        this.searchHistoryByDateSteps.should_show_table_search_by_date_result_has_columns(totalColumn);
    }

    @When("In Search by date screen, I select row (.*)")
    public void when_in_search_by_date_screen_i_select_row(int rowIndex) {
        this.searchHistoryByDateSteps.select_row(rowIndex);
    }

    @Then("The system should show confirm delete popup")
    public void when_the_system_should_show_confirm_delete_popup() {
        this.searchHistoryByDateSteps.should_show_confirm_delete_popup();
    }

    @When("In Search by date screen, I click button '(.*)' in confirm delete popup")
    public void when_in_search_by_date_screen_i_click_button_in_confirm_delete_popup(String buttonTitle) {
        this.searchHistoryByDateSteps.click_button_in_confirm_delete_popup(buttonTitle);
    }

    @Then("The system should show message delete successfully")
    public void then_the_system_should_show_message_delete_successfully() {
        this.searchHistoryByDateSteps.should_show_message_delete_successfully();
    }

    @Then("The system should not show button Edit and Delete")
    public void then_the_system_should_not_show_button_edit_and_delete() {
        this.searchHistoryByDateSteps.should_not_show_button_edit_and_delete();
    }

    @Then("The system should show table Search by date result can not select any row")
    public void then_the_system_should_show_table_search_by_date_result_can_not_select_any_row() {
        this.searchHistoryByDateSteps.should_show_table_search_by_date_result_can_not_select_any_row();
    }

    @Then("The system should show button Edit and Delete disabled")
    public void then_the_system_should_show_button_edit_and_delete_disabled() {
        this.searchHistoryByDateSteps.should_show_button_edit_and_delete_disabled();
    }
}

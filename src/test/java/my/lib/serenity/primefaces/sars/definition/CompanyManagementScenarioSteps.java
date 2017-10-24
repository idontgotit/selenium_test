package my.lib.serenity.primefaces.sars.definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my.lib.serenity.primefaces.sars.model.CompanyDetailModel;
import my.lib.serenity.primefaces.sars.steps.CompanyManagementSteps;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by arrow on 26/9/16.
 */
public class CompanyManagementScenarioSteps {

    @Steps
    CompanyManagementSteps companyManagementSteps;
    private List<String> listColumnTitle;

    @Given("A list of column title need toggle in Company management")
    public void a_list_of_column_title_need_toggle_in_company_management(List<String> listColumnTitle) {
        this.listColumnTitle = listColumnTitle;
    }

    @Then(value = "The system should show initialization screen of Company management page")
    public void then_the_system_should_show_initialization_screen_of_company_management_page() {
        this.companyManagementSteps.should_show_initialization_screen_of_company_management_page();
    }

    @When(value = "In Company management screen, I click button Export")
    public void when_in_company_management_screen_i_click_button_export() {
        this.companyManagementSteps.click_button_export();
    }

    @Then(value = "The system should download file excel company details")
    public void then_the_system_should_download_file_excel_company_details() {
        this.companyManagementSteps.download_file_excel_company_details();
    }

    @When(value = "In Company management screen, I click button Expand Branch")
    public void when_in_company_management_screen_i_click_button_expand_branch() {
        this.companyManagementSteps.click_button_expand_branch();
    }

    @Then(value = "The system should expand all row in table company")
    public void then_the_system_should_expan_all_row_in_table_company() {
        this.companyManagementSteps.should_expand_all_row_in_table_company();
    }

    @When(value = "I fill value (.*) for input search in Company management screen")
    public void when_i_fill_value_for_input_search_in_company_management_screen(String text) {
        this.companyManagementSteps.fill_value_for_input_search_in_company_management_screen(text);
    }

    @When(value = "In Company management screen, I click button Search")
    public void when_in_company_management_screen_i_click_button_search() {
        this.companyManagementSteps.click_button_search();
    }

    @Then(value = "In Company management screen, the system should show table company with no record found")
    public void then_the_system_should_show_table_company_with_no_record_found() {
        this.companyManagementSteps.should_show_table_company_with_no_record_found();
    }

    @Then(value = "The system should show table company with record found")
    public void then_the_system_should_show_table_company_with_record_found() {
        this.companyManagementSteps.should_show_table_company_with_record_found();
    }

    @When(value = "In Company management screen, I fill value '(.*)' for filter in column '(.*)'$")
    public void when_in_company_management_screen_i_fill_value_for_filter_in_column(String filterText, String columnTitle) {
        this.companyManagementSteps.filter_value_for_filter_in_column(filterText, columnTitle);
    }

    @Then(value = "Table Company should show only records contain text '(.*)' in column '(.*)'")
    public void then_table_company_should_show_only_record_contain_text(String text, String columnTitle) {
        this.companyManagementSteps.should_show_only_record_contain_text(text, columnTitle);
    }

    @When(value = "In Company management screen, I fill value '(.*)' for filter in column '(.*)' and enter$")
    public void when_in_company_management_screen_i_fill_value_for_filter_in_column_and_enter(String filterText, String columnTitle) {
        this.companyManagementSteps.filter_value_for_filter_in_column_and_enter(filterText, columnTitle);
    }

    @When(value = "In Company management screen, I choose value '(.*)' for dropdown filter in column '(.*)'")
    public void when_in_company_management_screen_i_choose_value_for_dropdown_filter_in_column(String filterText, String columnTitle) {
        this.companyManagementSteps.choose_value_for_dropdown_filter_in_column(filterText, columnTitle);
    }

    @Then("^The system should show table company sorted by column (.*) and (.*)$")
    public void the_system_should_show_table_company_sorted_by_column_column_company_name_title_and_ascending(String columnTitle, String type) {
        this.companyManagementSteps.should_show_table_company_sorted_by_column_column_company_name_title_and_ascending(columnTitle, type);
    }

    @When(value = "In Company management screen, I sort (.*) column by (.*)")
    public void when_in_company_management_screen_i_sort_column_by(String columnTitle, String type) {
        this.companyManagementSteps.sort_column_by(columnTitle, type);
    }

    @When(value = "I open toggle menu in table company")
    public void when_i_open_toggle_menu_in_table_company() {
        this.companyManagementSteps.open_toggle_menu();
    }

    @When(value = "I toggle all column in table company")
    public void when_i_toggle_column() {
        for (String columnTitle : this.listColumnTitle) {
            this.companyManagementSteps.toggle_column(columnTitle);
        }
        this.companyManagementSteps.open_toggle_menu();
    }

    @When(value = "^I create new company with name '(.*)'$")
    public void when_I_create_new_company_with_name(String companyName) {
        this.companyManagementSteps.create_new_company_with_name(companyName);
    }

    @When(value = "^I input company detail as below$")
    public void then_i_input_company_detail(List<CompanyDetailModel> params) {
        this.companyManagementSteps.input_company_detail(params.get(0));
    }

    @When(value = "^In Company Detail screen, I click '(.*)' button$")
    public void when_i_click_button_on_detail_screen(String buttonText) {
        this.companyManagementSteps.click_button_on_detail_screen(buttonText);
    }

    @Then(value = "In Company management screen, the system should show button delete")
    public void then_in_company_management_screen_the_system_should_show_button_delete() {
        this.companyManagementSteps.should_show_button_delete();
    }

    @Then(value = "In Company management screen, the system should not show button delete")
    public void then_in_company_management_screen_the_system_should_not_show_button_delete() {
        this.companyManagementSteps.should_not_show_button_delete();
    }

    @When(value = "In Company management screen, I select row '(.*)'$")
    public void when_in_company_management_screen_i_select_row(int rowIndex) {
        this.companyManagementSteps.select_row(rowIndex);
    }

    @When(value = "In Company management screen, I click button Delete")
    public void when_in_company_management_screen_i_click_button_delete() {
        this.companyManagementSteps.click_button_delete();
    }

    @When(value = "In Company management screen, I confirm delete company")
    public void when_in_company_management_screen_i_confirm_delete_company() {
        this.companyManagementSteps.confirm_delete_company();
    }

    @Then(value = "The system should save company success")
    public void the_system_should_save_company_success() {
        this.companyManagementSteps.should_save_company_success();
    }

    @Then(value = "The system should show initialization screen of Company details")
    public void then_the_system_should_show_initialization_screen_of_company_details() {
        this.companyManagementSteps.is_initialization_screen_of_company_details();
    }

    @When(value = "In Company Detail screen, I click button back")
    public void when_in_company_detail_screen_i_click_button_back() {
        this.companyManagementSteps.in_company_detail_screen_click_button_back();
    }

    @When(value = "In Company management screen, I click button last page on paging")
    public void when_in_company_management_screen_i_click_button_last_page_on_paging() {
        this.companyManagementSteps.click_button_last_page_on_paging();
    }

    @Then(value = "The table company should show last page")
    public void then_the_table_company_should_show_last_page() {
        this.companyManagementSteps.should_show_last_page();
    }

    @When(value = "In Company management screen, I click button first page on paging")
    public void when_in_company_management_screen_i_click_button_first_page_on_paging() {
        this.companyManagementSteps.click_button_first_page_on_paging();
    }

    @Then(value = "The table company should show first page")
    public void then_the_table_company_should_show_first_page() {
        this.companyManagementSteps.should_show_first_page();
    }

    @When(value = "In Company management screen, I click page (.*) on paging")
    public void when_in_company_management_screen_i_click_page_on_paging(int pageIndex) {
        this.companyManagementSteps.click_page_on_paging(pageIndex);
    }

    @Then(value = "The table company should change to selected page (\\d)(\\W*)(\\d*)")
    public void then_the_table_company_should_change_to_selected_page(int pageNumber, String character, Integer delta) {
        int increase = 0;
        if (StringUtils.isNotEmpty(character) && delta != null) {
            increase = character.trim().equals("+") ? delta : -delta;
        }
        this.companyManagementSteps.change_table_result_to_selected_page(pageNumber + increase);
    }

    @When(value = "In Company management screen, I click button next")
    public void when_in_company_management_screen_i_click_button_next() {
        this.companyManagementSteps.click_button_next();
    }

    @When(value = "In Company management screen, I click button back")
    public void when_in_company_management_screen_i_click_button_back() {
        this.companyManagementSteps.click_button_back();
    }

    @When(value = "In Company management screen, I click button Edit")
    public void when_in_company_management_screen_i_click_button_edit() {
        this.companyManagementSteps.click_button_edit();
    }

    @When(value = "I edit company with name (.*)")
    public void when_i_edit_company_with_name(String companyName) {
        this.companyManagementSteps.edit_company_with_name(companyName);
    }

    @Then(value = "The system should reset Company Detail screen")
    public void then_the_system_should_reset_company_detail_screen() {
        this.companyManagementSteps.should_reset_company_detail_screen();
    }

    @When(value = "In Company Detail screen, I view recent activities with company")
    public void when_in_company_detail_screen_i_view_recent_activities_with_company() {
        this.companyManagementSteps.view_recent_activities_with_company();
    }

    @Then(value = "The system should open recent activities screen")
    public void then_the_system_should_open_recent_activities_screen() {
        this.companyManagementSteps.should_open_recent_activities_screen();
    }

    @When(value = "In Company Detail screen, I close recent activities screen")
    public void when_in_company_detail_screen_i_close_recent_activities_screen() {
        this.companyManagementSteps.close_recent_activities_screen();
    }

    @When("I set name '(.*)' for company")
    public void when_i_set_name_for_company(String companyName) {
        this.companyManagementSteps.set_name_for_company(companyName);
    }

    @When("In Company Detail screen, I click accept on alert popup")
    public void when_in_company_detail_screen_i_click_accept_on_alert_popup() {
        this.companyManagementSteps.click_accept_on_alert_popup();
    }

    @When("In Company Detail screen, I clear customer code")
    public void when_in_company_detail_screen_i_clear_customer_code() {
        this.companyManagementSteps.clear_customer_code();
    }

    @When("In Company Detail screen, I input Customer code (.*)")
    public void when_in_company_detail_screen_i_input_customer_code(String customerCode) {
        this.companyManagementSteps.input_customer_code(customerCode);
    }

    @Then(value = "The system should save company unsuccess")
    public void the_system_should_save_company_unsuccess() {
        this.companyManagementSteps.should_save_company_unsuccess();
    }

    @Then("In Company Detail screen, the system should show customer code empty")
    public void in_company_detail_screen_the_system_should_show_customer_code_empty() {
        this.companyManagementSteps.the_system_should_show_customer_code_empty();
    }
}

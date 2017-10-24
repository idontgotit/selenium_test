package my.lib.serenity.primefaces.sars.definition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my.lib.serenity.primefaces.sars.steps.CreditManagementSteps;
import my.lib.serenity.primefaces.sars.steps.MenuSteps;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by arrow on 22/9/16.
 */
public class CreditManagementFeatureScenarioSteps {

    @Steps
    private MenuSteps menuSteps;

    @Steps
    private CreditManagementSteps creditManagementSteps;

    @When(value = "I open submenu (.*) of menu (.*)")
    public void when_i_open_menu(String submenuName, String menuName) {
        this.menuSteps.open_submenu_of_parent_menu(submenuName, menuName);
    }

    @Then(value = "The system should open initialization screen of Credit Management page")
    public void then_the_system_should_open_initialization_screen_of_credit_management_page() {
        this.creditManagementSteps.inintialization_screen();
    }

    @When(value = "I search customer by code (.*)")
    public void when_i_search_customer_by_code(String code) {
        this.creditManagementSteps.search_customer_by_code(code);
    }

    @Then(value = "The system should show table result with no record")
    public void then_the_system_should_show_table_result_with_no_record() {
        this.creditManagementSteps.show_table_result_with_no_record();
    }

    @Then(value = "The system should show table result with records")
    public void then_the_system_should_show_table_result_with_records() {
        this.creditManagementSteps.show_table_result_with_records();
    }

    @When(value = "I click checkbox left of a row (.*) into table result")
    public void when_i_click_checkbox_left_of_a_row_into_table_result(int rowIndex) {
        this.creditManagementSteps.click_checkbox_left_of_a_row_into_table_result(rowIndex);
    }

    @Then(value = "The system should enable select button and highlight row (.*)")
    public void then_the_system_should_enable_select_button_and_highlight_selected_row(int rowIndex) {
        this.creditManagementSteps.enable_select_button_and_highlight_selected_row(rowIndex);
    }

    @Then(value = "The system should disable select button and no highlight row (.*)")
    public void then_the_system_should_disable_select_button_and_no_highlight_row(int rowIndex) {
        this.creditManagementSteps.disable_select_button_and_no_highlight_selected_row(rowIndex);
    }

    @When(value = "I click a row (.*) into table result")
    public void when_i_click_a_row_into_table_result(int rowIndex) {
        this.creditManagementSteps.click_a_row_into_table_result(rowIndex);
    }

    @When(value = "In accounting screen, I click button select")
    public void when_i_click_button_select() {
        this.creditManagementSteps.click_button_select();
    }

    @Then(value = "The system should show customer details screen")
    public void then_the_system_should_show_customer_details_screen() {
        this.creditManagementSteps.should_process_to_customer_details_screen();
    }

    @When(value = "I fill value (.*) for input id name card")
    public void when_i_fill_value_for_input_id_name_card(String idNameCard) {
        this.creditManagementSteps.fill_value_for_input_id_name_card(idNameCard);
    }

    @When(value = "I click search button in Credit management")
    public void when_i_click_search_button_in_tab_other_conditions() {
        this.creditManagementSteps.click_search_button_in_tab_other_conditions();
    }

    @When(value = "I fill value (.*) for input company name")
    public void when_i_fill_value_for_input_company_name(String companyName) {
        this.creditManagementSteps.fill_value_for_input_company_name(companyName);
    }

    @When(value = "I click page (.*) on paging")
    public void when_i_click_page_on_paging(int pageNumber) {
        this.creditManagementSteps.click_page_on_paging(pageNumber);
    }

    @Then(value = "The system should change table result to selected page (\\d)(\\W*)(\\d*)")
    public void then_the_system_should_change_table_result_to_selected_page(int pageNumber,String character, Integer delta) {
        int increase = 0;
        if(StringUtils.isNotEmpty(character) && delta != null) {
            increase = character.trim().equals("+") ? delta : -delta;
        }
        this.creditManagementSteps.change_table_result_to_selected_page(pageNumber + increase);
    }

    @Then(value = "The table result has no selected row")
    public void then_the_table_result_has_no_selected_row() {
        this.creditManagementSteps.table_result_has_no_selected_row();
    }

    @Then(value = "The table result show no row selected")
    public void then_the_table_result_show_no_row_selected() {
        this.creditManagementSteps.table_result_current_page_show_no_row_selected();
    }

    @Then(value = "Button Select disabled")
    public void then_button_select_disabled() {
        this.creditManagementSteps.button_select_disabled();
    }

    @When(value = "In accounting screen, I click button next on paging")
    public void when_i_click_button_next_on_paging() {
        this.creditManagementSteps.click_button_next_on_paging();
    }

    @When(value = "In accounting screen, I click button back on paging")
    public void when_i_click_button_back_on_paging() {
        this.creditManagementSteps.click_button_back_on_paging();
    }

    @When(value = "In accounting screen, I click button last page on paging")
    public void when_i_click_button_last_page_on_paging() {
        this.creditManagementSteps.click_button_last_page_on_paging();
    }

    @Then(value = "The table result should show last page")
    public void then_the_table_result_should_show_last_page() {
        this.creditManagementSteps.table_result_should_show_last_page();
    }

    @When(value = "In accounting screen, I click button first page on paging")
    public void when_i_click_button_first_page_on_paging() {
        this.creditManagementSteps.click_button_first_page_on_paging();
    }

    @Then(value = "The table result should show first page")
    public void then_the_table_result_should_show_first_page() {
        this.creditManagementSteps.table_result_should_show_first_page();
    }
}

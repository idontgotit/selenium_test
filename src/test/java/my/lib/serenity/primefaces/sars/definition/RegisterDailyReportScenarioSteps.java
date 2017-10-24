package my.lib.serenity.primefaces.sars.definition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my.lib.serenity.primefaces.sars.model.DailyReportModel;
import my.lib.serenity.primefaces.sars.steps.RegisterDailyReportSteps;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by arrow on 14/10/16.
 */
public class RegisterDailyReportScenarioSteps {

    @Steps
    private RegisterDailyReportSteps registerDailyReportSteps;

    private List<String> listColumnNeedToggle;

    @Given("A list of column title need toggle in Register Daily report")
    public void given_a_list_of_column_title_need_toggle_in_register_daily_report(List<String> listColumnNeedToggle) {
        this.listColumnNeedToggle = listColumnNeedToggle;
    }

    @When("I add new Daily report with data below")
    public void when_i_add_new_daily_report_with_data_below(List<DailyReportModel> listDailyReport) {
        this.registerDailyReportSteps.add_new_daily_report_with_data_below(listDailyReport);
    }

    @Then("The system should show message save daily report successfully")
    public void then_the_system_should_show_message_save_daily_report_successfully() {
        this.registerDailyReportSteps.should_show_message_save_daily_report_successfully();
    }

    @Then("^The system should show initialization screen of Register Daily report$")
    public void then_the_system_should_show_initialization_screen_of_register_daily_report() {
        this.registerDailyReportSteps.should_show_initialization_screen_of_register_daily_report();
    }

    @When("I open toggle menu in table daily report history")
    public void when_i_open_toggle_menu_in_table_daily_report_history() {
        this.registerDailyReportSteps.open_toggle_menu_in_table_daily_report_history();
    }

    @When("I toggle all column in table daily report history")
    public void when_i_toggle_all_column_in_table_daily_report_history() {
        for (String columnTitle : this.listColumnNeedToggle) {
            this.registerDailyReportSteps.toggle_column_by_title(columnTitle);
        }
    }

    @Then("The system should show table daily report history has (.*) columns")
    public void then_the_system_should_show_table_daily_report_history_has_columns(int totalColumn) {
        this.registerDailyReportSteps.should_show_table_daily_report_history_has_columns(totalColumn);
    }

    @Then("^The system should show initialization screen of Register Daily report when access from Search by date screen$")
    public void then_the_system_should_show_initialization_screen_of_register_daily_report_when_access_from_search_by_date_screen() {
        this.registerDailyReportSteps.should_show_initialization_screen_of_register_daily_report_when_access_from_search_by_date_screen();
    }

    @When("In Table daily report history, I click button last page on paging")
    public void when_in_table_daily_report_history_i_click_button_last_page_on_paging() {
        this.registerDailyReportSteps.click_button_last_page_on_paging();
    }

    @Then("The table daily report history should show last page")
    public void then_the_table_daily_report_history_should_show_last_page() {
        this.registerDailyReportSteps.table_daily_report_history_should_show_last_page();
    }

    @When("In Table daily report history, I click button first page on paging")
    public void when_in_table_daily_report_history_i_click_button_first_page_on_paing() {
        this.registerDailyReportSteps.click_button_first_page_on_paing();
    }

    @Then("The table daily report history should show first page")
    public void then_the_table_daily_report_history_should_show_first_page() {
        this.registerDailyReportSteps.table_daily_report_history_should_show_first_page();
    }

    @When("In Table daily report history, I click page (.*) on paging")
    public void when_in_table_daily_report_history_i_click_page_on_paging(int index) {
        this.registerDailyReportSteps.i_click_page_on_paging(index);
    }

    @Then("The table daily report history should change to selected page (\\d)(\\W*)(\\d*)")
    public void then_the_table_daily_report_history_should_change_to_selected_page(int pageNumber, String character, Integer delta) {
        int increase = 0;
        if (StringUtils.isNotEmpty(character) && delta != null) {
            increase = character.trim().equals("+") ? delta : -delta;
        }
        this.registerDailyReportSteps.table_daily_report_history_should_change_to_selected_page(pageNumber + increase);
    }

    @When("In Table daily report history, I click button back on paging")
    public void when_in_table_daily_report_history_i_click_button_back_on_paging() {
        this.registerDailyReportSteps.click_button_back_on_paging();
    }

    @When("In Table daily report history, I click button next on paging")
    public void when_in_table_daily_report_history_i_click_button_next_on_paging() {
        this.registerDailyReportSteps.i_click_button_next_on_paging();
    }

    @When("In Register daily report, I choose date (.*) in calendar date")
    public void when_in_register_daily_report_i_choose_date_in_calendar_date(String date) {
        this.registerDailyReportSteps.choose_date_in_calendar_date(date);
    }

    @When("^In Register daily report, I choose category '(.*)'$")
    public void when_in_register_daily_report_i_choose_category(String categoryType) {
        this.registerDailyReportSteps.choose_category(categoryType);
    }

    @Then("The system should show start time and end time required message")
    public void then_the_system_should_show_start_time_and_end_time_required_message() {
        this.registerDailyReportSteps.should_show_start_time_and_end_time_required_message();
    }

    @Then("The system should show table daily report history has data")
    public void then_the_system_should_show_table_daily_report_history_has_date() {
        this.registerDailyReportSteps.should_show_table_daily_report_history_has_date();
    }

    @When("In Register daily report, I choose row (.*) in table daily report history")
    public void when_in_register_daily_report_i_choose_row_in_table_daily_report_history(int rowIndex) {
        this.registerDailyReportSteps.choose_row_in_table_daily_report_history(rowIndex);
    }

    @Then("The system should show daily report can update")
    public void then_the_system_should_show_daily_report_can_update() {
        this.registerDailyReportSteps.should_show_daily_report_can_update();
    }

    @When("I update Daily report with data below")
    public void when_i_update_daily_report_with_data_below(List<DailyReportModel> listDailyReportModel) {
        this.registerDailyReportSteps.update_daily_report_with_data_below(listDailyReportModel.get(0));
    }

    @Then("The system should show details like below")
    public void then_the_system_should_show_details_like_below(List<DailyReportModel> listDailyReportModel) {
        this.registerDailyReportSteps.should_show_details_like_below(listDailyReportModel.get(0));
    }

    @When("^In Register daily report, I select rows in table daily report history to delete$")
    public void when_in_register_daily_report_i_select_rows_in_table_daily_report_history_to_delete(List<Integer> listRowIndex) {
        for (Integer index : listRowIndex) {
            this.registerDailyReportSteps.select_row_in_table_daily_report_history_to_delete(index);
        }
    }

    @When("In Register daily report, I click button (.*) in popup confirm delete daily report")
    public void when_in_register_daily_report_i_click_button_in_popup_confirm_delete_daily_report(String buttonText) {
        this.registerDailyReportSteps.click_button_in_popup_confirm_delete_daily_report(buttonText);
    }

    @Then("The system should show message delete daily report successfully")
    public void then_the_system_should_show_message_delete_daily_report_successfully() {
        this.registerDailyReportSteps.should_show_message_delete_daily_report_successfully();
    }

    @When("In Register daily report, I click button Delete")
    public void when_in_register_daily_report_i_click_button_delete() {
        this.registerDailyReportSteps.click_button_delete();
    }

    @When("In Register daily report, I click link Register now")
    public void when_in_register_daily_report_i_click_link_register_now() {
        this.registerDailyReportSteps.click_link_register_now();
    }

    @Then("In Register daily report, autocomplete Company should filled value '(.*)'")
    public void then_in_register_daily_report_autocomplete_company_should_filled_value(String text) {
        this.registerDailyReportSteps.autocomplete_company_should_filled_value(text);
    }

    @When("I fill Daily report screen with data below")
    public void when_i_fill_daily_report_screen_with_data_below(List<DailyReportModel> listDailyReportModel) {
        this.registerDailyReportSteps.fill_daily_report_screen_with_data_below(listDailyReportModel.get(0));
    }

    @When("In Register daily report, I click button Add")
    public void when_in_register_daily_report_i_click_button_add() {
        this.registerDailyReportSteps.click_button_add();
    }

    @Then("The system should show link Register now is visible and i can click")
    public void then_the_system_should_show_link_register_now_is_visible_and_i_can_click() {
        this.registerDailyReportSteps.should_show_link_register_now_is_visible_and_i_can_click();
    }

    @When("In Register daily report, I delete all current daily report")
    public void when_in_register_daily_report_i_delete_all_current_daily_report() {
        this.registerDailyReportSteps.delete_all_current_daily_report();
    }

    @Then("The system should show table daily report history has no data")
    public void then_the_system_should_show_table_daily_report_has_no_data() {
        this.registerDailyReportSteps.should_show_table_daily_report_has_no_data();
    }
}

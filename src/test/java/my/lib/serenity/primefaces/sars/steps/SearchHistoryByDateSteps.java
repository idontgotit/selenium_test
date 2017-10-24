package my.lib.serenity.primefaces.sars.steps;

import my.lib.serenity.primefaces.sars.page.SearchHistoryByDatePage;
import org.assertj.core.api.Assertions;

/**
 * Created by arrow on 11/10/16.
 */
public class SearchHistoryByDateSteps {

    private SearchHistoryByDatePage searchHistoryByDatePage;

    public void show_initialization_screen_of_search_by_date_page() {
        Assertions.assertThat(this.searchHistoryByDatePage.is_initialization_screen()).isTrue();
    }

    public void search_by_date_screen_i_click_button(String buttonText) {
        this.searchHistoryByDatePage.search_by_date_screen_i_click_button(buttonText);
    }

    public void should_show_required_branch_and_employee_error_message() {
        Assertions.assertThat(this.searchHistoryByDatePage.should_show_required_branch_and_employee_error_message()).isTrue();
    }

    public void toggle_dropdown_branch() {
        this.searchHistoryByDatePage.toggle_dropdown_branch();
    }

    public void choose_a_branch_in_dropdown_branch(String branchName) {
        this.searchHistoryByDatePage.choose_a_branch_in_dropdown_branch(branchName);
    }

    public void type_value_for_autocomplete_employee(String employeeInfo) {
        this.searchHistoryByDatePage.type_value_for_autocomplete_employee(employeeInfo);
    }

    public void choose_employee_in_dropdown_of_autocomplete_employee(String employeeInfo) {
        this.searchHistoryByDatePage.choose_employee_in_dropdown_of_autocomplete_employee(employeeInfo);
    }

    public void should_show_table_search_by_date_result_with_no_record_found() {
        Assertions.assertThat(this.searchHistoryByDatePage.should_show_table_search_by_date_result_with_no_record_found()).isTrue();
    }

    public void select_date_in_item_date(String date) {
        this.searchHistoryByDatePage.select_date_in_item_date(date);
    }

    public void should_show_tabel_search_by_date_result_has_record_found() {
        Assertions.assertThat(this.searchHistoryByDatePage.should_show_table_search_by_date_result_has_record_found()).isTrue();
    }

    public void click_checkbox_include_retired_employee() {
        this.searchHistoryByDatePage.click_checkbox_include_retired_employee();
    }

    public void should_show_required_employee_error_message() {
        Assertions.assertThat(this.searchHistoryByDatePage.should_show_required_employee_error_message()).isTrue();
    }

    public void click_button_last_page_on_paging() {
        this.searchHistoryByDatePage.click_button_last_page_on_paging();
    }

    public void table_search_by_date_result_should_show_last_page() {
        Assertions.assertThat(this.searchHistoryByDatePage.table_search_by_date_result_should_show_last_page()).isTrue();
    }

    public void click_button_first_page_on_paging() {
        this.searchHistoryByDatePage.click_button_first_page_on_paging();
    }

    public void table_search_by_date_result_should_show_first_page() {
        Assertions.assertThat(this.searchHistoryByDatePage.table_search_by_date_result_should_show_first_page()).isTrue();
    }

    public void click_page_on_paging(int pageIndex) {
        this.searchHistoryByDatePage.click_page_on_paging(pageIndex);
    }

    public void should_change_to_selected_page(int pageIndex) {
        Assertions.assertThat(this.searchHistoryByDatePage.getTableSearchByDateResult().getPageSelected()).isEqualTo(pageIndex);
    }

    public void click_button_next_on_paging() {
        this.searchHistoryByDatePage.click_button_next_on_paging();
    }

    public void click_button_back_on_paging() {
        this.searchHistoryByDatePage.click_button_back_on_paging();
    }

    public void table_search_by_date_result_should_expand_all_row() {
        Assertions.assertThat(this.searchHistoryByDatePage.table_search_by_date_result_should_expand_all_row()).isTrue();
    }

    public void open_toggle_menu_in_table_search_by_date_result() {
        this.searchHistoryByDatePage.open_toggle_menu_in_table_search_by_date_result();
    }

    public void toggle_column_by_title(String columnTitle) {
        this.searchHistoryByDatePage.toggle_column_by_title(columnTitle);
    }

    public void should_show_table_search_by_date_result_has_columns(int totalColumn) {
        Assertions.assertThat(this.searchHistoryByDatePage.getTableSearchByDateResult().getAllColumnHeaderElement().size()).isEqualTo(totalColumn);
    }

    public void select_row(int rowIndex) {
        this.searchHistoryByDatePage.select_row(rowIndex);
    }

    public void should_show_confirm_delete_popup() {
        Assertions.assertThat(this.searchHistoryByDatePage.should_show_confirm_delete_popup()).isTrue();
    }

    public void click_button_in_confirm_delete_popup(String buttonTitle) {
        this.searchHistoryByDatePage.click_button_in_confirm_delete_popup(buttonTitle);
    }

    public void should_show_message_delete_successfully() {
        Assertions.assertThat(this.searchHistoryByDatePage.should_show_message_delete_successfully()).isTrue();
    }

    public void should_not_show_button_edit_and_delete() {
        Assertions.assertThat(this.searchHistoryByDatePage.should_not_show_button_edit_and_delete()).isTrue();
    }

    public void should_show_table_search_by_date_result_can_not_select_any_row() {
        Assertions.assertThat(this.searchHistoryByDatePage.should_show_table_search_by_date_result_can_not_select_any_row()).isTrue();
    }

    public void should_show_button_edit_and_delete_disabled() {
        Assertions.assertThat(this.searchHistoryByDatePage.should_show_button_edit_and_delete_disabled()).isTrue();
    }
}

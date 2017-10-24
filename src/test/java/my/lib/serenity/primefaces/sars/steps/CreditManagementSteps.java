package my.lib.serenity.primefaces.sars.steps;

import my.lib.serenity.primefaces.sars.page.CreditManagementPage;
import net.thucydides.core.steps.ScenarioSteps;
import org.assertj.core.api.Assertions;
import org.fluentlenium.core.annotation.Page;

/**
 * Created by arrow on 22/9/16.
 */
public class CreditManagementSteps extends ScenarioSteps {

    @Page
    CreditManagementPage creditManagementPage;

    public void inintialization_screen() {
        Assertions.assertThat(this.creditManagementPage.is_initialization_screen()).isTrue();
    }

    public void search_customer_by_code(String code) {
        this.creditManagementPage.search_customer_by_code(code);
    }

    public void show_table_result_with_no_record() {
        Assertions.assertThat(this.creditManagementPage.is_no_record_found()).isTrue();
    }

    public void show_table_result_with_records() {
        Assertions.assertThat(this.creditManagementPage.is_no_record_found()).isFalse();
    }

    public void click_checkbox_left_of_a_row_into_table_result(int rowIndex) {
        this.creditManagementPage.click_checkbox_left_of_a_row_into_table_result(rowIndex);
    }

    public void enable_select_button_and_highlight_selected_row(int rowIndex) {
        Assertions.assertThat(this.creditManagementPage.enable_select_button_and_highlight_selected_row(rowIndex)).isTrue();
    }

    public void disable_select_button_and_no_highlight_selected_row(int rowIndex) {
        Assertions.assertThat(this.creditManagementPage.disable_select_button_and_no_highlight_selected_row(rowIndex)).isTrue();
    }

    public void click_a_row_into_table_result(int rowIndex) {
        this.creditManagementPage.click_a_row_into_table_result(rowIndex);
    }

    public void click_button_select() {
        this.creditManagementPage.click_button_select();
    }

    public void should_process_to_customer_details_screen() {
        Assertions.assertThat(this.creditManagementPage.success_process_to_customer_details_screen()).isTrue();
    }

    public void fill_value_for_input_id_name_card(String idNameCard) {
        this.creditManagementPage.fill_value_for_input_id_name_card(idNameCard);
    }

    public void click_search_button_in_tab_other_conditions() {
        this.creditManagementPage.click_search_button_in_tab_other_conditions();
    }

    public void fill_value_for_input_company_name(String companyName) {
        this.creditManagementPage.fill_value_for_input_company_name(companyName);
    }

    public void click_page_on_paging(int pageNumber) {
        this.creditManagementPage.click_page_on_paging(pageNumber);
    }

    public void change_table_result_to_selected_page(int pageNumber) {
        Assertions.assertThat(this.creditManagementPage.getPageSelected()).isEqualTo(pageNumber);
    }

    public void table_result_has_no_selected_row() {
        Assertions.assertThat(this.creditManagementPage.table_result_has_selected_row()).isFalse();
    }

    public void table_result_current_page_show_no_row_selected() {
        Assertions.assertThat(this.creditManagementPage.table_result_current_page_show_no_row_selected()).isTrue();
    }

    public void button_select_disabled() {
        Assertions.assertThat(this.creditManagementPage.is_button_select_enabled()).isFalse();
    }

    public void click_button_next_on_paging() {
        this.creditManagementPage.click_button_next_on_paging();
    }

    public void click_button_back_on_paging() {
        this.creditManagementPage.click_button_back_on_paging();
    }

    public void click_button_last_page_on_paging() {
        this.creditManagementPage.click_button_last_page_on_paging();
    }

    public void table_result_should_show_last_page() {
        Assertions.assertThat(this.creditManagementPage.is_show_last_page()).isTrue();
    }

    public void click_button_first_page_on_paging() {
        this.creditManagementPage.click_button_first_page_on_paging();
    }

    public void table_result_should_show_first_page() {
        Assertions.assertThat(this.creditManagementPage.is_show_first_page()).isTrue();
    }
}

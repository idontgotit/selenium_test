package my.lib.serenity.primefaces.sars.steps;

import my.lib.serenity.primefaces.sars.model.DailyReportModel;
import my.lib.serenity.primefaces.sars.page.RegisterDailyReportPage;
import net.thucydides.core.steps.ScenarioSteps;
import org.assertj.core.api.Assertions;

import java.util.List;

/**
 * Created by arrow on 14/10/16.
 */
public class RegisterDailyReportSteps extends ScenarioSteps {
    private RegisterDailyReportPage registerDailyReportPage;

    public void add_new_daily_report_with_data_below(List<DailyReportModel> listDailyReport) {
        for (DailyReportModel dailyReportModel : listDailyReport) {
            this.registerDailyReportPage.add_new_daily_report_with_data_below(dailyReportModel);
        }
    }

    public void should_show_message_save_daily_report_successfully() {
        Assertions.assertThat(this.registerDailyReportPage.should_show_message_save_daily_report_successfully()).isTrue();
    }

    public void should_show_initialization_screen_of_register_daily_report() {
        Assertions.assertThat(this.registerDailyReportPage.should_show_initialization_screen_of_register_daily_report()).isTrue();
    }

    public void should_show_initialization_screen_of_register_daily_report_when_access_from_search_by_date_screen() {
        Assertions.assertThat(this.registerDailyReportPage.should_show_initialization_screen_of_register_daily_report_when_access_from_search_by_date_screen()).isTrue();
    }

    public void click_button_last_page_on_paging() {
        this.registerDailyReportPage.getTableDailyReportHistory().last();
    }

    public void table_daily_report_history_should_show_last_page() {
        Assertions.assertThat(this.registerDailyReportPage.table_daily_report_history_should_show_last_page()).isTrue();
    }

    public void click_button_first_page_on_paing() {
        this.registerDailyReportPage.getTableDailyReportHistory().first();
    }

    public void table_daily_report_history_should_show_first_page() {
        Assertions.assertThat(this.registerDailyReportPage.table_daily_report_history_should_show_first_page()).isTrue();
    }

    public void i_click_page_on_paging(int index) {
        this.registerDailyReportPage.getTableDailyReportHistory().click_page_on_paging(index);
    }

    public void table_daily_report_history_should_change_to_selected_page(int index) {
        Assertions.assertThat(this.registerDailyReportPage.getTableDailyReportHistory().getPageSelected()).isEqualTo(index);
    }

    public void click_button_back_on_paging() {
        this.registerDailyReportPage.getTableDailyReportHistory().back();
    }

    public void i_click_button_next_on_paging() {
        this.registerDailyReportPage.getTableDailyReportHistory().next();
    }

    public void choose_date_in_calendar_date(String date) {
        this.registerDailyReportPage.choose_date_in_calendar_date(date);
    }

    public void open_toggle_menu_in_table_daily_report_history() {
        this.registerDailyReportPage.getTableDailyReportHistory().getToggle().toggle_menu();
    }

    public void toggle_column_by_title(String columnTitle) {
        this.registerDailyReportPage.getTableDailyReportHistory().getToggle().toggle_column(columnTitle);
    }

    public void should_show_table_daily_report_history_has_columns(int totalColumn) {
        Assertions.assertThat(this.registerDailyReportPage.getTableDailyReportHistory().getAllColumnHeaderElement().size()).isEqualTo(totalColumn);
    }

    public void choose_category(String categoryType) {
        this.registerDailyReportPage.choose_category(categoryType);
    }

    public void should_show_start_time_and_end_time_required_message() {
        Assertions.assertThat(this.registerDailyReportPage.should_show_start_time_and_end_time_required_message()).isTrue();
    }

    public void should_show_table_daily_report_history_has_date() {
        Assertions.assertThat(this.registerDailyReportPage.getTableDailyReportHistory().is_no_record()).isFalse();
    }

    public void choose_row_in_table_daily_report_history(int rowIndex) {
        this.registerDailyReportPage.getTableDailyReportHistory().click_a_row_into_table_result(rowIndex);
    }

    public void should_show_daily_report_can_update() {
        Assertions.assertThat(this.registerDailyReportPage.getButtonUpdate().isEnabled()).isTrue();
    }

    public void update_daily_report_with_data_below(DailyReportModel dailyReportModel) {
        this.registerDailyReportPage.update_daily_report_with_data_below(dailyReportModel);
    }

    public void should_show_details_like_below(DailyReportModel dailyReportModel) {
        Assertions.assertThat(this.registerDailyReportPage.verify_screen_after_update(dailyReportModel)).isTrue();
    }

    public void select_row_in_table_daily_report_history_to_delete(int index) {
        this.registerDailyReportPage.getTableDailyReportHistory().click_check_box_by_row_index(index);
    }

    public void click_button_in_popup_confirm_delete_daily_report(String buttonText) {
        this.registerDailyReportPage.click_button_in_popup_confirm_delete_daily_report(buttonText);
    }

    public void should_show_message_delete_daily_report_successfully() {
        Assertions.assertThat(this.registerDailyReportPage.should_show_message_delete_daily_report_successfully()).isTrue();
    }

    public void click_button_delete() {
        this.registerDailyReportPage.getButtonDelete().click_and_wait();
    }

    public void click_link_register_now() {
        this.registerDailyReportPage.click_link_register_now();
    }

    public void autocomplete_company_should_filled_value(String text) {
        Assertions.assertThat(this.registerDailyReportPage.getAutoCompleteCompany().getValue()).isEqualTo(text);
    }

    public void fill_daily_report_screen_with_data_below(DailyReportModel dailyReportModel) {
        this.registerDailyReportPage.fill_daily_report_screen_with_data_below(dailyReportModel);
    }

    public void click_button_add() {
        this.registerDailyReportPage.getButtonAdd().click_and_wait();
    }

    public void should_show_link_register_now_is_visible_and_i_can_click() {
        Assertions.assertThat(this.registerDailyReportPage.should_show_link_register_now_is_visible_and_i_can_click()).isTrue();
    }

    public void delete_all_current_daily_report() {
        this.registerDailyReportPage.delete_all_current_daily_report();
    }

    public void should_show_table_daily_report_has_no_data() {
        Assertions.assertThat(this.registerDailyReportPage.getTableDailyReportHistory().is_no_record()).isTrue();
    }
}

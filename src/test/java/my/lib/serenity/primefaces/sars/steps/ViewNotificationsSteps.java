package my.lib.serenity.primefaces.sars.steps;

import my.lib.serenity.primefaces.sars.page.ViewNotificationsPage;
import net.thucydides.core.steps.ScenarioSteps;
import org.assertj.core.api.Assertions;

/**
 * Created by arrow on 13/10/16.
 */
public class ViewNotificationsSteps extends ScenarioSteps {

    private ViewNotificationsPage viewNotificationsPage;

    public void should_show_initialization_screen_of_view_notifications_page() {
        Assertions.assertThat(this.viewNotificationsPage.should_show_initialization_screen_of_view_notifications_page()).isTrue();
    }

    public void should_show_initialization_screen_of_view_notification_page_when_have_data() {
        Assertions.assertThat(this.viewNotificationsPage.should_show_initialization_screen_of_view_notification_page_when_have_data()).isTrue();
    }

    public void click_button(String buttonText) {
        this.viewNotificationsPage.click_button(buttonText);
    }

    public void should_switch_to_notification_setting_screen() {
        Assertions.assertThat(this.viewNotificationsPage.should_switch_to_notification_setting_screen()).isTrue();
    }

    public void choose_row_in_table_list_notification(int rowIndex) {
        this.viewNotificationsPage.getTableListNotification().click_a_row_into_table_result(rowIndex);
    }

    public void should_show_list_table_notification_detail() {
        Assertions.assertThat(this.viewNotificationsPage.isRenderTableDetails()).isTrue();
    }

    public void choose_row_in_talbe_of_notification_details_panel(int rowIndex, int tableIndex) {
        this.viewNotificationsPage.choose_row_in_talbe_of_notification_details_panel(rowIndex, tableIndex);
    }

    public void should_show_notification_details_panel_remove_row_i_clicked() {
        Assertions.assertThat(this.viewNotificationsPage.should_show_notification_details_panel_remove_row_i_clicked()).isTrue();
    }

    public void click_button_in_confirm_dialog(String buttonTitle) {
        this.viewNotificationsPage.click_button_in_confirm_dialog(buttonTitle);
    }

    public void should_show_message_mark_all_successfully() {
        this.viewNotificationsPage.should_show_message_mark_all_successfully();
    }
}

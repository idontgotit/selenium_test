package my.lib.serenity.primefaces.sars.definition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my.lib.serenity.primefaces.sars.steps.ViewNotificationsSteps;
import net.thucydides.core.annotations.Steps;

/**
 * Created by arrow on 13/10/16.
 */
public class ViewNotificationsFeatureScenarioSteps {

    @Steps
    private ViewNotificationsSteps viewNotificationsSteps;

    @Then("^The system should show initialization screen of View Notifications page$")
    public void then_the_system_should_show_initialization_screen_of_view_notifications_page() {
        this.viewNotificationsSteps.should_show_initialization_screen_of_view_notifications_page();
    }

    @Then("^The system should show initialization screen of View Notifications page when have data$")
    public void then_the_system_should_show_initialization_screen_of_view_notification_page_when_have_data() {
        this.viewNotificationsSteps.should_show_initialization_screen_of_view_notification_page_when_have_data();
    }

    @When("^In View notification screen, I click button '(.*)'$")
    public void when_in_view_notification_screen_i_click_button(String buttonText) {
        this.viewNotificationsSteps.click_button(buttonText);
    }

    @Then("The system should switch to Notification setting screen")
    public void then_the_system_should_switch_to_notification_setting_screen() {
        this.viewNotificationsSteps.should_switch_to_notification_setting_screen();
    }

    @When("In View notification screen, I choose row (.*) in table list notification")
    public void when_in_view_notification_screen_i_choose_row_in_table_list_notification(int rowIndex) {
        this.viewNotificationsSteps.choose_row_in_table_list_notification(rowIndex);
    }

    @Then("The system should show list table notification detail")
    public void then_the_system_should_show_list_table_notification_detail() {
        this.viewNotificationsSteps.should_show_list_table_notification_detail();
    }

    @When("In View notification screen, I choose row (.*) in table (.*) of Notification details panel")
    public void when_in_view_notification_screen_i_choose_row_in_talbe_of_notification_details_panel(int rowIndex, int tableIndex) {
        this.viewNotificationsSteps.choose_row_in_talbe_of_notification_details_panel(rowIndex, tableIndex);
    }

    @Then("The system should show Notification details panel remove row i clicked")
    public void then_the_system_should_show_notification_details_panel_remove_row_i_clicked() {
        this.viewNotificationsSteps.should_show_notification_details_panel_remove_row_i_clicked();
    }

    @When("In View notification screen, I click button '(.*)' in  confirm dialog")
    public void when_in_view_notification_screen_i_click_button_in_confirm_dialog(String buttonTitle) {
        this.viewNotificationsSteps.click_button_in_confirm_dialog(buttonTitle);
    }

    @Then("The system should show message mark all successfully")
    public void then_the_system_should_show_message_mark_all_successfully() {
        this.viewNotificationsSteps.should_show_message_mark_all_successfully();
    }
}

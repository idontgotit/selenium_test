package my.lib.serenity.primefaces.sars.page;

import my.lib.serenity.primefaces.component.ButtonComponent;
import my.lib.serenity.primefaces.component.PanelComponent;
import my.lib.serenity.primefaces.component.TableComponent;
import my.lib.serenity.primefaces.component.factory.PFComponentFactory;
import my.lib.serenity.primefaces.constant.CommonConstant;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.collections.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by arrow on 13/10/16.
 */
public class ViewNotificationsPage extends AbstractPage {

    private int selectedTableIndex, selectedRowIndex, totalRowInSelectedtable;
    private List<TableComponent> listTableDetails;

    public boolean should_show_initialization_screen_of_view_notifications_page() {
        return this.is_button_mark_all_disabled() && this.getButtonNotificationSetting().isEnabled() && this.getReportPanel().isVisible()
                && this.getTableListNotification().isVisible() && !this.isRenderTableDetails();
    }

    public boolean should_show_initialization_screen_of_view_notification_page_when_have_data() {
        return !this.is_button_mark_all_disabled() && this.getButtonNotificationSetting().isEnabled() && this.getReportPanel().isVisible()
                && !this.getTableListNotification().is_no_record() && this.isRenderTableDetails();
    }

    public ButtonComponent getButtonMarkAll() {
        return PFComponentFactory.wrapButton(this, this.findBy("*//button[contains(@id,'markAllAsRead')]"));
    }

    public ButtonComponent getButtonNotificationSetting() {
        return PFComponentFactory.wrapButton(this, this.findBy("*//button[contains(@id,'noticeSettingButton')]"));
    }

    public TableComponent getTableListNotification() {
        return PFComponentFactory.wrapTable(this, this.findBy("*//div[contains(@id,'dashBoardTable')]"));
    }

    public PanelComponent getReportPanel() {
        return PFComponentFactory.wrapPanel(this, By.xpath("*//div[contains(@id,'reportTable_pane')]"));
    }

    public List<TableComponent> getListTableDetails() {
        List<WebElementFacade> listTableElement = this.findAll("*//div[contains(@id,'reportTable_pane')]/div/div[contains(@class,'ui-datatable')]");
        if (CollectionUtils.isEmpty(listTableElement)) {
            return Collections.emptyList();
        }

        return listTableElement.stream().map(webElementFacade -> {
            return PFComponentFactory.wrapTable(this, webElementFacade);
        }).collect(Collectors.toList());
    }

    public boolean is_button_mark_all_disabled() {
        return this.findBy("*//button[contains(@id,'markAllAsRead')]").getAttribute("class").contains("ui-state-disabled");
    }

    public boolean isRenderTableDetails() {
        return CollectionUtils.isNotEmpty(this.getListTableDetails());
    }

    public void click_button(String buttonText) {
        this.findBy("*//button[contains(.,'" + buttonText + "')]").waitUntilEnabled().waitUntilClickable();
        PFComponentFactory.wrapButton(this, this.findBy("*//button[contains(.,'" + buttonText + "')]")).click_and_wait();
    }

    public boolean should_switch_to_notification_setting_screen() {
        try {
            return findBy("*//form[@id='notification_setting']/div/div/div/strong/label")
                    .getText().equalsIgnoreCase(CommonConstant.ADD_TRACKING_NOTIFICATION_PANEL_HEADER);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean should_show_notification_details_panel_remove_row_i_clicked() {
        List<TableComponent> listCurrentTableDetails = this.getListTableDetails();
        if (this.totalRowInSelectedtable == 1) {
            return (this.listTableDetails.size() - 1) == listCurrentTableDetails.size();
        }

        if (this.listTableDetails.size() != listCurrentTableDetails.size()) {
            return false;
        }

        return (this.totalRowInSelectedtable - 1) == listCurrentTableDetails.get(selectedTableIndex).getCountContentRow();
    }

    public void choose_row_in_talbe_of_notification_details_panel(int rowIndex, int tableIndex) {
        this.listTableDetails = this.getListTableDetails();
        this.selectedRowIndex = rowIndex;
        this.selectedTableIndex = tableIndex;
        this.totalRowInSelectedtable = this.getListTableDetails().get(tableIndex).getCountContentRow();
        this.getListTableDetails().get(tableIndex).click_a_row_into_table_result(rowIndex);
    }

    public void click_button_in_confirm_dialog(String buttonTitle) {
        PFComponentFactory.wrapButton(this, this.findBy("//div[contains(@class,'ui-confirm-dialog') and @aria-hidden='false']//button[contains(.,'" + buttonTitle + "')]")).click_and_wait();
    }

    public boolean should_show_message_mark_all_successfully() {
        boolean isShowMessage = this.is_show_panel_message();
        List<String> listMessagesText = this.getListMessageText();
        this.wait_for_message_disappeared();
        return isShowMessage && listMessagesText.contains(CommonConstant.MARK_ALL_AS_READ_SUCCESS_MESSAGE);
    }

    public boolean is_show_panel_message() {
        return this.find(By.xpath("//div[@id='growl_container']")).isCurrentlyVisible();
    }

    public List<String> getListMessageText() {
        List<WebElementFacade> listErrorMessages = this.findAll("//div[@id='growl_container']//div[@class='ui-growl-message']//p");
        List<String> listErrorMessageText = listErrorMessages.stream().map(WebElementFacade::getText).collect(Collectors.toList());
        return listErrorMessageText;
    }
}

package my.lib.serenity.primefaces.sars.page;

import my.lib.serenity.primefaces.component.ButtonComponent;
import my.lib.serenity.primefaces.component.CommandLinkComponent;
import my.lib.serenity.primefaces.component.SelectOneMenuComponent;
import my.lib.serenity.primefaces.component.TableComponent;
import my.lib.serenity.primefaces.component.factory.PFComponentFactory;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static my.lib.serenity.primefaces.sars.utils.ConstantsEmployeeManagement.*;

/**
 * Created by ngoc on 11/10/2016.
 */
public class NotificationSettingPage extends AbstractPage {

    private List<String> currentEmpNameDropdownLabel;
    private String positionSelected;
    private String empNameSelected;
    private int currentPage;

    public ButtonComponent findByButtonTextInNotificationSetting(String buttonText) {
        return PFComponentFactory.wrapButton(this, this.find(By.xpath("//form[@id='notification_setting']//span[text()='" + buttonText + "']//parent::*")));
    }

    private CommandLinkComponent getViewNotificationLink() {
        try {
            return PFComponentFactory.wrapCommandLink(this, By.id("notification_setting:viewNotification"));
        } catch (NoSuchElementException nse) {
            return null;
        }
    }

    public TableComponent getTableNotification() {
        return PFComponentFactory.wrapTable(this, this.find(By.id("notification_setting:notificationTable")));
    }

    private SelectOneMenuComponent getSelectBranch() {
        return PFComponentFactory.wrapSelectOneMenu(this, this.find(By.id("notification_setting:address_point")));
    }

    private SelectOneMenuComponent getSelectPosition() {
        return PFComponentFactory.wrapSelectOneMenu(this, this.find(By.id("notification_setting:position_base")));
    }

    private SelectOneMenuComponent getSelectEmployeeName() {
        return PFComponentFactory.wrapSelectOneMenu(this, this.find(By.id("notification_setting:listEmployee")));
    }

    public boolean verifySelectBoxCanSelect(String title) {
        switch (title) {
            case "Branch":
                return this.getSelectBranch().can_open_menu_options();
            case "Position":
                return this.getSelectPosition().can_open_menu_options();
            case "Employee Name":
                return this.getSelectEmployeeName().can_open_menu_options();
            default:
                return false;
        }
    }

    public boolean verifyStatusViewNotification(String statusViewNotification) {
        switch (statusViewNotification) {
            case "Visible":
                try {
                    return this.getViewNotificationLink().isCurrentlyVisible();
                } catch (NullPointerException npe) {
                    return false;
                }
            case "Not Visible":
                return this.getViewNotificationLink() == null;
            default:
                return false;
        }
    }

    public void clickWithName(String name) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (name.equalsIgnoreCase("View Notifications")) {
            this.getViewNotificationLink().click_and_wait();
        } else {
            this.findByButtonTextInNotificationSetting(name).click_and_wait();
        }
    }

    public WebElementFacade findButtonInScreenByText(String textTitle) {
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return this.find(By.xpath("*//span[text()='" + textTitle + "']//parent::*"));
        } catch (NoSuchElementException nse) {
            return null;
        }
    }

    public void selectDrownDownWithValue(String title, String value) {
        switch (title) {
            case "Branch":
                this.getSelectBranch().open_menu_options();
                value =
                        this.getValuePrepareSelectBy(this.getSelectBranch(), value);
                this.getSelectBranch().select_option_by_text_without_open_first(value);
                break;
            case "Position":
                this.getSelectPosition().open_menu_options();
                value =
                        this.getValuePrepareSelectBy(this.getSelectPosition(), value);
                this.getSelectPosition().select_option_by_text_without_open_first(value);
                this.positionSelected = value;
                break;
            case "Employee Name":
                this.getSelectEmployeeName().open_menu_options();
                this.currentEmpNameDropdownLabel = this.getListLabelFromDropDown(this.getSelectEmployeeName().getAllLabelInSelectOneMenu());
                value =
                        this.getValuePrepareSelectBy(this.getSelectEmployeeName(), value);
                this.getSelectEmployeeName().select_option_by_text_without_open_first(value);
                this.empNameSelected = value;
                break;
        }
    }

    private String getValuePrepareSelectBy(SelectOneMenuComponent dropdownClicked, String paramSelect) {
        String valuePrepareSelectConvert = null;
        List<WebElementFacade> listLabel = dropdownClicked.getAllLabelInSelectOneMenu();
        switch (paramSelect) {
            case "first in list dropdown":
                valuePrepareSelectConvert =
                        listLabel.get(0).getText();
                break;
            case "second in list dropdown":
                valuePrepareSelectConvert =
                        listLabel.get(1).getText();
                break;
            case "third in list dropdown":
                valuePrepareSelectConvert =
                        listLabel.get(2).getText();
                break;
            case "fifth in list dropdown":
                valuePrepareSelectConvert =
                        listLabel.get(4).getText();
                break;
            case "random":
                int numberRandom = ThreadLocalRandom.current().nextInt(1, listLabel.size() - 1);
                valuePrepareSelectConvert =
                        listLabel.get(numberRandom).getText();
                break;
        }
        if (valuePrepareSelectConvert != null) return valuePrepareSelectConvert;
        return paramSelect;
    }

    public List<String> getGrowlMessage() {
        List<String> listGrowlMessage = new ArrayList<>();
        List<WebElementFacade> messagePanel = this.findAll(By.xpath("//*[@id='growl_container']//div[contains(@class,'ui-growl-message')]//p"));
        listGrowlMessage.addAll(messagePanel.stream().map(WebElementFacade::getText).collect(Collectors.toList()));
        return listGrowlMessage;
    }

    public boolean verifyEmpNameSelectedAdded() {
        int index = this.getTableNotification().getColumnIndex("Employee Name");
        List<String> listAll = this.getTableNotification().getAllCellValueByColumnIndex(index);
        return listAll.contains(this.empNameSelected);
    }

    public void confirmDelete() {
        PFComponentFactory.wrapButton(this, this.find(By.xpath("//div[contains(@class,'ui-confirm-dialog') and contains(@style,'display: block')]//span[text()='Yes']//ancestor::button"))).click_and_wait();
    }

    public boolean verifyAllEmpNameAdded() {
        List<String> listAllEmployeeName = new ArrayList<>();
        int index = this.getTableNotification().getColumnIndex("Employee Name");
        do {
            listAllEmployeeName.addAll(this.getTableNotification().getAllCellValueByColumnIndex(index));
        }
        while (!this.isLastPage());
        this.getTableNotification().first();

        return compareTwoListEqual(listAllEmployeeName, this.currentEmpNameDropdownLabel);
    }

    private boolean isLastPage() {
        if (this.getTableNotification().is_show_last_page())
            return true;
        else {
            this.getTableNotification().next();
            return false;
        }
    }

    private List<String> getListLabelFromDropDown(List<WebElementFacade> listInput) {
        List<String> listLabelDropDown = new ArrayList<>();
        for (WebElementFacade aListInput : listInput) {
            String currentLabel = aListInput.getAttribute("data-label");
            if (currentLabel.equalsIgnoreCase("Please Select") || currentLabel.equalsIgnoreCase("All employee"))
                continue;
            listLabelDropDown.add(currentLabel);
        }
        return listLabelDropDown;
    }

    public void clickRandomCheckBoxEnable() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int rowNumber = this.getTableNotification().getCountContentRow();
        if (rowNumber == 1) {
            this.getTableNotification().select_check_box_by_index(0);
        } else {
            int randomLoop = ThreadLocalRandom.current().nextInt(1, rowNumber - 1);
            for (int i = 0; i < randomLoop; i++) {
                int random = ThreadLocalRandom.current().nextInt(0, rowNumber - 1);
                this.getTableNotification().select_check_box_by_index(random);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void clickPageWithNameOnPaging(String namePage) {
        switch (namePage) {
            case LAST:
                this.getTableNotification().last();
                break;
            case PREVIOUS:
                this.currentPage = this.getTableNotification().getPageSelected();
                this.getTableNotification().back();
                break;
            case NEXT:
                this.currentPage = this.getTableNotification().getPageSelected();
                this.getTableNotification().next();
                break;
            case FIRST:
                this.getTableNotification().first();
                break;
        }
    }

    public boolean verifyPageAfterClick(String namePage) {
        switch (namePage) {
            case LAST:
                return this.getTableNotification().is_show_last_page();
            case PREVIOUS:
                return this.getTableNotification().getPageSelected() == this.currentPage - 1;
            case NEXT:
                return this.getTableNotification().getPageSelected() == this.currentPage + 1;
            case FIRST:
                return this.getTableNotification().is_show_first_page();
        }
        return false;
    }

    public boolean verifyTableNotificationNoRecord() {
        if (this.getTableNotification().is_no_record())
            return true;
        return false;
    }

    public boolean compareTwoListEqual(List<String> listSrc, List<String> listDes) {
        Collections.sort(listSrc);
        Collections.sort(listDes);
        return listSrc.size() == listDes.size() && listSrc.equals(listDes);
    }
}

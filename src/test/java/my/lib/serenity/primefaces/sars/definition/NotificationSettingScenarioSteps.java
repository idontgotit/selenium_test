package my.lib.serenity.primefaces.sars.definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import my.lib.serenity.primefaces.sars.model.NotificationSettingModel;
import my.lib.serenity.primefaces.sars.steps.NotificationSettingSteps;
import net.thucydides.core.annotations.Steps;

import java.util.List;

/**
 * Created by ngoc on 11/10/2016.
 */
public class NotificationSettingScenarioSteps {
    @Steps
    private NotificationSettingSteps notificationSettingSteps;

    @And("^In Notification Setting screen, System show list button can use$")
    public void inNotificationSettingScreenSystemShowListButtonCanUse(List<String> listBtnName) throws Throwable {
        for (int i = 0; i < listBtnName.size(); i++) {
            this.notificationSettingSteps.buttonIsEnable(listBtnName.get(i));
        }
    }

    @And("^In Notification Setting screen, System show list button can not use$")
    public void inNotificationSettingScreenSystemShowListButtonCanNotUse(List<String> listColumnTitle) throws Throwable {
        for (int i = 0; i < listColumnTitle.size(); i++) {
            this.notificationSettingSteps.buttonIsDisable(listColumnTitle.get(i));
        }
    }

    @And("^In Notification Setting screen, Table in the right have (.*) columns$")
    public void inNotificationSettingScreenTableInTheRightHaveNumberClmColumns(int numberColumn) throws Throwable {
        this.notificationSettingSteps.compareColumn(numberColumn);
    }

    @And("^In Notification Setting screen, Table in the left have list select box can select$")
    public void inNotificationSettingScreenTableInTheLeftHaveListSelectBoxCanSelect(List<String> listTitle) throws Throwable {
        for (int i = 0; i < listTitle.size(); i++) {
            this.notificationSettingSteps.verifySelectBoxCanSelect(listTitle.get(i));
        }
    }

    @And("^In Notification Setting screen, link View Notifications is (.*)$")
    public void inNotificationSettingScreenLinkViewNotificationsIsStatusViewNotifications(String statusViewNotification) throws Throwable {
        this.notificationSettingSteps.verifyStatusViewNotification(statusViewNotification);
    }

    @Then("^In Notification Setting screen, I click in (.*)$")
    public void inNotificationSettingScreenIClickInViewNotification(String name) throws Throwable {
        this.notificationSettingSteps.clickWithName(name);
    }

    @Then("^In Notification Setting screen, System show screen View Notification have buttons$")
    public void inNotificationSettingScreenSystemShowScreenViewNotification(List<String> listTitle) throws Throwable {
        this.notificationSettingSteps.systemShowViewNotification(listTitle);
    }

    @And("^In Notification Setting screen, Table in the right have columns like below$")
    public void inNotificationSettingScreenTableInTheRightHaveColumnsLikeBelow(List<String> listColumnTitle) throws Throwable {
        this.notificationSettingSteps.verifyTitleInTable(listColumnTitle);
    }

    @Then("^In Notification Setting screen, i select dropdown (.*) with value (.*)$")
    public void inNotificationSettingScreenISelectDropdownTitleDropdownWithValueValueSelect(String title, String value) throws Throwable {
        this.notificationSettingSteps.selectDrownDownWithValue(title, value);
    }

    @Then("^In Notification Setting screen, i select more dropdown with value below$")
    public void inNotificationSettingScreenISelectMoreDropdownWithValueBelow(List<NotificationSettingModel> params) throws Throwable {
        this.notificationSettingSteps.selectMoreDrownDownWithValue(params.get(0));
    }

    @Then("^In Notification Setting screen, System show message (.*)$")
    public void inNotificationSettingScreenSystemShowMessageSuccessSave(String message) throws Throwable {
        this.notificationSettingSteps.systemShowMessage(message);
        Thread.sleep(1000);
    }

    @And("^In Notification Setting screen, Table in the right have Employee Name selected added$")
    public void inNotificationSettingScreenTableInTheRightHaveEmployeeNameSelectedAdded() throws Throwable {
        this.notificationSettingSteps.verifyEmpNameSelectedAdded();
    }

    @And("^In Notification Setting screen, I delete all in table notification, show message (.*)$")
    public void inNotificationSettingScreenIDeleteAllInTableNotificationShowMessageDeleteSuccess(String message) throws Throwable {
        this.notificationSettingSteps.deleteAllAndVerifyMessage(message);
        Thread.sleep(1000);
    }

    @And("^In Notification Setting screen, Table in the right have all employee in Employee Name added$")
    public void inNotificationSettingScreenTableInTheRightHaveAllEmployeeInEmployeeNameAdded() throws Throwable {
        this.notificationSettingSteps.verifyAllEmpNameAdded();
    }

    @And("^In Notification Setting screen, I delete random in table notification, show message (.*)$")
    public void inNotificationSettingScreenIDeleteRandomInTableNotificationShowMessageDeleteSuccess(String message) throws Throwable {
        this.notificationSettingSteps.deleteRandomAndVerifyMessage(message);
        Thread.sleep(1000);
    }

    @And("^In Notification Setting screen, I click random checkbox in column enable$")
    public void inNotificationSettingScreenIClickRandomCheckboxInColumnEnable() throws Throwable {
        this.notificationSettingSteps.clickRandomCheckBoxEnable();
    }

    @And("^In Notification Setting screen, I click button (.*) page on paging$")
    public void inNotificationSettingScreenIClickButtonNextPagePageOnPaging(String page) throws Throwable {
        this.notificationSettingSteps.clickPageWithNameOnPaging(page);
    }

    @Then("^In Notification Setting screen, Table should show (.*) page$")
    public void inNotificationSettingScreenTableShouldShowLastPagePage(String namePage) throws Throwable {
        this.notificationSettingSteps.verifyPageAfterClick(namePage);
    }

    @Then("^In Notification Setting screen, Table show result with (.*) results in page$")
    public void inNotificationSettingScreenTableShowResultWithNumberPagingResultsInPage(int numberRs) throws Throwable {
        this.notificationSettingSteps.compareNumberResultInPage(numberRs);
    }

    @And("^In Notification Setting screen, Table in the right do not have any record$")
    public void inNotificationSettingScreenTableInTheRightDoNotHaveAnyRecord() throws Throwable {
        this.notificationSettingSteps.verifyTableNotificationNoRecord();
    }

    @And("^In Notification Setting screen, Table in the right have any record$")
    public void inNotificationSettingScreenTableInTheRightHaveAnyRecord() throws Throwable {
        this.notificationSettingSteps.verifyTableNotificationHaveRecord();
    }
}

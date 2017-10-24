package my.lib.serenity.primefaces.sars.steps;

import my.lib.serenity.primefaces.component.ColumnHeaderComponent;
import my.lib.serenity.primefaces.sars.model.NotificationSettingModel;
import my.lib.serenity.primefaces.sars.page.NotificationSettingPage;
import net.thucydides.core.steps.ScenarioSteps;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;
import org.fluentlenium.core.annotation.Page;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by ngoc on 11/10/2016.
 */
public class NotificationSettingSteps extends ScenarioSteps {
    @Page
    private NotificationSettingPage notificationSettingPage;

    public void buttonIsEnable(String buttonText) {
        Assertions.assertThat(this.notificationSettingPage.findByButtonTextInNotificationSetting(buttonText).isEnabled()).isTrue();
    }

    public void buttonIsDisable(String buttonText) {
        Assertions.assertThat(this.notificationSettingPage.findByButtonTextInNotificationSetting(buttonText).isEnabled()).isFalse();
    }

    public void compareColumn(int numberColumn) {
        Assertions.assertThat(this.notificationSettingPage.getTableNotification().getAllColumnHeader().size()).isEqualTo(numberColumn);
    }

    public void verifySelectBoxCanSelect(String title) {
        Assertions.assertThat(this.notificationSettingPage.verifySelectBoxCanSelect(title)).isTrue();
    }

    public void verifyStatusViewNotification(String statusViewNotification) {
        Assertions.assertThat(this.notificationSettingPage.verifyStatusViewNotification(statusViewNotification)).isTrue();
    }

    public void clickWithName(String name) {
        this.notificationSettingPage.clickWithName(name);
    }

    public void systemShowViewNotification(List<String> listTitle) {
        Assertions.assertThat(this.notificationSettingPage.findButtonInScreenByText(listTitle.get(0)).isCurrentlyVisible()).isTrue();
        Assertions.assertThat(this.notificationSettingPage.findButtonInScreenByText(listTitle.get(1)).isCurrentlyEnabled()).isTrue();
    }

    public void verifyTitleInTable(List<String> listColumnTitle) {
        List<ColumnHeaderComponent> allColumnHeader = this.notificationSettingPage.getTableNotification().getAllColumnHeader();
        for (int i = 0; i < listColumnTitle.size(); i++) {
            Assertions.assertThat(listColumnTitle.get(i).equalsIgnoreCase(allColumnHeader.get(i).getTitleText()));
        }
    }

    public void selectDrownDownWithValue(String title, String value) {
        this.notificationSettingPage.selectDrownDownWithValue(title, value);
    }

    public void selectMoreDrownDownWithValue(NotificationSettingModel notificationSettingModel) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (StringUtils.isNotEmpty(notificationSettingModel.getValueBranch()))
            this.notificationSettingPage.selectDrownDownWithValue("Branch", notificationSettingModel.getValueBranch());
        if (StringUtils.isNotEmpty(notificationSettingModel.getValuePosition()))
            this.notificationSettingPage.selectDrownDownWithValue("Position", notificationSettingModel.getValuePosition());
        if (StringUtils.isNotEmpty(notificationSettingModel.getValueEmpName()))
            this.notificationSettingPage.selectDrownDownWithValue("Employee Name", notificationSettingModel.getValueEmpName());
    }

    public void systemShowMessage(String message) {
        {
            this.verifyMessage(message);
            this.notificationSettingPage.wait_for_message_disappeared();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void verifyEmpNameSelectedAdded() {
        Assertions.assertThat(this.notificationSettingPage.verifyEmpNameSelectedAdded()).isTrue();
    }

    public void deleteAllAndVerifyMessage(String message) {
        do {
            try {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.notificationSettingPage.getTableNotification().click_radio_box_by_row_index(0);
                this.notificationSettingPage.clickWithName("Delete");
                this.notificationSettingPage.confirmDelete();
                this.verifyMessage(message);

            } catch (org.openqa.selenium.NoSuchElementException e) {
                break;
            }
        }
        while (!this.notificationSettingPage.getTableNotification().is_no_record());
        this.notificationSettingPage.wait_for_message_disappeared();
    }

    public void verifyAllEmpNameAdded() {
        Assertions.assertThat(this.notificationSettingPage.verifyAllEmpNameAdded()).isTrue();
    }

    public void deleteRandomAndVerifyMessage(String message) {
        int rowNumber = this.notificationSettingPage.getTableNotification().getCountContentRow();
        int randomLoop;
        if (rowNumber > 1) {
            randomLoop = ThreadLocalRandom.current().nextInt(1, rowNumber);
        } else {
            randomLoop = 1;
        }
        for (int i = 0; i < randomLoop; i++) {
            rowNumber = this.notificationSettingPage.getTableNotification().getCountContentRow();
            if (!this.notificationSettingPage.getTableNotification().is_no_record()) {
                int random = ThreadLocalRandom.current().nextInt(0, rowNumber);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.notificationSettingPage.getTableNotification().click_radio_box_by_row_index(random);
                this.notificationSettingPage.clickWithName("Delete");
                this.notificationSettingPage.confirmDelete();
                this.verifyMessage(message);
                this.buttonIsDisable("Delete");
            }
        }
        this.notificationSettingPage.wait_for_message_disappeared();
    }

    private void verifyMessage(String message) {
        List<String> listGrowlMessage = this.notificationSettingPage.getGrowlMessage();
        for (String aListGrowlMessage : listGrowlMessage) {
            Assertions.assertThat(aListGrowlMessage).containsIgnoringCase(message);
        }
    }

    public void clickRandomCheckBoxEnable() {
        this.notificationSettingPage.clickRandomCheckBoxEnable();
    }

    public void clickPageWithNameOnPaging(String page) {
        this.notificationSettingPage.clickPageWithNameOnPaging(page);
    }

    public void verifyPageAfterClick(String namePage) {
        Assertions.assertThat(this.notificationSettingPage.verifyPageAfterClick(namePage)).isTrue();
    }

    public void compareNumberResultInPage(int numberRs) {
        Assertions.assertThat(this.notificationSettingPage.getTableNotification().getCountContentRow()).isEqualTo(numberRs);
    }

    public void verifyTableNotificationNoRecord() {
        Assertions.assertThat(this.notificationSettingPage.verifyTableNotificationNoRecord()).isTrue();
    }

    public void verifyTableNotificationHaveRecord() {
        Assertions.assertThat(this.notificationSettingPage.verifyTableNotificationNoRecord()).isFalse();
    }


}

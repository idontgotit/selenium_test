package my.lib.serenity.primefaces.sars.steps;

import my.lib.serenity.primefaces.sars.page.MaintainCreditDataPage;
import org.assertj.core.api.Assertions;
import org.fluentlenium.core.annotation.Page;

import java.util.List;

/**
 * Created by ngoc on 04/11/2016.
 */
public class MaintainCreditDataSteps {

    @Page
    MaintainCreditDataPage maintainCreditDataPage;


    public void buttonIsEnable(String buttonText) {
        Assertions.assertThat(this.maintainCreditDataPage.getButtonByTitle(buttonText).isEnabled()).isTrue();
    }

    public void clickRadioByName(String name) {
        this.maintainCreditDataPage.clickRadioByName(name);
    }

    public void fieldCanInput(String fieldName) {
        Assertions.assertThat(this.maintainCreditDataPage.verifyInputFieldEnable(fieldName)).isTrue();
        Assertions.assertThat(this.maintainCreditDataPage.verifyInputFieldCanInput(fieldName)).isTrue();
    }

    public void buttonIsDisable(String buttonText) {
        Assertions.assertThat(this.maintainCreditDataPage.getButtonByTitle(buttonText).isEnabled()).isFalse();
    }

    public void fieldCanNotInput(String fieldName) {
        Assertions.assertThat(this.maintainCreditDataPage.verifyInputFieldEnable(fieldName)).isFalse();
        Assertions.assertThat(this.maintainCreditDataPage.verifyInputFieldCanInput(fieldName)).isFalse();
    }

    public void clickBtnByName(String btnName) {
        this.maintainCreditDataPage.clickBtnByName(btnName);
    }

    public void typeToInputField(String input, String fieldName) {
        this.maintainCreditDataPage.typeToInputField(input, fieldName);
    }

    public void tableHaveNumberRecord(int numberRc) {
        Assertions.assertThat(this.maintainCreditDataPage.verifyTableHaveNumberRecord()).isEqualTo(numberRc);
    }

    public void tableHaveNumberClm(int numberClm) {
        Assertions.assertThat(this.maintainCreditDataPage.verifyTableHaveNumberColumn()).isEqualTo(numberClm);
    }

    public void toggleAllColumn(List<String> listColumn) {
        this.maintainCreditDataPage.toggleAllColumn(listColumn);
    }

    public void memoryDataInAccountTable() {
        this.maintainCreditDataPage.memoryDataAccountTable();
    }

    public void selectCheckBoxByRow(int rowSelect) {
        this.maintainCreditDataPage.selectCheckBoxByRow(rowSelect);
    }

    public void verifyTableLikeRowSelect() {
        Assertions.assertThat(this.maintainCreditDataPage.verifyInputField()).isTrue();
        Assertions.assertThat(this.maintainCreditDataPage.verifyClientCode()).isTrue();
        this.maintainCreditDataPage.verifyLabelFieldIdNameCode();
    }


    public void systemShowMessage(String message) {
        {
            this.verifyMessage(message);
            this.maintainCreditDataPage.wait_for_message_disappeared();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void verifyMessage(String message) {
        List<String> listGrowlMessage = this.maintainCreditDataPage.getGrowlMessage();
        for (String aListGrowlMessage : listGrowlMessage) {
            Assertions.assertThat(aListGrowlMessage).containsIgnoringCase(message);
        }
    }

    public void typeToInputFieldInSearchSansan(String input, String field) {
        this.maintainCreditDataPage.typeToInputFieldInSearchSansan(input, field);
    }

    public void clickBtnByNameInSearchSansan(String name) {
        this.maintainCreditDataPage.clickBtnByNameInSearchSansan(name);
    }

    public void tableBelowSearchSansanHaveNumberRecord(int numberRc) {
        Assertions.assertThat(this.maintainCreditDataPage.verifyTableBelowSearchSansanHaveNumberRecord()).isEqualTo(numberRc);
    }

    public void clickOneRecordCanClickSearchSansan() {
        this.maintainCreditDataPage.clickOneRecordCanClickSearchSansan();
    }

    public void verifyFieldTradeNameAfterSelect() {
        Assertions.assertThat(this.maintainCreditDataPage.verifyFieldTradeNameAfterSelect()).isTrue();
    }

    public void unselectRecord() {
        this.maintainCreditDataPage.unselectRecord();
    }

    public void gotoPageWithValue(String valuePage) {
        this.maintainCreditDataPage.gotoPageWithValue(valuePage);
    }

    public void verifyRecordSelectedBeforeChangePage() {
        Assertions.assertThat(this.maintainCreditDataPage.verifyRecordSelectedBeforeChangePage()).isTrue();
    }

    public void verifyFieldHaveValueNotAvailable(String fieldId, String fieldName) {
        Assertions.assertThat(this.maintainCreditDataPage.verifyFieldHaveValueNotAvailable(fieldId, fieldName)).isEqualTo("N/A");
    }

    public void memoDataInTradeNameOfCustomer() {
        this.maintainCreditDataPage.memoDataInTradeNameOfCustomer();
    }

    public void retypeMemoDataInTradeNameOfCustomer(String fieldName) {
        this.maintainCreditDataPage.retypeMemoDataInTradeNameOfCustomer(fieldName);
    }

    public void verifyDataInTradeNameOfCustomerInField(String fieldId, String fieldCompanyName) {
        Assertions.assertThat(this.maintainCreditDataPage.verifyDataInTradeNameOfCustomerInField(fieldId, fieldCompanyName)).isTrue();
    }

    public void clickCheckBoxInSearchSansan(int rowIndex) {
        this.maintainCreditDataPage.clickCheckBoxInSearchSansan(rowIndex);
    }

    public void tableHaveRecord() {
        Assertions.assertThat(this.maintainCreditDataPage.tableHaveRecord()).isTrue();
    }
}

package my.lib.serenity.primefaces.sars.page;

import my.lib.serenity.primefaces.component.*;
import my.lib.serenity.primefaces.component.factory.PFComponentFactory;
import my.lib.serenity.primefaces.sars.model.MaintainCreditAccountTableModel;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ngoc on 04/11/2016.
 */
public class MaintainCreditDataPage extends AbstractPage {

    public ButtonComponent getButtonByTitle(String buttonText) {
        List<WebElementFacade> webElementFacades = this.findAll(By.xpath("//div[@id='contentPanel_content']//button/span[text()='"
                + buttonText + "']/parent::*"));
        if (webElementFacades.get(0).isCurrentlyVisible())
            return PFComponentFactory.wrapButton(this, webElementFacades.get(0));
        else
            return PFComponentFactory.wrapButton(this, webElementFacades.get(1));
    }

    public void clickRadioByName(String name) {
        WebElementFacade webElementFacade;
        try {
            webElementFacade = this.find(By.xpath("//div[@id='contentPanel_content']//td//label[text()='" + name + "']/preceding::input[1]"));
            webElementFacade.click();
        } catch (ElementNotVisibleException env) {
            webElementFacade = this.find(By.xpath("//div[@id='contentPanel_content']//td//label[text()='" + name + "']/preceding::td[1]//span"));
            webElementFacade.click();
        }
    }

    public boolean verifyInputFieldEnable(String fieldName) {
        return this.getInputTextByLabelName(fieldName).isEnabled();
    }

    private InputTextComponent getInputTextByLabelName(String fieldName) {
        return PFComponentFactory.wrapInputText(this, this.find(org.openqa.selenium.By.xpath("*//td[contains(@class,'text-right')]//label[text()='" + fieldName + "']/ancestor::tr//input")));
    }

    public boolean verifyInputFieldCanInput(String fieldName) {
        try {
            this.getInputTextByLabelName(fieldName).type_and_wait("test123");
//            if (this.getGrowlMessage().size() != 0 && StringUtils.indexOfAny(this.getGrowlMessage().get(0), "invalid") != -1) {
//                this.getInputTextByLabelName(fieldName).type_and_wait("01101");
//            }
            return true;
        } catch (InvalidElementStateException e) {
            return false;
        }
    }

    public void clickBtnByName(String btnName) {
        this.getButtonByTitle(btnName).click_and_wait();
    }

    public void typeToInputField(String input, String fieldName) {
        this.getInputTextByLabelName(fieldName).type_and_wait(input);
    }

    public TableComponent getAccountTable() {
        return PFComponentFactory.wrapTable(this, this.find(By.id("formAccountTable:accountTable")));
    }

    public int verifyTableHaveNumberRecord() {
        if (this.getAccountTable().is_no_record())
            return 0;
        else {
            return this.getAccountTable().getCountContentRow();
        }
    }

    public int verifyTableHaveNumberColumn() {
        return this.getAccountTable().getAllColumnHeader().size();
    }

    public void toggleAllColumn(List<String> listColumn) {
        listColumn.forEach(this::toggle_column);
    }

    private void toggle_column(String columnTitle) {
        this.getAccountTable().getToggle().toggle_column(columnTitle);
    }

    public void memoryDataAccountTable() {
        this.maintainCreditAccountTableModel = new MaintainCreditAccountTableModel();
        List<ColumnHeaderComponent> columnHeaderComponents = this.getAccountTable().getAllColumnHeader();
        List<String> listValueInFirstRecord = new ArrayList<>();
        for (int i = 1; i < columnHeaderComponents.size(); i++) {
            try {
                int index = this.getAccountTable().getColumnIndex(columnHeaderComponents.get(i).getTitleText());
                listValueInFirstRecord.add(this.getAccountTable().getAllCellValueByColumnIndex(index).get(0));
            } catch (ElementNotVisibleException enve) {
                listValueInFirstRecord.add(StringUtils.EMPTY);
            }
        }
        this.maintainCreditAccountTableModel.setCustomerCode(listValueInFirstRecord.get(0));
        this.maintainCreditAccountTableModel.setSansanCompanyId(listValueInFirstRecord.get(1));
        this.maintainCreditAccountTableModel.setCompanyName(listValueInFirstRecord.get(2));
        this.maintainCreditAccountTableModel.setCompanyNo(listValueInFirstRecord.get(3));
        this.maintainCreditAccountTableModel.setCompanyNameInKana(listValueInFirstRecord.get(4));
        this.maintainCreditAccountTableModel.setClientStatus(listValueInFirstRecord.get(5));
        this.maintainCreditAccountTableModel.setYearStart(listValueInFirstRecord.get(6));
        this.maintainCreditAccountTableModel.setYearEstablish(listValueInFirstRecord.get(7));
        this.maintainCreditAccountTableModel.setLastExport(listValueInFirstRecord.get(8));

    }

    public void selectCheckBoxByRow(int rowSelect) {
        try {
            Thread.sleep(500);
            this.getAccountTable().select_row_by_index(rowSelect);
        } catch (Exception e) {

        }

    }

    public WebElementFacade getTableTradeNameOfCustomer() {
        return this.find(By.xpath("//div[@id='maintenaceCompanyForm:dataCustomer']//table"));
    }

    public InputTextComponent getInputTextTableTradeNameOfCustomerByName(String name) {
        return PFComponentFactory.wrapInputText(this, this.find(By.xpath("//div[@id='maintenaceCompanyForm:dataCustomer']//table//td[label='" + name + "']/parent::tr//input")));
    }

    public InputTextComponent getInputTextTableSearchSansan(String name) {
        return PFComponentFactory.wrapInputText(this, this.find(By.xpath("//*[@id='searchCompanySansanTable']//td[label='" + name + "']/parent::tr//input")));
    }

    public List<WebElementFacade> getListValueInTableTradeName() {
        return this.findAll(By.xpath("//div[@id='maintenaceCompanyForm:dataCustomer']//table//td[contains(@class,'text-right')]"));
    }

    private List<WebElementFacade> listLabelTradeName;
    private MaintainCreditAccountTableModel maintainCreditAccountTableModel;


    public SelectOneMenuComponent getSelectOneMenuInTradeNameOfCustomerByName(String name) {
        return PFComponentFactory.wrapSelectOneMenu(this, this.find(By.xpath("//div[@id='maintenaceCompanyForm:dataCustomer']//table//td[label='" + name + "']/parent::tr//td[2]/div")));
    }

    public boolean verifyInputField() {
        return
                this.getInputTextTableTradeNameOfCustomerByName("Company name").getValue().equals(this.maintainCreditAccountTableModel.getCompanyName()) &&
                        this.getInputTextTableTradeNameOfCustomerByName("Company name in Kana").getValue().equals(this.maintainCreditAccountTableModel.getCompanyNameInKana()) &&
                        this.getInputTextTableTradeNameOfCustomerByName("Year of starting business").getValue().equals(this.maintainCreditAccountTableModel.getYearStart()) &&
                        this.getInputTextTableTradeNameOfCustomerByName("Year of official establishment").getValue().equals(this.maintainCreditAccountTableModel.getYearEstablish());

    }

    public boolean verifyClientCode() {
        return this.getSelectOneMenuInTradeNameOfCustomerByName("Client code status").getValue().equals(this.maintainCreditAccountTableModel.getClientStatus());
    }

    public String getLabelValueInTradeNameByLabelName(String name) {
        return this.find(By.xpath("//div[@id='maintenaceCompanyForm:dataCustomer']//table//td[label='" + name + "']/parent::tr//td[2]")).getText();
    }

    public TableComponent getSansanCompanyTable() {
        return PFComponentFactory.wrapTable(this, this.find(By.id("maintenaceCompanyForm:sansanCompanyTable")));
    }


    public void verifyLabelFieldIdNameCode() {
        List<WebElementFacade> listLabelTradeName = this.getListValueInTableTradeName();
        String sansanID = this.getLabelValueInTradeNameByLabelName(listLabelTradeName.get(0).getText());
        String[] idAndCode = sansanID.split("\\(");
        idAndCode[0].equals(this.maintainCreditAccountTableModel.getSansanCompanyId());
        idAndCode[1].substring(0, idAndCode[1].length() - 1).equals(this.getInputTextTableSearchSansan("Sansan Company ID").getValue());
        this.getLabelValueInTradeNameByLabelName(listLabelTradeName.get(1).getText()).equals(this.getSansanCompanyTable().getAllCellValueByColumnIndex(2));
        this.getLabelValueInTradeNameByLabelName(listLabelTradeName.get(2).getText()).equals(this.maintainCreditAccountTableModel);
    }

    public List<String> getGrowlMessage() {
        List<String> listGrowlMessage = new ArrayList<>();
        List<WebElementFacade> messagePanel = this.findAll(By.xpath("//*[@id='growl_container']//div[contains(@class,'ui-growl-message')]//p"));
        listGrowlMessage.addAll(messagePanel.stream().map(WebElementFacade::getText).collect(Collectors.toList()));
        return listGrowlMessage;
    }

    public void typeToInputFieldInSearchSansan(String input, String field) {
        this.getInputTextTableSearchSansan(field).type_and_wait(input);
    }

    public void clickBtnByNameInSearchSansan(String name) {
        PFComponentFactory.wrapButton(this, this.find(By.xpath("//*[@id='searchCompanySansanTable']//button/span[text()='" + name + "']/parent::*"))).click_and_wait();
    }

    public int verifyTableBelowSearchSansanHaveNumberRecord() {
        {
            if (this.getSansanCompanyTable().is_no_record())
                return 0;
            else {
                return this.getSansanCompanyTable().getCountContentRow();
            }
        }
    }

    private int rowSelect;

    public void clickOneRecordCanClickSearchSansan() {
        int i = 1;
        while (!this.getSansanCompanyTable().checkSelectBoxHasIndexCanSelect(i)) {
            i++;
            if (i % 5 == 0) {
                this.getSansanCompanyTable().next();
            }
        }
        this.rowSelect = this.convertValueDataRiToRowIndexInTable(i);
        this.getSansanCompanyTable().click_check_box_by_row_index_without_wait(this.rowSelect);
    }

    private int convertValueDataRiToRowIndexInTable(int valueDataRi) {
        if (valueDataRi <= 4) {
            return valueDataRi;
        }
        do {
            valueDataRi = valueDataRi - 5;
        }
        while (valueDataRi > 4);
        return valueDataRi;
    }

    public boolean verifyFieldTradeNameAfterSelect() {
        List<WebElementFacade> listLabelTradeName = this.getListValueInTableTradeName();
        int clmIndex = this.getSansanCompanyTable().getColumnIndex("Company name");
        List<String> listCompanyName = this.getSansanCompanyTable().getAllCellValueByColumnIndex(clmIndex);
        if (this.getSansanCompanyTable().getRowSelectedInCurrentPage().size() == 1) {
            return this.getLabelValueInTradeNameByLabelName(listLabelTradeName.get(1).getText()).equals(listCompanyName.get(this.rowSelect));
        }
        return this.getLabelValueInTradeNameByLabelName(listLabelTradeName.get(1).getText()).equals("N/A") &&
                this.getLabelValueInTradeNameByLabelName(listLabelTradeName.get(0).getText()).equals("N/A");
    }

    public void unselectRecord() {
        this.getSansanCompanyTable().click_check_box_by_row_index(this.rowSelect);
    }

    public void gotoPageWithValue(String valuePage) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switch (valuePage.toLowerCase()) {
            case "next":
                this.getSansanCompanyTable().next();
                break;
            case "previous":
                this.getSansanCompanyTable().back();
                break;
        }
    }

    public boolean verifyRecordSelectedBeforeChangePage() {
        if (this.getSansanCompanyTable().getRowSelectedInCurrentPage().size() == 1) {
            String dataRi = this.getSansanCompanyTable().getRowSelectedInCurrentPage().get(0).getAttribute("data-ri");
            int valueRiAfterConvert = this.convertValueDataRiToRowIndexInTable(Integer.valueOf(dataRi));
            return valueRiAfterConvert == this.rowSelect;

        }
        return false;
    }

    public String verifyFieldHaveValueNotAvailable(String fieldId, String fieldName) {
        if (this.getLabelValueInTradeNameByLabelName(fieldId).equals(
                this.getLabelValueInTradeNameByLabelName(fieldName)))
            return this.getLabelValueInTradeNameByLabelName(fieldId);
        return StringUtils.EMPTY;
    }

    private String customerCode;
    private String sansanCompanyId;
    private String sansanCompanyName;
    private String oldSansanCompanyId;

    public void memoDataInTradeNameOfCustomer() {
        List<WebElementFacade> listLabelTradeName = this.getListValueInTableTradeName();
        if (StringUtils.isNotEmpty(this.sansanCompanyId)) {
            // keep old value for search next step
            this.oldSansanCompanyId = this.sansanCompanyId;
        }
        this.sansanCompanyId = this.getLabelValueInTradeNameByLabelName(listLabelTradeName.get(0).getText());
        this.sansanCompanyName = this.getLabelValueInTradeNameByLabelName(listLabelTradeName.get(1).getText());
        this.customerCode = this.getLabelValueInTradeNameByLabelName(listLabelTradeName.get(2).getText());
    }

    public void retypeMemoDataInTradeNameOfCustomer(String fieldName) {
        switch (fieldName) {
            case "Customer code":
                this.getInputTextByLabelName(fieldName).type_and_wait(this.customerCode);
                break;
            case "Sansan Company ID":
                if (StringUtils.isNotEmpty(this.oldSansanCompanyId)) {
                    this.getInputTextTableSearchSansan(fieldName).type_and_wait(this.oldSansanCompanyId.split("\\(")[0]);
                } else {
                    this.getInputTextTableSearchSansan(fieldName).type_and_wait(this.sansanCompanyId.split("\\(")[0]);
                }
                break;
            case "Company name":
                this.getInputTextByLabelName(fieldName).type_and_wait(this.sansanCompanyName);
                break;
        }
    }

    public boolean verifyDataInTradeNameOfCustomerInField(String fieldId, String fieldCompanyName) {
        String currentSansanIdInTable = this.getAccountTable().getAllCellValueByColumnIndex(this.getAccountTable().getColumnIndex(fieldId)).get(0);
        if (StringUtils.isNotEmpty(currentSansanIdInTable) && StringUtils.isNotEmpty(this.sansanCompanyId) && !this.sansanCompanyId.equalsIgnoreCase("N/A"))
            return currentSansanIdInTable.equals(this.sansanCompanyId.split("\\(")[0]);
        else
            return false;
    }

    public void clickCheckBoxInSearchSansan(int rowIndex) {
        this.getSansanCompanyTable().click_check_box_by_row_index(rowIndex);
    }

    public boolean tableHaveRecord() {
        return !this.getAccountTable().is_no_record();
    }
}

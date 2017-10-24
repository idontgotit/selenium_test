package my.lib.serenity.primefaces.sars.page;

import my.lib.serenity.primefaces.component.*;
import my.lib.serenity.primefaces.component.factory.PFComponentFactory;
import my.lib.serenity.primefaces.sars.model.EmployeeManagementModel;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;
import java.util.stream.Collectors;

import static my.lib.serenity.primefaces.sars.utils.ConstantsEmployeeManagement.*;

/**
 * Created by ngoc on 27/09/2016.
 */
@DefaultUrl("https://192.168.1.4:8447/sars_it/index.xhtml")
public class EmployeeManagementPage extends AbstractPage {

    private int currentPage;

    public TableComponent getTableEmployee() {
        return PFComponentFactory.wrapTable(this, this.findBy("//div[@id='emp_list_form:employeeTable']"));
    }

    private InputTextComponent getEmpName() {
        return PFComponentFactory.wrapInputText(this, this.find(By.id("form:employee_add_name")));
    }

    private InputTextComponent getHireDate() {
        return PFComponentFactory.wrapInputText(this, this.find(By.id("form:employee_add_hire_date:employee_add_hire_date_input")));
    }

    private String getValueWorkingStatus() {
        try {
            return this.find(By.xpath("//table[@id='form:workingStatus']//span[contains(@class,'ui-icon-bullet')]//following::td[1]")).getText();
        } catch (NoSuchElementException nse) {
            return "";
        }
    }

    private InputTextComponent getBaseLocation() {
        return PFComponentFactory.wrapInputText(this, this.find(By.id("form:employee_add_head_office_input")));
    }

    private String getValuePosition() {
        try {
            return this.find(By.xpath("//table[@id='form:employee_add_position']//span[contains(@class,'ui-icon-bullet')]//following::td[1]")).getText();
        } catch (NoSuchElementException nse) {
            return null;
        }
    }

    private String getValueAuthority() {
        try {
            return this.find(By.xpath("//table[@id='form:employee_add_authority']//span[contains(@class,'ui-icon-bullet')]//following::td[1]")).getText();
        } catch (NoSuchElementException nse) {
            return null;
        }
    }

    private InputTextComponent getEmail() {
        return PFComponentFactory.wrapInputText(this, this.find(By.id("form:employee_add_email")));
    }

    private InputTextComponent getTel() {
        return PFComponentFactory.wrapInputText(this, this.find(By.id("form:employee_add_tel")));
    }

    private InputTextComponent getMobile() {
        return PFComponentFactory.wrapInputText(this, this.find(By.id("form:employee_add_mobile")));
    }

    public int getNumberColumnInTableEmployee() {
        return this.findAll(By.xpath("//div[@id='emp_list_form:employeeTable']//th")).size();
    }

    public int getNumberColumnNotHiddenInTableEmployee() {
        return this.findAll(By.xpath("//div[@id='emp_list_form:employeeTable']//th[not(contains(@class,'ui-helper-hidden'))]")).size();
    }

    private int getPageActive() {
        return Integer.valueOf(this.find(By.xpath("//div[@id='emp_list_form:employeeTable_paginator_bottom']//span[contains(@class,'ui-state-active')]")).getText());
    }

    public ButtonComponent getButtonByTitle(String buttonTitle) {
        return PFComponentFactory.wrapButton(this, this.findBy("//div[@id='contentPanel_content']//button/span[text()='"
                + buttonTitle + "']/parent::*"));
    }

    public WebElementFacade findByButtonText(String buttonText) {
        return this.find(By.xpath("//div[@id='contentPanel_content']//span[text()='" + buttonText + "']//parent::*"));
    }

    public void typeTextToFilterColumn(String textSend, String columnName) {
        InputTextComponent input = this.getTableEmployee().getFilter(columnName);
        input.type_and_enter(textSend);
    }

    private List<String> getAllCellValueByColumnIndex(int columnIndex) {
        List<String> listText = new ArrayList<>();
        List<WebElementFacade> listAll = this.findAll(By.xpath("//div[@id='emp_list_form:employeeTable']//tr/td[" + columnIndex + "]"));
        listText.addAll(listAll.stream().map(WebElementFacade::getText).collect(Collectors.toList()));
        return listText;
    }

    public List<WebElementFacade> getAllResultInPage() {
        return this.findAll(By.xpath("//tbody[@id='emp_list_form:employeeTable_data']//tr"));
    }

    public List<String> getValueTableInPageByColumnName(String columnName) {
        TableComponent table = PFComponentFactory.wrapTable(this, this.findBy("//div[@id='emp_list_form:employeeTable']"));
        int index = table.getColumnIndex(columnName);
        return this.getAllCellValueByColumnIndex(index);
    }

    public List<String> getGrowlMessage() {
        List<String> listGrowlMessage = new ArrayList<>();
        List<WebElementFacade> messagePanel = this.findAll(By.xpath("//*[@id='growl_container']//div[contains(@class,'ui-growl-message')]//p"));
        listGrowlMessage.addAll(messagePanel.stream().map(WebElementFacade::getText).collect(Collectors.toList()));
        return listGrowlMessage;
    }

    public void clickPage(int numberPage) {
        ButtonComponent buttonComponent = PFComponentFactory.wrapButton(this, this.findBy("//div[@id='emp_list_form:employeeTable_paginator_bottom']//span[text()='" + numberPage + "']"));
        buttonComponent.click_and_wait();
    }

    public void clickSort(String columnName) {
        ColumnHeaderComponent header = this.getTableEmployee().getColumnHeaderByTitle(columnName);
        header.click_title_and_wait();
    }

    public void selectRecord(int indexRecord) {
        this.getTableEmployee().select_row_by_index(indexRecord);
    }

    public void chooseTextInSelectBoxByColumnTitle(String textFilter, String columnTitle) {
        this.getTableEmployee().choose_value_for_dropdown_filter_in_column(textFilter, columnTitle);
    }

    public void selectButton(String buttonTitle) {
        ButtonComponent buttonComponent = PFComponentFactory.wrapButton(this, this.findBy("//div[@id='contentPanel_content']//button/span[text()='"
                + buttonTitle + "']/parent::*"));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buttonComponent.click_and_wait();
    }

    public void fillDataRequireInEmployeeManagement(String empName, String hireDate, String status, String baseLocation, String privilege, String email) throws InterruptedException {
        InputTextComponent employeeName = PFComponentFactory.wrapInputText(this, this.find(By.id("form:employee_add_name")));
        employeeName.type_and_wait(empName);
        CalendarComponent calendarComponent = PFComponentFactory.wrapCalendarElement(this, this.find(By.xpath("//form[@id='form']//span[@id='form:employee_add_hire_date:employee_add_hire_date']")));
        calendarComponent.openDateTimeSelect();
        calendarComponent.setLocale(Locale.ENGLISH);
        int year = Integer.valueOf(hireDate.split("/")[0]);
        int month = Integer.valueOf(hireDate.split("/")[1]);
        int day = Integer.valueOf(hireDate.split("/")[2]);
        calendarComponent.select_year_month(year, month);
        calendarComponent.select_date_of_month(day);
        this.selectBaseLocation(baseLocation);
        this.find(By.xpath("//*[text()='" + status + "']//parent::td//preceding::td[1]")).click();
        SelectOneMenuComponent privilegeSelectBox = PFComponentFactory.wrapSelectOneMenu(this, this.find(By.id("form:employee_add_position")));
        privilegeSelectBox.select_option_by_text(privilege);
        InputTextComponent emailInput = PFComponentFactory.wrapInputText(this, this.find(By.id("form:employee_add_email")));
        emailInput.type_and_wait(email);
    }

    public void fillDataNotRequireInEmployeeManagement(String tel, String mobile) {
        this.getTel().type_and_wait(tel);
        this.getMobile().type_and_wait(mobile);
    }

    private void selectBaseLocation(String baseLocation) {
        AutoCompleteComponent webElementFacade = PFComponentFactory.wrapAutoCompleteElement(this, this.findBy("//span[@id='form:employee_add_head_office']"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webElementFacade.click_drop_down();
        webElementFacade.select_result_by_text(baseLocation);
    }

    public void clearAllDataBeforeNewInput() {
        this.getEmpName().type_and_wait(StringUtils.EMPTY);
        this.getEmail().type_and_wait(StringUtils.EMPTY);
        InputTextComponent baseLocation = PFComponentFactory.wrapInputText(this, this.find(By.id("form:employee_add_head_office_input")));
        baseLocation.type_and_wait(StringUtils.EMPTY);
        this.getTel().type_and_wait(StringUtils.EMPTY);
        this.getMobile().type_and_wait(StringUtils.EMPTY);
    }

    public void selectBackButton() {
        try {
            ButtonComponent buttonComponent = PFComponentFactory.wrapButton(this, this.findBy("//button[@id='form:btnclose']"));
            buttonComponent.click_and_wait();
        } catch (UnhandledAlertException e) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            this.getDriver().switchTo().alert().accept();
            PanelComponent companyTradeMark = PFComponentFactory.wrapPanel(this, By.xpath("//div[@id='companyTradeMark']"));
            companyTradeMark.wait_for_ajax_done();
        } finally {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Alert alert = ExpectedConditions.alertIsPresent().apply(this.getDriver());
            if (alert != null) {
                alert.accept();
            }
        }
    }

    public EmployeeManagementModel createPhantomInputValue() {
        EmployeeManagementModel empModelBeforeReset = new EmployeeManagementModel();
        empModelBeforeReset.setEmpName(this.getEmpName().getValue());
        empModelBeforeReset.setBaseLocation(this.getBaseLocation().getValue());
        empModelBeforeReset.setEmail(this.getEmail().getValue());
        empModelBeforeReset.setHireDate(String.valueOf(this.getHireDate().getValue()));
        empModelBeforeReset.setMobile(this.getMobile().getValue());
        empModelBeforeReset.setPrivilege(this.getValuePosition());
        empModelBeforeReset.setStatus(String.valueOf(this.getValueWorkingStatus()));
        empModelBeforeReset.setTel(this.getTel().getValue());
        return empModelBeforeReset;
    }

    public boolean compareValueAfterReset(EmployeeManagementModel empModelBeforeReset) {
        return this.getEmpName().getValue().equals(empModelBeforeReset.getEmpName()) &&
                String.valueOf(this.getHireDate().getValue()).equals(empModelBeforeReset.getHireDate()) &&
                java.util.Objects.equals(this.getValueWorkingStatus(), empModelBeforeReset.getStatus()) &&
                this.getBaseLocation().getValue().equals(empModelBeforeReset.getBaseLocation()) &&
                this.getEmail().getValue().equals(empModelBeforeReset.getEmail()) &&
                this.getMobile().getValue().equals(empModelBeforeReset.getMobile());
    }

    public void confirmDelete() {
        PFComponentFactory.wrapButton(this, this.find(By.xpath("//div[contains(@class,'ui-confirm-dialog') and contains(@style,'display: block')]//span[text()='Yes']//ancestor::button"))).click_and_wait();
    }

    public void findRecordWithNameAndSelect(String name) {
        List<Integer> listIndex = this.findRecordWithName(name);
        if (listIndex.size() == 1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.selectRecord(listIndex.get(0));
        }
    }

    private List<Integer> findRecordWithName(String name) {
        List<WebElementFacade> listAll = this.findAll(By.xpath("//tbody[@id='emp_list_form:employeeTable_data']//tr[not(contains(@class,'deleted'))]"));
        return listAll.stream().filter(aListAll -> aListAll.findBy("td[4]").getText().equalsIgnoreCase(name)).map(aListAll -> Integer.valueOf(aListAll.getAttribute("data-ri"))).collect(Collectors.toList());
    }

    public String generateUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
    }

    private List<Integer> findRecordCanClick() {
        List<WebElementFacade> listAll = this.findAll(By.xpath("//tbody[@id='emp_list_form:employeeTable_data']//tr[not(contains(@class,'deleted'))]"));
        return listAll.stream().map(aListAll -> Integer.valueOf(aListAll.getAttribute("data-ri"))).collect(Collectors.toList());
    }

    public void selectIndexRecordCanClick(int index) {
        List<Integer> listIndex = this.findRecordCanClick();
        if (index <= listIndex.size())
            this.selectRecord(listIndex.get(index - 1));
        else {
            do {
                this.getTableEmployee().next();
                listIndex = this.findRecordCanClick();
                if (index <= listIndex.size())
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                this.selectRecord(listIndex.get(index - 1));
                // if next cant click break do while
                if (!this.getTableEmployee().is_show_last_page())
                    break;
            }
            while (index > listIndex.size());
        }
    }

    public void toggleAllColumn(List<String> listColumnTitle) {
        listColumnTitle.forEach(this::toggle_column);
    }

    private void toggle_column(String columnTitle) {
        this.getTableEmployee().getToggle().toggle_column(columnTitle);
    }

    public void clickPageWithNameOnPaging(String namePage) {
        switch (namePage) {
            case LAST:
                this.getTableEmployee().last();
                break;
            case PREVIOUS:
                this.currentPage = this.getPageActive();
                this.getTableEmployee().back();
                break;
            case NEXT:
                this.currentPage = this.getPageActive();
                this.getTableEmployee().next();
                break;
            case FIRST:
                this.getTableEmployee().first();
                break;
        }
    }

    public boolean verifyPageAfterClick(String namePage) {
        switch (namePage) {
            case LAST:
                return this.getTableEmployee().is_show_last_page();
            case PREVIOUS:
                return this.getPageActive() == this.currentPage - 1;
            case NEXT:
                return this.getPageActive() == this.currentPage + 1;
            case FIRST:
                return this.getTableEmployee().is_show_first_page();
        }
        return false;
    }

    public boolean verifyRecordSelected(int index) {
        List<WebElementFacade> webElementFacades = this.getTableEmployee().getRowSelectedInCurrentPage();
        if (webElementFacades.size() == 1) {
            int indexSelected = Integer.valueOf(webElementFacades.get(0).getAttribute("data-ri"));
            return indexSelected == index;
        }
        return false;
    }

    public boolean verifyMaxLengthInputFieldByName(String name, Integer maxLength) {
        switch (name) {
            case EMPLOYEE_NAME:
                return this.verifyInputEmployeeNameMaxLength(maxLength);
            case EMAIL:
                return this.verifyInputEmailMaxLength(maxLength);
            case TEL:
                return this.verifyInputTelMaxLength(maxLength);
            case MOBILE:
                return this.verifyInputMobileMaxLength(maxLength);
            default:
                return false;
        }
    }

    private boolean verifyInputEmployeeNameMaxLength(Integer maxLength) {
        return this.getEmpName().getMaxLength() != null && Objects.equals(this.getEmpName().getMaxLength(), maxLength);
    }

    private boolean verifyInputEmailMaxLength(Integer maxLength) {
        return this.getEmail().getMaxLength() != null && Objects.equals(this.getEmail().getMaxLength(), maxLength);
    }

    private boolean verifyInputTelMaxLength(Integer maxLength) {
        return this.getTel().getMaxLength() != null && Objects.equals(this.getTel().getMaxLength(), maxLength);
    }

    private boolean verifyInputMobileMaxLength(Integer maxLength) {
        return this.getMobile().getMaxLength() != null && Objects.equals(this.getMobile().getMaxLength(), maxLength);
    }

}

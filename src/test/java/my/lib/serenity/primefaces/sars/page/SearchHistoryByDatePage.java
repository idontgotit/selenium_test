package my.lib.serenity.primefaces.sars.page;

import my.lib.serenity.primefaces.component.*;
import my.lib.serenity.primefaces.component.factory.PFComponentFactory;
import my.lib.serenity.primefaces.constant.CommonConstant;
import my.lib.serenity.primefaces.sars.utils.CommonUtils;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by arrow on 11/10/16.
 */
public class SearchHistoryByDatePage extends AbstractPage {

    private CalendarComponent calendarDate;
    private SelectOneMenuComponent dropdownBranch;
    private AutoCompleteComponent autoCompleteEmployee;
    private ButtonComponent buttonSearch;
    private ButtonComponent buttonEdit;
    private ButtonComponent buttonDelete;
    private ButtonComponent buttonShowAllBusinessDetails;
    private ToggleComponent toggleColumn;
    private CheckboxComponent checkboxRetired;
    private TableComponent tableSearchByDateResult;

    public boolean is_initialization_screen() {
        return this.getCalendarDate().isCurrentEnable() && this.getDropdownBranch().isEnabled() && this.getAutoCompleteEmployee().isCurrentEnable()
                && !this.getButtonSearch().isEnabled() && !this.isButtonEditRendered() && !this.isButtonDeleteRendered()
                && this.getCheckboxRetired().isVisible();
    }

    public boolean isButtonEditRendered() {
        return this.getButtonEdit() != null;
    }

    public boolean isButtonDeleteRendered() {
        return this.getButtonDelete() != null;
    }

    public CalendarComponent getCalendarDate() {
        if (calendarDate == null) {
            calendarDate = PFComponentFactory.wrapCalendar(this, By.xpath("//button[contains(@class,'ui-datepicker-trigger')]/parent::span"));
        }
        return calendarDate;
    }

    public SelectOneMenuComponent getDropdownBranch() {
        if (dropdownBranch == null) {
            dropdownBranch = PFComponentFactory.wrapSelectOneMenu(this, this.findBy("//div[@id='search_by_date_form:company_base']"));
        }
        return dropdownBranch;
    }

    public AutoCompleteComponent getAutoCompleteEmployee() {
        if (autoCompleteEmployee == null) {
            autoCompleteEmployee = PFComponentFactory.wrapAutoComplete(this, "//span[@id='search_by_date_form:listEmployee']");
        }
        return autoCompleteEmployee;
    }

    public ButtonComponent getButtonSearch() {
        if (buttonSearch == null) {
            buttonSearch = PFComponentFactory.wrapButton(this, this.findBy("//form[@id='search_by_date_form']//span[text()='Search']/parent::button"));
        }
        return buttonSearch;
    }

    public ButtonComponent getButtonEdit() {
        try {
            buttonEdit = PFComponentFactory.wrapButton(this, this.findBy("//button[@id='search_by_date_form:editButton']"));
        } catch (NoSuchElementException e) {
            buttonEdit = null;
        }
        return buttonEdit;
    }

    public ButtonComponent getButtonDelete() {
        try {
            buttonDelete = PFComponentFactory.wrapButton(this, this.findBy("//button[@id='search_by_date_form:deleteButton']"));
        } catch (NoSuchElementException e) {
            buttonDelete = null;
        }
        return buttonDelete;
    }

    public ButtonComponent getButtonShowAllBusinessDetails() {
        if (buttonShowAllBusinessDetails == null) {
            buttonShowAllBusinessDetails =
                    PFComponentFactory.wrapButton(this, this.findBy("//div[@id='search_by_date_form:employeeScreenId_reportTable']//span[text()='Show all Business Detail']/parent::button"));
        }
        return buttonShowAllBusinessDetails;
    }

    public ToggleComponent getToggleColumn() {
        if (toggleColumn == null) {
            toggleColumn =
                    PFComponentFactory.wrapToggleComponent(this, this.findBy("//div[@id='search_by_date_form:employeeScreenId_reportTable']//button[@id='search_by_date_form:employeeScreenId_reportTable:toggler']"));
        }
        return toggleColumn;
    }

    public CheckboxComponent getCheckboxRetired() {
        if (checkboxRetired == null) {
            checkboxRetired = PFComponentFactory.wrapCheckboxComponent(this, this.findBy("//div[@id='search_by_date_form:toggleRetiredEmployee']"));
        }
        return checkboxRetired;
    }

    public TableComponent getTableSearchByDateResult() {
        if (tableSearchByDateResult == null) {
            tableSearchByDateResult = PFComponentFactory.wrapTable(this, this.findBy("//div[@id='search_by_date_form:employeeScreenId_reportTable']"));
        }
        return tableSearchByDateResult;
    }

    public void search_by_date_screen_i_click_button(String buttonText) {
        this.findBy("//form[@id='search_by_date_form']//span[text()='" + buttonText + "']/parent::button").waitUntilEnabled().waitUntilClickable();
        PFComponentFactory.wrapButton(this, this.findBy("//form[@id='search_by_date_form']//span[text()='" + buttonText + "']/parent::button")).click_and_wait();
    }

    public boolean is_show_panel_message() {
        return this.find(By.xpath("//div[@id='growl_container']")).isCurrentlyVisible();
    }

    public List<String> getListMessageText() {
        List<WebElementFacade> listErrorMessages = this.findAll("//div[@id='growl_container']//div[@class='ui-growl-message']//p");
        List<String> listErrorMessageText = listErrorMessages.stream().map(WebElementFacade::getText).collect(Collectors.toList());
        return listErrorMessageText;
    }

    public boolean should_show_required_branch_and_employee_error_message() {
        boolean isShowMessage = this.is_show_panel_message();
        List<String> listErrorMessagesText = this.getListMessageText();
        this.wait_for_message_disappeared();
        return isShowMessage && listErrorMessagesText.contains(CommonConstant.EMPLOYEE_REQUIRED_MESSAGE_TEXT);
    }

    public void toggle_dropdown_branch() {
        this.getDropdownBranch().open_menu_options();
    }

    public void choose_a_branch_in_dropdown_branch(String branchName) {
        this.getDropdownBranch().select_option_by_text(branchName);
    }

    public void type_value_for_autocomplete_employee(String employeeInfo) {
        this.getAutoCompleteEmployee().input_text(employeeInfo);
    }

    public void choose_employee_in_dropdown_of_autocomplete_employee(String employeeInfo) {
        autoCompleteEmployee = PFComponentFactory.wrapAutoComplete(this, "//span[@id='search_by_date_form:listEmployee']");
        this.getAutoCompleteEmployee().select_result_by_text(employeeInfo);
    }

    public boolean should_show_table_search_by_date_result_with_no_record_found() {
        return this.getTableSearchByDateResult().is_no_record();
    }

    public void select_date_in_item_date(String date) {
        this.getCalendarDate().select_date(CommonUtils.parseStringToYearMonthDayLocalDate(date));
    }

    public boolean should_show_table_search_by_date_result_has_record_found() {
        this.tableSearchByDateResult = PFComponentFactory.wrapTable(this, this.findBy("//div[@id='search_by_date_form:employeeScreenId_reportTable']"));
        return !tableSearchByDateResult.is_no_record();
    }

    public void click_checkbox_include_retired_employee() {
        this.getCheckboxRetired().click_and_wait();
    }

    public boolean should_show_required_employee_error_message() {
        boolean isShowMessage = this.is_show_panel_message();
        List<String> listErrorMessagesText = this.getListMessageText();
        this.wait_for_message_disappeared();
        return isShowMessage && listErrorMessagesText.contains(CommonConstant.EMPLOYEE_REQUIRED_MESSAGE_TEXT);
    }

    public void click_button_last_page_on_paging() {
        this.getTableSearchByDateResult().last();
    }

    public boolean table_search_by_date_result_should_show_last_page() {
        return this.getTableSearchByDateResult().is_show_last_page();
    }

    public void click_button_first_page_on_paging() {
        this.getTableSearchByDateResult().first();
    }

    public boolean table_search_by_date_result_should_show_first_page() {
        return this.getTableSearchByDateResult().is_show_first_page();
    }

    public void click_page_on_paging(int pageIndex) {
        this.getTableSearchByDateResult().click_page_on_paging(pageIndex);
    }

    public void click_button_next_on_paging() {
        this.getTableSearchByDateResult().next();
    }

    public void click_button_back_on_paging() {
        this.getTableSearchByDateResult().back();
    }

    public boolean table_search_by_date_result_should_expand_all_row() {
        tableSearchByDateResult = PFComponentFactory.wrapTable(this, this.findBy("//div[@id='search_by_date_form:employeeScreenId_reportTable']"));
        return this.getTableSearchByDateResult().isExpandAll();
    }

    public void open_toggle_menu_in_table_search_by_date_result() {
        this.getTableSearchByDateResult().getToggle().toggle_menu();
    }

    public void toggle_column_by_title(String columnTitle) {
        this.getTableSearchByDateResult().getToggle().toggle_column(columnTitle);
    }

    public void select_row(int rowIndex) {
        this.getTableSearchByDateResult().click_radio_box_by_row_index(rowIndex);
    }

    public boolean should_show_confirm_delete_popup() {
        return this.findBy("*//div[contains(@class,'ui-confirm-dialog')]").isCurrentlyVisible();
    }

    public void click_button_in_confirm_delete_popup(String buttonTitle) {
        PFComponentFactory.wrapButton(this, this.findBy("//body/div[contains(@class,'ui-confirm-dialog') and @aria-hidden='false']/div/button[contains(@class,'ui-confirmdialog-" + buttonTitle.toLowerCase() + "')]")).click_and_wait();
    }

    public boolean should_show_message_delete_successfully() {
        boolean isShowMessage = this.is_show_panel_message();
        List<String> listMessagesText = this.getListMessageText();
        this.wait_for_message_disappeared();
        return isShowMessage && listMessagesText.contains(CommonConstant.DELETE_SUCCESSFULLY_MESSAGE_TEXT);
    }

    public boolean should_not_show_button_edit_and_delete() {
        return this.getButtonEdit() == null && this.getButtonDelete() == null;
    }

    public boolean should_show_table_search_by_date_result_can_not_select_any_row() {
        return this.getTableSearchByDateResult().can_not_select_row();
    }

    public boolean is_button_edit_enabled() {
        return this.getButtonEdit() != null && this.getButtonEdit().isEnabled();
    }

    public boolean is_button_delete_enabled() {
        return this.getButtonDelete() != null && this.getButtonDelete().isEnabled();
    }

    public boolean should_show_button_edit_and_delete_disabled() {
        return !this.is_button_edit_enabled() && !this.is_button_delete_enabled();
    }
}

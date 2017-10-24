package my.lib.serenity.primefaces.sars.page;

import my.lib.serenity.primefaces.component.*;
import my.lib.serenity.primefaces.component.factory.PFComponentFactory;
import my.lib.serenity.primefaces.constant.CommonConstant;
import my.lib.serenity.primefaces.sars.model.DailyReportModel;
import my.lib.serenity.primefaces.sars.utils.CommonUtils;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Created by arrow on 14/10/16.
 */
public class RegisterDailyReportPage extends AbstractPage {

    public AutoCompleteComponent getAutoCompleteCompany() {
        return PFComponentFactory.wrapAutoComplete(this, "*//span[@id='registerDailyReportForm:companyAutoComplete']");
    }

    public TextAreaComponent getTextAreaContentBusiness() {
        return PFComponentFactory.wrapTextArea(this, this.findBy("*//textarea[@id='registerDailyReportForm:txtContentBusiness']"));
    }

    public TextAreaComponent getTextAreaContentOther() {
        return PFComponentFactory.wrapTextArea(this, this.findBy("*//textarea[@id='registerDailyReportForm:txtContentOther']"));
    }

    public ButtonComponent getButtonAdd() {
        return PFComponentFactory.wrapButton(this, this.findBy("*//button[@id='registerDailyReportForm:btnAdd']"));
    }

    public CalendarComponent getCalendarDate() {
        return PFComponentFactory.wrapCalendarElement(this, this.findBy("//form[@id='registerDailyReportForm']//button[contains(@class,'ui-datepicker-trigger')]//parent::span"));
    }

    public TableComponent getTableDailyReportHistory() {
        return PFComponentFactory.wrapTable(this, this.findBy("//form[@id='registerDailyReportForm']//div[@id='registerDailyReportForm:reportTable']"));
    }

    public ButtonComponent getButtonDelete() {
        return PFComponentFactory.wrapButton(this, this.findBy("//form[@id='registerDailyReportForm']//div[@id='registerDailyReportForm:reportTable']//button[@id='registerDailyReportForm:reportTable:leftDeleteButton']"));
    }

    public TimePickerComponent getTimePickerStart() {
        return PFComponentFactory.wrapTimePicker(this, this.findBy("//form[@id='registerDailyReportForm']//div[@id='registerDailyReportForm:panelReport']//span[@id='registerDailyReportForm:startWorkingTime']"));
    }

    public TimePickerComponent getTimePickerEnd() {
        return PFComponentFactory.wrapTimePicker(this, this.findBy("//form[@id='registerDailyReportForm']//div[@id='registerDailyReportForm:panelReport']//span[@id='registerDailyReportForm:endWorkingTime']"));
    }

    public SelectOneRadioComponent getCategory() {
        return PFComponentFactory.wrapSelectOneRadio(this, this.findBy("//form[@id='registerDailyReportForm']//table[@id='registerDailyReportForm:Kachigori']"));
    }

    public SelectOneMenuComponent getSelectBranch() {
        return PFComponentFactory.wrapSelectOneMenu(this, this.findBy("//form[@id='registerDailyReportForm']//div[@id='registerDailyReportForm:branchOfCompany']"));
    }

    public AutoCompleteComponent getAutoCompletePersonInCharge() {
        return PFComponentFactory.wrapAutoComplete(this, "//form[@id='registerDailyReportForm']//div[@id='registerDailyReportForm:psnInChargePanel']");
    }

    public AutoCompleteComponent getAutoCompleteDepartment() {
        return PFComponentFactory.wrapAutoComplete(this, "//form[@id='registerDailyReportForm']//div[@id='registerDailyReportForm:departmentPanel']");
    }

    public SelectOneMenuComponent getSelectBusinessType() {
        return PFComponentFactory.wrapSelectOneMenu(this, this.findBy("//form[@id='registerDailyReportForm']//div[@id='registerDailyReportForm:ddlBusinessType']"));
    }

    public SelectOneMenuComponent getSelectPurpose() {
        return PFComponentFactory.wrapSelectOneMenu(this, this.findBy("//form[@id='registerDailyReportForm']//div[@id='registerDailyReportForm:ddlActivityType']"));
    }

    public SelectOneRadioComponent getReminder() {
        return PFComponentFactory.wrapSelectOneRadio(this, this.findBy("//form[@id='registerDailyReportForm']//table[@id='registerDailyReportForm:rdbReminder']"));
    }

    public SelectOneRadioComponent getProjectFlag() {
        return PFComponentFactory.wrapSelectOneRadio(this, this.findBy("//form[@id='registerDailyReportForm']//table[@id='registerDailyReportForm:projectFlag']"));
    }

    public SelectOneRadioComponent getOpenFlag() {
        return PFComponentFactory.wrapSelectOneRadio(this, this.findBy("//form[@id='registerDailyReportForm']//table[@id='registerDailyReportForm:openFlag']"));
    }

    public ButtonComponent getButtonUpdate() {
        return PFComponentFactory.wrapButton(this, this.findBy("//button[@id='registerDailyReportForm:saveButon']"));
    }

    public CalendarComponent getReminderFrom() {
        return PFComponentFactory.wrapCalendarElement(this, this.findBy("//span[@id='registerDailyReportForm:dateReminderStartTime']"));
    }

    public CalendarComponent getReminderTo() {
        return PFComponentFactory.wrapCalendarElement(this, this.findBy("//span[@id='registerDailyReportForm:dateReminderEndTime']"));
    }

    public CommandLinkComponent getLinkRegisterNow() {
        return PFComponentFactory.wrapCommandLinkElement(this, this.findBy("//div[@id='registerDailyReportForm:searchCompanyPanel']//a[contains(.,'Register now')]"));
    }

    public List<WebElementFacade> getListVisibleSuggestionItems() {
        try {
            return this.findAll("//body/ul[contains(@class,'arrow-suggestion-panel') and contains(@style,'display: inline-block')]/li[contains(@class,'arrow-suggestion-select-items')]");
        } catch (NoSuchElementException e) {
            return Collections.emptyList();
        }
    }

    public void set_data_for_screen(DailyReportModel dailyReportModel) {
        if (StringUtils.isNotEmpty(dailyReportModel.getCompanyName())) {
            this.getAutoCompleteCompany().input_text(dailyReportModel.getCompanyName());
            this.getAutoCompleteCompany().select_result(dailyReportModel.getCompanyName(), 0);
        }

        if (StringUtils.isNotEmpty(dailyReportModel.getContent())) {
            TextAreaComponent textAreaComponent = this.getCategory().getRadioButton(0).isSelected() ? this.getTextAreaContentBusiness() : this.getTextAreaContentOther();
            textAreaComponent.input_text(dailyReportModel.getContent());
        }

        if (StringUtils.isNotEmpty(dailyReportModel.getBusinessType())) {
            this.getSelectBusinessType().select_option_by_text(dailyReportModel.getBusinessType());
        }

        if (StringUtils.isNotEmpty(dailyReportModel.getPurpose())) {
            this.getSelectPurpose().select_option_by_text(dailyReportModel.getPurpose());
        }

        if (StringUtils.isNotEmpty(dailyReportModel.getReminder())) {
            if (CommonConstant.FLAG_ON.equalsIgnoreCase(dailyReportModel.getReminder())) {
                this.getReminder().getRadioButton(0).click_and_wait();
                if (StringUtils.isNoneEmpty(dailyReportModel.getReminderFrom())) {
                    this.getReminderFrom().select_date(CommonUtils.parseStringToYearMonthDayLocalDate(dailyReportModel.getReminderFrom()), Locale.ENGLISH);
                }
                if (StringUtils.isNoneEmpty(dailyReportModel.getReminderTo())) {
                    this.getReminderTo().select_date(CommonUtils.parseStringToYearMonthDayLocalDate(dailyReportModel.getReminderTo()), Locale.ENGLISH);
                }
            } else if (CommonConstant.FLAG_OFF.equalsIgnoreCase(dailyReportModel.getReminder())) {
                this.getReminder().getRadioButton(1).click_and_wait();
            }
        }

        if (StringUtils.isNotEmpty(dailyReportModel.getProjectFlag())) {
            int projectIndex = CommonConstant.FLAG_ON.equalsIgnoreCase(dailyReportModel.getProjectFlag()) ? 0 : 1;
            this.getProjectFlag().getRadioButton(projectIndex).click_and_wait();

        }

        if (StringUtils.isNoneEmpty(dailyReportModel.getOpenFlag())) {
            int openIndex = CommonConstant.FLAG_ON.equalsIgnoreCase(dailyReportModel.getOpenFlag()) ? 0 : 1;
            this.getOpenFlag().getRadioButton(openIndex).click_and_wait();
        }

        if (StringUtils.isNotEmpty(dailyReportModel.getPersonInCharge())) {
            this.getAutoCompletePersonInCharge().getInput().type(dailyReportModel.getPersonInCharge());
            this.waitForSuggestionVisibleAndSelectItem(0);
        }

        if (StringUtils.isNotEmpty(dailyReportModel.getDepartment())) {
            this.getAutoCompleteDepartment().getInput().type(dailyReportModel.getDepartment());
            this.waitForSuggestionVisibleAndSelectItem(0);
        }
    }

    private void waitForSuggestionVisibleAndSelectItem(int index) {
        try {
            // Wait 2s for suggestion panel visible
            Thread.sleep(2000);
            List<WebElementFacade> listItems = this.getListVisibleSuggestionItems();
            if (CollectionUtils.isNotEmpty(listItems)) {
                listItems.get(index).click();
            }
            // Wait for other element updated
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update_daily_report_with_data_below(DailyReportModel dailyReportModel) {
        if (StringUtils.isNotEmpty(dailyReportModel.getCompanyName())) {
            this.getCategory().getRadioButton(0).click_and_wait();
        } else {
            this.getCategory().getRadioButton(1).click_and_wait();
        }
        this.set_data_for_screen(dailyReportModel);
        this.getButtonUpdate().click_and_wait();
    }

    public void fill_daily_report_screen_with_data_below(DailyReportModel dailyReportModel) {
        this.set_data_for_screen(dailyReportModel);
    }

    public void add_new_daily_report_with_data_below(DailyReportModel dailyReportModel) {
        this.getCategory().waitUntilClickable();
        if (StringUtils.isNotEmpty(dailyReportModel.getCompanyName())) {
            this.getCategory().getRadioButton(0).click_and_wait();
        } else {
            this.getCategory().getRadioButton(1).click_and_wait();
        }
        this.set_data_for_screen(dailyReportModel);
        this.getButtonAdd().click_and_wait();
    }

    public boolean should_show_message_save_daily_report_successfully() {
        boolean isShowMessage = this.is_show_panel_message();
        List<String> listMessagesText = this.getListMessageText();
        this.wait_for_message_disappeared();
        return isShowMessage && listMessagesText.contains(CommonConstant.ADD_NEW_DAILY_REPORT_SUCCESS_MESSAGE);
    }

    public boolean is_show_panel_message() {
        return this.find(By.xpath("//div[@id='growl_container']")).isCurrentlyVisible();
    }

    public List<String> getListMessageText() {
        List<WebElementFacade> listErrorMessages = this.findAll("//div[@id='growl_container']//div[@class='ui-growl-message']//p");
        List<String> listErrorMessageText = listErrorMessages.stream().map(WebElementFacade::getText).collect(Collectors.toList());
        return listErrorMessageText;
    }

    public boolean should_show_initialization_screen_of_register_daily_report() {
        return this.getCalendarDate().getSelectedDate().isEqual(LocalDate.now()) && this.getTableDailyReportHistory().currentPageShowNoRowSelected() && !this.getButtonDelete().isEnabled()
                && this.getButtonAdd().isEnabled() && !this.getButtonUpdate().isEnabled() && StringUtils.isNotEmpty(this.getTimePickerStart().getValue())
                && StringUtils.isNotEmpty(this.getTimePickerEnd().getValue()) && this.getCategory().getRadioButton(0).isSelected() && StringUtils.isEmpty(this.getAutoCompleteCompany().getValue())
                && this.getAutoCompletePersonInCharge().isEnabled() && this.getAutoCompleteDepartment().isEnabled()
                && this.getReminder().getRadioButton(1).isSelected() && this.getReminderFrom().isDisabled() && this.getReminderTo().isDisabled()
                && this.getProjectFlag().getRadioButton(1).isSelected() && this.getOpenFlag().getRadioButton(1).isSelected() && StringUtils.isEmpty(this.getTextAreaContentBusiness().getValue())
                && StringUtils.isNotEmpty(this.getSelectBusinessType().getValue()) && StringUtils.isNotEmpty(this.getSelectPurpose().getValue());
    }

    private boolean is_initialization_screen_when_view_daily_report_has_type_other() {
        if (this.getCategory().getRadioButton(0).isSelected()) {
            return false;
        }
        return StringUtils.isNotEmpty(this.getTextAreaContentOther().getValue());
    }

    private boolean is_initialization_screen_when_view_daily_report_has_type_business() {
        if (this.getCategory().getRadioButton(1).isSelected()) {
            return false;
        }
        return StringUtils.isNoneEmpty(this.getTextAreaContentBusiness().getValue()) && StringUtils.isNotEmpty(this.getAutoCompleteCompany().getValue())
                && this.getAutoCompletePersonInCharge().isEnabled() && this.getAutoCompleteDepartment().isEnabled() && StringUtils.isNotEmpty(this.getSelectBusinessType().getValue())
                && StringUtils.isNotEmpty(this.getSelectPurpose().getValue());
    }

    public boolean should_show_initialization_screen_of_register_daily_report_when_access_from_search_by_date_screen() {
        return (this.getCalendarDate().getSelectedDate() != null) && !this.getTableDailyReportHistory().is_no_record() && !this.getButtonAdd().isEnabled() && this.getButtonUpdate().isEnabled()
                && StringUtils.isNotEmpty(this.getTimePickerStart().getValue()) && StringUtils.isNotEmpty(this.getTimePickerEnd().getValue())
                && (this.is_initialization_screen_when_view_daily_report_has_type_business() || this.is_initialization_screen_when_view_daily_report_has_type_other());
    }

    public boolean table_daily_report_history_should_show_last_page() {
        return this.getTableDailyReportHistory().is_show_last_page();
    }

    public boolean table_daily_report_history_should_show_first_page() {
        return this.getTableDailyReportHistory().is_show_first_page();
    }

    public void choose_date_in_calendar_date(String date) {
        this.getCalendarDate().select_date(CommonUtils.parseStringToYearMonthDayLocalDate(date));
    }

    public void choose_category(String categoryType) {
        if (CommonConstant.REGISTER_DAILY_REPORT_CATEGORY_BUSINESS.equalsIgnoreCase(categoryType)) {
            this.getCategory().getRadioButton(0).click_and_wait();
        } else if (CommonConstant.REGISTER_DAILY_REPORT_CATEGORY_OTHER_WORKS.equalsIgnoreCase(categoryType)) {
            this.getCategory().getRadioButton(1).click_and_wait();
        }
    }

    public boolean should_show_start_time_and_end_time_required_message() {
        boolean isShowMessage = this.is_show_panel_message();
        List<String> listMessagesText = this.getListMessageText();
        this.wait_for_message_disappeared();
        return isShowMessage && listMessagesText.contains(CommonConstant.START_TIME_AND_END_TIME_REQUIRED_MESSAGE);
    }

    public DailyReportModel create_model_from_screen() {
        DailyReportModel dailyReportModel = new DailyReportModel();
        if (this.getCategory().getRadioButton(0).isSelected()) {
            dailyReportModel.setContent(this.getTextAreaContentBusiness().getValue());
            dailyReportModel.setCompanyName(this.getAutoCompleteCompany().getValue());
            dailyReportModel.setPersonInCharge(this.getAutoCompletePersonInCharge().getValue());
            dailyReportModel.setDepartment(this.getAutoCompleteDepartment().getValue());
            dailyReportModel.setBusinessType(this.getSelectBusinessType().getValue());
            dailyReportModel.setPurpose(this.getSelectPurpose().getValue());
            dailyReportModel.setReminder(this.getReminder().getRadioButton(0).isSelected() ? CommonConstant.FLAG_ON : CommonConstant.FLAG_OFF);
            dailyReportModel.setProjectFlag(this.getProjectFlag().getRadioButton(0).isSelected() ? CommonConstant.FLAG_ON : CommonConstant.FLAG_OFF);
            dailyReportModel.setOpenFlag(this.getOpenFlag().getRadioButton(0).isSelected() ? CommonConstant.FLAG_ON : CommonConstant.FLAG_OFF);
            if (CommonConstant.FLAG_ON.equalsIgnoreCase(dailyReportModel.getReminder())) {
                dailyReportModel.setReminderFrom(this.getReminderFrom().getValue());
                dailyReportModel.setReminderTo(this.getReminderTo().getValue());
            }
        } else if (this.getCategory().getRadioButton(1).isSelected()) {
            dailyReportModel.setContent(this.getTextAreaContentOther().getValue());
        }
        return dailyReportModel;
    }

    public boolean verify_screen_after_update(DailyReportModel dailyReportModel) {
        return this.create_model_from_screen().equals(dailyReportModel);
    }

    public void click_button_in_popup_confirm_delete_daily_report(String buttonText) {
        PFComponentFactory.wrapButton(this, this.findBy("//div[contains(@class,'ui-confirm-dialog') and @aria-hidden='false']//button[contains(.,'" + buttonText + "')]")).click_and_wait();
    }

    public boolean should_show_message_delete_daily_report_successfully() {
        boolean isShowMessage = this.is_show_panel_message();
        List<String> listMessagesText = this.getListMessageText();
        this.wait_for_message_disappeared();
        return isShowMessage && listMessagesText.contains(CommonConstant.DELETE_DAILY_REPORT_SUCCESSFULLY_MESSAGE);
    }

    public void click_link_register_now() {
        this.getLinkRegisterNow().click_and_wait();
    }

    public boolean should_show_link_register_now_is_visible_and_i_can_click() {
        return this.getLinkRegisterNow().isCurrentlyVisible() && this.getLinkRegisterNow().isEnabled();
    }

    public void delete_all_current_daily_report() {
        if(!this.getTableDailyReportHistory().is_no_record()) {
            for (int i = 0; i < this.getTableDailyReportHistory().getCountContentRow(); i++) {
                this.getTableDailyReportHistory().select_row_by_index(i);
            }
            this.getButtonDelete().click_and_wait();
            this.click_button_in_popup_confirm_delete_daily_report(CommonConstant.FLAG_YES);
        }
    }
}

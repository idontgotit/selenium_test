package my.lib.serenity.primefaces.component;

import my.lib.serenity.primefaces.component.factory.PFComponentFactory;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Created by michael on 9/8/16.
 */
public class CalendarComponent extends WebComponent {
    private boolean isInlineMode = false;
    private Locale locale;

    public CalendarComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
        if (this.wrappedElement.thenFindAll("div/div").size() > 0) {
            this.isInlineMode = this.wrappedElement.findBy("div/div").getAttribute("class").contains("ui-datepicker-inline");
        }
    }

    public CalendarComponent select_year_month(int year, int month) {
        LocalDate currentDate = this.getSelectedDate();
        LocalDate selectedDate = LocalDate.of(year, month, 1);
        String monthName = Month.of(month).getDisplayName(TextStyle.FULL, this.locale);

        if (!this.isInlineMode) {
            this.getInputField().click_and_wait();
        }
        if (currentDate.isAfter(selectedDate)) {
            while (!this.getCalenderTitleYear().getText().contains(String.valueOf(year)) || !this.getCalenderTitleMonth().getText().contains(monthName)) {
                this.getPreviousButton().click_and_wait();
            }
        } else if (currentDate.isBefore(selectedDate)) {
            while (!this.getCalenderTitleYear().getText().contains(String.valueOf(year)) || !this.getCalenderTitleMonth().getText().contains(monthName)) {
                this.getNextButton().click_and_wait();
            }

        }
        return this;
    }

    private InputTextComponent getInputField() {
        if (this.isInlineMode) {
            return null;
        }
        return PFComponentFactory.wrapInputText(this.parentPage, this.wrappedElement.findBy("input[@role='textbox']"));
    }

    private WebElementFacade getCalenderTitleYear() {
        String xpathToYearTitle = "div[contains(@class,'ui-datepicker-header')]//span[@class='ui-datepicker-year']";
        if (this.isInlineMode) {
            return this.wrappedElement.findBy("*//" + xpathToYearTitle);
        }
        return this.getPopupHolder().findBy(xpathToYearTitle);
    }

    private WebElementFacade getCalenderTitleMonth() {
        String xpathToMonthTitle = "div[contains(@class,'ui-datepicker-header')]//span[@class='ui-datepicker-month']";
        if (this.isInlineMode) {
            return this.wrappedElement.findBy("*//" + xpathToMonthTitle);
        }
        return this.getPopupHolder().findBy(xpathToMonthTitle);
    }

    private WebElementFacade getPopupHolder() {
        return this.parentPage.findBy("//div[@id='ui-datepicker-div' and contains(@class,'ui-datepicker')]");
    }

    private CommandLinkComponent getNextButton() {
        return getButtonByText("next");
    }

    private CommandLinkComponent getButtonByText(String buttonName) {
        String xpath = "";
        xpath = "div[contains(@class,'ui-datepicker-header')]/a[@data-handler='" + buttonName + "']";
        if (this.isInlineMode) {
            WebElementFacade webElementFacade = this.wrappedElement.findBy("*//" + xpath);
            return PFComponentFactory.wrapCommandLinkElement(this.parentPage, webElementFacade);
        } else {
            WebElementFacade webElementFacade = this.getPopupHolder().findBy(xpath);
            return PFComponentFactory.wrapCommandLinkElement(this.parentPage, webElementFacade);
        }


    }

    private CommandLinkComponent getPreviousButton() {
        return getButtonByText("prev");
    }

    public void select_date_of_month(int dateOfMonth) {
        String xpath = "table[@class='ui-datepicker-calendar']//td[@data-handler='selectDay']/a";
        if (this.isInlineMode) {
            this.wrappedElement.thenFindAll("*//" + xpath).get(dateOfMonth - 1).click();
        } else {
            this.getPopupHolder().thenFindAll(xpath).get(dateOfMonth - 1).click();
        }
        this.parentPage.waitForRenderedElementsToDisappear(By.xpath("*//div[@id='ui-datepicker-div' and contains(@class,'ui-datepicker')]"));
    }

    public LocalDate getSelectedDate() {
        //yyyy/mm/dd
        String val = this.getValueHolder().getValue();
        if (StringUtils.isEmpty(val) || val.equals("____/__/__"))
            return LocalDate.now();
        String[] dateParts = val.split("/");
        // this method will 'still' correct until year 3000
        return LocalDate.of(Integer.valueOf(dateParts[0]), Integer.valueOf(dateParts[1]), Integer.valueOf(dateParts[2]));
    }

    private InputTextComponent getValueHolder() {
        WebElementFacade inputHolder = this.wrappedElement.findBy("input");
        if (this.isInlineMode) {
            return PFComponentFactory.wrapHiddenInput(this.parentPage, inputHolder);
        } else {
            return PFComponentFactory.wrapInputText(this.parentPage, inputHolder);
        }
    }

    public void click_button_and_wait() {
        this.getButton().click_and_wait();
    }

    private ButtonComponent getButton() {
        if (this.isInlineMode) {
            return null;
        }
        return PFComponentFactory.wrapButton(this.parentPage, this.wrappedElement.findBy("button"));
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void openDateTimeSelect() {
        this.wrappedElement.findBy(By.xpath(".//button[contains(@class,'ui-datepicker-trigger')]")).waitUntilClickable();
        this.wrappedElement.findBy(By.xpath(".//button[contains(@class,'ui-datepicker-trigger')]")).click();
    }

    public boolean isCurrentEnable() {
        return this.getInputField() != null && this.getInputField().isEnabled() && this.getButton() != null && this.getButton().isEnabled();
    }

    public CalendarComponent select_date(LocalDate date) {
        this.openDateTimeSelect();
        this.setLocale(Locale.ENGLISH);
        this.select_month(date.getMonthValue());
        this.select_year(date.getYear());
        this.select_date_of_month(date.getDayOfMonth());
        this.waitForAjaxDone();
        return this;
    }

    private CalendarComponent select_month(int monthValue) {
        WebElementFacade monthSelect = this.getHeaderMonthSelect();
        monthSelect.click();
        monthSelect.findBy("./option[@value='" + (monthValue - 1) + "']").click();
        return this;
    }

    private WebElementFacade getHeaderMonthSelect() {
        String xpathToHeaderMonthSelect = "div[contains(@class,'ui-datepicker-header')]/div[contains(@class,'ui-datepicker-title')]/select[@data-handler='selectMonth']";
        if(this.isInlineMode) {
            return this.wrappedElement.findBy("*//" + xpathToHeaderMonthSelect);
        }
        return this.getPopupHolder().findBy(xpathToHeaderMonthSelect);
    }

    public WebElementFacade getHeaderYearSelect() {
        String xpathToHeaderYearSelect = "div[contains(@class,'ui-datepicker-header')]/div[contains(@class,'ui-datepicker-title')]/select[@data-handler='selectYear']";
        if(this.isInlineMode) {
            return this.wrappedElement.findBy("*//" + xpathToHeaderYearSelect);
        }
        return this.getPopupHolder().findBy(xpathToHeaderYearSelect);
    }

    public CalendarComponent select_year(int year) {
        WebElementFacade yearSelect = this.getHeaderYearSelect();
        yearSelect.click();
        yearSelect.findBy("./option[@value='" + year + "']").click();
        return this;
    }

    public boolean isDisabled() {
        return !this.wrappedElement.isEnabled() || !this.getInputField().isEnabled();
    }

    public void select_date(LocalDate date, Locale locale) {
        this.setLocale(locale);
        this.select_year_month(date.getYear(), date.getMonthValue());
        this.select_date_of_month(date.getDayOfMonth());
    }

    public String getValue() {
        return this.wrappedElement.findBy("./input[@id='" + this.clientId + "_input']").getValue();
    }
}

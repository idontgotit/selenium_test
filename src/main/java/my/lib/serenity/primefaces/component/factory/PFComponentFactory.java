package my.lib.serenity.primefaces.component.factory;

import my.lib.serenity.primefaces.component.*;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

/**
 * Created by michael on 9/6/16.
 */
public class PFComponentFactory {

    public static InputTextComponent wrapInputText(PageObject parentPage, WebElementFacade webElementFacade) {
        return new InputTextComponent(parentPage, webElementFacade);
    }

    public static ButtonComponent wrapButton(PageObject parentPage, WebElementFacade webElementFacade) {
        return new ButtonComponent(parentPage, webElementFacade);
    }

    public static CommandLinkComponent wrapCommandLink(PageObject parentPage, String cssOrXPathSelector) {
        WebElementFacade webElementFacade = parentPage.findBy(cssOrXPathSelector);
        return new CommandLinkComponent(parentPage, webElementFacade);
    }

    public static CommandLinkComponent wrapCommandLinkElement(PageObject parentPage, WebElementFacade webElementFacade) {
        return new CommandLinkComponent(parentPage, webElementFacade);
    }

    public static CommandLinkComponent wrapCommandLink(PageObject parentPage, By by) {
        WebElementFacade webElementFacade = parentPage.find(by);
        return new CommandLinkComponent(parentPage, webElementFacade);
    }

    public static ConfirmDialogComponent wrapConfirmDialog(PageObject parentPage, String xpathOrCssSelector) {
        WebElementFacade webElementFacade = parentPage.findBy(xpathOrCssSelector);
        return new ConfirmDialogComponent(parentPage, webElementFacade);
    }

    public static MenuBarComponent wrapMenuBar(PageObject parentPage, By by) {
        WebElementFacade webElementFacade = parentPage.find(by);
        return new MenuBarComponent(parentPage, webElementFacade);
    }

    public static MenuBarItemComponent wrapMenuBarItem(PageObject parentPage, WebElementFacade webElementFacade) {
        return new MenuBarItemComponent(parentPage, webElementFacade);
    }

    public static PanelComponent wrapPanel(PageObject parentPage, By by) {
        WebElementFacade webElementFacade = parentPage.find(by);
        return new PanelComponent(parentPage, webElementFacade);
    }

    public static CalendarComponent wrapCalendarElement(PageObject parentPage, WebElementFacade webElementFacade) {
        return new CalendarComponent(parentPage, webElementFacade);
    }

    public static CalendarComponent wrapCalendar(PageObject parentPage, By by) {
        WebElementFacade webElementFacade = parentPage.find(by);
        return new CalendarComponent(parentPage, webElementFacade);
    }

    public static HiddenInputComponent wrapHiddenInput(PageObject parentPage, WebElementFacade webElementFacade) {
        return new HiddenInputComponent(parentPage, webElementFacade);
    }

    public static AutoCompleteComponent wrapAutoComplete(PageObject parentPage, String xpathOrCssSelector) {
        return new AutoCompleteComponent(parentPage, parentPage.findBy(xpathOrCssSelector));
    }

    public static OneRadioComponent wrapOneRadio(PageObject parentPage, String xpathOrCssSelector) {
        return new OneRadioComponent(parentPage, parentPage.findBy(xpathOrCssSelector));
    }

    public static OneRadioComponent wrapOneRadioElement(PageObject parentPage, WebElementFacade webElementFacade) {
        return new OneRadioComponent(parentPage, webElementFacade);
    }

    public static RadioOptionComponent wrapRadioOption(PageObject parentPage, WebElementFacade webElementFacade) {
        return new RadioOptionComponent(parentPage, webElementFacade);
    }

    public static TabViewComponent wrapTabView(PageObject parentPage, String xpathOrCssSelector) {
        return new TabViewComponent(parentPage, parentPage.findBy(xpathOrCssSelector));
    }

    public static TabViewComponent wrapTabView(PageObject parentPage, WebElementFacade webElementFacade) {
        return new TabViewComponent(parentPage, webElementFacade);
    }

    public static TabPaneComponent wrapTabPane(PageObject parentPage, WebElementFacade webElementFacade) {
        return new TabPaneComponent(parentPage, webElementFacade);
    }

    public static PanelGridComponent wrapPanelGrid(PageObject parentPage, WebElementFacade webElementFacade) {
        return new PanelGridComponent(parentPage, webElementFacade);
    }

    public static TableComponent wrapTable(PageObject parentPage, WebElementFacade webElementFacade) {
        return new TableComponent(parentPage, webElementFacade);
    }

    public static ColumnHeaderComponent wrapColumnHeader(PageObject parentPage, WebElementFacade webElementFacade) {
        return new ColumnHeaderComponent(parentPage, webElementFacade);
    }

    public static SpanComponent wrapSpan(PageObject parentPage, WebElementFacade webElementFacade) {
        return new SpanComponent(parentPage, webElementFacade);
    }

    public static SelectOneMenuComponent wrapSelectOneMenu(PageObject parentPage, WebElementFacade webElementFacade) {
        return new SelectOneMenuComponent(parentPage, webElementFacade);
    }

    public static TableFilterComponent wrapTableFilter(PageObject parentPage, WebElementFacade webElementFacade) {
        return new TableFilterComponent(parentPage, webElementFacade);
    }

    public static ToggleComponent wrapToggleComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        return new ToggleComponent(parentPage, webElementFacade);
    }

    public static AutoCompleteComponent wrapAutoCompleteElement(PageObject parentPage, WebElementFacade webElementFacade) {
        return new AutoCompleteComponent(parentPage, webElementFacade);
    }

    public static CheckboxComponent wrapCheckboxComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        return new CheckboxComponent(parentPage, webElementFacade);
    }

    public static TextAreaComponent wrapTextArea(PageObject parentPage, WebElementFacade webElementFacade) {
        return new TextAreaComponent(parentPage, webElementFacade);
    }

    public static TimePickerComponent wrapTimePicker(PageObject parentPage, WebElementFacade webElementFacade) {
        return new TimePickerComponent(parentPage, webElementFacade);
    }

    public static SelectOneRadioComponent wrapSelectOneRadio(PageObject parentPage, WebElementFacade webElementFacade) {
        return new SelectOneRadioComponent(parentPage, webElementFacade);
    }

    public static RadioButtonComponent wrapRadioButton(PageObject parentPage, WebElementFacade webElementFacade) {
        return new RadioButtonComponent(parentPage, webElementFacade);
    }
}

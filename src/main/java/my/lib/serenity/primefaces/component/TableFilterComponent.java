package my.lib.serenity.primefaces.component;

import my.lib.serenity.primefaces.component.factory.PFComponentFactory;
import my.lib.serenity.primefaces.component.tablefilter.TableFilterMode;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

/**
 * Created by arrow on 28/9/16.
 */
public class TableFilterComponent extends WebComponent {
    private TableFilterMode mode;

    public TableFilterComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
        if(webElementFacade.getAttribute("class").contains("ui-inputfield")) {
            this.mode = TableFilterMode.INPUT_TEXT;
        } else if(webElementFacade.getAttribute("class").contains("ui-selectonemenu")) {
            this.mode = TableFilterMode.SELECT_ONE_MENU;
        } else {
            this.mode = TableFilterMode.UNDEFINED;
        }
    }

    public void filter_by_text(String inputText) {
        if(TableFilterMode.INPUT_TEXT == this.mode) {
            InputTextComponent inputFilter = PFComponentFactory.wrapInputText(this.parentPage, this.wrappedElement);
            inputFilter.type_and_enter(inputText);
        } else if(TableFilterMode.SELECT_ONE_MENU == this.mode){
            SelectOneMenuComponent selectOneMenu = PFComponentFactory.wrapSelectOneMenu(this.parentPage, this.wrappedElement);
            selectOneMenu.select_option_by_text(inputText);
        }
    }
}

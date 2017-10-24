package my.lib.serenity.primefaces.component;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by michael on 9/6/16.
 */
public class ConfirmButtonComponent extends ButtonComponent {
    public ConfirmButtonComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
    }

    public ConfirmButtonComponent click_and_yes(){
        this.wrappedElement.waitUntilClickable();

        super.getConfirmDialog().click_yes();

        super.waitForAjaxDone();
        return this;
    }


}

package my.lib.serenity.primefaces.component;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by michael on 9/6/16.
 */
public class ConfirmDialogComponent extends WebComponent{
    public ConfirmDialogComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
    }

    public ConfirmDialogComponent click_yes() {
        this.getYesButton().waitUntilVisible().click();
        super.waitForAjaxDone();
        return this;
    }

    private WebElementFacade getYesButton() {
        return this.wrappedElement.findBy("div/button[contains(concat(@class, ' '), 'ui-confirmdialog-yes ')]");
    }
}

package my.lib.serenity.primefaces.component;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by arrow on 11/10/16.
 */
public class CheckboxComponent extends WebComponent {
    public CheckboxComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
    }

    public void click() {
        this.wrappedElement.click();
    }

    public void click_and_wait() {
        this.wrappedElement.waitUntilClickable();
        this.wrappedElement.click();
        super.waitForAjaxDone();
    }
}

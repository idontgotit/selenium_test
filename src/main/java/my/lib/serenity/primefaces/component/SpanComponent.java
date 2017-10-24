package my.lib.serenity.primefaces.component;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by ngoc on 27/09/2016.
 */
public class SpanComponent extends WebComponent {
    public SpanComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
    }

    public SpanComponent click_and_wait() {
        this.wrappedElement.waitUntilClickable().click();
        super.waitForAjaxDone();
        return this;
    }
}

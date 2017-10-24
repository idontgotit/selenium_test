package my.lib.serenity.primefaces.component;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by michael on 9/7/16.
 */
public class CommandLinkComponent extends WebComponent {
    public CommandLinkComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
    }

    public CommandLinkComponent click_and_wait() {
        this.wrappedElement.waitUntilEnabled();
        this.wrappedElement.waitUntilClickable();
        this.wrappedElement.click();
        super.waitForAjaxDone();
        return this;
    }

    public boolean isCurrentlyVisible() {
        return this.wrappedElement.isCurrentlyVisible();
    }

    public boolean isEnabled() {
        return this.wrappedElement.isCurrentlyEnabled();
    }
}

package my.lib.serenity.primefaces.component;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by michael on 9/7/16.
 */
public class PanelComponent extends WebComponent {
    public PanelComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
    }

    public String getTitle() {
        return this.wrappedElement.findBy("//span[@class='ui-panel-title']//label[@class='arrow-form-title']").getText();
    }

    public void wait_for_ajax_done() {
        super.waitForAjaxDone();
    }
}

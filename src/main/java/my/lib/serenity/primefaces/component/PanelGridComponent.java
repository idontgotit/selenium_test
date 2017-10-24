package my.lib.serenity.primefaces.component;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by ngoc on 21/09/2016.
 */
public class PanelGridComponent extends WebComponent {
    public PanelGridComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
    }

    public String getTitle() {
        return this.wrappedElement.findBy("thead/tr/td[@role='columnheader']").getText();
    }


    public int getNumberOfContentRows() {
        return this.wrappedElement.thenFindAll("tbody/tr[@role='row']").size();
    }
}

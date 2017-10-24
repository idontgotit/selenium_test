package my.lib.serenity.primefaces.component;

import my.lib.serenity.primefaces.component.factory.PFComponentFactory;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by michael on 13/09/2016.
 */
public class TabViewComponent extends WebComponent {
    public TabViewComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
    }

    public void click_tab_by_index(int tabIndex) {
        this.getTabByIndex(tabIndex).open();

    }

    private TabPaneComponent getTabByIndex(int tabIndex) {
        return PFComponentFactory.wrapTabPane(this.parentPage, this.wrappedElement.thenFindAll("ul/li[@role='tab']").get(tabIndex));
    }

    public TabPaneComponent getTabByName(String tabName) {
        return PFComponentFactory.wrapTabPane(this.parentPage, this.wrappedElement.findBy("ul/li/a[text()='" + tabName + "']/parent::*"));
    }
}

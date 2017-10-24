package my.lib.serenity.primefaces.component;

import my.lib.serenity.primefaces.component.factory.PFComponentFactory;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by michael on 9/7/16.
 */
public class MenuBarItemComponent extends WebComponent {
    private boolean isParent;
    private boolean isMegaMenu;

    public MenuBarItemComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
        this.isParent = this.wrappedElement.getAttribute("class").contains("ui-menu-parent");
        this.isMegaMenu = this.wrappedElement.getAttribute("class").contains("ui-megamenu");
    }


    public void click_and_wait() {
        Actions builder = new Actions(this.getDriver());
        if (this.wrappedElement.getAttribute("class").contains("ui-menu-parent")) {
            // has submenu,


            // just hover mouse over it
            builder.moveToElement(this.wrappedElement.getWrappedElement()).build().perform();

            // wait for done
//            this.waitUntilSubmenuShown(this.wrappedElement);
        } else {
            // has no submenu, then wait for action done.
            // do action
            builder.click(this.wrappedElement.findBy("a")).perform();
            super.waitForAjaxDone();
        }
    }

    private void waitUntilSubmenuShown(WebElementFacade menuitem) {
        menuitem.findBy("*//ul[contains(@style, 'display: block')]").waitUntilVisible();
    }

    public void click_item_by_text(String menuText) {
        if (!this.isParent) {
            return;
        }

        String xpath = "ul//li[@role='menuitem']/a/span[@class='ui-menuitem-text' and text()='" + menuText + "']/parent::*/parent::*";
        WebElementFacade menuitem = this.wrappedElement.findBy(By.xpath(xpath));
        MenuBarItemComponent itemComp = PFComponentFactory.wrapMenuBarItem(this.parentPage, menuitem);
        itemComp.click_and_wait();
    }
}

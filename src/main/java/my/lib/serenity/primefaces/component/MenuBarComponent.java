package my.lib.serenity.primefaces.component;

import my.lib.serenity.primefaces.component.factory.PFComponentFactory;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.interactions.Actions;

import java.util.NoSuchElementException;

/**
 * Created by michael on 9/7/16.
 */
public class MenuBarComponent extends WebComponent {
    public MenuBarComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
    }

    public MenuBarItemComponent click_item_by_index(int menu_index) {

        // find element
        WebElementFacade menuitem = this.wrappedElement.thenFindAll("ul/li[@role='menuitem']").get(menu_index - 1);
        MenuBarItemComponent itemComponent = PFComponentFactory.wrapMenuBarItem(this.parentPage, menuitem);
        itemComponent.click_and_wait();
        return itemComponent;
    }


    public MenuBarItemComponent click_item_by_text(String menuText) {
        String xpath = "ul/li[@role='menuitem']/a/span[@class='ui-menuitem-text' and text()='" + menuText + "']/parent::*/parent::*";
        WebElementFacade menuitem = this.wrappedElement.findBy(By.xpath(xpath));
        MenuBarItemComponent itemComp = PFComponentFactory.wrapMenuBarItem(this.parentPage, menuitem);
        itemComp.click_and_wait();
        return itemComp;
    }

    public MenuBarItemComponent find_item_by_text(String menuText) {
        try {
            return PFComponentFactory.wrapMenuBarItem(this.parentPage, this.wrappedElement.find(By.xpath("*//li[@role='menuitem']//span[text()='" + menuText + "']/ancestor::li")));
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void click_menu_item_by_text(String menuText) {
        try {
            MenuBarItemComponent menu = this.find_item_by_text(menuText);
            menu.wrappedElement.find(By.xpath(".//a")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void move_to_menu_item_by_text(String menuText) {
        Actions builder = new Actions(this.getDriver());
        builder.moveToElement(this.wrappedElement.findElement(org.openqa.selenium.By.xpath("*//li[@role='menuitem']//span[text()='" + menuText + "']/ancestor::li"))).build().perform();
    }

    public int get_number_of_action_menu() {
        return this.wrappedElement.thenFindAll(By.xpath("//*[@id='menuForm']//ul/li//table//tr//span[@class='ui-menuitem-text']")).size();
    }
}

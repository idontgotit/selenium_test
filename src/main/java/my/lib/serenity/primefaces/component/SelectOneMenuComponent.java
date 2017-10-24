package my.lib.serenity.primefaces.component;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

/**
 * Created by arrow on 28/9/16.
 */
public class SelectOneMenuComponent extends WebComponent {
    public SelectOneMenuComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
    }

    public void open_menu_options() {
        super.waitForAjaxDone();
        this.wrappedElement.find(By.xpath(".//div[contains(@class,'ui-selectonemenu-trigger')]")).waitUntilEnabled().waitUntilClickable().click();
        super.waitForAjaxDone();
    }

    public void select_option_by_text(String inputText) {
        this.open_menu_options();
        this.wrappedElement.find(By.xpath("//div[contains(@class,'ui-selectonemenu-panel') and contains(@style,'display: block')]//li[text()='" + inputText + "']")).click();
        super.waitForAjaxDone();
    }

    public boolean can_open_menu_options() {
        return this.wrappedElement.isCurrentlyEnabled() && !this.wrappedElement.getAttribute("class").contains("ui-state-disabled");
    }

    public List<WebElementFacade> getAllLabelInSelectOneMenu() {
        return this.wrappedElement.thenFindAll("//div[@id='" + this.wrappedElement.getAttribute("id") + "_panel" + "']//li[contains(@class,'ui-selectonemenu-item')]");
    }

    public void select_option_by_text_without_open_first(String inputText) {
        this.wrappedElement.find(By.xpath("//div[contains(@class,'ui-selectonemenu-panel') and contains(@style,'display: block')]//li[text()='" + inputText + "']")).click();
        super.waitForAjaxDone();
    }

    public boolean isDisabled() {
        return !this.isEnabled() || this.wrappedElement.getAttribute("class").contains("ui-state-disabled");
    }

    public String getValue() {
        return this.wrappedElement.findBy("./label[contains(@class,'ui-selectonemenu-label')]").getText();
    }
}

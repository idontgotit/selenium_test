package my.lib.serenity.primefaces.component;

import my.lib.serenity.primefaces.component.factory.PFComponentFactory;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by arrow on 27/9/16.
 */
public class ColumnHeaderComponent extends WebComponent{
    public ColumnHeaderComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
    }

    public void click_title_and_wait() {
        this.getTitle().click_and_wait();
    }

    public CommandLinkComponent getTitle() {
        return PFComponentFactory.wrapCommandLinkElement(this.parentPage, this.wrappedElement.find(By.xpath("span/a")));
    }

    public TableFilterComponent getFilter() {
        if(this.wrappedElement.containsElements(By.xpath("*//div[contains(@class,'ui-selectonemenu')]"))) {
            return PFComponentFactory.wrapTableFilter(this.parentPage, this.wrappedElement.find(By.xpath("*//div[contains(@class,'ui-selectonemenu')]")));
        } else if(this.wrappedElement.containsElements(By.xpath("*//input"))){
            return PFComponentFactory.wrapTableFilter(this.parentPage, this.wrappedElement.find(By.xpath("*//input")));
        } else {
            return null;
        }
    }

    public String getTitleText() {
        return this.wrappedElement.find(By.xpath("span[contains(@class,'ui-column-title')]")).getText();
    }
}

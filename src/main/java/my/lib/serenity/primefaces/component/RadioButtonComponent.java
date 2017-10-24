package my.lib.serenity.primefaces.component;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

/**
 * Created by arrow on 18/10/16.
 */
public class RadioButtonComponent extends WebComponent {
    public RadioButtonComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
    }

    public boolean isSelected() {
        return this.wrappedElement.find(By.xpath("./div[contains(@class,'ui-radiobutton-box')]")).getAttribute("class").contains("ui-state-active");
    }

    public void click_and_wait() {
        this.waitForAjaxDone();
        this.wrappedElement.waitUntilClickable();
        this.waitForAjaxDone();
        this.wrappedElement.click();
        this.waitForAjaxDone();
    }
}

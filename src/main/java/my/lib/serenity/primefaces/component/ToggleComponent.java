package my.lib.serenity.primefaces.component;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.collections.CollectionUtils;
import org.openqa.selenium.By;

import java.util.Date;
import java.util.List;

/**
 * Created by arrow on 28/9/16.
 */
public class ToggleComponent extends WebComponent {
    public ToggleComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
    }

    public WebElementFacade get_openning_toggle_menu() {
        List<WebElementFacade> menu = this.wrappedElement.thenFindAll(By.xpath("//div[contains(@class,'ui-columntoggler') and contains(@style,'display: block')]"));
        return CollectionUtils.isNotEmpty(menu) ? menu.get(0) : null;
    }

    public void toggle_column(String columnTitle) {
        WebElementFacade menu = this.get_openning_toggle_menu();
        List<WebElementFacade> listLabel = menu.thenFindAll(By.xpath(".//ul//li//label"));
        for(int i = 0; i < listLabel.size(); i++) {
            if(listLabel.get(i).getText().equalsIgnoreCase(columnTitle)) {
                menu.find(By.xpath(".//ul/li[" + (i+1) + "]//div[contains(@class,'ui-chkbox-box')]")).click();
            }
        }
    }

    public void toggle_menu() {
        this.waitForAjaxDone();
        this.wrappedElement.waitUntilClickable();
        this.wrappedElement.waitUntilEnabled();
        this.wrappedElement.click();
        this.waitForAjaxDone();
    }
}

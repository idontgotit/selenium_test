package my.lib.serenity.primefaces.component;

import javafx.scene.control.RadioButton;
import my.lib.serenity.primefaces.component.factory.PFComponentFactory;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by arrow on 18/10/16.
 */
public class SelectOneRadioComponent extends WebComponent {
    public SelectOneRadioComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
    }

    public RadioButtonComponent getRadioButton(int index) {
        return PFComponentFactory.wrapRadioButton(this.parentPage, this.wrappedElement.thenFindAll(".//tbody/tr/td/div[contains(@class,'ui-radiobutton')]").get(index));
    }

    public void waitUntilClickable() {
        this.wrappedElement.waitUntilClickable();
    }
}

package my.lib.serenity.primefaces.component;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;

/**
 * Created by arrow on 14/10/16.
 */
public class TextAreaComponent extends WebComponent {
    public TextAreaComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
    }

    public void clear_input() {
        while (StringUtils.isNotEmpty(this.wrappedElement.getValue())) {
            this.wrappedElement.sendKeys(Keys.BACK_SPACE);
        }
    }

    public void input_text(String companyName) {
        this.clear_input();
        this.wrappedElement.sendKeys(companyName);
        this.waitForAjaxDone();
    }

    public String getValue() {
        return this.wrappedElement.getText();
    }
}

package my.lib.serenity.primefaces.component;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by michael on 9/6/16.
 */
public class ButtonComponent extends WebComponent {
    public ButtonComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
    }

    public ButtonComponent click_and_wait() {
        this.wrappedElement.waitUntilVisible();
        this.wrappedElement.waitUntilClickable();
        try {
            this.wrappedElement.click();
        } catch (UnhandledAlertException e) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            new WebDriverWait(getDriver(), 5).until(ExpectedConditions.alertIsPresent());
            this.getDriver().switchTo().alert().accept();
        }
        super.waitForAjaxDone();
        return this;
    }

    public String getText() {
        return super.wrappedElement.findBy("span[contains(concat(@class,' '), 'ui-button-text ')]").getText();
    }

    public void shouldShowText(String text) {
        super.wrappedElement.shouldBePresent();
        super.wrappedElement.shouldContainText(text);
    }

}

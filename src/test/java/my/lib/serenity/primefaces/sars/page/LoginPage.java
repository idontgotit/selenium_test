package my.lib.serenity.primefaces.sars.page;

import my.lib.serenity.primefaces.component.ButtonComponent;
import my.lib.serenity.primefaces.component.InputTextComponent;
import my.lib.serenity.primefaces.component.factory.PFComponentFactory;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.UnhandledAlertException;

/**
 * Created by michael on 9/6/16.
 */
public class LoginPage extends AbstractPage {

    @FindBy(name = "login:username:text")
    WebElementFacade loginName;

    @FindBy(name = "login:passwd")
    WebElementFacade passwd;

    @FindBy(name = "login:btnLogin")
    WebElementFacade loginButton;

    @FindBy(xpath = "//*[@id=\"growl_container\"]//span[contains(@class,\"ui-growl-image-error\")]")
    WebElementFacade errorMessagePanel;

    @FindBy(xpath = "//*[@id=\"growl_container\"]//span[contains(@class,\"ui-growl-title\")]")
    WebElementFacade errorMessage;

    @FindBy(id = "profileBar")
    WebElementFacade profileBar;

    public void login(String userNameVal, String passwordVal) {
        try {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.loginName.waitUntilClickable();
            InputTextComponent userName = PFComponentFactory.wrapInputText(this, this.loginName);
            userName.type_and_wait(userNameVal);

            InputTextComponent password = PFComponentFactory.wrapInputText(this, this.passwd);
            password.type_and_wait(passwordVal);

            Serenity.takeScreenshot();

            ButtonComponent login = PFComponentFactory.wrapButton(this, this.loginButton);
            login.click_and_wait();
        } catch (UnhandledAlertException e) {
            this.getDriver().switchTo().alert().accept();
        }

    }

    public void should_login_success() {
        this.profileBar.shouldBeVisible();
        Serenity.takeScreenshot();
    }

    public boolean hasError() {
        return this.errorMessagePanel.isVisible();
    }

    public String getErrorMessage() {
        return this.errorMessage.isVisible() ? this.errorMessage.getText() : null;
    }

    public void should_enable_login_button() {
        this.loginButton.shouldBeEnabled();
    }
}

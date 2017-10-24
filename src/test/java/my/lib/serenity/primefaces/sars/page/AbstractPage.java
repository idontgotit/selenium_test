package my.lib.serenity.primefaces.sars.page;

import com.google.common.base.Function;
import my.lib.serenity.primefaces.component.factory.PFComponentFactory;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.annotation.Nullable;
import java.util.concurrent.TimeUnit;

/**
 * Created by michael on 9/6/16.
 */
public abstract class AbstractPage extends PageObject {
    @FindBy(id = "profileBar")
    WebElementFacade profileBar;

    public void should_loggged_in() {
        this.profileBar.shouldBeVisible();
    }

    public void logout() {
        this.wait_for_blockui_disappered();
        try {
            Actions builder = new Actions(this.getDriver());
            builder.moveToElement(this.profileBar.findBy("//li[contains(@class,'user-management')]")).build().perform();
            this.findBy("*//a[@title='Logout']/ancestor::ul[2]").waitUntilVisible();
            PFComponentFactory.wrapCommandLink(this, By.xpath("*//a[@title='Logout']")).click_and_wait();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return;
        } catch (UnhandledAlertException ex) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Alert alert = ExpectedConditions.alertIsPresent().apply(this.getDriver());
            if (alert != null) {
                this.getDriver().switchTo().alert().accept();
            }
            this.wait_for_blockui_disappered();
        } finally {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Alert alert = ExpectedConditions.alertIsPresent().apply(this.getDriver());
            if (alert != null) {
                this.getDriver().switchTo().alert().accept();
            }
            this.wait_for_blockui_disappered();
        }
    }

    public void wait_for_message_disappeared() {
        this.waitForCondition().withTimeout(30, TimeUnit.SECONDS).pollingEvery(10, TimeUnit.MILLISECONDS).until(new Function<WebDriver, Object>() {
            @Nullable
            @Override
            public Object apply(@Nullable WebDriver webDriver) {
                WebElementFacade messageDialog = find(net.serenitybdd.core.annotations.findby.By.xpath("//div[@id='growl_container']"));
                return !messageDialog.isCurrentlyVisible();
            }
        });
    }

    public void wait_for_blockui_disappered() {
        this.waitForCondition().withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(10, TimeUnit.MILLISECONDS).until(new Function<WebDriver, Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {
                try {
                    WebElementFacade blockPanels = find(By.xpath("*//div[contains(@class,'blockUI')]"));
                    return !blockPanels.isCurrentlyVisible();
                } catch (NoSuchElementException e) {
                    return true;
                }
            }

        });
    }
}

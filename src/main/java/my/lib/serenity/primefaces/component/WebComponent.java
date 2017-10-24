package my.lib.serenity.primefaces.component;

import com.google.common.base.Function;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.annotation.Nullable;
import java.util.concurrent.TimeUnit;

/**
 * Created by michael on 9/6/16.
 */
public abstract class WebComponent {
    private static final String DISABLED_ATTR_NAME = "aria-disabled";

    protected String clientId;

    protected final Actions actionBuilder;
    protected final WebDriver webDriver;
    protected final PageObject parentPage;
    protected WebElementFacade wrappedElement;

    public WebComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        this.wrappedElement = webElementFacade;
        this.parentPage = parentPage;
        this.webDriver = parentPage.getDriver();
        this.actionBuilder = new Actions(this.webDriver);
        this.clientId = webElementFacade.getAttribute("id");
    }

    public WebDriver getDriver() {
        return this.webDriver;
    }

    private static final String JS_JQUERY_DEFINED = "return typeof jQuery != 'undefined';";
    private static final String JS_PRIMEFACES_DEFINED = "return typeof PrimeFaces != 'undefined';";
    private static final String JS_JQUERY_ACTIVE = "return jQuery.active != 0;";
    private static final String JS_PRIMEFACES_QUEUE_NOT_EMPTY = "return !PrimeFaces.ajax.Queue.isEmpty();";

    private static final int TIME_OUT_SECONDS = 10;
    private static final int POLLING_MILLISECONDS = 500;

    private void waitForJQueryAndPrimeFaces() {
        this.parentPage.waitForCondition().withTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
                .pollingEvery(POLLING_MILLISECONDS, TimeUnit.MILLISECONDS)
                .until(new Function<WebDriver, Boolean>() {
                    @Override
                    public Boolean apply(WebDriver input) {
                        boolean ajax = false;
                        boolean jQueryDefined = executeBooleanJavascript(input, JS_JQUERY_DEFINED);
                        boolean primeFacesDefined = executeBooleanJavascript(input, JS_PRIMEFACES_DEFINED);

                        if (jQueryDefined) {
                            // jQuery is still active
                            ajax |= executeBooleanJavascript(input, JS_JQUERY_ACTIVE);
                        }
                        if (primeFacesDefined) {
                            // PrimeFaces queue isn't empty
                            ajax |= executeBooleanJavascript(input, JS_PRIMEFACES_QUEUE_NOT_EMPTY);
                        }
                        // continue if all ajax request are processed
                        return !ajax;
                    }
                });

        if (this.parentPage.containsElements(By.xpath("*//div[contains(@class,'blockUI')]"))) {
            this.parentPage.waitForCondition().withTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
                    .pollingEvery(10, TimeUnit.MILLISECONDS).until(new Function<WebDriver, Boolean>() {
                @Nullable
                @Override
                public Boolean apply(@Nullable WebDriver webDriver) {
                    try {
                        WebElementFacade blockPanels = WebComponent.this.parentPage.find(By.xpath("*//div[contains(@class,'blockUI')]"));
                        return !blockPanels.isCurrentlyVisible();
                    } catch (NoSuchElementException e) {
                        return true;
                    }
                }

            });
        }

    }

    private boolean executeBooleanJavascript(WebDriver input, String javascript) {
        return (Boolean) ((JavascriptExecutor) input).executeScript(javascript);
    }

    public void waitForAjaxDone() {
        this.waitForJQueryAndPrimeFaces();
    }

    protected ConfirmDialogComponent getConfirmDialog() {
        return null;
    }

    public boolean isEnabled() {
        return this.wrappedElement.isCurrentlyEnabled();
    }

    public boolean isVisible() {
        return this.wrappedElement.isCurrentlyVisible();
    }

    public void waitUntilVisible() {
        this.wrappedElement.waitUntilVisible();
    }
}
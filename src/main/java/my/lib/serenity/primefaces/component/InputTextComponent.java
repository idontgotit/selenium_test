package my.lib.serenity.primefaces.component;

import my.lib.serenity.primefaces.component.inputtext.InputTextMode;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;

/**
 * Created by michael on 9/6/16.
 */
public class InputTextComponent extends WebComponent {

    private InputTextMode mode;

    public InputTextComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
        if (this.wrappedElement.getAttribute("class").contains("ui-inputmask")) {
            this.mode = InputTextMode.INPUT_MASK;
        } else {
            this.mode = InputTextMode.INPUT_TEXT;
        }
    }

    public InputTextComponent type_and_wait(String inputVal) {
        this.clear_input();
        this.wrappedElement.sendKeys(inputVal);
        this.parentPage.blurActiveElement();
        super.waitForAjaxDone();
        return this;
    }

    public String getValue() {
        return this.wrappedElement.getValue();
    }

    public void click_and_wait() {
        this.wrappedElement.waitUntilClickable().click();
        super.waitForAjaxDone();
    }

    public void clear_input() {
        if(InputTextMode.INPUT_TEXT == this.mode) {
            while (StringUtils.isNotEmpty(this.wrappedElement.getValue())) {
                this.wrappedElement.sendKeys(Keys.BACK_SPACE);
            }
        } else {
            this.wrappedElement.sendKeys(Keys.BACK_SPACE);
        }
    }

    public void type_and_enter(String inputText) {
        this.clear_input();
        this.wrappedElement.sendKeys(inputText, Keys.ENTER);
        super.waitForAjaxDone();
    }

    public void type(String inputText) {
        this.clear_input();
        this.wrappedElement.sendKeys(inputText);
    }

    public InputTextMode getMode() {
        return this.mode;
    }

    public void setMode(InputTextMode mode) {
        this.mode = mode;
    }

    public Integer getMaxLength() {
        return StringUtils.isNoneEmpty(this.wrappedElement.getAttribute("maxlength")) ? Integer.valueOf(this.wrappedElement.getAttribute("maxlength")) : null;
    }
}

package my.lib.serenity.primefaces.component;

import my.lib.serenity.primefaces.component.factory.PFComponentFactory;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.TimeoutException;

import java.util.List;

/**
 * Created by michael on 12/09/2016.
 */
public class AutoCompleteComponent extends WebComponent {
    private String clientId;
    private WebElementFacade resultEl;

    public AutoCompleteComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
        this.clientId = this.wrappedElement.getAttribute("id");
    }

    public void input_text(String text) {
        this.getInput().type_and_wait(text);
    }

    public InputTextComponent getInput() {
        return PFComponentFactory.wrapInputText(this.parentPage, this.wrappedElement.findBy(".//input[@role='textbox']"));
    }

    public void should_display_result() {
        this.getResult().shouldBePresent();
    }

    private WebElementFacade getResult() {
        if (this.resultEl == null) {
            try {
                this.parentPage.waitForRenderedElements(By.id(this.clientId + "_panel"));
                this.resultEl = this.parentPage.find(By.id(this.clientId + "_panel"));
            } catch (TimeoutException timeoutException) {
                this.resultEl = null;
            }
        }
        return this.resultEl;
    }

    public void should_show_number_of_result(int numberOfItem) {
        Assertions.assertThat(this.getNumberOfItems()).isEqualTo(numberOfItem);
    }

    private int getNumberOfItems() {
        if (this.getResult() == null) return 0;
        return this.getResult().thenFindAll("ul/li[contains(@class,'ui-autocomplete-item')]").size();
    }

    public void click_drop_down() {
        this.getDropdownButton().click_and_wait();
    }

    private ButtonComponent getDropdownButton() {
        return PFComponentFactory.wrapButton(this.parentPage, this.wrappedElement.findBy("button[contains(@class,'ui-autocomplete-dropdown')]"));
    }

    public String getValue() {
        return getInput().getValue();
    }

    public void select_result_by_text(String text) {
        this.input_text(text);
        List<WebElementFacade> listResult = this.getResult().thenFindAll("./table/tbody/tr/td[text() = '" + text + "']");
        // should select the first one
        listResult.get(0).click();
        super.waitForAjaxDone();
    }

    public void select_result(String text, int index) {
        this.input_text(text);
        List<WebElementFacade> listResult = this.getResult().thenFindAll("*//*[contains(text(),'" + text + "')]");
        listResult.get(index).click();
        super.waitForAjaxDone();
    }

    public boolean isCurrentEnable() {
        return this.getInput().isEnabled() && this.getDropdownButton().isEnabled();
    }

    public void open_drop_down_and_select_restul_by_text(String text) {
        this.click_drop_down();
        List<WebElementFacade> listResult = this.getResult().thenFindAll("*//*[@data-item-label='" + text + "']");
        listResult.get(0).click();
        super.waitForAjaxDone();
    }
}

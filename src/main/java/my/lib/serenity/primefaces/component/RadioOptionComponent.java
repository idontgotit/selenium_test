package my.lib.serenity.primefaces.component;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;

/**
 * Created by michael on 13/09/2016.
 */
public class RadioOptionComponent extends WebComponent {
    public RadioOptionComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
    }

    public void should_be_selected() {
        WebElementFacade webElementFacade = this.wrappedElement.findBy("div[contains(@class,'ui-radiobutton-box')]");
        Assertions.assertThat(webElementFacade.thenFindAll("span[contains(@class,'ui-icon-bullet')]")).isNotEmpty();
    }

    public boolean isSelected() {
        return StringUtils.isNotEmpty(this.wrappedElement.getAttribute("checked"));
    }

    public void click_and_wait() {
        this.waitForAjaxDone();
        this.wrappedElement.waitUntilClickable();
        this.wrappedElement.click();
        this.waitForAjaxDone();
    }
}

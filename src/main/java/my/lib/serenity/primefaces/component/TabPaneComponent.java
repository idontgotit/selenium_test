package my.lib.serenity.primefaces.component;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.assertj.core.api.Assertions;

/**
 * Created by michael on 13/09/2016.
 */
public class TabPaneComponent extends WebComponent {
    public TabPaneComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
    }

    public void open() {
        this.wrappedElement.findBy("a").click();
        super.waitForAjaxDone();
    }

    public void should_be_active() {
        Assertions.assertThat(this.wrappedElement.getAttribute("aria-selected").equals("true")).isTrue();
    }
}

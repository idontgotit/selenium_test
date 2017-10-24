package my.lib.serenity.primefaces.component;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import static io.github.seleniumquery.SeleniumQuery.jQuery;

/**
 * Created by michael on 9/9/16.
 */
public class HiddenInputComponent extends InputTextComponent {
    public HiddenInputComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
    }

    @Override
    public String getValue() {
        return jQuery(super.wrappedElement.getWrappedElement()).val();
    }
}

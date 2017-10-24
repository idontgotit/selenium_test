package my.lib.serenity.primefaces.component;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by arrow on 18/10/16.
 */
public class TimePickerComponent extends WebComponent {
    public TimePickerComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
    }

    public boolean isNotEmpty() {
        return StringUtils.isNotEmpty(this.getValue());
    }

    public String getValue() {
        return this.wrappedElement.findBy("./input").getAttribute("value");
    }
}

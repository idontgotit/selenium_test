package my.lib.serenity.primefaces.component;

import my.lib.serenity.primefaces.component.factory.PFComponentFactory;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static io.github.seleniumquery.SeleniumQuery.jQuery;

/**
 * Created by michael on 12/09/2016.
 */
public class OneRadioComponent extends WebComponent {
    private boolean isResponsiveMode;
    private boolean isCustomLayoutMode;

    public OneRadioComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
        this.isResponsiveMode = this.wrappedElement.getAttribute("class").contains("ui-grid-responsive");
        this.isCustomLayoutMode = this.wrappedElement.getAttribute("class").contains("ui-helper-hidden");
    }

    public void select_option_by_text(String optionText) {
        int index = getOptionIndexByLabel(optionText);
        this.waitForAjaxDone();
        this.getOptionByIndex(index).waitUntilClickable();
        this.getOptionByIndex(index).click();
        super.waitForAjaxDone();
    }

    private int getOptionIndexByLabel(String optionText) {
        WebElementFacade parentElement = this.isCustomLayoutMode ? this.wrappedElement.findBy("./parent::*") : this.wrappedElement;
        List<WebElementFacade> allLabels = parentElement.thenFindAll(".//label");
        if (CollectionUtils.isEmpty(allLabels)) {
            return -1;
        }
        for (WebElementFacade web : allLabels) {
            if (StringUtils.equals(web.getText(), optionText)) {
                return allLabels.indexOf(web);
            }
        }
        return -1;
    }

    private WebElementFacade getOptionByIndex(int index) {
        WebElementFacade parentElement = this.isCustomLayoutMode ? this.wrappedElement.findBy("./..") : this.wrappedElement;
        return parentElement.thenFindAll("*//div[contains(concat(@class,' '),'ui-radiobutton ')]").get(index);
    }


    public RadioOptionComponent getOptionByLabel(String optionText) {
        int index = this.isCustomLayoutMode ? this.findOptionIndexByText(optionText) : this.getOptionIndexByLabel(optionText);
        return PFComponentFactory.wrapRadioOption(this.parentPage, this.getOptionByIndex(index));
    }

    public void select_option_by_index(int optionNumber) {
        this.getOptionByIndex(optionNumber).click();
        super.waitForAjaxDone();
    }

    public int findOptionIndexByText(String text) {
        if (this.isCustomLayoutMode) {
            WebElementFacade labelEl = this.wrappedElement.findBy("./..").findBy("*//label[text()='" + text + "']");
            String divId = labelEl.getAttribute("for");
            WebElementFacade divEl = this.parentPage.find(By.id(divId));

            return Integer.valueOf(jQuery(divEl.getWrappedElement()).find("input").get(0).getAttribute("data-itemindex"));
        }
        return -1;
    }
}

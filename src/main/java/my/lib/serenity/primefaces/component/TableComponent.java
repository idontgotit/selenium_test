package my.lib.serenity.primefaces.component;

import my.lib.serenity.primefaces.component.factory.PFComponentFactory;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by arrow on 22/9/16.
 */
public class TableComponent extends WebComponent {

    public TableComponent(PageObject parentPage, WebElementFacade webElementFacade) {
        super(parentPage, webElementFacade);
    }

    public int getCountContentRow() {
        return this.wrappedElement.thenFindAll(By.xpath("*//tbody/tr")).size();
    }

    public WebElementFacade getRow(int index) {
        return this.wrappedElement.thenFindAll(By.xpath("*//tbody/tr")).get(index);
    }

    public boolean is_no_record() {
        return (this.getCountContentRow() == 1) && this.getRow(0).getAttribute("class").contains("ui-datatable-empty-message");
    }

    public void click_check_box_by_row_index(int index) {
        this.waitForAjaxDone();
        this.wrappedElement.findBy("//div[contains(@class, 'ui-chkbox ui-widget')]").waitUntilClickable();
        this.getRow(index).findElement(By.xpath("*//div[contains(@class, 'ui-chkbox ui-widget')]")).click();
        this.waitForAjaxDone();
    }

    public boolean is_row_highlight(int index) {
        return this.getRow(index).getAttribute("class").contains("ui-state-highlight");
    }

    public void click_a_row_into_table_result(int rowIndex) {
        this.waitForAjaxDone();
        this.getRow(rowIndex).waitUntilClickable().click();
        this.waitForAjaxDone();
    }

    public void click_page_on_paging(int pageNumber) {
        this.wrappedElement.find(By.xpath("*//span[contains(@class, 'ui-paginator-page') and text()='" + pageNumber + "']")).click();
        this.waitForAjaxDone();
    }

    public int getPageSelected() {
        return Integer.parseInt(this.wrappedElement.find(By.xpath("*//span[contains(@class,'ui-paginator-page') and contains(@class, 'ui-state-active')]")).getText());
    }

    public boolean hasRowHighlight() {
        return this.wrappedElement.thenFindAll(By.xpath("*//tbody/tr[contains(@class,'ui-state-highlight')]")).size() > 0;
    }

    public boolean hasRowSelectedBySelection() {
        return this.wrappedElement.thenFindAll(By.xpath("*//tbody/tr/td/div/div[contains(@class,'ui-state-active')]")).size() > 0;
    }

    public boolean hasSelectedRow() {
        return this.hasRowHighlight() || this.hasRowSelectedBySelection();
    }

    public List<WebElementFacade> getRowSelectedInCurrentPage() {
        return this.wrappedElement.thenFindAll(By.xpath("*//tbody/tr[contains(@class,'ui-state-highlight')]"));
    }

    public boolean currentPageShowNoRowSelected() {
        return this.is_no_record() || (this.getRowSelectedInCurrentPage().size() == 0);
    }

    public void next() {
        WebElement nextButton = this.wrappedElement.find(By.xpath("*//span[contains(@class,'ui-paginator-next')]"));
        if (nextButton.isDisplayed() && nextButton.isEnabled()) {
            nextButton.click();
            this.waitForAjaxDone();
        }
    }

    public void back() {
        WebElement prevButton = this.wrappedElement.find(By.xpath("*//span[contains(@class,'ui-paginator-prev')]"));
        if (prevButton.isDisplayed() && prevButton.isEnabled()) {
            prevButton.click();
            this.waitForAjaxDone();
        }
    }

    public void first() {
        WebElement firstButton = this.wrappedElement.find(By.xpath("*//span[contains(@class,'ui-paginator-first')]"));
        if (firstButton.isDisplayed() && firstButton.isEnabled()) {
            firstButton.click();
            this.waitForAjaxDone();
        }
    }

    public void last() {
        this.waitForAjaxDone();
        WebElement lastButton = this.wrappedElement.find(By.xpath("*//span[contains(@class,'ui-paginator-last')]"));
        if (lastButton.isDisplayed() && lastButton.isEnabled()) {
            lastButton.click();
            this.waitForAjaxDone();
        }
    }

    public boolean is_show_first_page() {
        List<WebElementFacade> prevButtons = this.wrappedElement.thenFindAll(By.xpath("*//span[contains(@class,'ui-paginator-prev') and contains(@class,'ui-state-disabled')]"));
        List<WebElementFacade> firstButtons = this.wrappedElement.thenFindAll(By.xpath("*//span[contains(@class,'ui-paginator-first') and contains(@class,'ui-state-disabled')]"));
        return prevButtons.size() > 0 && firstButtons.size() > 0;
    }

    public boolean is_show_last_page() {
        List<WebElementFacade> nextButtons = this.wrappedElement.thenFindAll(By.xpath("*//span[contains(@class,'ui-paginator-next') and contains(@class,'ui-state-disabled')]"));
        List<WebElementFacade> lastButtons = this.wrappedElement.thenFindAll(By.xpath("*//span[contains(@class,'ui-paginator-last') and contains(@class,'ui-state-disabled')]"));
        return nextButtons.size() > 0 && lastButtons.size() > 0;
    }

    public boolean isExpandAll() {
        List<WebElementFacade> listDataRows = this.wrappedElement.thenFindAll(By.xpath("*//tbody/tr[contains(@class,'ui-expanded-row-content')]"));
        List<WebElementFacade> listExpandRows = this.wrappedElement.thenFindAll(By.xpath("*//tbody/tr[contains(@class,'ui-expanded-row-content')]"));
        return CollectionUtils.isNotEmpty(listExpandRows) && CollectionUtils.isNotEmpty(listDataRows) && (listDataRows.size() == listExpandRows.size());
    }

    public InputTextComponent getFilter(String columnTitle) {
        return PFComponentFactory.wrapInputText(this.parentPage, this.wrappedElement.find(By.xpath("*//thead/tr/th//label[text()='" + columnTitle + "']/ancestor::th//input")));
    }

    public void filter(String text, String columnTitle) {
        this.getFilter(columnTitle).type(text);
        this.parentPage.blurActiveElement();
        super.waitForAjaxDone();
    }

    public void filter_by_enter(String text, String columnTitle) {
        this.getFilter(columnTitle).type_and_enter(text);
    }

    public boolean is_filterd_with_text(String text, String columnTitle) {
        int columnIndex = this.getColumnIndex(columnTitle);
        List<WebElementFacade> listTd = this.wrappedElement.thenFindAll(By.xpath("*//tbody//tr/td[" + columnIndex + "]"));
        for (WebElementFacade item : listTd) {
            if (!StringUtils.containsIgnoreCase(item.getText(), text)) {
                return false;
            }
        }
        return true;
    }

    public WebElementFacade getColumnHeaderElementByTitle(String columnTitle) {
        return this.wrappedElement.find(By.xpath("*//*[text()='" + columnTitle + "']/ancestor::th"));
    }

    public ColumnHeaderComponent getColumnHeaderByTitle(String columnTitle) {
        return PFComponentFactory.wrapColumnHeader(this.parentPage, this.getColumnHeaderElementByTitle(columnTitle));
    }

    public List<WebElementFacade> getAllColumnHeaderElement() {
        List<WebElementFacade> listHeaderElement = this.wrappedElement.thenFindAll(By.xpath("*//thead//th[@role='columnheader']"));
        if (CollectionUtils.isEmpty(listHeaderElement)) {
            return Collections.emptyList();
        }
        return listHeaderElement;
    }

    public List<ColumnHeaderComponent> getAllColumnHeader() {
        List<WebElementFacade> listHeaderElement = this.getAllColumnHeaderElement();
        if (CollectionUtils.isEmpty(listHeaderElement)) {
            return Collections.emptyList();
        }
        return listHeaderElement.stream().map(webElementFacade -> {
            return new ColumnHeaderComponent(this.parentPage, webElementFacade);
        }).collect(Collectors.toList());
    }

    public int getColumnIndex(String columnTitle) {
        List<WebElementFacade> listHeader = this.wrappedElement.thenFindAll(By.xpath("*//thead//th[@role='columnheader']"));
        WebElementFacade columnHeader = getColumnHeaderElementByTitle(columnTitle);
        for (int i = 0; i < listHeader.size(); i++) {
            if (columnHeader.getAttribute("id").equalsIgnoreCase(listHeader.get(i).getAttribute("id")))
                return i + 1;
        }
        if (listHeader.size() == 0) {
            listHeader = this.wrappedElement.thenFindAll(By.xpath("thead//th[@role='columnheader']"));
            columnHeader = getColumnHeaderElementByTitle(columnTitle);
            for (int i = 0; i < listHeader.size(); i++) {
                if (columnHeader.getAttribute("id").equalsIgnoreCase(listHeader.get(i).getAttribute("id")))
                    return i + 1;
            }
        }
        return -1;
    }

    public void choose_value_for_dropdown_filter_in_column(String filterText, String columnTitle) {
        this.getColumnHeaderByTitle(columnTitle).getFilter().filter_by_text(filterText);
    }

    public ToggleComponent getToggle() {
        String id = super.clientId + ":toggler";
        return PFComponentFactory.wrapToggleComponent(this.parentPage, this.wrappedElement.find(By.xpath("*//button[@id='" + id + "']")));
    }

    public void click_radio_box_by_row_index(int index) {
        this.waitForAjaxDone();
        this.getRow(index).findBy("*//div[contains(@class, 'ui-radiobutton-box ui-widget')]").waitUntilClickable();
        this.getRow(index).findElement(By.xpath("*//div[contains(@class, 'ui-radiobutton-box ui-widget')]")).click();
        this.waitForAjaxDone();
    }

    public void select_row_by_index(int indexRecord) {
        this.waitForAjaxDone();
        this.wrappedElement.waitUntilEnabled().waitUntilClickable();
        try {
            WebElement checkbox = this.wrappedElement.findBy("*//tbody/tr[@data-ri='" + indexRecord + "']/td/div/div/span");
            if (checkbox.isDisplayed() && checkbox.isEnabled()) {
                checkbox.click();
                this.waitForAjaxDone();
            }
        } catch (NoSuchElementException e) {
            this.click_a_row_into_table_result(indexRecord);
            this.waitForAjaxDone();
        }
    }

    public boolean can_not_select_row() {
        if (this.hasSelectedRow()) {
            return false;
        }
        this.select_row_by_index(0);
        return !this.hasSelectedRow();
    }

    public List<String> getAllCellValueByColumnIndex(int columnIndex) {
        List<String> listText = new ArrayList<>();
        List<WebElementFacade> listAll = this.wrappedElement.thenFindAll(By.xpath("//div[@id='" + this.wrappedElement.getAttribute("id") + "']//tr/td[" + columnIndex + "]"));
        listText.addAll(listAll.stream().map(WebElementFacade::getText).collect(Collectors.toList()));
        return listText;
    }

    public void select_check_box_by_index(int indexRecord) {
        WebElement checkbox = this.wrappedElement.findElement(By.xpath(("*//tbody/tr[@data-ri='" + indexRecord + "']//span[contains(@class,'ui-chkbox-icon')]")));
        if (checkbox.isDisplayed() && checkbox.isEnabled()) {
            checkbox.click();
            this.waitForAjaxDone();
        }
    }

    public InputTextComponent getInputTextByIndex(int index) {
        return PFComponentFactory.wrapInputText(this.parentPage, this.wrappedElement.find(By.xpath("//tr/td[" + index + "]//input")));
    }

    public InputTextComponent getInputTextByLabelName(String labelName) {
        return PFComponentFactory.wrapInputText(this.parentPage, this.wrappedElement.find(By.xpath("*//td[contains(@class,'text-right')]//label[text()='" + labelName + "']/ancestor::tr//input")));
    }

    public SelectOneMenuComponent getSelectOneMenuByLabelName(String labelName) {
        return PFComponentFactory.wrapSelectOneMenu(this.parentPage, this.wrappedElement.find(By.xpath("*//td[contains(@class,'text-right')]//label[text()='" + labelName + "']/ancestor::tr//div[contains(@class,'ui-selectonemenu')]")));
    }

    public boolean checkSelectBoxHasIndexCanSelect(int index) {
        WebElement checkbox = this.wrappedElement.findBy("*//tbody/tr[@data-ri='" + index + "']/td/div/div/span");
        return checkbox.isDisplayed() && checkbox.isEnabled();
    }

    public String getValueInRowWithPositionColumnHeader(int clmIndex) {
        return this.wrappedElement.find(By.xpath("//tr/td[" + clmIndex + "]")).getText();
    }

    public void click_check_box_by_row_index_without_wait(int index) {
        this.waitForAjaxDone();
        this.getRow(index).findElement(By.xpath("*//div[contains(@class, 'ui-chkbox ui-widget')]")).click();
        this.waitForAjaxDone();
    }

}

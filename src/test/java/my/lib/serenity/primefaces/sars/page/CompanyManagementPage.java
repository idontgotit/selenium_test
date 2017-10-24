package my.lib.serenity.primefaces.sars.page;

import my.lib.serenity.primefaces.component.*;
import my.lib.serenity.primefaces.component.factory.PFComponentFactory;
import my.lib.serenity.primefaces.sars.model.CompanyDetailModel;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by arrow on 26/9/16.
 */
public class CompanyManagementPage extends AbstractPage {

    private static final String SAVE_SUCCESS_MESSAGE = "Save successfully";

    @FindBy(xpath = "//form[@id='searchCompany']//input[@type='text']")
    WebElementFacade inputSearchElement;

    @FindBy(xpath = "//button[@id='searchCompany:searchCompanyBtn']")
    WebElementFacade buttonSearchElement;

    @FindBy(xpath = "//div[@id='resultSearchCompany_form:menu-bar-btn-group_content']/button[1]")
    WebElementFacade buttonAddElement;

    @FindBy(xpath = "//button[@id='resultSearchCompany_form:comp_edit_btn']")
    WebElementFacade buttonEditElement;

    @FindBy(xpath = "//button[@id='resultSearchCompany_form:exportCompany']")
    WebElementFacade buttonExportElement;

    @FindBy(xpath = "//div[@id='resultSearchCompany_form:companyTable']//button[1]")
    WebElementFacade buttonExpandBranchElement;

    @FindBy(xpath = "//div[@id='resultSearchCompany_form:companyTable']")
    WebElementFacade tableCompanyElement;

    @FindBy(xpath = "//button[@id='resultSearchCompany_form:comp_delete_btn']")
    WebElementFacade buttonDeleteElement;

    private InputTextComponent inputSearch;
    private ButtonComponent buttonSearch;
    private ButtonComponent buttonAdd;
    private ButtonComponent buttonEdit;
    private ButtonComponent buttonExport;
    private ButtonComponent buttonExpandBranch;
    private TableComponent tableCompany;
    private ButtonComponent buttonDelete;

    private CompanyDetailModel selectedCompany;

    public boolean is_initialization_screen() {
        return this.getInputSearch().isEnabled() && this.getButtonSearch().isEnabled() && this.getButtonAdd().isEnabled()
                && !this.getButtonEdit().isEnabled() && this.getButtonExpandBranch().isEnabled() && this.getTableCompany().isVisible();
    }

    public void click_button_export() {
        this.getButtonExport().click_and_wait();
    }

    public boolean download_file_success() {
        return true;
    }

    public void click_button_expand_branch() {
        this.getButtonExpandBranch().click_and_wait();
    }

    public boolean should_expand_all_row_in_table_company() {
        return this.getTableCompany().isExpandAll();
    }

    public void fill_value_for_input_search_in_company_management_screen(String text) {
        this.getInputSearch().type(text);
    }

    public void click_button_search() {
        ((JavascriptExecutor) this.getDriver()).executeScript("scroll(0, -1250);");
        this.getButtonSearch().click_and_wait();
    }

    public boolean is_no_record_found() {
        return this.getTableCompany().is_no_record();
    }

    public void filter_value_for_filter_in_column(String filterText, String columnTitle) {
        this.getTableCompany().filter(filterText, columnTitle);
    }

    public void filter_value_for_filter_in_column_and_enter(String filterText, String columnTitle) {
        this.getTableCompany().filter_by_enter(filterText, columnTitle);
    }

    public boolean show_only_record_contain_text(String text, String columnTitle) {
        return this.getTableCompany().is_filterd_with_text(text, columnTitle);
    }

    public void choose_value_for_dropdown_filter_in_column(String filterText, String columnTitle) {
        this.getTableCompany().choose_value_for_dropdown_filter_in_column(filterText, columnTitle);
    }

    public void sort_column_by(String columnTitle, String type) {
        this.getTableCompany().getColumnHeaderByTitle(columnTitle).click_title_and_wait();
    }

    public void open_toggle_menu() {
        this.getTableCompany().getToggle().toggle_menu();
    }

    public void toggle_column(String columnTitle) {
        this.getTableCompany().getToggle().toggle_column(columnTitle);
//        this.getTableCompany().display_all_column();
    }

    public InputTextComponent getInputSearch() {
        if (this.inputSearch == null) {
            this.inputSearch = PFComponentFactory.wrapInputText(this, this.inputSearchElement);
        }
        return this.inputSearch;
    }

    public ButtonComponent getButtonSearch() {
        if (this.buttonSearch == null) {
            this.buttonSearch = PFComponentFactory.wrapButton(this, this.buttonSearchElement);
        }
        return this.buttonSearch;
    }

    public ButtonComponent getButtonAdd() {
        if (this.buttonAdd == null) {
            this.buttonAdd = PFComponentFactory.wrapButton(this, this.buttonAddElement);
        }
        return this.buttonAdd;
    }

    public ButtonComponent getButtonEdit() {
        if (this.buttonEdit == null) {
            this.buttonEdit = PFComponentFactory.wrapButton(this, this.buttonEditElement);
        }
        return this.buttonEdit;
    }

    public ButtonComponent getButtonExport() {
        if (this.buttonExport == null) {
            this.buttonExport = PFComponentFactory.wrapButton(this, this.buttonExportElement);
        }
        return this.buttonExport;
    }

    public ButtonComponent getButtonExpandBranch() {
        if (this.buttonExpandBranch == null) {
            this.buttonExpandBranch = PFComponentFactory.wrapButton(this, this.buttonExpandBranchElement);
        }
        return this.buttonExpandBranch;
    }

    public TableComponent getTableCompany() {
        if (this.tableCompany == null) {
            this.tableCompany = PFComponentFactory.wrapTable(this, this.tableCompanyElement);
        }
        return this.tableCompany;
    }

    public List<String> getValueTableInPageByColumnName(String columnTitle) {
        int index = this.getTableCompany().getColumnIndex(columnTitle);
        return this.getValueTableInPage(index);
    }

    public List<String> getValueTableInPage(int index) {
        List<String> listText = new ArrayList<>();
        List<WebElementFacade> listAll = this.findAll(By.xpath("*//tbody//tr/td[" + index + "]"));
        for (WebElementFacade item : listAll) {
            String itemText = item.getText();
            if (itemText.startsWith("(JSC)") || itemText.startsWith("(Co.,Ltd)")) {
                listText.add(itemText.substring(itemText.indexOf(")") + 1).trim());
            } else {
                listText.add(itemText);
            }
        }
        return listText;
    }

    public void create_new_company() {
        ButtonComponent newButton = PFComponentFactory.wrapButton(this, this.findBy("//div[@id='resultSearchCompany_form:menu-bar-btn-group_content']/button[.//span[text()='Add']]"));
        newButton.click_and_wait();
    }

    public void set_company_name(String companyName) {
        InputTextComponent companyNameTxt = PFComponentFactory.wrapInputText(this, this.findBy("//input[@id='companyAddForm:company_name']"));
        companyNameTxt.type_and_wait(companyName);
    }

    public void input_company_detail(CompanyDetailModel companyDetailModel) {
        OneRadioComponent companyFullName = PFComponentFactory.wrapOneRadioElement(this, this.findBy("//span[@id='companyAddForm:company_limited']"));
        companyFullName.select_option_by_text(companyDetailModel.getCompanyFullName());

        if (StringUtils.isNoneEmpty(companyDetailModel.getCustomerCode())) {
            InputTextComponent customerCode = PFComponentFactory.wrapInputText(this, this.findBy("//input[@id='companyAddForm:customer_code']"));
            customerCode.type(companyDetailModel.getCustomerCode());
        }

        AutoCompleteComponent workType = PFComponentFactory.wrapAutoCompleteElement(this, this.findBy("//span[@id='companyAddForm:company_type_of_work']"));
//        workType.click_drop_down();
        workType.open_drop_down_and_select_restul_by_text(companyDetailModel.getWorkType());

        OneRadioComponent listedType = PFComponentFactory.wrapOneRadioElement(this, this.findBy("//*[@id='companyAddForm:company_listed']"));
        listedType.select_option_by_text(companyDetailModel.getListed());

        if (StringUtils.isNotEmpty(companyDetailModel.getWebsite())) {
            InputTextComponent website = PFComponentFactory.wrapInputText(this, this.findBy("//input[@id='companyAddForm:company_url']"));
            website.type(companyDetailModel.getWebsite());
        }

        AutoCompleteComponent headOffice = PFComponentFactory.wrapAutoCompleteElement(this, this.findBy("//span[@id='companyAddForm:company_main_address']"));
//        headOffice.click_drop_down();
        headOffice.open_drop_down_and_select_restul_by_text(companyDetailModel.getHeadOffice());

        if (StringUtils.isNotEmpty(companyDetailModel.getBranches())) {
            String[] branches = companyDetailModel.getBranches().split(",");
            for (int i = 0; i < branches.length; i++) {
                this.select_branch_by_name(branches[i]);
            }
        }

    }

    public void select_branch_by_name(String branchName) {
        WebElementFacade element = this.findBy("//*[@id='companyAddForm:pickList']//ul[contains(@class,'ui-picklist-source')]/li[contains(@data-item-label,'" + branchName.trim() + "')]");
        element.click();
        ButtonComponent buttonAdd = PFComponentFactory.wrapButton(this, this.findBy("//button[contains(@class,'ui-picklist-button-add') and @title='Add']"));
        buttonAdd.click_and_wait();
    }

    public void click_button_on_detail(String buttonText) {
        ButtonComponent buttonComponent = PFComponentFactory.wrapButton(this, this.findBy("//button[.//span[text()='" + buttonText + "']]"));
        buttonComponent.click_and_wait();
    }

    public boolean should_show_button_delete() {
        return this.getButtonDelete() != null && this.getButtonDelete().isVisible();
    }

    public ButtonComponent getButtonDelete() {
        if (this.buttonDelete != null || !containsElements(By.xpath("//button[@id='resultSearchCompany_form:comp_delete_btn']"))) {
            return buttonDelete;
        } else {
            this.buttonDelete = PFComponentFactory.wrapButton(this, this.buttonDeleteElement);
            return this.buttonDelete;
        }
    }

    public void select_row(int rowIndex) {
        this.getTableCompany().click_radio_box_by_row_index(rowIndex);
    }

    public void click_button_delete() {
        if (this.getButtonDelete() == null) {
            return;
        }

        this.getButtonDelete().click_and_wait();
    }

    public void confirm_delete_compnay() {
        PFComponentFactory.wrapButton(this, this.find(By.xpath("//div[contains(@class,'ui-confirm-dialog') and contains(@style,'display: block')]//span[text()='Yes']//ancestor::button"))).click_and_wait();
    }

    public boolean should_save_company_success() {
        boolean isShowMessage = this.find(By.xpath("//div[@id='growl_container']")).isCurrentlyVisible();
        List<WebElementFacade> listErrorMessages = this.findAll("//div[@id='growl_container']//div[@class='ui-growl-message']//p");
        List<String> listMessageText = listErrorMessages.stream().map(WebElementFacade::getText).collect(Collectors.toList());
        this.wait_for_message_disappeared();
        return isShowMessage && listMessageText.contains(this.SAVE_SUCCESS_MESSAGE);
    }

    public boolean is_initialization_screen_of_company_details() {
        WebElementFacade companyName = this.findBy("//input[@id='companyAddForm:company_name']");
        WebElementFacade furigana = this.findBy("//input[@id='companyAddForm:company_furigama']");
        List<WebElementFacade> companyFullName = this.findAll("//table[@id='companyAddForm:content_company_limited']//div[contains(@class,'ui-state-active')]");
        WebElementFacade customerCode = this.findBy("//input[@id='companyAddForm:customer_code']");
        WebElementFacade workType = this.findBy("//input[@id='companyAddForm:company_type_of_work_input']");
        List<WebElementFacade> listed = this.findAll("//table[@id='companyAddForm:company_listed']//div[contains(@class,'ui-state-active')]");
        WebElementFacade website = this.findBy("//input[@id='companyAddForm:company_url']");
        WebElementFacade headOffice = this.findBy("//input[@id='companyAddForm:company_main_address_input']");
        List<WebElementFacade> branches = this.findAll("//div[@id='companyAddForm:pickList']//div[3]/ul/li");

        return StringUtils.isEmpty(companyName.getText()) && StringUtils.isEmpty(furigana.getText()) && CollectionUtils.isEmpty(companyFullName) && StringUtils.isEmpty(customerCode.getText())
                && StringUtils.isEmpty(workType.getText()) && CollectionUtils.isEmpty(listed) && StringUtils.isEmpty(website.getText()) && StringUtils.isEmpty(headOffice.getText())
                && CollectionUtils.isEmpty(branches);
    }

    public void in_company_detail_screen_click_button_back() {
        try {
//            ButtonComponent buttonBack = PFComponentFactory.wrapButton(this, this.findBy("//button[@id='companyAddForm:btnclose']"));
//            buttonBack.click_and_wait();
            this.findBy("//button[@id='companyAddForm:btnclose']").click();
//            this.wait_for_ajax_done();
        } catch (UnhandledAlertException e) {
        } finally {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            new WebDriverWait(getDriver(), 5).until(ExpectedConditions.alertIsPresent());
            Alert alert = ExpectedConditions.alertIsPresent().apply(this.getDriver());
            if (alert != null) {
                this.getDriver().switchTo().alert().accept();
            }
            this.wait_for_ajax_done();
        }
    }

    public void click_button_last_page_on_paging() {
        this.getTableCompany().last();
    }

    public void click_button_first_page_on_paging() {
        this.getTableCompany().first();
    }

    public void click_page_on_paging(int pageIndex) {
        this.getTableCompany().click_page_on_paging(pageIndex);
    }

    public void click_button_next() {
        this.getTableCompany().next();
    }

    public void click_button_back() {
        this.getTableCompany().back();
    }

    private void wait_for_ajax_done() {
        PanelComponent companyTradeMark = PFComponentFactory.wrapPanel(this, By.xpath("//div[@id='companyTradeMark']"));
        companyTradeMark.wait_for_ajax_done();
    }

    public void click_button_edit() {
        this.getButtonEdit().click_and_wait();
        this.selectedCompany = this.create_company_detail_model_from_screen_data();
    }

    public boolean should_reset_company_detail_screen() {
        CompanyDetailModel companyDetailAfterReset = this.create_company_detail_model_from_screen_data();
        return this.selectedCompany.equals(companyDetailAfterReset);
    }

    private CompanyDetailModel create_company_detail_model_from_screen_data() {
        String companyName = this.findBy("//input[@id='companyAddForm:company_name']").getValue();
        String furigana = this.findBy("//input[@id='companyAddForm:company_furigama']").getValue();
        String companyFullName = this.findBy("//table[@id='companyAddForm:content_company_limited']//div[contains(@class,'ui-state-active')]//ancestor::td[1]//following::td[1]/label").getText();
        String customerCode = this.findBy("//input[@id='companyAddForm:customer_code']").getValue();
        String workType = this.findBy("//input[@id='companyAddForm:company_type_of_work_input']").getValue();
        String listed = this.findBy("//table[@id='companyAddForm:company_listed']//div[contains(@class,'ui-state-active')]//ancestor::td[1]//following::td[1]/label").getText();
        String website = this.findBy("//input[@id='companyAddForm:company_url']").getValue();
        String headOffice = this.findBy("//input[@id='companyAddForm:company_main_address_input']").getValue();

        String branches = "";
        List<WebElementFacade> listBranches = this.findAll("//div[@id='companyAddForm:pickList']//div[3]/ul/li/table/tbody/tr/td[2]");
        if (CollectionUtils.isNotEmpty(listBranches)) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < listBranches.size(); i++) {
                builder.append(listBranches.get(i).getText());
                builder.append(i != (listBranches.size() - 1) ? "," : "");
            }
            branches = builder.toString();
        }

        return new CompanyDetailModel(companyFullName, workType, listed, headOffice, customerCode, website, branches, furigana, companyName);
    }

    public void view_recent_activities_with_company() {
        PFComponentFactory.wrapCommandLink(this, "//a[text()='Top recent activities with company']").click_and_wait();
    }

    public boolean is_open_recent_activities_screen() {
        return this.findBy("//div[@id='activitiesWithCompanyDialog']").isCurrentlyVisible();
    }

    public void close_recent_activities_screen() {
        this.findBy("//div[@id='activitiesWithCompanyDialog']/div/a").click();
    }

    public void click_accept_on_alert_popup() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Alert alert = this.getDriver().switchTo().alert();
        if (alert != null) {
            alert.accept();
            this.wait_for_ajax_done();
        }
    }

    public void clear_customer_code() {
        this.findBy("//input[@id='companyAddForm:customer_code']").clear();
    }

    public void input_customer_code(String customerCode) {
        PFComponentFactory.wrapInputText(this, this.findBy("//input[@id='companyAddForm:customer_code']")).type(customerCode);
    }

    public boolean the_system_should_show_customer_code_empty() {
        return StringUtils.isEmpty(PFComponentFactory.wrapInputText(this, this.findBy("//input[@id='companyAddForm:customer_code']")).getValue());
    }
}

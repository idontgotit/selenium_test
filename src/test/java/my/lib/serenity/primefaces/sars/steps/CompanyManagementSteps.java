package my.lib.serenity.primefaces.sars.steps;

import my.lib.serenity.primefaces.constant.CommonConstant;
import my.lib.serenity.primefaces.sars.model.CompanyDetailModel;
import my.lib.serenity.primefaces.sars.page.CompanyManagementPage;
import net.thucydides.core.steps.ScenarioSteps;
import org.apache.commons.collections.CollectionUtils;
import org.assertj.core.api.Assertions;

import java.text.Collator;
import java.util.*;

/**
 * Created by arrow on 26/9/16.
 */
public class CompanyManagementSteps extends ScenarioSteps {
    private CompanyManagementPage companyManagementPage;

    public void should_show_initialization_screen_of_company_management_page() {
        Assertions.assertThat(this.companyManagementPage.is_initialization_screen()).isTrue();
    }

    public void click_button_export() {
        this.companyManagementPage.click_button_export();
    }

    public void download_file_excel_company_details() {
        Assertions.assertThat(this.companyManagementPage.download_file_success()).isTrue();
    }

    public void click_button_expand_branch() {
        this.companyManagementPage.click_button_expand_branch();
    }

    public void should_expand_all_row_in_table_company() {
        Assertions.assertThat(this.companyManagementPage.should_expand_all_row_in_table_company()).isTrue();
    }

    public void fill_value_for_input_search_in_company_management_screen(String text) {
        this.companyManagementPage.fill_value_for_input_search_in_company_management_screen(text);
    }

    public void click_button_search() {
        this.companyManagementPage.click_button_search();
    }

    public void should_show_table_company_with_no_record_found() {
        Assertions.assertThat(this.companyManagementPage.is_no_record_found()).isTrue();
    }

    public void should_show_table_company_with_record_found() {
        Assertions.assertThat(this.companyManagementPage.is_no_record_found()).isFalse();
    }

    public void filter_value_for_filter_in_column(String filterText, String columnTitle) {
        this.companyManagementPage.filter_value_for_filter_in_column(filterText, columnTitle);
    }

    public void should_show_only_record_contain_text(String text, String columnTitle) {
        Assertions.assertThat(this.companyManagementPage.show_only_record_contain_text(text, columnTitle)).isTrue();
    }

    public void filter_value_for_filter_in_column_and_enter(String filterText, String columnTitle) {
        this.companyManagementPage.filter_value_for_filter_in_column_and_enter(filterText, columnTitle);
    }

    public void choose_value_for_dropdown_filter_in_column(String filterText, String columnTitle) {
        this.companyManagementPage.choose_value_for_dropdown_filter_in_column(filterText, columnTitle);
    }

    public void should_show_table_company_sorted_by_column_column_company_name_title_and_ascending(String columnTitle, String type) {
        List<String> listAll = this.companyManagementPage.getValueTableInPageByColumnName(columnTitle);
        if (columnTitle.equalsIgnoreCase("Company Name")) {
            HashMap<String, Integer> listMapCountAllResultIsSame = this.countAllResultIsSame(listAll);
            HashMap<String, Integer> listCountNextResultIsSame = this.countNextResultIsSame(listAll);
            Assertions.assertThat(listMapCountAllResultIsSame.size()).isEqualTo(listCountNextResultIsSame.size());
            if (listMapCountAllResultIsSame.size() == listCountNextResultIsSame.size()) {
                this.compareHashMapAllResultAndNextSameResult(listMapCountAllResultIsSame, listCountNextResultIsSame);
            }
        }

        if (columnTitle.equalsIgnoreCase("Website") || columnTitle.equalsIgnoreCase("Customer code") || columnTitle.equalsIgnoreCase("Listed")) {
            List<String> newListSortAlphabet = new ArrayList<>(listAll);
            Collator collator = Collator.getInstance(Locale.JAPANESE);
            if (type.equalsIgnoreCase("ASC")) {
                Collections.sort(newListSortAlphabet, collator);
            } else {
                Collections.reverse(newListSortAlphabet);
            }
            Assertions.assertThat(CollectionUtils.isEqualCollection(listAll, newListSortAlphabet)).isTrue();
        }

        if (columnTitle.equalsIgnoreCase("Head Office")) {
            if (type.equalsIgnoreCase("ASC")) {
                Assertions.assertThat(this.check_sorter_for_header_with_dropdown(listAll, CommonConstant.getMapAddressPoint(), true)).isTrue();
            } else {
                Assertions.assertThat(this.check_sorter_for_header_with_dropdown(listAll, CommonConstant.getMapAddressPoint(), false)).isTrue();
            }


        }
    }

    private boolean check_sorter_for_header_with_dropdown(List<String> dataList, Map<Integer, String> verifyingMap, boolean isAscending) {
        int lastMatchedIndex = 0;
        for (String data : dataList) {
            if (!verifyingMap.containsValue(data)) {
                return false;
            }

            int matchedKey = 0;
            if (isAscending) {
                for (Integer key : verifyingMap.keySet()) {
                    if (verifyingMap.get(key).equalsIgnoreCase(data)) {
                        matchedKey = key;
                        break;
                    }
                }

                if (matchedKey < lastMatchedIndex) {
                    return false;
                }
                lastMatchedIndex = matchedKey;
            } else {
                ArrayList<Integer> keys = new ArrayList<Integer>(verifyingMap.keySet());
                lastMatchedIndex = keys.get(keys.size() - 1);
                for (int i = (keys.size() - 1); i >= 0; i--) {
                    if (verifyingMap.get(keys.get(i)).equalsIgnoreCase(data)) {
                        matchedKey = keys.get(i);
                        break;
                    }
                }

                if (matchedKey > lastMatchedIndex) {
                    return false;
                }
                lastMatchedIndex = matchedKey;
            }
        }
        return true;
    }

    private void compareHashMapAllResultAndNextSameResult(HashMap<String, Integer> listMapCountAllResultIsSame, HashMap<String, Integer> listCountNextResultIsSame) {
        for (Map.Entry<String, Integer> entry : listMapCountAllResultIsSame.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            Assertions.assertThat(value).isEqualTo(listCountNextResultIsSame.get(key));
        }
    }

    private HashMap<String, Integer> countAllResultIsSame(List<String> listAll) {
        HashMap<String, Integer> listMapCountAllResultIsSame = new HashMap<>();
        for (int i = 0; i < listAll.size(); i++) {
            int count = 1;
            for (int j = 0; j < listAll.size(); j++) {
                if (i == j)
                    continue;
                else {
                    if (listAll.get(j).substring(0, 1).equalsIgnoreCase(listAll.get(i).substring(0, 1))) {
                        count++;
                    }
                }
            }
            listMapCountAllResultIsSame.put(listAll.get(i).substring(0, 1).toLowerCase(), count);
        }
        return listMapCountAllResultIsSame;
    }

    private HashMap<String, Integer> countNextResultIsSame(List<String> listAll) {
        HashMap<String, Integer> listCountNextResultIsSame = new HashMap<>();
        for (int i = 0; i < listAll.size(); i++) {
            int count = 1;
            for (int j = i + 1; j < listAll.size(); j++) {
                if (listAll.get(j).substring(0, 1).equalsIgnoreCase(listAll.get(i).substring(0, 1))) {
                    count++;
                    i = j;
                }
            }
            listCountNextResultIsSame.put(listAll.get(i).substring(0, 1).toLowerCase(), count);
        }
        return listCountNextResultIsSame;
    }

    public void sort_column_by(String columnTitle, String type) {
        this.companyManagementPage.sort_column_by(columnTitle, type);
    }

    public void open_toggle_menu() {
        this.companyManagementPage.open_toggle_menu();
    }

    public void toggle_column(String columnTitle) {
        this.companyManagementPage.toggle_column(columnTitle);
    }

    public void create_new_company_with_name(String companyName) {
        this.companyManagementPage.create_new_company();
        this.companyManagementPage.set_company_name(companyName);
    }

    public void input_company_detail(CompanyDetailModel companyDetailModel) {
        this.companyManagementPage.input_company_detail(companyDetailModel);
    }

    public void click_button_on_detail_screen(String buttonText) {
        this.companyManagementPage.click_button_on_detail(buttonText);
    }

    public void should_show_button_delete() {
        Assertions.assertThat(this.companyManagementPage.should_show_button_delete()).isTrue();
    }

    public void should_not_show_button_delete() {
        Assertions.assertThat(this.companyManagementPage.should_show_button_delete()).isFalse();
    }

    public void select_row(int rowIndex) {
        this.companyManagementPage.select_row(rowIndex);
    }

    public void click_button_delete() {
        this.companyManagementPage.click_button_delete();
    }

    public void confirm_delete_company() {
        this.companyManagementPage.confirm_delete_compnay();
    }

    public void should_save_company_success() {
        Assertions.assertThat(this.companyManagementPage.should_save_company_success()).isTrue();
    }

    public void is_initialization_screen_of_company_details() {
        Assertions.assertThat(this.companyManagementPage.is_initialization_screen_of_company_details()).isTrue();
    }

    public void in_company_detail_screen_click_button_back() {
        this.companyManagementPage.in_company_detail_screen_click_button_back();
    }

    public void click_button_last_page_on_paging() {
        this.companyManagementPage.click_button_last_page_on_paging();
    }

    public void should_show_last_page() {
        Assertions.assertThat(this.companyManagementPage.getTableCompany().is_show_last_page()).isTrue();
    }

    public void click_button_first_page_on_paging() {
        this.companyManagementPage.click_button_first_page_on_paging();
    }

    public void should_show_first_page() {
        Assertions.assertThat(this.companyManagementPage.getTableCompany().is_show_first_page()).isTrue();
    }

    public void click_page_on_paging(int pageIndex) {
        this.companyManagementPage.click_page_on_paging(pageIndex);
    }

    public void change_table_result_to_selected_page(int pageIndex) {
        Assertions.assertThat(this.companyManagementPage.getTableCompany().getPageSelected()).isEqualTo(pageIndex);
    }

    public void click_button_next() {
        this.companyManagementPage.click_button_next();
    }

    public void click_button_back() {
        this.companyManagementPage.click_button_back();
    }

    public void click_button_edit() {
        this.companyManagementPage.click_button_edit();
    }

    public void edit_company_with_name(String companyName) {
        this.companyManagementPage.click_button_edit();
        this.companyManagementPage.set_company_name(companyName);
    }

    public void should_reset_company_detail_screen() {
        Assertions.assertThat(this.companyManagementPage.should_reset_company_detail_screen());
    }

    public void view_recent_activities_with_company() {
        this.companyManagementPage.view_recent_activities_with_company();
    }

    public void should_open_recent_activities_screen() {
        Assertions.assertThat(this.companyManagementPage.is_open_recent_activities_screen()).isTrue();
    }

    public void close_recent_activities_screen() {
        this.companyManagementPage.close_recent_activities_screen();
    }

    public void set_name_for_company(String companyName) {
        this.companyManagementPage.set_company_name(companyName);
    }

    public void click_accept_on_alert_popup() {
        this.companyManagementPage.click_accept_on_alert_popup();
    }

    public void clear_customer_code() {
        this.companyManagementPage.clear_customer_code();
    }

    public void should_save_company_unsuccess() {
        Assertions.assertThat(this.companyManagementPage.should_save_company_success()).isFalse();
    }

    public void input_customer_code(String customerCode) {
        this.companyManagementPage.input_customer_code(customerCode);
    }

    public void the_system_should_show_customer_code_empty() {
        Assertions.assertThat(this.companyManagementPage.the_system_should_show_customer_code_empty()).isTrue();
    }
}

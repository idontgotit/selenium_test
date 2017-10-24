package my.lib.serenity.primefaces.sars.steps;

import my.lib.serenity.primefaces.constant.CommonConstant;
import my.lib.serenity.primefaces.sars.model.EmployeeManagementModel;
import my.lib.serenity.primefaces.sars.page.EmployeeManagementPage;
import my.lib.serenity.primefaces.sars.utils.CommonUtils;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.steps.ScenarioSteps;
import org.assertj.core.api.Assertions;
import org.fluentlenium.core.annotation.Page;

import java.util.*;

import static my.lib.serenity.primefaces.sars.utils.ConstantsEmployeeManagement.*;

/**
 * Created by ngoc on 27/09/2016.
 */
public class EmployeeManagementSteps extends ScenarioSteps {

    @Page
    private EmployeeManagementPage employeeManagementPage;

    public static EmployeeManagementModel currentEmployeeManagementModel;

    private EmployeeManagementModel empModelBeforeReset;

    public EmployeeManagementModel getVariable() {
        return currentEmployeeManagementModel;
    }

    public void setVariable(EmployeeManagementModel var) {
        this.currentEmployeeManagementModel = var;
    }

    public void buttonIsEnable(String buttonText) {
        Assertions.assertThat(this.employeeManagementPage.findByButtonText(buttonText).isEnabled()).isTrue();
    }

    public void buttonIsDisable(String buttonText) {
        Assertions.assertThat(this.employeeManagementPage.findByButtonText(buttonText).isEnabled()).isFalse();
    }

    public void tableIsVisible() {
        Assertions.assertThat(this.employeeManagementPage.getTableEmployee().isVisible()).isTrue();
    }

    public void compareColumn(int numberColumn) {
        Assertions.assertThat(this.employeeManagementPage.getNumberColumnInTableEmployee()).isEqualTo(numberColumn);
    }

    public void typeTextToFilterColumn(String textSend, String columnName) {
        this.employeeManagementPage.typeTextToFilterColumn(textSend, columnName);
    }

    public void compareResult(String columnName, String resultText) {
        List<String> listResultAfterFilter = this.employeeManagementPage.getValueTableInPageByColumnName(columnName);
        for (String item : listResultAfterFilter) {
            Assertions.assertThat(item.contains(resultText)).isTrue();
        }
    }

    public void compareNumberResultInPage(int numberOfRs) {
        Assertions.assertThat(this.employeeManagementPage.getAllResultInPage().size()).isEqualTo(numberOfRs);
    }

    public void clickPage(int numberButtonPage) {

        this.employeeManagementPage.clickPage(numberButtonPage);
    }

    public void clickSortPage(String columnName, String typeSort) {
        this.employeeManagementPage.clickSort(columnName);
    }

    public void verifyResultAfterSort(String columnName, String typeSort) {
        List<String> listAll = this.employeeManagementPage.getValueTableInPageByColumnName(columnName);
        if (columnName.equalsIgnoreCase(EMPLOYEE_CODE)) {
            if (typeSort.equalsIgnoreCase("ASC")) {
                for (int i = 0; i < listAll.size() - 1; i++) {
                    Assertions.assertThat(Integer.valueOf(listAll.get(i))).isLessThan(Integer.valueOf(listAll.get(i + 1)));
                }
            } else {
                for (int i = 0; i < listAll.size() - 1; i++) {
                    Assertions.assertThat(Integer.valueOf(listAll.get(i))).isGreaterThan(Integer.valueOf(listAll.get(i + 1)));
                }
            }
        }
        if (columnName.equalsIgnoreCase(EMPLOYEE_NAME)) {
            HashMap<String, Integer> listMapCountAllResultIsSame = CommonUtils.countAllResultIsSame(listAll);
            HashMap<String, Integer> listCountNextResultIsSame = CommonUtils.countNextResultIsSame(listAll);
            Assertions.assertThat(listMapCountAllResultIsSame.size()).isEqualTo(listCountNextResultIsSame.size());
            if (listMapCountAllResultIsSame.size() == listCountNextResultIsSame.size()) {
                this.compareHashMapAllResultAndNextSameResult(listMapCountAllResultIsSame, listCountNextResultIsSame);
            }
        }

        if (columnName.equalsIgnoreCase(HEAD_OFFICE)) {
            if (typeSort.equalsIgnoreCase(ASCENDING)) {
                Assertions.assertThat(this.check_sorter_for_header_with_dropdown(listAll, CommonConstant.getMapBranch_master(), true)).isTrue();
            } else {
                Assertions.assertThat(this.check_sorter_for_header_with_dropdown(listAll, CommonConstant.getMapBranch_master(), false)).isTrue();
            }
        }

        if (columnName.equalsIgnoreCase(POSITION)) {
            if (typeSort.equalsIgnoreCase(ASCENDING)) {
                Assertions.assertThat(this.check_sorter_for_header_with_dropdown(listAll, CommonConstant.getMapPosition(), true)).isTrue();
            } else {
                Assertions.assertThat(this.check_sorter_for_header_with_dropdown(listAll, CommonConstant.getMapPosition(), false)).isTrue();
            }
        }

        if (columnName.equalsIgnoreCase(AUTHORITY)) {
            if (typeSort.equalsIgnoreCase(ASCENDING)) {
                Assertions.assertThat(this.check_sorter_for_header_with_dropdown(listAll, CommonConstant.getMapAuthority(), true)).isTrue();
            } else {
                Assertions.assertThat(this.check_sorter_for_header_with_dropdown(listAll, CommonConstant.getMapAuthority(), false)).isTrue();
            }
        }

        if (columnName.equalsIgnoreCase(EMAIL)) {
            if (typeSort.equalsIgnoreCase(ASCENDING)) {
                List<String> newListSortAlphabet = new ArrayList<>(listAll);
                Collections.sort(newListSortAlphabet, String.CASE_INSENSITIVE_ORDER);
                this.compare2ListStringIsEqual(listAll, newListSortAlphabet);
            } else {
                List<String> newListSortReverseAlphabet = new ArrayList<>(listAll);
                Collections.sort(newListSortReverseAlphabet, String.CASE_INSENSITIVE_ORDER);
                Collections.reverse(newListSortReverseAlphabet);
                this.compare2ListStringIsEqual(listAll, newListSortReverseAlphabet);
            }
        }
    }

    private void compare2ListStringIsEqual(List<String> srcList, List<String> desList) {
        for (int i = 0; i < srcList.size(); i++) {
            Assertions.assertThat(srcList.get(i).equalsIgnoreCase(desList.get(i))).isTrue();
        }
    }

    private void compareHashMapAllResultAndNextSameResult(HashMap<String, Integer> listMapCountAllResultIsSame, HashMap<String, Integer> listCountNextResultIsSame) {
        for (Map.Entry<String, Integer> entry : listMapCountAllResultIsSame.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            Assertions.assertThat(value).isEqualTo(listCountNextResultIsSame.get(key));
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
                ArrayList<Integer> keys = new ArrayList<>(verifyingMap.keySet());
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

    public void selectRecord(int indexRecord) {
        this.employeeManagementPage.selectRecord(indexRecord);
    }

    public void chooseTextInSelectBoxByColumnTitle(String textFilter, String columnTitle) {
        this.employeeManagementPage.chooseTextInSelectBoxByColumnTitle(textFilter, columnTitle);
    }

    public void selectButton(String buttonTitle) {
        this.employeeManagementPage.selectButton(buttonTitle);
    }

    public void systemShowMessage(String message) {
        List<String> listGrowlMessage = this.employeeManagementPage.getGrowlMessage();
        for (int i = 0; i < listGrowlMessage.size(); i++) {
            Assertions.assertThat(listGrowlMessage.get(i)).containsIgnoringCase(message);
        }
        this.employeeManagementPage.wait_for_message_disappeared();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkButtonCanNotUse(String buttonTitle) {
        Assertions.assertThat(this.employeeManagementPage.getButtonByTitle(buttonTitle).isEnabled()).isFalse();
    }

    public void fillAllDataInEmployeeManagementModel(EmployeeManagementModel employeeManagementModel) throws InterruptedException {
        this.empModelBeforeReset = this.employeeManagementPage.createPhantomInputValue();
        this.employeeManagementPage.clearAllDataBeforeNewInput();
        employeeManagementModel.setEmpName(this.employeeManagementPage.generateUUID());
        if (employeeManagementModel.getPrivilege() != null) {
            this.setVariable(employeeManagementModel);
            this.employeeManagementPage.fillDataRequireInEmployeeManagement(employeeManagementModel.getEmpName(), employeeManagementModel.getHireDate(), employeeManagementModel.getStatus(), employeeManagementModel.getBaseLocation()
                    , employeeManagementModel.getPrivilege(), employeeManagementModel.getEmail());
        }
        if (employeeManagementModel.getTel() != null)
            this.employeeManagementPage.fillDataNotRequireInEmployeeManagement(employeeManagementModel.getTel(), employeeManagementModel.getMobile());

    }

    public void fillAllDataWithOutRequire(String tel, String mobile) {
        this.employeeManagementPage.clearAllDataBeforeNewInput();
        this.employeeManagementPage.fillDataNotRequireInEmployeeManagement(tel, mobile);
    }

 
    public void checkTableEmployeeShow() {
        Assertions.assertThat(this.employeeManagementPage.find(By.xpath("//div[@id='emp_list']")).isVisible()).isTrue();
    }

    public void selectBackButton() {
        this.employeeManagementPage.selectBackButton();
    }

    public void compareResultTableAfterReset() {
        Assertions.assertThat(this.employeeManagementPage.compareValueAfterReset(this.empModelBeforeReset)).isTrue();
    }

    public void confirmDelete() {
        this.employeeManagementPage.confirmDelete();
    }

    public void findRecordWithNameAndSelect(String name) {
        this.employeeManagementPage.findRecordWithNameAndSelect(name);
    }

    public void selectRecordCreateBefore() {
        this.employeeManagementPage.typeTextToFilterColumn(this.currentEmployeeManagementModel.getEmpName(), EMPLOYEE_NAME);
        this.findRecordWithNameAndSelect(this.currentEmployeeManagementModel.getEmpName());
    }

    public void selectIndexRecordCanClick(int index) {
        this.employeeManagementPage.selectIndexRecordCanClick(index);
    }

    public void toggleAllColumn(List<String> listColumnTitle) {
        this.employeeManagementPage.toggleAllColumn(listColumnTitle);
    }

    public void compareColumnNotHidden(int numberColumn) {
        Assertions.assertThat(this.employeeManagementPage.getNumberColumnNotHiddenInTableEmployee()).isEqualTo(numberColumn);
    }

    public void clickPageWithNameOnPaging(String namePage) {
        this.employeeManagementPage.clickPageWithNameOnPaging(namePage);
    }

    public void verifyPageAfterClick(String namePage) {
        Assertions.assertThat(this.employeeManagementPage.verifyPageAfterClick(namePage)).isTrue();
    }

    public void verifyRecordSelected(int index) {
        this.employeeManagementPage.verifyRecordSelected(index);
    }

    public void verifyMaxLengthInputField(String name, Integer maxLength) {
        Assertions.assertThat(this.employeeManagementPage.verifyMaxLengthInputFieldByName(name, maxLength)).isTrue();
    }
}

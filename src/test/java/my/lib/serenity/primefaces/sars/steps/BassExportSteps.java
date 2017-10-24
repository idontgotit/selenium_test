package my.lib.serenity.primefaces.sars.steps;

import my.lib.serenity.primefaces.sars.page.BassExportPage;
import my.lib.serenity.primefaces.sars.urlstatuschecker.RequestMethod;
import my.lib.serenity.primefaces.sars.urlstatuschecker.URLStatusChecker;
import net.thucydides.core.steps.ScenarioSteps;
import org.assertj.core.api.Assertions;
import org.fluentlenium.core.annotation.Page;

import java.net.URL;
import java.util.List;

/**
 * Created by ngoc on 21/09/2016.
 */
public class BassExportSteps extends ScenarioSteps {

    @Page
    private BassExportPage bassExportPage;

    public void buttonIsVisible(String buttonText) {
        Assertions.assertThat(this.bassExportPage.findByButtonText(buttonText)).isGreaterThan(0);
    }

    public void clickButton(String buttonText) {
        this.bassExportPage.clickButton(buttonText);
    }

    public void tableFileDownloadVisibleWithSixRows(String tableTitle) {
        Assertions.assertThat(this.bassExportPage.getPanelGridTitle()).isEqualToIgnoringCase(tableTitle);
        Assertions.assertThat(this.bassExportPage.getRowsOfPanelGrid()).isEqualTo(6);
    }

    public void downloadLocationVisible(String downloadLocationText) {
        Assertions.assertThat(this.bassExportPage.getDownloadedLocationText()).isEqualToIgnoringCase(downloadLocationText);
    }

    public void inputTextCanNotEdit() {
        Assertions.assertThat(this.bassExportPage.getValueDownloadLocationElement().getAttribute("readonly")).isEqualToIgnoringCase("true");
    }

    public void inputTextCanEdit() {
        Assertions.assertThat(this.bassExportPage.getValueDownloadLocationElement().getAttribute("readonly") == null);
    }


    public void buttonIsInvisible(String buttonText) {
        Assertions.assertThat(this.bassExportPage.getButtonElementByButtonText(buttonText).isCurrentlyVisible()).isFalse();
    }

    public void typeTextInInputText(String textValue) {
        this.bassExportPage.getElementInputText().type(textValue);
        Assertions.assertThat(this.bassExportPage.getElementInputText().getValue()).isEqualToIgnoringCase(textValue);
    }

    public void savePathToNewVariable() {
        this.bassExportPage.savePathToNewVar();
    }

    public void comparePathAfterCancel() {
        Assertions.assertThat(this.bassExportPage.comparePathAfterCancel()).isTrue();
    }

    public void comparePathAfterSave(String newPath) {
        Assertions.assertThat(this.bassExportPage.comparePathAfterSave(newPath)).isTrue();
    }

    public void comparePathWithClipBoardAfterCopy() {
        Assertions.assertThat(this.bassExportPage.getPathInClipBoardO()).isEqualToIgnoringCase(this.bassExportPage.getElementInputText().getValue());
    }

    public void checkLinkDownloadApi() throws Exception {
        List<String> listDownload = this.bassExportPage.getAllLinkDownloadApi();
        for (int i = 0; i < listDownload.size(); i++) {
            URLStatusChecker urlChecker = new URLStatusChecker(this.getDriver());
            urlChecker.setURIToCheck(new URL(listDownload.get(i)));
            urlChecker.setHTTPRequestMethod(RequestMethod.GET);
            Assertions.assertThat(urlChecker.getResponse().getStatusLine().getStatusCode()).isEqualTo(200);
            String currentDownloadLink = listDownload.get(i).substring(listDownload.get(i).lastIndexOf("/") + 1, listDownload.get(i).length());
            Assertions.assertThat(urlChecker.getResponse().getHeaders("Content-Disposition")[0].getValue()).contains(currentDownloadLink);
        }
    }

    public void createAllLinkDownloadApi() {
        this.bassExportPage.createAllLinkDownloadApi();
    }
}

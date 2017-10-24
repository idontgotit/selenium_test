package my.lib.serenity.primefaces.sars.definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my.lib.serenity.primefaces.sars.steps.BassExportSteps;
import my.lib.serenity.primefaces.sars.steps.LoginSteps;
import net.thucydides.core.annotations.Steps;

/**
 * Created by ngoc on 21/09/2016.
 */
public class BassExportScenarioSteps {

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private BassExportSteps bassExportSteps;


    @Then("^In Bass export screen, System show button (.*)$")
    public void should_show_button(String buttonText) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.bassExportSteps.buttonIsVisible(buttonText);
    }


    @When("^In Bass export screen, I click button (.*)$")
    public void i_click_button_Export(String buttonText) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.bassExportSteps.clickButton(buttonText);
    }

    @Then("^System show table (.*) with 6 download link$")
    public void system_show_table_Files_Exported_with_download_link(String tableTitle) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.bassExportSteps.tableFileDownloadVisibleWithSixRows(tableTitle);
    }


    @Then("^System show downloaded location (.*) and can not edit$")
    public void system_show_downloaded_location_Download_location_and_can_not_edit(String downloadLocationText) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.bassExportSteps.downloadLocationVisible(downloadLocationText);
        this.bassExportSteps.inputTextCanNotEdit();

    }


    @And("^System show downloaded location (.*) and can edit$")
    public void systemShowDownloadedLocationLocationAndCanEdit(String downloadLocationText) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.bassExportSteps.downloadLocationVisible(downloadLocationText);
        this.bassExportSteps.inputTextCanEdit();
    }

    @And("^System hide button (.*)$")
    public void systemHideButtonEditBtn(String buttonText) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.bassExportSteps.buttonIsInvisible(buttonText);

    }

    @And("^I type (.*) in downloaded location$")
    public void iTypeTextTestValueInDownloadedLocationLocation(String textValue) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.bassExportSteps.typeTextInInputText(textValue);
    }

    @And("^I save path in download location to new variable$")
    public void iSavePathInDownloadLocationToNewVariable() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.bassExportSteps.savePathToNewVariable();
    }

    @And("^System show downloaded location with old path$")
    public void systemShowDownloadedLocationWithOldPath() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.bassExportSteps.comparePathAfterCancel();
    }

    @And("^System show downloaded location with new path (.*)$")
    public void systemShowDownloadedLocationWithNewPath(String newPath) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.bassExportSteps.comparePathAfterSave(newPath);
    }

    @Then("^System copy value in download location in clipboard$")
    public void systemCopyValueInDownloadLocationInClipboard() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.bassExportSteps.comparePathWithClipBoardAfterCopy();
    }


    @Then("^System show link can download$")
    public void systemShowLinkCanDownload() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.bassExportSteps.checkLinkDownloadApi();
    }

    @And("^I create all link download by API$")
    public void iGetAllLinkDownloadByAPI() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.bassExportSteps.createAllLinkDownloadApi();
    }
}

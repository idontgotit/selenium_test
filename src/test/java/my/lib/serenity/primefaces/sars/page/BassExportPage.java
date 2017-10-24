package my.lib.serenity.primefaces.sars.page;

import my.lib.serenity.primefaces.component.ButtonComponent;
import my.lib.serenity.primefaces.component.PanelGridComponent;
import my.lib.serenity.primefaces.component.factory.PFComponentFactory;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ngoc on 21/09/2016.
 */
public class BassExportPage extends AbstractPage {


    public int findByButtonText(String buttonText) {
        return this.findAll("//div[@id='contentPanel_content']//span[text()='" + buttonText + "']").size();

    }

    public void clickButton(String buttonText) {
        ButtonComponent buttonComponent = PFComponentFactory.wrapButton(this, this.findBy("//div[@id='contentPanel_content']//button/span[text()='"
                + buttonText + "']/parent::*"));
        buttonComponent.click_and_wait();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getPanelGridTitle() {
        PanelGridComponent panelGridComponent = PFComponentFactory.wrapPanelGrid(this, this.find(By.id("contentListDownloadForm:contentListDownloadPanel")));
        return panelGridComponent.getTitle();
    }

    public int getRowsOfPanelGrid() {
        PanelGridComponent panelGridComponent = PFComponentFactory.wrapPanelGrid(this, this.find(By.id("contentListDownloadForm:contentListDownloadPanel")));
        return panelGridComponent.getNumberOfContentRows();
    }

    public String getDownloadedLocationText() {
        return this.findBy("//div[@id='savingPathDiv']/span").getText();
    }

    public WebElementFacade getValueDownloadLocationElement() {
        return this.find(By.id("savingPathForm:inputSavingPath"));
    }

    public WebElementFacade getButtonElementByButtonText(String buttonText) {
        return this.findBy("//div[@id='contentPanel_content']//span[text()='" + buttonText + "']/parent::*");
    }

    public WebElementFacade getElementInputText() {
        return this.find(By.id("savingPathForm:inputSavingPath"));
    }

    public void savePathToNewVar() {
        this.evaluateJavascript("oldPath = '" + this.getElementInputText().getValue() + "'");
    }

    public boolean comparePathAfterCancel() {
        return this.getElementInputText().getValue().equalsIgnoreCase((String) this.evaluateJavascript("return oldPath"));
    }

    public boolean comparePathAfterSave(String newPath) {
        return this.getElementInputText().getValue().equalsIgnoreCase(newPath);
    }

    public String getPathInClipBoardO() {
        this.evaluateJavascript("x = document.createElement(\"INPUT\");");
        this.evaluateJavascript("x.setAttribute(\"type\", \"text\");");
        this.evaluateJavascript("x.setAttribute(\"id\",\"testPasteClipboard\");");
        this.evaluateJavascript("document.body.appendChild(x);");
        WebElementFacade elementFacade = this.find(By.id("testPasteClipboard"));
        elementFacade.sendKeys(Keys.CONTROL + "V");
        return elementFacade.getValue();
    }

    public void createAllLinkDownloadApi() {
        String nameProject = (String) this.evaluateJavascript("return  $('.param-project-hidden')[0].innerHTML;");
        String folderPathEncode = (String) this.evaluateJavascript("return $('.param-project-hidden')[1].innerHTML;");
        this.evaluateJavascript("linkDownload = $('.register-link');");
        ArrayList linkDownload = (ArrayList) this.evaluateJavascript("return $('.register-link');");
        for (int i = 0; i < linkDownload.size(); i++) {
//            this.evaluateJavascript("linkDownload" + i + " = location.origin + '/" + nameProject +
//                    "/rest/bass/download/' + '" + folderPathEncode + "' + '/' + linkDownload[" + i + "].innerHTML");

            this.evaluateJavascript("linkDownload" + i + " = location.origin + '" + nameProject +
                    "/rest/bass/download/' + '" + folderPathEncode + "' + '/' + linkDownload[" + i + "].innerHTML");
        }
    }

    public List<String> getAllLinkDownloadApi() {
        List<String> listDownload = new ArrayList<>();
        ArrayList linkDownload = (ArrayList) this.evaluateJavascript("return $('.register-link');");
        for (int i = 0; i < linkDownload.size(); i++) {
            listDownload.add((String) this.evaluateJavascript("return linkDownload" + i));
        }
        return listDownload;

    }
}

package my.lib.serenity.primefaces.sars.page;

import my.lib.serenity.primefaces.component.*;
import my.lib.serenity.primefaces.component.factory.PFComponentFactory;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by michael on 9/7/16.
 */
@DefaultUrl("https://192.168.1.4:8447/sars_it/index.xhtml")
public class TopPage extends AbstractPage {
    final static Map<String, String> mapLocaleAndName = new HashMap<>();
    final static Map<String, String> mapLocaleAndNotificationTitle = new HashMap<>();
    final static Map<String, String> mapLanguageAndNotificationTitle = new HashMap<>();

    static {
        mapLocaleAndName.put("en", "english");
        mapLocaleAndName.put("ja", "japan");
        mapLocaleAndNotificationTitle.put("en", "Notification");
        mapLocaleAndNotificationTitle.put("ja", "通知");
        mapLanguageAndNotificationTitle.put("english", "Notification");
        mapLanguageAndNotificationTitle.put("japan", "通知");
    }

    public void change_locale_and_wait(String locale) {
        this.profileBar.findBy("//li[contains(@class,'user-management')]").waitUntilPresent().waitUntilEnabled();
        Actions builder = new Actions(this.getDriver());
        builder.moveToElement(this.profileBar.findBy("//li[contains(@class,'user-management')]")).build().perform();

        CommandLinkComponent localeComp = PFComponentFactory.wrapCommandLink(this, By.id("menuForm:" + mapLocaleAndName.get(locale)));
        localeComp.click_and_wait();

        say_yes();

    }

    private void say_yes() {
        ConfirmDialogComponent confirmDialogComponent = PFComponentFactory.wrapConfirmDialog(this, "//div[contains(concat(@class,' '),'ui-confirm-dialog ') and @aria-hidden='false']");
        confirmDialogComponent.waitUntilVisible();
        confirmDialogComponent.click_yes();
    }

    public void should_changed_to_locale(String locale) {
        this.waitForTextToAppear(mapLocaleAndNotificationTitle.get(locale));
    }

    public void open_menu_by_name(String menuText) {
        MenuBarComponent leftMenu = PFComponentFactory.wrapMenuBar(this, By.xpath("//form[@id='menuForm']/div[@role='menubar']"));
        leftMenu.click_item_by_text(menuText);
    }

    public void should_open_screen(String menuText) {
//        PanelComponent panelComponent = PFComponentFactory.wrapPanel(this, By.id("contentPanel"));

//        Assertions.assertThat(panelComponent.getTitle()).isEqualToIgnoringCase(menuText);
        (new WebDriverWait(this.getDriver(), 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("*//label[@class='arrow-form-title']")));
        this.findBy("*//label[@class='arrow-form-title']").getText().equalsIgnoreCase(menuText);
    }

    public void change_language_and_wait(String lang) {
        MenuBarComponent profileBarMenu = PFComponentFactory.wrapMenuBar(this, By.id("profileBarForm:profileMenu"));
        profileBarMenu.click_item_by_index(2);

        CommandLinkComponent localeComp = PFComponentFactory.wrapCommandLink(this, By.id("profileBarForm:" + lang));
        localeComp.click_and_wait();
        this.say_yes();
    }

    public void should_changed_to_language(String lang) {
        this.waitForTextToAppear(mapLanguageAndNotificationTitle.get(lang));

    }

    public void open_submenu_of_parent_menu(String subMenuText, String parentMenuText) {
        findBy("//form[@id='menuForm']/div[@role='menubar']").waitUntilClickable();
        String parentMenuPath = "//form[@id='menuForm']/div[@role='menubar']/ul/li[.//span[text()='" + parentMenuText + "']]";
        Actions builder = new Actions(this.getDriver());
        builder.moveToElement(this.profileBar.findBy(parentMenuPath)).build().perform();

        String subMenuPath = parentMenuPath + "//a[.//span[text()='" + subMenuText + "']]";
        CommandLinkComponent subMenu = PFComponentFactory.wrapCommandLink(this, subMenuPath);
        subMenu.click_and_wait();
    }

    public boolean should_have_submenu_of_menu(String submenuText, String menuText) {
        MenuBarComponent leftMenu = PFComponentFactory.wrapMenuBar(this, By.xpath("//form[@id='menuForm']/div[@role='menubar']"));
        MenuBarItemComponent menuItem;
        if (StringUtils.isEmpty(menuText)) {
            menuItem = leftMenu.find_item_by_text(submenuText);
        } else {
            leftMenu.move_to_menu_item_by_text(menuText);
            menuItem = leftMenu.find_item_by_text(submenuText);
        }
        find(By.xpath("//*[@id='companyTradeMark']")).click();
        return menuItem != null;
    }

    public int get_number_of_action_menu() {
        MenuBarComponent leftMenu = PFComponentFactory.wrapMenuBar(this, By.xpath("//form[@id='menuForm']/div[@role='menubar']"));
        return leftMenu.get_number_of_action_menu();
    }

    public void search_value_by_menubar(String input) {
        try {
            InputTextComponent search = PFComponentFactory.wrapInputText(this, this.findBy("//input[@id='menuForm:quick_seacrh_input']"));
            search.type_and_enter(input);
        } catch (UnhandledAlertException e) {
            this.getDriver().switchTo().alert().accept();
            PanelComponent companyTradeMark = PFComponentFactory.wrapPanel(this, net.serenitybdd.core.annotations.findby.By.xpath("//div[@id='companyTradeMark']"));
            companyTradeMark.wait_for_ajax_done();
        }
    }

    public void close_screen() {
        PFComponentFactory.wrapCommandLink(this, By.xpath("//div[@id='contentPanel_header']/span/form/a")).click_and_wait();
    }
}

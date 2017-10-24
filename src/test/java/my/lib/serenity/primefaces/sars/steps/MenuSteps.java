package my.lib.serenity.primefaces.sars.steps;

import my.lib.serenity.primefaces.sars.page.TopPage;
import net.thucydides.core.steps.ScenarioSteps;
import org.fluentlenium.core.annotation.Page;

/**
 * Created by michael on 9/7/16.
 */
public class MenuSteps extends ScenarioSteps {
    @Page
    private TopPage topPage;


    public void open_menu_by_name(String menuText) {
        this.topPage.open_menu_by_name(menuText);
    }

    public void should_open_screen(String menuText) {
        this.topPage.should_open_screen(menuText);
    }

    public void should_logged_in() {
        this.topPage.should_loggged_in();
    }

    public void logout() {
        this.topPage.logout();
    }

    public void open_submenu_of_parent_menu(String subMenuText, String parentMenuText) {
        this.topPage.open_submenu_of_parent_menu(subMenuText, parentMenuText);
    }

    public void search_value_by_menubar(String input) {
        this.topPage.search_value_by_menubar(input);
    }

    public void close_screen() {
        this.topPage.close_screen();
    }
}

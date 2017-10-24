package my.lib.serenity.primefaces.sars.steps;

import my.lib.serenity.primefaces.sars.page.LoginPage;
import my.lib.serenity.primefaces.sars.page.TopPage;
import net.thucydides.core.steps.ScenarioSteps;
import org.assertj.core.api.Assertions;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.UnhandledAlertException;

/**
 * Created by michael on 9/6/16.
 */
public class LoginSteps extends ScenarioSteps {

    @Page
    private LoginPage loginPage;
    private TopPage topPage;

    public void open_page() {
        try {
            this.loginPage.open();
        } catch (UnhandledAlertException e) {
            this.getDriver().switchTo().alert().accept();
        }
    }

    public void should_login_success() {
        this.loginPage.should_login_success();
    }

    public void login(String username, String password) {
        this.loginPage.login(username, password);
    }

    public void should_see_error_message(String message) {
        Assertions.assertThat(this.loginPage.hasError()).isTrue();
        Assertions.assertThat(this.loginPage.getErrorMessage()).isEqualToIgnoringCase(message);
    }

    public void should_see_top_page() {
        this.loginPage.should_login_success();
    }

    public void change_locale(String locale) {
        this.topPage.change_locale_and_wait(locale);
    }

    public void should_change_to_locale(String locale) {
        this.topPage.should_changed_to_locale(locale);
    }

    public void should_show_submenu_of_menu(String submenu, String menu) {
        Assertions.assertThat(this.topPage.should_have_submenu_of_menu(submenu, menu)).isTrue();
    }

    public void should_show_only_menu_i_have_permission(int size) {
        Assertions.assertThat(this.topPage.get_number_of_action_menu() - 3).isEqualTo(size);
    }
}

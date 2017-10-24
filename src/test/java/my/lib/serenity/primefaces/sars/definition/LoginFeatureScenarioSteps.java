package my.lib.serenity.primefaces.sars.definition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my.lib.serenity.primefaces.sars.steps.LoginSteps;
import my.lib.serenity.primefaces.sars.steps.MenuSteps;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

public class LoginFeatureScenarioSteps {
    @Steps
    protected LoginSteps loginSteps;
    @Steps
    protected MenuSteps menuSteps;

    private Map<String, String> listMenu;

    @Given("I open Login page")
    public void given_I_open_login_page() {
        this.loginSteps.open_page();
    }

    @When("I input my credentials username (\\d+) and password (.*)")
    public void when_I_input_credentials(String username, String password) {
        this.loginSteps.login(username, password);
    }

    @Then("The system should let me in")
    public void then_system_should_let_me_in() {
        this.loginSteps.should_login_success();
    }

    @When("I change language to (.*)")
    public void when_I_change_language_to(String lang) {
        this.loginSteps.change_locale(lang);
    }

    @Then("The system should change all text to (.*)")
    public void then_system_should_change_texts_to_(String lang) {
        this.loginSteps.should_change_to_locale(lang);
    }

    @When("List menu I have permission")
    public void given_list_menu_i_have_permission(Map<String, String> listMenu) {
        this.listMenu = listMenu;
    }

    @Then("The system should show all menu I have permission")
    public void then_the_system_should_show_all_menu_i_have_permission() {
        for (Map.Entry entry : this.listMenu.entrySet()) {
            this.loginSteps.should_show_submenu_of_menu(entry.getKey().toString(), entry.getValue().toString());
        }
    }

    @Then("The system should show only menu I have permission")
    public void the_system_should_show_only_menu_i_have_permission() {
        this.loginSteps.should_show_only_menu_i_have_permission(this.listMenu.size());
    }


    @Given("I logout from system")
    public void given_i_logout_from_system() {
        this.menuSteps.logout();
    }

}

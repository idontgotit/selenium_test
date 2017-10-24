package my.lib.serenity.primefaces.sars.definition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my.lib.serenity.primefaces.sars.steps.MenuSteps;
import net.thucydides.core.annotations.Steps;

public class MenuFeatureScenarioSteps {
    @Steps
    private MenuSteps menuSteps;

    @When("I open menu '(.*)'")
    public void when_I_open_menu(String menuText) {
        this.menuSteps.open_menu_by_name(menuText);
    }

    @Then("The system should open '(.*)' page")
    public void then_system_should_open_page(String pageTitle) {
        this.menuSteps.should_open_screen(pageTitle);
    }

    @When("^I open submenu (.*) of parent menu (.*)$")
    public void i_open_submenu_of_parent_menu(String subMenuText, String parentMenuText) throws Throwable {
        this.menuSteps.open_submenu_of_parent_menu(subMenuText, parentMenuText);
    }

    @When(value = "I search value (.*) by menubar")
    public void when_i_search_value_by_menubar(String input) {
        this.menuSteps.search_value_by_menubar(input);
    }

    @When("^I close screen$")
    public void when_i_close_screen() {
        this.menuSteps.close_screen();
    }
}

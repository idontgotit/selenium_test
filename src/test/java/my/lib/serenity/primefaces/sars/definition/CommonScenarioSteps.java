package my.lib.serenity.primefaces.sars.definition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import my.lib.serenity.primefaces.sars.TestContext;
import my.lib.serenity.primefaces.sars.steps.LoginSteps;
import my.lib.serenity.primefaces.sars.steps.MenuSteps;
import net.thucydides.core.annotations.Steps;

/**
 * Created by michael on 29/09/2016.
 */
public class CommonScenarioSteps {
    @Steps
    protected LoginSteps loginSteps;
    @Steps
    protected MenuSteps menuSteps;

    @Before("@LoggedIn")
    public void beforeLoggedIn() {
        this.loginSteps.open_page();
        this.loginSteps.login(TestContext.get().getProp("username"), TestContext.get().getProp("password"));
        this.loginSteps.change_locale(TestContext.get().getProp("locale"));
    }

    @After("@LoggedIn")
    public void afterLoggedIn() {
        this.menuSteps.logout();
    }
}

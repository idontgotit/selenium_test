package my.lib.serenity.primefaces.sars.features.login;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/login/login_and_change_locale.feature",
        glue = {"my.lib.serenity.primefaces.sars.definition"})
public class LoginAnChangeLocaleFeature {

}

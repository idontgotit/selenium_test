package my.lib.serenity.primefaces.sars.features.menu;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/menu/verify_all_menus.feature"},
        glue = {"my.lib.serenity.primefaces.sars.definition"})
public class VerifyAllMenusFeature {

}

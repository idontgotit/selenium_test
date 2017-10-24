package my.lib.serenity.primefaces.sars.showcase.autocomplete;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by michael on 12/09/2016.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/autocomplete/autocomplete_showcase.feature",
        glue = {"my.lib.serenity.primefaces.showcases.definition"})
public class AutoCompleteFeature {
}

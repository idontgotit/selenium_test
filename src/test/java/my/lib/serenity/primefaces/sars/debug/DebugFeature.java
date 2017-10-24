package my.lib.serenity.primefaces.sars.debug;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by michael on 9/8/16.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/debug/debug.feature",
        glue = {"my.lib.serenity.primefaces.sars.definition"})
public class DebugFeature {
}

package my.lib.serenity.primefaces.sars.showcase.tabview;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by michael on 13/09/2016.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/tabview/tabview_showcase.feature",
        glue = {"my.lib.serenity.primefaces.showcases.definition"})
public class TabViewFeature {
}

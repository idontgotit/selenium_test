package my.lib.serenity.primefaces.sars.features.bassExport;


import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/bassExport/bass_export.feature",
        glue = {"my.lib.serenity.primefaces.sars.definition"})
public class BassExportFeature {

}

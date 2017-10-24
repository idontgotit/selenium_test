package my.lib.serenity.primefaces.sars.features.registerDailyReport;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by arrow on 14/10/16.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/registerDailyReport/registerDailyReport.feature",
        glue = {"my.lib.serenity.primefaces.sars.definition"})
public class RegisterDailyReportFeature {
}

package my.lib.serenity.primefaces.sars.features.searchDailyReportByDate;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by arrow on 11/10/16.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/searchDailyReportByDate/searchDailyReportByDate.feature",
        glue = {"my.lib.serenity.primefaces.sars.definition"})
public class SearchDailyReportByDateFeature {
}

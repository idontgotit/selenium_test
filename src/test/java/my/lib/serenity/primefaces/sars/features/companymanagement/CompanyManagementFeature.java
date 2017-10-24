package my.lib.serenity.primefaces.sars.features.companymanagement;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by arrow on 26/9/16.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/companyManagement/companyManagement.feature",
        glue = {"my.lib.serenity.primefaces.sars.definition"})
public class CompanyManagementFeature {
}

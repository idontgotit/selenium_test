package my.lib.serenity.primefaces.sars.features.creditManagement;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by arrow on 22/9/16.
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/creditManagement/credit_management_add_edit.feature",
        glue = {"my.lib.serenity.primefaces.sars.definition"})
public class CreditManagementAddEditFeature {
}
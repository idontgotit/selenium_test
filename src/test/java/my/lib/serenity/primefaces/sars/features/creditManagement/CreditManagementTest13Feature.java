

package my.lib.serenity.primefaces.sars.features.creditManagement;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by arrow on 22/9/16.
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/creditManagement/creadit_management_test13_company_and_credit_data.feature",
        glue = {"my.lib.serenity.primefaces.sars.definition"})
public class CreditManagementTest13Feature {
}

package my.lib.serenity.primefaces.sars.features.employee_management;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by ngoc on 27/09/2016.
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/employee_management/employee_management.feature",
        glue = {"my.lib.serenity.primefaces.sars.definition"})
public class EmployeeManagementFeature {

}
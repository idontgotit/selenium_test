package my.lib.serenity.primefaces.sars.features.viewNotifications;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by arrow on 13/10/16.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/viewNotifications/viewNotifications.feature",
        glue = {"my.lib.serenity.primefaces.sars.definition"})
public class ViewNotificationsFeature {
}

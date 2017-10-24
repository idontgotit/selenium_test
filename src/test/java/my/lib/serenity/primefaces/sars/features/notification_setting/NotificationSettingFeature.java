package my.lib.serenity.primefaces.sars.features.notification_setting;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by ngoc on 11/10/2016.
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/notification_setting/notification_setting.feature",
        glue = {"my.lib.serenity.primefaces.sars.definition"})
public class NotificationSettingFeature {

}
package my.lib.serenity.primefaces.sars.showcase.calendar;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by michael on 9/8/16.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/calendar/calendar_showcase.feature",
        glue = {"my.lib.serenity.primefaces.showcases.definition"})
public class CalendarFeature {
}

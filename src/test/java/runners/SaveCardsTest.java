package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
        plugin = {"pretty","html:reports/cucumber/SaveCardsTest"},
        strict = true,
        features = {"src/test/resources/features/Save cards.feature"},
        glue = {"stepdefs"},
        monochrome=true
        )



@Test
public class SaveCardsTest extends AbstractTestNGCucumberTests{
}

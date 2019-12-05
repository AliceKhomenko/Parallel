package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
        plugin = {"pretty","html:reports/cucumber/CardInfoTest"},
        strict = true,
        features = {"src/test/resources/features/Card info.feature"},
        glue = {"stepdefs"},
        monochrome=true
        )



@Test
public class CardInfoTest extends AbstractTestNGCucumberTests{
}

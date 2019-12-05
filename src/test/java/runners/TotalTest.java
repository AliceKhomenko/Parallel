package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
        plugin = {"pretty","html:reports/cucumber/TotalTest"},
        strict = true,
        features = {"src/test/resources/features/"},
        glue = {"stepdefs"},
        monochrome=true
        )



@Test
public class TotalTest extends AbstractTestNGCucumberTests{
}

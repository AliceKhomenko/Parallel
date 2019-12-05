package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
        plugin = {"pretty","html:reports/cucumber/ProfilePageTest"},
        strict = true,
        features = {"src/test/resources/features/Profile page.feature"},
        glue = {"stepdefs"},
        monochrome=true
        )



@Test
public class ProfilePageTest extends AbstractTestNGCucumberTests{
}

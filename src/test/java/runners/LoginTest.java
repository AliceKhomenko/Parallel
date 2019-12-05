package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
        plugin = {"pretty","html:reports/cucumber/LoginTest"},
        strict = true,
        features = {"src/test/resources/features/Login.feature"},
        glue = {"stepdefs"},
        monochrome=true
        )



@Test
public class LoginTest extends AbstractTestNGCucumberTests{
}

package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
        plugin = {"pretty","html:reports/cucumber/MainPageTest"},
        strict = true,
        features = {"src/test/resources/features/MainPage.feature"},
        glue = {"stepdefs"},
        monochrome=true
        )



@Test
public class MainPageTest extends AbstractTestNGCucumberTests{
}

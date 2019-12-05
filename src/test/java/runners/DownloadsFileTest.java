package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
        plugin = {"pretty","html:reports/cucumber/DownloadsFileTest"},
        strict = true,
        features = {"src/test/resources/features/Download files.feature"},
        glue = {"stepdefs"},
        monochrome=true
        )



@Test
public class DownloadsFileTest extends AbstractTestNGCucumberTests{
}

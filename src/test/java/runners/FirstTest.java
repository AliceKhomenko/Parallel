package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
        plugin = {"pretty","json:target/report/cucumber2.json"},
        strict = true,
        features = {"src/test/resources/features/"},
        glue = {"stepdefs"},
        monochrome=true
        ,tags={"@test"}

        )



@Test
public class FirstTest extends AbstractTestNGCucumberTests{
}

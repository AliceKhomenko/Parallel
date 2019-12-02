package stepdefs;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.util.Date;

import static com.codeborne.selenide.Selenide.screenshot;


public class Hooks {

    Scenario scenario;
    String scenarioName;
    String featureName;

    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
        scenarioName = Preparing.getScenarioName(scenario);
        featureName = Preparing.getFeatureName(scenario);

    }


    @After
    public void close() {
        if (scenario.isFailed()) {
            Date date = new Date();

            String filepath="build/screenshots/"+featureName+"/"+scenarioName+(String.valueOf(date.getTime()));
            screenshot(filepath);

        }
        WebDriverRunner.getWebDriver().quit();
    }

}

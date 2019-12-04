package stepdefs;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.Preparing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.screenshot;


public class Hooks {

    String scenarioName;
    String featureName;


    @Before
    public void setUp(Scenario scenario) {
        TestContext.clearTestVariables();
        Configuration.screenshots = false;
        Configuration.savePageSource=false;

        featureName = Preparing.getFeatureName(scenario);

        Configuration.reportsFolder = "test-result/reports/" + featureName;

    }


    @After
    public void close(Scenario scenario) {

        Date date = new Date();
        if(TestContext.getSize()>0)
        scenario.write("Using variables in scenario:"+TestContext.printSharedVariables());
        scenarioName = Preparing.getScenarioName(scenario);
        String fileName = scenarioName + (String.valueOf(date.getTime()));
        screenshot(fileName);
        String filepath = "test-result/reports/" + featureName + File.separator + fileName + ".png";
        try {
            scenario.embed(Files.readAllBytes(Paths.get(filepath)), "image/png");
        } catch (IOException e) {
            e.printStackTrace();
        }

        WebDriverRunner.getWebDriver().quit();
    }

}

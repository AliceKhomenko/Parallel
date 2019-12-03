package stepdefs;

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
        System.out.println(featureName);
        System.out.println(scenarioName);

    }


    @After
    public void close() {
        if (scenario.isFailed()) {
            Date date = new Date();

            String filepath="build/screenshots/"+featureName+"/"+scenarioName+(String.valueOf(date.getTime()));
            screenshot(filepath);
           // File screen = new File(filepath+".png");
            try {
                scenario.embed(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+filepath+".png")),"image/png");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        WebDriverRunner.getWebDriver().quit();
    }

}

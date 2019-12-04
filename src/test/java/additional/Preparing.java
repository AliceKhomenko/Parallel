package additional;

import cucumber.api.Scenario;

import java.io.File;

public class Preparing {
    static String featureName;
    static String scenarioName;

    public static String getFeatureName(Scenario scenario) {
        featureName = scenario.getUri()
                .replaceAll("src/test/resources/features/", "")
                .replaceAll(".feature", "")
                .replaceAll(" ","");
        return featureName;
    }

    public static String getScenarioName(Scenario scenario) {
        scenarioName = scenario.getName().replaceAll(" ","");
        return scenarioName;
    }
}

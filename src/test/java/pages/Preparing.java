package pages;

import cucumber.api.Scenario;

import java.io.File;

public class Preparing {
    static String featureName;
    static String scenarioName;

    public static String getFeatureName(Scenario scenario) {
        featureName = scenario.getUri()
                .replaceAll("src/test/resources/features/", "")
                .replaceAll(".feature", "");
        return featureName;
    }

    public static String getScenarioName(Scenario scenario) {
        scenarioName = scenario.getName();
        return scenarioName;
    }

    public static void deleteOldScreenshots() {
        try {

            File featureDirectory = new File("build/screenshots/" + featureName + "/");
            if (featureDirectory.exists()) {

                for (File f : featureDirectory.listFiles()) {
                    if (f.getName().startsWith(scenarioName))
                        f.delete();

                }
                if (featureDirectory.listFiles().length == 0)
                    featureDirectory.delete();
            }
        } catch (Exception e) {
            System.out.println("can't delete old screenshots");
        }
    }
}

package additional;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.util.HashMap;

public class DriversConfiguration {

    public static ChromeOptions configureChromeDownloadPath() {

        osDetector();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "build" + File.separator + "downloads" + File.separator);
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.directory_upgrade", true);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        return options;
    }

    public static FirefoxOptions configureFirefoxDownloadSettings() {

        osDetector();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", System.getProperty("user.dir") + File.separator + "externalFiles"
                + File.separator + "downloadFiles" + File.separator);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "text/csv,application/java-archive, application/x-msexcel,application/excel,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/vnd.microsoft.portable-executable");
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        return options;
    }

    public static void osDetector() {

            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                System.setProperty("webdriver.gecko.driver", "drivers/Firefox/geckodriver.exe");
                System.setProperty("webdriver.chrome.driver", "drivers/Chrome/chromedriver.exe");
            } else if (os.contains("nux") || os.contains("nix") || (os.contains("centos")) || (os.contains("ubuntu"))) {
                System.setProperty("webdriver.gecko.driver", "drivers/Firefox/linux_geckodriver");
                System.setProperty("webdriver.chrome.driver", "drivers/Chrome/linux_chromedriver");

            } else if(os.contains("mac")){
                System.setProperty("webdriver.gecko.driver", "drivers/Firefox/mac_geckodriver");
                System.setProperty("webdriver.chrome.driver", "drivers/Chrome/mac_chromedriver");


            }


    }
}

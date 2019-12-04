package stepdefs;

import additional.DriversConfiguration;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.Cookie;
import additional.LoadProperties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

/**
 * Created by khomenkoalina on 03.12.19.
 */
public class BrowserStepDefs {

    Properties properties = LoadProperties.init();
    String url = properties.getProperty("url");


    @Given("^site is opened$")
    public void siteIsOpened() {
        Configuration.startMaximized = true;
        Configuration.timeout = Integer.parseInt(properties.getProperty("timeout.in.seconds")) * 1000;
        open(url);
    }

    @And("^user is already logged in$")
    public void userIsAlreadyLoggedIn() {
        Cookie cookies = new Cookie("secret", properties.getProperty("authorized.cookie"));
        WebDriverRunner.getWebDriver().manage().addCookie(cookies);
        refresh();
    }


    @Given("^custom browser is configured$")
    public void customBrowserIsConfigured() throws Throwable {
        if (WebDriverRunner.isChrome()) {
            WebDriverRunner.setWebDriver(new ChromeDriver(DriversConfiguration.configureChromeDownloadPath()));
        } else
        //if (WebDriverRunner.isFirefox()) { WebDriverRunner.setWebDriver(new FirefoxDriver(DriversConfiguration.configureFirefoxDownloadSettings()));
        {
            open("https://files.everypony.ru/gallery/season-9/sad_twilight_by_ironm17_dbj1rqh-pre.png");
            Assert.fail("Sorry, but my hands aren't from shoulders and I can't configure Firefox to download files to project directory ");
        }
    }
}

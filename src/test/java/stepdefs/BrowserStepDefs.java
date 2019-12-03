package stepdefs;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.Cookie;
import pages.LoadProperties;

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
}

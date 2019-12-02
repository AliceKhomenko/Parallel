package stepdefs;

import com.codeborne.selenide.*;
import com.codeborne.selenide.webdriver.WebDriverFactory;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import pages.LoadProperties;
import pages.LoginPage;
import pages.MainPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static com.codeborne.selenide.Selenide.*;

public class LoginPageStepDefs {
    LoginPage loginPage;
    Properties properties = new LoadProperties().init();
    String url = properties.getProperty("url");


    @Given("^site is opened$")
    public void siteIsOpened() {
        Configuration.startMaximized = true;
        Configuration.timeout = Integer.parseInt(properties.getProperty("timeout.in.seconds")) * 1000;

        open(url);

    }

    @When("^user inputs ([^\"]*) login$")
    public void userInputsCorrectLogin(String loginType) {
        loginPage = page(LoginPage.class);
        loginPage.inputLogin(loginType);

    }

    @And("^user inputs ([^\"]*) password$")
    public void userInputsCorrectPassword(String pass) {
        loginPage.inputPassword(pass);
    }

    @And("^user clicks Login button$")
    public void userClicksLoginButton() {
        loginPage.moveCursorToButton();
        loginPage.clickSighInButton();
    }

    @Then("^main page is opened$")
    public void mainPageIsOpened() {
        MainPage mainPage = page(MainPage.class);
        mainPage.waitForPageLoad();
    }


    @And("^login page is shown$")
    public void loginPageIsShown() {
        loginPage.isShown();
    }

    @And("^user is already logged in$")
    public void userIsAlreadyLoggedIn() {
        Cookie cookies = new Cookie("secret", properties.getProperty("authorized.cookie"));
        WebDriverRunner.getWebDriver().manage().addCookie(cookies);
        refresh();


    }

    @And("^user accepts [0-9.][a-z.]+ alert$")
    public void userAcceptsStAlert() throws Throwable {
        Selenide.switchTo().alert().accept();


    }

    @And("^user is authorized$")
    public void userIsAuthorized() throws Throwable {
        userInputsCorrectLogin("correct");
        userInputsCorrectPassword("correct");
        userClicksLoginButton();
        userAcceptsStAlert();
        userAcceptsStAlert();
    }


    @And("^user dismissed [0-9.][a-z.]+ alert$")
    public void userDismissedStAlert() throws Throwable {
        Selenide.switchTo().alert().dismiss();

    }


    @Then("^login page is opened$")
    public void loginPageIsOpened() throws Throwable {
        loginPageIsShown();
    }

    @Then("^main page isn't opened$")
    public void mainPageIsnTOpened() throws Throwable {
        try {
            loginPage.loginForm.waitUntil(Condition.disappear, 5000);
        } catch (AssertionError error) {
        }
    }

    @When("^user inputs <login> login$")
    public void userInputsLogin() throws Throwable {

    }

    public FirefoxOptions configureFirefoxDownloadSettings() {

        System.setProperty("webdriver.gecko.driver", "drivers/Firefox/geckodriver");

        FirefoxProfile profile = new FirefoxProfile();

        profile.setPreference("browser.download.folderList", 2);

        // Setting custom download directory
        profile.setPreference("browser.download.dir", System.getProperty("user.dir") + File.separator + "externalFiles"
                + File.separator + "downloadFiles" + File.separator);

        // Skipping Save As dialog box for types of files with their MIME
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "text/csv,application/java-archive, application/x-msexcel,application/excel,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/vnd.microsoft.portable-executable");

        // Creating FirefoxOptions to set profile
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        // Launching browser with desired capabilities
        return options;
    }

    public ChromeOptions configureChromeDownloadPath() {

        DesiredCapabilities cap = DesiredCapabilities.chrome();

        System.setProperty("webdriver.chrome.driver", "drivers/Chrome/chromedriver");
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "build" + File.separator + "downloads" + File.separator);
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.directory_upgrade", true);
        System.out.println(chromePrefs);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs).merge(cap);
        System.out.println(options);


        cap.setCapability(ChromeOptions.CAPABILITY, options);
        System.out.println(cap);
        //  cap.setCapability("download.default_directory", System.getProperty("user.dir") + File.separator + "build"+File.separator+"downloads"+File.separator);
        //  cap.setCapability("profile.default_content_settings.popups", 0);
        //  cap.setCapability("download.directory_upgrade", true);

        //   Configuration.browserCapabilities=cap;

        return options;
    }

    @When("^user clicks login field$")
    public void userClicksLoginField() throws Throwable {
        loginPage.clickLoginFiled();
    }

    @And("^user clicks password field$")
    public void userClicksPasswordField() throws Throwable {
        loginPage.clickPasswordField();
    }

    @Then("^howerMeFaster button is disabled$")
    public void tratataButtonIsDisabled() throws Throwable {
        loginPage.checkhowerMeFasterButton();
    }


    @Given("^custom browser is configured$")
    public void customBrowserIsConfigured() throws Throwable {
        if (WebDriverRunner.isChrome()) {
            WebDriverRunner.setWebDriver(new ChromeDriver(configureChromeDownloadPath()));
        }
        if (WebDriverRunner.isFirefox()) {
            WebDriverRunner.setWebDriver(new FirefoxDriver(configureFirefoxDownloadSettings()));

        }
    }
}

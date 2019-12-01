package stepdefs;

import com.codeborne.selenide.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import pages.LoginPage;
import pages.MainPage;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class MyStepdefs {
    LoginPage loginPage;
        @Given("^browser is opened$")
        public void openBrowser(){

            Configuration.timeout=20000;
            Configuration.fileDownload= FileDownloadMode.PROXY;
            Configuration.proxyEnabled=true;

        }


    @And("^site is opened$")
    public void siteIsOpened() {
        Configuration.timeout=20000;
        Configuration.fileDownload= FileDownloadMode.PROXY;
        Configuration.proxyEnabled=true;
        open("http://192.168.99.100:8080/");

    }

    @When("^user inputs correct login$")
    public void userInputsCorrectLogin() {
        loginPage = page(LoginPage.class);
        loginPage.inputLogin("test");
    }

    @And("^user inputs correct password$")
    public void userInputsCorrectPassword() {
       loginPage.inputPassword("test");
    }

    @And("^user clicks Login button$")
    public void userClicksLoginButton(){
        loginPage.moveCursorToButton();
        loginPage.clickSighInButton();
    }

    @Then("^main page is opened$")
    public void mainPageIsOpened(){MainPage mainPage = page(MainPage.class);
    mainPage.waitForPageLoad();}



    @And("^login page is shown$")
    public void loginPageIsShown() {
        loginPage.isShown();
    }

    @And("^user is already logged in$")
    public void userIsAlreadyLoggedIn() {
        Cookie cookies = new Cookie("secret","IAmSuperSeleniumMaster");
        WebDriverRunner.getWebDriver().manage().addCookie(cookies);
        refresh();



    }

    @And("^user accepts [0-9.][a-z.]+ alert$")
    public void userAcceptsStAlert() throws Throwable {
        Selenide.switchTo().alert().accept();


    }
    @And("^user is authorized$")
    public void userIsAuthorized() throws Throwable {
        userInputsCorrectLogin();
        userInputsCorrectPassword();
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
       }catch(AssertionError error){
       }
       }

    @When("^user inputs <login> login$")
    public void userInputsLoginLogin() throws Throwable {

    }
}

package stepdefs;

import com.codeborne.selenide.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.testng.Assert;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.*;

public class LoginPageStepDefs {
    LoginPage loginPage = page(LoginPage.class);

    @When("^user inputs ([^\"]*) login$")
    public void userInputsCorrectLogin(String loginType) {
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

    @And("^login page is shown$")
    public void loginPageIsShown() {
        loginPage.isShown();
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
        boolean isShown = true;
        try {
            loginPage.loginForm.waitUntil(Condition.disappear, 1000);
        } catch (AssertionError error) {
            isShown = false;
        }
        Assert.assertTrue(true);
    }

    @When("^user clicks login field$")
    public void userClicksLoginField() throws Throwable {
        loginPage = page(LoginPage.class);
        loginPage.clickLoginFiled();
    }

    @And("^user clicks password field$")
    public void userClicksPasswordField() throws Throwable {
        loginPage = page(LoginPage.class);
        loginPage.clickPasswordField();
    }

    @Then("^howerMeFaster button is disabled$")
    public void tratataButtonIsDisabled() throws Throwable {
        loginPage = page(LoginPage.class);
        loginPage.checkhowerMeFasterButton();
    }

}

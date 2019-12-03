package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ProfilePage;
import sun.java2d.cmm.Profile;

import static com.codeborne.selenide.Selenide.page;

public class ProfileStepDefs {
ProfilePage profilePage = page(ProfilePage.class);



    @And("^user inputs \"([^\"]*)\" in first name field$")
    public void userInputsInFirstNameField(String arg0) throws Throwable {
        profilePage.inputFirstName(arg0);
    }

    @And("^user inputs \"([^\"]*)\" in last name field$")
    public void userInputsInLastNameField(String arg0) throws Throwable {
        profilePage.inputLastName(arg0);
    }

    @And("^user clicks Save user info button$")
    public void userClicksSaveUserInfoButton() throws Throwable {
       profilePage.clickSaveUserInfo();
    }

    @Then("^successful alert is shown$")
    public void successfulAlertIsShown() throws Throwable {
       profilePage.successfullAlertIsShown();
    }

    @When("^user clicks Payment Info$")
    public void userClicksPaymentInfo() throws Throwable {
        profilePage.clickPaymentSettingsButton();
    }

    @And("^user inputs \"([^\"]*)\" card number$")
    public void userInputsCardNumber(String arg0) throws Throwable {
        profilePage.inputCardNumber(arg0);
    }

    @And("^user selects \"([^\"]*)\" Payment system$")
    public void userSelectsPaymentSystem(String arg0) throws Throwable {
       profilePage.selectPaymentSystem(arg0);
    }

    @And("^user clicks Save Payment Info$")
    public void userClicksSavePaymentInfo() throws Throwable {
       profilePage.clickSavePaymentInfo();
    }

    @Then("^succesful payment info saved alert is shown$")
    public void succesfulPaymentInfoSavedAlertIsShown() throws Throwable {
        profilePage.successfulPaymentInfoSavedIsShown();
    }

    @And("^user inputs ([^\"]*) day of payment$")
    public void userInputsDayOfPayment(String arg0) throws Throwable {
       profilePage.inputDayOfPayment(arg0);
    }
}

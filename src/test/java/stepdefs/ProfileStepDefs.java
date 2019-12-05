package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ProfilePage;

import static com.codeborne.selenide.Selenide.page;

public class ProfileStepDefs {
ProfilePage profilePage = page(ProfilePage.class);


    @And("^user inputs \"([^\"]*)\" in first name field$")
    public void userInputsInFirstNameField(String arg0){
        profilePage.inputFirstName(arg0);
    }

    @And("^user inputs \"([^\"]*)\" in last name field$")
    public void userInputsInLastNameField(String arg0){
        profilePage.inputLastName(arg0);
    }

    @And("^user clicks Save user info button$")
    public void userClicksSaveUserInfoButton(){
        profilePage.clickSaveUserInfo();
    }

    @Then("^successful alert is shown$")
    public void successfulAlertIsShown(){
       profilePage.successfullAlertIsShown();
    }

    @When("^user clicks Payment Info$")
    public void userClicksPaymentInfo(){
        profilePage.clickPaymentSettingsButton();
    }

    @And("^user inputs \"([^\"]*)\" card number$")
    public void userInputsCardNumber(String arg0){
        profilePage.inputCardNumber(arg0);
    }

    @And("^user selects \"([^\"]*)\" Payment system$")
    public void userSelectsPaymentSystem(String arg0){
       profilePage.selectPaymentSystem(arg0);
    }

    @And("^user clicks Save Payment Info$")
    public void userClicksSavePaymentInfo(){
       profilePage.clickSavePaymentInfo();
    }

    @Then("^successful payment info saved alert is shown$")
    public void successfulPaymentInfoSavedAlertIsShown(){
        profilePage.successfulPaymentInfoSavedIsShown();
    }

    @And("^user inputs (\\d+) day of payment$")
    public void userInputsDayOfPayment(int arg0){
       profilePage.inputDayOfPayment(arg0);
    }

    @Then("^validation message \"([^\"]*)\" is shown$")
    public void validationMessageIsShown(String arg0){
        profilePage.validationMessageIsShown(arg0);
    }


}

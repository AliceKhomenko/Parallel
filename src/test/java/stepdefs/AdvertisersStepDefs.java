package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.MainPage;
import pages.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.screenshot;

public class AdvertisersStepDefs {
    MainPage mainPage= page(MainPage.class);;
    @When("^user clicks Advertiser block$")
    public void userClicksAdvertiserBlock() {
        mainPage.waitForPageLoad();
        mainPage.clickAdverisers();
    }

    @Then("^Advertisers list is shown$")
    public void advertisersListIsShown() {
        List<String> advertisersList = Arrays.asList("Test Advertiser","Adidas");

        Assert.assertEquals(advertisersList,mainPage.advertisersNames());
        mainPage.advertisers.first().click();
           Card card = page(Card.class);
           card.changeScale(100);
           card.changeScale(-100);
           card.downloadFile();

    }

    @When("^user clicks Publishers block$")
    public void userClicksPublishersBlock() throws Throwable {
        mainPage.waitForPageLoad();
        mainPage.clickPublishers();
    }

    @Then("^Publishers list is shown$")
    public void publishersListIsShown() throws Throwable {
        List<String> publishersList = Arrays.asList("Test Advertiser","Adidas");

        Assert.assertEquals(publishersList,mainPage.advertisersNames());
    }

    @When("^user clicks Top level clients block$")
    public void userClicksTopLevelClientsBlock() throws Throwable {
        mainPage.waitForPageLoad();
        mainPage.clickTopLevelClients();
    }

    @Then("^Top level clients list is shown$")
    public void topLevelClientsListIsShown() throws Throwable {
        List<String> clientsList = Arrays.asList("Test Advertiser","Adidas");

        Assert.assertEquals(clientsList,mainPage.advertisersNames());
    }

    @When("^user double clicks Advertiser block$")
    public void userDoubleClicksAdvertiserBlock() throws Throwable {
        userClicksAdvertiserBlock();
        userClicksAdvertiserBlock();
    }
}

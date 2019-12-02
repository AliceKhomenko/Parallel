package stepdefs;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import pages.MainPage;
import pages.Card;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.screenshot;

public class MainPageStepDefs {
    MainPage mainPage = page(MainPage.class);
    Card card = page(Card.class);

    @When("^user clicks Advertiser block$")
    public void userClicksAdvertiserBlock() {
        mainPage.waitForPageLoad();
        mainPage.clickAdverisers();
    }

    @Then("^Advertisers list is shown$")
    public void advertisersListIsShown() {
        List<String>expectedList = mainPage.getExpectedAdvertiserList();
        Assert.assertEquals(expectedList, mainPage.advertisersNames());

        // card.changeScale(100);
        // card.changeScale(-100);

    }

    @When("^user clicks Publishers block$")
    public void userClicksPublishersBlock() throws Throwable {
        mainPage.waitForPageLoad();
        mainPage.clickPublishers();
    }

    @Then("^Publishers list is shown$")
    public void publishersListIsShown() throws Throwable {
        List<String>expectedList = mainPage.getExpectedPublisherList();
        Assert.assertEquals(expectedList, mainPage.publishersNames());

    }

    @When("^user clicks Top level clients block$")
    public void userClicksTopLevelClientsBlock() throws Throwable {
        mainPage.waitForPageLoad();
        mainPage.clickTopLevelClients();
    }

    @Then("^Top level clients list is shown$")
    public void topLevelClientsListIsShown() throws Throwable {
        List<String>expectedList = mainPage.getExpectedTopLevelClientsList();

        Assert.assertEquals(expectedList, mainPage.topLevelClientNames());
    }

    @When("^user double clicks Advertiser block$")
    public void userDoubleClicksAdvertiserBlock() throws Throwable {
        userClicksAdvertiserBlock();
        userClicksAdvertiserBlock();
    }

    @And("^user clicks \"([^\"]*)\" Advertiser$")
    public void userClicksAdvertiser(String adver) throws Throwable {
        mainPage.findAdvertiser(adver).click();

    }

    @And("^user downloads file$")
    public void userDownloadsFile() throws Throwable {
        card.downloadFile();


    }

    @Then("^download file and text on the site is equal$")
    public void downloadFileAndTextOnTheSiteIsEqual() {
        String path = System.getProperty("user.dir") + File.separator + "build" + File.separator + "downloads" + File.separator + "data.txt";
        System.out.println(path);
        String file = card.readFile(path);

        Assert.assertEquals(file, card.cardText.getText().replaceAll("\n", ""));
    }

    @And("^user clicks \"([^\"]*)\" Publisher$")
    public void userClicksPublisher(String pub) throws Throwable {
        mainPage.findPublisher(pub).click();

    }

    @And("^user clicks \"([^\"]*)\" Client$")
    public void userClicksClient(String client) throws Throwable {
        mainPage.findTopLevelClient(client).click();
    }

    @When("^user double clicks Publishers block$")
    public void userDoubleClicksPublishersBlock() throws Throwable {
        userClicksPublishersBlock();
        userClicksPublishersBlock();
    }

    @When("^user double clicks Top level clients block$")
    public void userDoubleClicksTopLevelClientsBlock() throws Throwable {
        userClicksTopLevelClientsBlock();
        userClicksTopLevelClientsBlock();
    }

    @And("^Top level clients is added to cookies$")
    public void topLevelClientsIsAddedToCookies() throws Throwable {
        Set<Cookie> cookie = WebDriverRunner.getWebDriver().manage().getCookies();
        System.out.println(cookie);
    }



    @Then("^Advertisers list isn't shown$")
    public void advertisersListIsnTShown() throws Throwable {
        mainPage.waitUntilSubTreeBlockIsHidden("Advetisers");

    }

    @And("^\"([^\"]*)\" is added to cookies$")
    public void isAddedToCookies(String value) throws Throwable {
        Assert.assertTrue(mainPage.checkCookie("notSavedOpened",value));

    }

    @And("^\"([^\"]*)\" isn't existed in cookie$")
    public void isnTExistedInCookie(String value) throws Throwable {
        Assert.assertFalse(mainPage.checkCookie("notSavedOpened",value));


    }

    @Then("^Publishers list isn't shown$")
    public void publishersListIsnTShown() throws Throwable {
        mainPage.waitUntilSubTreeBlockIsHidden("Publishers");

    }

    @Then("^top level clients list isn't shown$")
    public void topLevelClientsListIsnTShown() throws Throwable {
        mainPage.waitUntilSubTreeBlockIsHidden("Top level clients");
    }
}

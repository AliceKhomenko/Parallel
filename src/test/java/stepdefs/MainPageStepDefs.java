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
import pages.FileReader;
import pages.MainPage;
import pages.Card;

import java.io.File;

import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Selenide.page;

public class MainPageStepDefs {
    MainPage mainPage = page(MainPage.class);
    Card card = page(Card.class);


    @Then("^main page is opened$")
    public void mainPageIsOpened() {
        mainPage.waitForPageLoad();
    }

    @When("^user clicks Advertiser block$")
    public void userClicksAdvertiserBlock() {
        mainPage.waitForPageLoad();
        mainPage.clickAdverisers();
    }

    @Then("^Advertisers list is shown$")
    public void advertisersListIsShown() {
        List<String> expectedList = mainPage.getExpectedAdvertiserList();
        Assert.assertEquals(expectedList, mainPage.textInElements(mainPage.advertisers));

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
        List<String> expectedList = mainPage.getExpectedPublisherList();
        Assert.assertEquals(expectedList, mainPage.textInElements(mainPage.publishers));

    }

    @When("^user clicks Top level clients block$")
    public void userClicksTopLevelClientsBlock() throws Throwable {
        mainPage.waitForPageLoad();
        mainPage.clickTopLevelClients();
    }

    @Then("^Top level clients list is shown$")
    public void topLevelClientsListIsShown() throws Throwable {
        List<String> expectedList = mainPage.getExpectedTopLevelClientsList();
        Assert.assertEquals(expectedList, mainPage.textInElements(mainPage.topLevelClients));
    }

    @When("^user double clicks Advertiser block$")
    public void userDoubleClicksAdvertiserBlock() throws Throwable {
        mainPage.doubleClickOnAdvertiserButton();
    }

    @And("^user clicks \"([^\"]*)\" Advertiser$")
    public void userClicksAdvertiser(String adver) throws Throwable {
        mainPage.findAdvertiser(adver).click();
        card.waitForPageLoad();
    }

    @And("^user downloads file$")
    public void userDownloadsFile() throws Throwable {
        card.downloadFile();
    }

    @Then("^download file and text on the site is equal$")
    public void downloadFileAndTextOnTheSiteIsEqual() {
        String path = File.separator + "build" + File.separator + "downloads" + File.separator + "data.txt";
        String file = FileReader.readFile(path);
        card.deleteFile(path);
        Assert.assertEquals(file, card.cardText.getText().replaceAll("\n", ""));
    }

    @And("^user clicks \"([^\"]*)\" Publisher$")
    public void userClicksPublisher(String pub) throws Throwable {
        mainPage.findPublisher(pub).click();
        card.waitForPageLoad();
    }

    @And("^user clicks \"([^\"]*)\" Client$")
    public void userClicksClient(String client) throws Throwable {
        mainPage.findTopLevelClient(client).click();
        card.waitForPageLoad();
    }

    @When("^user double clicks Publishers block$")
    public void userDoubleClicksPublishersBlock() throws Throwable {
        mainPage.doubleClickOnPublisherButton();
    }

    @When("^user double clicks Top level clients block$")
    public void userDoubleClicksTopLevelClientsBlock() throws Throwable {
        mainPage.doubleClickOnTopLevelClientButton();
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

    @And("^\"([^\"]*)\" is added to cookie \"([^\"]*)\"$")
    public void isAddedToCookies(String value,String cookie) throws Throwable {
        Assert.assertTrue(mainPage.checkCookie(cookie, value));
    }

    @And("^\"([^\"]*)\" isn't existed in cookie$")
    public void isnTExistedInCookie(String value) throws Throwable {
        Assert.assertFalse(mainPage.checkCookie("notSavedOpened", value));
    }

    @Then("^Publishers list isn't shown$")
    public void publishersListIsnTShown() throws Throwable {
        mainPage.waitUntilSubTreeBlockIsHidden("Publishers");
    }

    @Then("^top level clients list isn't shown$")
    public void topLevelClientsListIsnTShown() throws Throwable {
        mainPage.waitUntilSubTreeBlockIsHidden("Top level clients");
    }

    @And("^card image is shown$")
    public void cardImageIsShown() throws Throwable {
        Assert.assertTrue(card.checkImage());
    }

    @Then("^card title is \"([^\"]*)\"$")
    public void cardTitleIs(String title) throws Throwable {
        Assert.assertTrue(card.checkTitle(title));
    }

    @And("^card image is on ([^\"]*)$")
    public void cardImageIsOn(String src) throws Throwable {
        Assert.assertTrue(card.checkImageSrc(src));
    }

    @And("^card description is equal to ([^\"]*)$")
    public void cardDescriptionIsEqualToDescription(String file) throws Throwable {
        Assert.assertTrue(card.checkShortDescription(file));
    }

    @Then("^Moved to save button is disabled$")
    public void movedToSaveButtonIsDisabled() throws Throwable {
        Assert.assertTrue(card.MovedToSaveButtonIsDisabled());
    }

    @And("^user scrolls textarea to the middle$")
    public void userScrollsTextareaToTheMiddle() throws Throwable {
        card.scrollTextAreaToTheMiddle();
    }

    @And("^user scrolls textarea to the end$")
    public void userScrollsTextareaToTheEnd() throws Throwable {
        card.scrollTextAreaToTheEnd();
    }

    @Then("^Moved to save button is enabled$")
    public void movedToSaveButtonIsEnabled() throws Throwable {
        Assert.assertFalse(card.MovedToSaveButtonIsDisabled());
    }

    @Then("^user clicks move to saved button$")
    public void userClicksMoveToSavedButton() throws Throwable {
        card.clickMoveToSavedButton();
    }

    @And("^user clicks Advertiser in Saved articles$")
    public void userClicksAdvertiserInSavedArticles() throws Throwable {
        mainPage.clickAdvertisersButtonInSavedBlock();
    }

    @Then("^\"([^\"]*)\" is shown in Saved Advertiser Articles$")
    public void isShownInSavedArticles(String arg0) throws Throwable {
        Assert.assertTrue(mainPage.textInElements(mainPage.savedAdvertisers).contains(arg0));
    }

    @And("^\"([^\"]*)\" isn't shown in Advertiser Articles to read$")
    public void isnTShownInAdvertiserArticlesToRead(String arg0) throws Throwable {
        Assert.assertFalse(mainPage.textInElements(mainPage.advertisers).contains(arg0));
    }

    @And("^user clicks Publisher in Saved articles$")
    public void userClicksPublisherInSavedArticles() throws Throwable {
        mainPage.clickPublishersButtonInSavedBlock();
    }

    @Then("^\"([^\"]*)\" is shown in Saved Publisher Articles$")
    public void isShownInSavedPublisherArticles(String arg0) throws Throwable {
        Assert.assertTrue(mainPage.textInElements(mainPage.savedPublishers).contains(arg0));
    }

    @And("^\"([^\"]*)\" isn't shown in Publisher Articles to read$")
    public void isnTShownInPublisherArticlesToRead(String arg0) throws Throwable {
        Assert.assertFalse(mainPage.textInElements(mainPage.publishers).contains(arg0));
    }

    @And("^user clicks Top level clients in Saved articles$")
    public void userClicksTopLevelClientsInSavedArticles() throws Throwable {
        mainPage.clickTopLevelButtonInSavedBlock();
    }

    @Then("^\"([^\"]*)\" is shown in Saved Top level clients Articles$")
    public void isShownInSavedTopLevelClientsArticles(String arg0) throws Throwable {
        Assert.assertTrue(mainPage.textInElements(mainPage.savedTopLevelClients).contains(arg0));
    }

    @And("^\"([^\"]*)\" isn't shown in Top Level clients Articles to read$")
    public void isnTShownInTopLevelClientsArticlesToRead(String arg0) throws Throwable {
        Assert.assertFalse(mainPage.textInElements(mainPage.topLevelClients).contains(arg0));
    }

    @When("^user clicks avatar icon$")
    public void userClicksAvatarIcon() {
        mainPage.clickAvatar();
    }

    @And("^user increases image scale on (\\d+)%$")
    public void userIncreasesImageScaleTo(int arg0) throws Throwable {
        card.changeScale(arg0);
    }

    @Then("^image size is ([^\"]*)$")
    public void imageSizeIsX(String s) throws Throwable {
        Assert.assertEquals(card.getImageSize(),s);
    }

    @And("^user decreases image scale on (\\d+)%$")
    public void userDecreasesImageScaleTo(int arg0) throws Throwable {
        card.changeScale(-arg0);
    }
}

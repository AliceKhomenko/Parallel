package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.screenshot;

public class MainPage {

    @FindBy(id = "avatar")
    private SelenideElement avatarIcon;

    @FindBy(xpath = "//div[contains(@class,'card-header') and contains(text(),'Saved articles')]/..//button[contains(text(),'Advertisers')]")
    private SelenideElement savedAdvertisersButton;

    @FindBy(xpath = "//div[contains(@class,'card-header') and contains(text(),'Saved articles')]/..//button[contains(text(),'Publishers')]")
    private SelenideElement savedPublishersButton;

    @FindBy(xpath = "//div[contains(@class,'card-header') and contains(text(),'Saved articles')]/..//button[contains(text(),'Top level clients')]")
    private SelenideElement savedTopLevelClientsButton;

    @FindBy(xpath = "//div[contains(@class,'card-header') and contains(text(),'Saved articles')]/..//button[contains(text(),'Advertisers')]/..//div[@class='sub-tree-element']//button")
    public ElementsCollection savedAdvertisers;

    @FindBy(xpath = "//div[contains(@class,'card-header') and contains(text(),'Saved articles')]/..//button[contains(text(),'Publishers')]/..//div[@class='sub-tree-element']//button")
    public ElementsCollection savedPublishers;

    @FindBy(xpath = "//div[contains(@class,'card-header') and contains(text(),'Saved articles')]/..//button[contains(text(),'Top level clients')]/..//div[@class='sub-tree-element']//button")
    public ElementsCollection savedTopLevelClients;


    @FindBy(xpath = "//div[contains(@class,'card-header') and contains(text(),'Articles to read')]/..//button[contains(text(),'Advertisers')]")
    private SelenideElement advertisersButton;

    @FindBy(xpath = "//div[contains(@class,'card-header') and contains(text(),'Articles to read')]/..//button[contains(text(),'Publishers')]")
    private SelenideElement publishersButton;

    @FindBy(xpath = "//div[contains(@class,'card-header') and contains(text(),'Articles to read')]/..//button[contains(text(),'Top level clients')]")
    private SelenideElement topLevelClientsButton;

    @FindBy(xpath = "//div[contains(@class,'card-header') and contains(text(),'Articles to read')]/..//button[contains(text(),'Advertisers')]/..//div[@class='sub-tree-element']//button")
    public ElementsCollection advertisers;

    @FindBy(xpath = "//div[contains(@class,'card-header') and contains(text(),'Articles to read')]/..//button[contains(text(),'Publishers')]/..//div[@class='sub-tree-element']//button")
    public ElementsCollection publishers;

    @FindBy(xpath = "//div[contains(@class,'card-header') and contains(text(),'Articles to read')]/..//button[contains(text(),'Top level clients')]/..//div[@class='sub-tree-element']//button")
    public ElementsCollection topLevelClients;


    private     Properties properties = LoadProperties.init();



    public void clickAdverisers() {
        advertisersButton.click();
    }

    public void clickPublishers() {
        publishersButton.click();
    }

    public void clickTopLevelClients() {
        topLevelClientsButton.click();
    }

    public List<String> textInElements(ElementsCollection elements) {
        List<String> text = new ArrayList<>();
        for(SelenideElement element: elements){
            text.add(element.getText());
        }
        Collections.sort(text);
        return text;
    }

    public void waitForPageLoad() {
        avatarIcon.waitUntil(Condition.exist,30000);
    }





    public SelenideElement findAdvertiser(String adver) {
        return advertisers.findBy(Condition.text(adver));

    }

    public SelenideElement findPublisher(String pub) {
        return publishers.findBy(Condition.text(pub));
    }

    public SelenideElement findTopLevelClient(String client) {
        return topLevelClients.findBy(Condition.text(client));
    }

    public List<String> getExpectedAdvertiserList() {
        String adverString = properties.getProperty("advertisers.list");
        List <String> result = Arrays.asList(adverString.split(","));
        Collections.sort(result);
        return result;
    }

    public List<String> getExpectedPublisherList() {
        String pubString = properties.getProperty("publishers.list");
        List <String> result = Arrays.asList(pubString.split(","));
        Collections.sort(result);
        return result;
    }

    public List<String> getExpectedTopLevelClientsList() {
        String clientString = properties.getProperty("top.level.clients.list");
        List <String> result = Arrays.asList(clientString.split(","));
        Collections.sort(result);
        return result;
    }


    public void waitUntilSubTreeBlockIsHidden(String value) {
        $x("//button[contains(text(),'"+value+"')]/..//div[@class='sub-tree']").waitUntil(Condition.hidden,2000);

    }

    public Boolean checkCookie(String notSavedOpened, String value) {
        WebDriver.Options options = WebDriverRunner.getWebDriver().manage();
       if (options.getCookies().toString().contains(value))
       {String cookie = options.getCookieNamed("notSavedOpened").getValue();
        return cookie.contains(value);}
       else
           return false;
    }

    public void doubleClickOnAdvertiserButton(){
        advertisersButton.doubleClick();

    }

    public void doubleClickOnPublisherButton(){
        publishersButton.doubleClick();

    }

    public void doubleClickOnTopLevelClientButton(){
        topLevelClientsButton.doubleClick();

    }

    public void clickAdvertisersButtonInSavedBlock() {
        savedAdvertisersButton.click();
    }

    public void clickPublishersButtonInSavedBlock() {
        savedPublishersButton.click();
    }

    public void clickTopLevelButtonInSavedBlock() {
        savedTopLevelClientsButton.click();
    }

    public void clickAvatar(){
        avatarIcon.click();

    }
}

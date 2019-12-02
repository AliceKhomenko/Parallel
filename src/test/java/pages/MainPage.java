package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
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

    @FindBy(xpath = "//button[contains(text(),'Advertisers')]")
    private SelenideElement advertisersButton;

    @FindBy(xpath = "//button[contains(text(),'Publishers')]")
    private SelenideElement publishersButton;

    @FindBy(xpath = "//button[contains(text(),'Top level clients')]")
    private SelenideElement topLevelClientsButton;

    @FindBy(xpath = "//button[contains(text(),'Advertisers')]/..//div[@class='sub-tree-element']//button")
    public ElementsCollection advertisers;

    @FindBy(xpath = "//button[contains(text(),'Publishers')]/..//div[@class='sub-tree-element']//button")
    public ElementsCollection publishers;

    @FindBy(xpath = "//button[contains(text(),'Top level clients')]/..//div[@class='sub-tree-element']//button")
    public ElementsCollection topLevelClients;

    private     Properties properties = new LoadProperties().init();



    public void clickAdverisers() {
        advertisersButton.click();
    }

    public void clickPublishers() {
        publishersButton.click();
    }

    public void clickTopLevelClients() {
        topLevelClientsButton.click();
    }

    public List<String> advertisersNames() {
        List<String> advertiserNames = new ArrayList<>();
        for(SelenideElement element: advertisers){
            advertiserNames.add(element.getText());
        }
        Collections.sort(advertiserNames);
        return advertiserNames;
    }

    public void waitForPageLoad() {
        avatarIcon.waitUntil(Condition.exist,30000);
    }

    public List<String> publishersNames() {
        List<String> result = new ArrayList<>();
        for(SelenideElement element: publishers){
            result.add(element.getText());
        }
        System.out.println(result);
        Collections.sort(result);
        return result;
    }

    public List<String> topLevelClientNames() {
        List<String> result = new ArrayList<>();
        for(SelenideElement element: topLevelClients){
            result.add(element.getText());
        }
        System.out.println(result);
        Collections.sort(result);
        return result;
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

       if ( WebDriverRunner.getWebDriver().manage().getCookies().toString().contains("notSavedOpened"))
       {String cookie = WebDriverRunner.getWebDriver().manage().getCookieNamed("notSavedOpened").getValue();
        return cookie.contains(value);}
       else
           return false;
    }
}

package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

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
    private ElementsCollection publishers;

    @FindBy(xpath = "//button[contains(text(),'Top level clients')]/..//div[@class='sub-tree-element']//button")
    private ElementsCollection topLevelClients;



    public void clickAdverisers() {
        advertisersButton.click();
    }

    public void clickPublishers() {
        publishersButton.click();
    }

    public void clickTopLevelClients() {
        advertisersButton.click();
    }

    public List<String> advertisersNames() {
        List<String> advertiserNames = new ArrayList<>();
        for(SelenideElement element: advertisers){
            advertiserNames.add(element.getText());
        }
        System.out.println(advertiserNames);
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
        return result;
    }

    public List<String> topLevelNames() {
        List<String> result = new ArrayList<>();
        for(SelenideElement element: publishers){
            result.add(element.getText());
        }
        System.out.println(result);
        return result;
    }
}

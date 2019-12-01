package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.Wait;

public class LoginPage {
    @FindBy(id="registrationContainer")
    public SelenideElement loginForm;

    @FindBy(how = How.ID, using = "loginInput")
    private SelenideElement loginField;

    @FindBy(how = How.CSS,using = "div[onclick=\"startInputLogin()\"]")
    private SelenideElement loginBlock;

    @FindBy(how = How.ID,using = "passwordInput")
    private SelenideElement passwordField;

    @FindBy(how = How.CSS,using = "div[onclick=\"startInputPassword()\"]")
    private SelenideElement passwordBlock;

    @FindBy(how=How.XPATH,using = "//button[contains(text(),'Hover me faster!')]")
    private SelenideElement howerMeFasterButton;

    @FindBy(how=How.CSS,using="img[src='sign.png']")
    private SelenideElement signInButton;



    public void inputLogin(String login){
        loginBlock.click();
        loginField.setValue(login);
    }

    public void inputPassword(String password){
        passwordBlock.click();
        passwordField.setValue(password);
    }

    public void moveCursorToButton(){
        howerMeFasterButton.hover();
    }

    public void clickSighInButton() {
        signInButton.waitUntil(Condition.visible,10000);

        signInButton.click();
    }

    public void isShown() {

    }
}

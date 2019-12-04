package pages;

import additional.LoadProperties;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.Properties;

public class LoginPage {
    @FindBy(id = "registrationContainer")
    public SelenideElement loginForm;

    @FindBy(how = How.ID, using = "loginInput")
    private SelenideElement loginField;

    @FindBy(how = How.CSS, using = "div[onclick=\"startInputLogin()\"]")
    private SelenideElement loginBlock;

    @FindBy(how = How.ID, using = "passwordInput")
    private SelenideElement passwordField;

    @FindBy(how = How.CSS, using = "div[onclick=\"startInputPassword()\"]")
    private SelenideElement passwordBlock;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Hover me faster!')]")
    private SelenideElement howerMeFasterButton;

    @FindBy(how = How.CSS, using = "img[src='sign.png']")
    private SelenideElement signInButton;

    private Properties properties = LoadProperties.init();


    public void inputLogin(String loginType) {

        loginBlock.click();
        switch (loginType) {
            case "correct":
                loginField.setValue(properties.getProperty("correct.login"));
                break;
            case "incorrect":
                loginField.setValue(properties.getProperty("incorrect.login"));
                break;
            default:
                Assert.fail("Unknown parameter for login");
        }
    }

    public void inputPassword(String passwordType) {
        passwordBlock.click();
        switch (passwordType) {
            case "correct":
                passwordField.setValue(properties.getProperty("correct.password"));
                break;
            case "incorrect":
                passwordField.setValue(properties.getProperty("incorrect.password"));
                break;
            default:
                Assert.fail("Unknown parameter for password");
        }
    }

    public void moveCursorToButton() {
        howerMeFasterButton.hover();
    }

    public void clickSighInButton() {
        signInButton.waitUntil(Condition.visible, 10000);
        signInButton.click();
    }

    public void isShown() {
        loginForm.waitUntil(Condition.visible, 3000);

    }

    public void clickLoginFiled() {
        loginBlock.click();
    }

    public void clickPasswordField() {
        passwordBlock.click();
    }

    public void checkhowerMeFasterButton() {
        howerMeFasterButton.should(Condition.disabled);
    }
}

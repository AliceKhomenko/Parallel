package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

public class ProfilePage {

    @FindBy(id = "v-pills-home-tab")
    private SelenideElement userProfileButton;

    @FindBy(id = "v-pills-messages-tab")
    private SelenideElement paymentSettingsButton;

    @FindBy(id = "firstNameInput")
    private SelenideElement firstNameField;

    @FindBy(id = "lastNameInput")
    private SelenideElement lastNameField;

    @FindBy(css = "button[onclick=\"saveUserInfo()\"]")
    private SelenideElement saveButton;

    @FindBy(id = "successUserInfoSaveInfo")
    private SelenideElement successfulUserInfoSavedAlert;

    @FindBy(id = "cardNumberInput")
    private SelenideElement cardNumberField;

    @FindBy(id = "paymentSystemSelect")
    private SelenideElement paymentSysyremSelector;

    @FindBy(id = "paymentRange")
    private SelenideElement paymentRangeSlider;

    @FindBy(css = "button[onclick=\"savePaymentInfo()\"]")
    private SelenideElement savePaymentInfoButton;

    @FindBy(id = "successPaymentInfoSaveInfo")
    private SelenideElement successfulPaymentInfoSavedALert;


    public void inputFirstName(String name) {
        firstNameField.setValue(name);
    }

    public void inputLastName(String name) {
        lastNameField.setValue(name);

    }

    public void clickProfileButton() {
        userProfileButton.click();
    }

    public void clickPaymentSettingsButton() {

        paymentSettingsButton.click();

    }

    public void inputCardNumber(String card) {

        cardNumberField.setValue(card);
    }

    public void selectPaymentSystem(String system) {
        paymentSysyremSelector.selectOptionContainingText(system);


    }

    public void clickSaveUserInfo() {
        saveButton.click();
    }

    public void successfullAlertIsShown() {
        successfulUserInfoSavedAlert.shouldBe(Condition.visible);

    }

    public void successfulPaymentInfoSavedIsShown() {
        successfulPaymentInfoSavedALert.shouldBe(Condition.visible);
    }

    public void clickSavePaymentInfo() {
        savePaymentInfoButton.click();
    }

    public void inputDayOfPayment(int arg0) {
        for(int i=1;i<arg0;i++) {
            paymentRangeSlider.sendKeys(Keys.ARROW_RIGHT);
        }
        }
}

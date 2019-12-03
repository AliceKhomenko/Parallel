package pages;

import com.codeborne.selenide.SelenideElement;
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
    private SelenideElement successfulSaveAlert;

    @FindBy(id = "cardNumberInput")
    private SelenideElement cardNumberField;

    @FindBy(id = "paymentSystemSelect")
    private SelenideElement paymentSysyremSelector;

    @FindBy(id = "paymentRange")
    private SelenideElement paymentRangeSlider;

    @FindBy(css = "button[onclick=\"savePaymentInfo()\"]")
    private SelenideElement savePaymentInfoButton;




}

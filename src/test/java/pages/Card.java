package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.screenshot;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Card {

    @FindBy(id="dataCard")
    private SelenideElement card;

    @FindBy(css = "#dataCard h5.card-title")
    private SelenideElement cardTitle;

    @FindBy(css = "#dataCard textarea.form-control")
    public SelenideElement cardText;

    @FindBy(xpath = "//*[@id='dataCard']//button[contains(text(),'Download info')]")
    private SelenideElement downloadFileButton;

    @FindBy(id = "heroImage")
    private SelenideElement cardImage;

    @FindBy(xpath = "//*[@id='dataCard']//button[contains(text(),'Move to saved')]")
    private SelenideElement movedToSavedButton;

    @FindBy(xpath = "//*[@id='dataCard']//button[contains(text(),'Removed from saved')]")
    private SelenideElement removedFromSavedButton;

    @FindBy(css = "#dataCard div.ui-slider")
    private SelenideElement scale;

    @FindBy(css = "#dataCard span.ui-slider-handle")
    private SelenideElement scaleSlider;


    public void changeScale(int percent){


        double p = (double)percent/100;
        double k=p/10;
        double w = (double)scale.getSize().width;
        System.out.println(w);
        String style = cardImage.getAttribute("style");
        String pattern = "(\\d+)";
        Pattern pat = Pattern.compile(pattern);
        Matcher m = pat.matcher(style);
        m.find();
        System.out.println(m.group(0));
        System.out.println(m.group(1));

        System.out.println(cardImage.getAttribute("style"));
        Actions actions = new Actions(getWebDriver());

       for( int i=0;i<10;i++) {
           actions.dragAndDropBy(scaleSlider, (int)Math.round (w * k), 0);
       }

        actions.build().perform();

    }

    public static String readFile(String path) {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(path)));
            File downloadedFile = new File(path);
            downloadedFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.replaceAll("\n", "");
    }

    public void downloadFile() {


            downloadFileButton.click();


        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean checkImage() {
            boolean loaded = (boolean) ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("return arguments[0].complete", cardImage);

            return loaded;
    }

    public boolean checkTitle(String title) {
        return cardTitle.equals(title);
    }

    public boolean checkImageSrc(String src) {
        return  cardImage.getAttribute("src").equals(src);
    }

    public void scrollTextArea(){
       JavascriptExecutor js =(JavascriptExecutor)WebDriverRunner.getWebDriver();
       js.executeScript("var textarea = document.querySelector('textarea');\n" +
                "textarea.scrollTop = textarea.scrollHeight;");

    }
}


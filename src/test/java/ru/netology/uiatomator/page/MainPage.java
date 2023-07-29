package ru.netology.uiatomator.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

//import org.openqa.selenium.support.PageFactory;
import java.time.Duration;



public class MainPage {


    private   AppiumDriver driver;

    public MainPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }




    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/userInput")
    private WebElement textInput;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonChange")
    private WebElement changeButton;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/textToBeChanged")
    private WebElement mainPageTextArea;

    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonActivity")
    private WebElement activityButton;


public void seвtTextToTextInput(String text) {
    textInput.isDisplayed();
    textInput.sendKeys(text);

}

 public void clickToChangeButton () {
    textInput.isDisplayed();
    changeButton.click();
 }

 public String getMainPageTextAreaValue() {

    mainPageTextArea.isDisplayed();
    return mainPageTextArea.getText();
 }

 public void clickToActivityButton () {
    activityButton.isDisplayed();
    activityButton.click();
 }

}

package ru.netology.uiatomator.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ActivityPage {

    private   AppiumDriver driver;

    public ActivityPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }


    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/text")
    private WebElement activityTextArea;


    public String getActivityTextAreaInput () {
        activityTextArea.isDisplayed();
        return activityTextArea.getText();
    }

}

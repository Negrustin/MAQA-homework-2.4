package ru.netology.uiatomator.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.netology.uiatomator.page.ActivityPage;
import ru.netology.uiatomator.page.MainPage;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.MobileCapabilityType.AUTOMATION_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SampleTest {


    enum Platforms {Android, iOS}

    Platforms platform = Platforms.Android  ;
    private AppiumDriver driver;


    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        URL remoteUrl = new URL("http://127.0.0.1:4723");

        if (platform == Platforms.Android) {
            desiredCapabilities.setCapability(PLATFORM_NAME, "android");
            desiredCapabilities.setCapability(DEVICE_NAME, "some name");
            desiredCapabilities.setCapability(APP_PACKAGE, "ru.netology.testing.uiautomator");
            desiredCapabilities.setCapability(APP_ACTIVITY, "ru.netology.testing.uiautomator.MainActivity");
            desiredCapabilities.setCapability(AUTOMATION_NAME, "uiautomator2");


            driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        }



    }

    @Test
    public void sampleTest() {
        String text = "Hello World";

        MainPage mainPage = new MainPage(driver);

        mainPage.setTextToTextInput(text);
        mainPage.clickToChangeButton();

        String expected = text;
        String actual = mainPage.getMainPageTextAreaValue();

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void myTest2 () {
        String firstText = "Hello world!";
        String emptyString = "";

        MainPage mainPage = new MainPage(driver);

        mainPage.setTextToTextInput(firstText);
        mainPage.clickToChangeButton();

        mainPage.setTextToTextInput(emptyString);
        mainPage.clickToChangeButton();


        String expected = firstText;
        String actual = mainPage.getMainPageTextAreaValue();

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void myTest3 () {
        String firstText = "New activity text";

        MainPage mainPage = new MainPage(driver);

        mainPage.setTextToTextInput(firstText);
        mainPage.clickToActivityButton();

        ActivityPage activityPage = new ActivityPage(driver);



        String expected = firstText;
        String actual = activityPage.getActivityTextAreaInput();

        Assertions.assertEquals(expected, actual);


    }




    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

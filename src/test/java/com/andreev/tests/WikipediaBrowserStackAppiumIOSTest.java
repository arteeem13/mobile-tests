package com.andreev.tests;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WikipediaBrowserStackAppiumIOSTest {

    @Test
    void searchIOSAppiumTest() throws InterruptedException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "artemandreev_bNoMv4");
        caps.setCapability("browserstack.key", "LxBRtqHyrLqzzDTxsZ2m");

        // Set URL of the application under test
        caps.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");

        // Specify device and os_version for testing
        caps.setCapability("device", "iPhone 14 Pro Max");
        caps.setCapability("os_version", "16");


        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(
                new URL("http://hub-cloud.browserstack.com/wd/hub"), caps);

        // Test case for the BrowserStack sample iOS app.
        // If you have uploaded your app, update the test case here.
        IOSElement textButton = (IOSElement) new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Button")));
        textButton.click();
        IOSElement textInput = (IOSElement) new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Input")));
        textInput.sendKeys("hello@browserstack.com");
        Thread.sleep(5000);
        IOSElement textOutput = (IOSElement) new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Output")));
        if (textOutput != null && textOutput.getText().equals("hello@browserstack.com"))
            assert (true);
        else
            assert (false);

        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();
    }
}

package saucelablogin;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SaucelabDemoRunProject {

    @Test
    public void SaucelabDemoRunProject() throws MalformedURLException, InterruptedException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Samsung_Galaxy_S23_FE_free");
        caps.setCapability("appium:platformVersion", "16.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("appiumVersion", "2.0.0");
        sauceOptions.setCapability("username", "oauth-arman202216abc-553be");
        sauceOptions.setCapability("accessKey", "e33bf513-52df-46fc-993c-0ea5a24eddb0");
        sauceOptions.setCapability("build", "appium-build-BKK4A");
        sauceOptions.setCapability("name", "Run sample test");
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
        caps.setCapability("sauce:options", sauceOptions);

        // Start the session
        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, caps);

        driver.findElement(AppiumBy.xpath("//*[@text='Username' and @content-desc='test-Username']")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//*[@text='Password' and @content-desc='test-Password']")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//*[@content-desc='test-LOGIN']")).click();

// replace with commands and assertions
        Thread.sleep(5000);
        String jobStatus = "passed"; // or "failed"


// end the session
        driver.executeScript("sauce:job-result=" + jobStatus);
        driver.quit();
    }
}

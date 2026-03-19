package handlingBasicValidations;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class HandlingElementsBasics_ios {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("IOS");
        options.setUdid("4B733329-44E4-4712-9AD2-8EC4E24CF059");
        options.setAutomationName(AutomationName.IOS_XCUI_TEST);
        options.setBundleId("com.saucelabs.mydemo.app.ios");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        Thread.sleep(5000);

        // to avoid redunduncy of thelement we store the element in the webelement datatype
        WebElement morebutton = driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"More-tab-item\"]"));
        morebutton.click();
        Thread.sleep(2000);
        WebElement loginbuttonvalidation = driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"LogOut-menu-item\"]"));

        System.out.println("to check the element is displayed : " + loginbuttonvalidation.isDisplayed());
        System.out.println("to check the element is enabled : " + loginbuttonvalidation.isEnabled());
        System.out.println("to check the element has text : " + loginbuttonvalidation.getText());
        System.out.println("to check the element has attribuites value : " + loginbuttonvalidation.getAttribute("placeholderValue"));

        Thread.sleep(5000);
        driver.quit();


    }
}

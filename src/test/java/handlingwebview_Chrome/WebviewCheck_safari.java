package handlingwebview_Chrome;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.net.MalformedURLException;
import java.net.URL;

public class WebviewCheck_safari {

    //     AppiumDriver driver;
    // to run from command line appium --allow-insecure chromedriver_autodownload
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("IOS");
        options.setUdid("4B733329-44E4-4712-9AD2-8EC4E24CF059");
        options.setPlatformVersion("26.2");
        options.setAutomationName(AutomationName.IOS_XCUI_TEST);
        // Ios its recommended to use the safari- safari si the native browser for all ios environments
        options.withBrowserName("Safari");
//        options.setCapability("startIWDP", true);// only for real device - to enabling webview debugging mode


        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
        //code for chrome
        driver.get("https://bing.com");
        Thread.sleep(5000);
        System.out.println(driver.getPageSource()); // this will get the page source of the browser website that has opened
        driver.findElement(By.xpath("//textarea[@id='sb_form_q']")).sendKeys("appium");
        driver.findElement(By.xpath("//textarea[@id='sb_form_q']")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.quit();

    }

//    public UiAutomator2Options getChrome(){
//        UiAutomator2Options options = new UiAutomator2Options();
//        options.setPlatformName("Android");
//        options.setDeviceName("29221JEGR00379");
//        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
//        options.withBrowserName("Chrome");
//        return  options;
//    }
}

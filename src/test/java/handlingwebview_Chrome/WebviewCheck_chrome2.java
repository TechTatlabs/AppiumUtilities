package handlingwebview_Chrome;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.By;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WebviewCheck_chrome2 {

    //     AppiumDriver driver;
    // to run from command line appium --allow-insecure chromedriver_autodownload
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        AppiumServiceBuilder builder = new AppiumServiceBuilder().withArgument(GeneralServerFlag.ALLOW_INSECURE,"chromedriver_autodownload");

        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
        service.start();


        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setUdid("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.withBrowserName("Chrome");
//        options.setChromedriverExecutable(System.getProperty("user.dir") + "/src/test/resources/browser/chromedriver_mac");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        //code for chrome
        driver.get("https://atlantis.com");
        Thread.sleep(5000);
        System.out.println(driver.getPageSource());
//        driver.findElement(By.xpath("//textarea[@id='sb_form_q']")).sendKeys("appium");
//        Thread.sleep(5000);
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

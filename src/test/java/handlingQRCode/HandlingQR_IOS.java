package handlingQRCode;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HandlingQR_IOS {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

// File path of the QR code image
        String filePath = System.getProperty("user.dir") + "/src/test/resources/qrcodesample/qr_code_1.png";

        File qrFile = new File(filePath);

        // Decode and print the QR code text
        String qrText = decodeQRCode(qrFile);
        if (qrText != null) {
            System.out.println("QR Code Text: " + qrText);
        } else {
            System.out.println("QR Code not found in the image.");
        }


        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName("IOS");
//        options.setUdid("4B733329-44E4-4712-9AD2-8EC4E24CF059");
        options.setUdid("8859C57C-CD79-492A-A058-13236D7B0E6B");
        options.setAutomationName(AutomationName.IOS_XCUI_TEST);
        // to open chrom browser inside the device below 2 options are mandatory
        options.withBrowserName("Safari");
//        options.setCapability("startIWDP", true);// only for real device - to enabling webview debugging mode


        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
        //code for chrome
        driver.get(qrText);
        Thread.sleep(5000);
        System.out.println(driver.getPageSource()); // this will get the page source of the browser website that has opened
        Thread.sleep(5000);
        driver.quit();
    }

    public static String decodeQRCode(File qrImage) throws NotFoundException {
        try {
            BufferedImage bufferedImage = ImageIO.read(qrImage);

            // Convert to grayscale to improve detection
            BufferedImage grayscaleImage = new BufferedImage(
                    bufferedImage.getWidth(), bufferedImage.getHeight(),
                    BufferedImage.TYPE_BYTE_GRAY);
            grayscaleImage.getGraphics().drawImage(bufferedImage, 0, 0, null);

            // Try to enhance image contrast
            LuminanceSource source = new BufferedImageLuminanceSource(grayscaleImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        } catch (IOException e) {
            System.out.println("Error reading QR Code image: " + e.getMessage());
            return null;
        } catch (NotFoundException | com.google.zxing.NotFoundException e) {
            System.out.println("QR Code not found in image. Try adjusting the screenshot.");
            return null;
        }
    }




}

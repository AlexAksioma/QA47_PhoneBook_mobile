package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import static config.DeviceFactory.*;

public abstract class AppiumConfig {
    protected static AppiumDriver driver;
    private static final String device = System.getProperty("device", "pixel3");

    @BeforeMethod(alwaysRun = true)
    public void setup() {
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability("platformName", "Android");
//        desiredCapabilities.setCapability("deviceName", "Pixel_3");
//        desiredCapabilities.setCapability("platformVersion", "8.0");
//        //desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
//        desiredCapabilities.setCapability("appPackage","com.sheygam.contactapp");
//        desiredCapabilities.setCapability("appActivity", ".SplashActivity");
//        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        DesiredCapabilities desiredCapabilities = createDC(device);
        String url = "http://localhost:4723/wd/hub";
        try {
            driver = new AndroidDriver(new URL(url), desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
//  "platformName": "Android",
//          "deviceName": "Pixel_3",
//          "platformVersion": "8.0",
//          "appPackage": "com.sheygam.contactapp",
//          "appActivity": ".SplashActivity"
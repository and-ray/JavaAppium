package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.WelcomePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSWelcomePageObject extends WelcomePageObject {
    public IOSWelcomePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        SKIP_BUTTON = "xpath://*[@name='Skip']";
    }
}

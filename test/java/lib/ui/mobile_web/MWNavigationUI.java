package lib.ui.mobile_web;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUI extends NavigationUI {
    public MWNavigationUI(RemoteWebDriver driver) {
        super(driver);
    }
    static {
        BUTTON_TO_OPEN_OPTIONS = "xpath://*[@resource-id='org.wikipedia:id/page_action_overflow_reading_lists'][contains(@text, 'My lists')]";
        NO_THANKS_BUTTON = "xpath://*[contains(@text, 'NO THANKS')]";
        OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']";
        NAVIGATE_BACK = "xpath://*[@content-desc='Navigate up']";

    }
}

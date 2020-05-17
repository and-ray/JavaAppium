package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject {

    public NavigationUI(RemoteWebDriver driver) {
        super(driver);
    }

    protected static String
            BUTTON_TO_OPEN_OPTIONS,
            NO_THANKS_BUTTON,
            OPTIONS_BUTTON,
            NAVIGATE_BACK,
            OPEN_NAVIGATION;

    public void openNavigation(){
        if (Platform.getInstance().isMW()){
    waitForElementAndClick(OPEN_NAVIGATION, "Cannot find and click open navigation button", 5);
        }    else {
            System.out.println("Method openNavigation does nothing for the platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void openMyLists() {
        openOptions();
        clickMyReadingLists();
        clickNoThanksButton();
    }

    public void moveBack() {
        this.waitForElementAndClick(
                NAVIGATE_BACK,
                "Cannot find button BACK",
                5);
    }

    public void openOptions() {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open options",
                5);
    }

    public void clickMyReadingLists() {

            this.waitForElementAndClick(
                    BUTTON_TO_OPEN_OPTIONS,
                    "Cannot find button to open article lists",
                    5);

    }

    public void clickNoThanksButton() {
        this.waitForElementAndClick(
                NO_THANKS_BUTTON,
                "Cannot find button 'NO THANKS'",
                5);
    }
}

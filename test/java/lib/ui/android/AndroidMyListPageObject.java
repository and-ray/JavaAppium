package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMyListPageObject extends MyListPageObject {
    public AndroidMyListPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        BUTTON_TO_OPEN_BOOKMARK_OPTIONS = "id:org.wikipedia:id/article_menu_bookmark";
        FOLDER_BY_NAME_TPL = "xpath://*[contains(@text, '{FOLDER_NAME}')]";
        ARTICLE_BY_NAME_TPL = "xpath://*[contains(@text, '{ARTICLE_NAME}')]";
    }
}

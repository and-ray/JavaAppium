package lib.ui.mobile_web;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListsPageObject {
    public MWMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        BUTTON_TO_OPEN_BOOKMARK_OPTIONS = "id:org.wikipedia:id/article_menu_bookmark";
        FOLDER_BY_NAME_TPL = "xpath://*[contains(@text, '{FOLDER_NAME}')]";
        ARTICLE_BY_NAME_TPL = "xpath://*[contains(@text, '{ARTICLE_NAME}')]";
    }
}

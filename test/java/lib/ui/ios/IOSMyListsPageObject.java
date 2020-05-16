package lib.ui.ios;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSMyListsPageObject extends MyListsPageObject {
        public IOSMyListsPageObject(RemoteWebDriver driver) {
            super(driver);
        }

        static {
            BUTTON_TO_OPEN_BOOKMARK_OPTIONS = "id:org.wikipedia:id/article_menu_bookmark";
            FOLDER_BY_NAME_TPL = "xpath://*[contains(@text, '{FOLDER_NAME}')]";
            ARTICLE_BY_NAME_TPL = "xpath://XCUIElementTypeLink[contains(@name, '{ARTICLE_NAME}')]";
            CLOSE_OVERLAY = "id:Close";
            BUTTON_TO_OPEN_SAVED_ARTICLES = "id:Saved";
        }
}

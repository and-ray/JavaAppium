package lib.ui.mobile_web;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListsPageObject {
    public MWMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    static {
        BUTTON_TO_OPEN_BOOKMARK_OPTIONS = "id:org.wikipedia:id/article_menu_bookmark";
        FOLDER_BY_NAME_TPL = "xpath://*[contains(@text,'{FOLDER_NAME}')]";
        ARTICLE_BY_NAME_TPL = "xpath://h3";
        BUTTON_TO_OPEN_SAVED_ARTICLES = "css:a[data-event-name='menu.unStar']";
        ARTICLE_BY_TITLE_TPL = "xpath://ul[contains(@class,'mw-mf-watchlist-page-list')]//h3[contains(text(),'{TITLE}')]";
        REMOVE_FROM_SAVED_BUTTON = "xpath://ul[contains(@class,'mw-mf-watchlist-page-list')]//h3[contains(text(),'{TITLE}')]/../../a[contains(@class, 'watched')]";
                //"xpath://ul[contains(@class,'mw-mf-watchlist-page-list')]//h3[contains(text(),'{TITLE}')]/../../div[contains(@class, 'watched')]";
    }
}

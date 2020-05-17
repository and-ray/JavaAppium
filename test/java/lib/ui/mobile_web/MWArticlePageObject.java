package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {

        static {
            TITLE ="css:#content h1"; // or div.page-heading...
            FOOTER_ELEMENT = "css:footer";
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://li[@id='page-actions-watch']//a[@id='ca-watch']"; //Add this page to your watchlist']";
            OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "xpath://a[@title='Unwatch']";
        /*    BUTTON_TO_CREATE_NEW_LIST = "xpath://*[contains(@text, 'Create new')]";
            MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input";
            MY_LIST_OK_BUTTON = "xpath://*[@text='OK']";
            MY_ARTICLE_TPL = "xpath://*[contains(@text, '{ARTICLE_DATA}')]";
            */
        }


    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}

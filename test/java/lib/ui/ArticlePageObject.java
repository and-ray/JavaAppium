package lib.ui;

import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import static java.lang.Thread.sleep;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String
            TITLE,
            FOOTER_ELEMENT,
            ADD_TO_MY_LIST_OVERLAY,
            BUTTON_TO_CREATE_NEW_LIST,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON,
            MY_ARTICLE_TPL,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            CLOSE_ARTICLE_BUTTON,
            OPTIONS_REMOVE_FROM_MY_LIST_BUTTON;

    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return waitForElementPresent(
                TITLE,
                "Cannot find article title on the page",
                15);
    }

    public String getArticleTitle() {
        WebElement titleElement = waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return titleElement.getAttribute("text");
        } else if (Platform.getInstance().isIOS()) {
            return titleElement.getAttribute("name");
        } else {
            return titleElement.getText();
        }
    }

    public void swipeUpToFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of the article",
                    100
            );
        } else if (Platform.getInstance().isIOS()){
            swipeUpTillElementAppears(
                FOOTER_ELEMENT,
                "Cannot find the end of the article",
                40
        );
        } else scrollWebPageTillElementNotVisible(
                FOOTER_ELEMENT,
                "Cannot find the end of the article",
                40
        );
    }

    public void addArticleToNewList(String name_of_reading_list) {
        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find button to prove adding bookmarks",
                5);
        this.waitForElementAndClick(
                BUTTON_TO_CREATE_NEW_LIST,
                "Cannot find button +",
                5);
        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_reading_list,
                "Cannot find field 'Name of the list' on the page",
                5);
        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot find button OK",
                5);
    }

    public void addArticlesToMySaved() throws InterruptedException {
        if(Platform.getInstance().isMW()){
            removeArticleFromSavedIfItAdded();
        }
        sleep(5000);
        waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                10
                );
    }

    public void removeArticleFromSavedIfItAdded(){
        if (isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)){
            waitForElementAndClick(
                    OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                    "Cannot click button to remove saved article",
                   1
            );
            this.waitForElementPresent(
                    OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot find button to add an article to saved list after removing it from this list before"
            );
        }
    }
/*
    public void addArticleToExistingList(String name_of_reading_list){
        waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                5
                );
    }
*/
    public void closeArticle(){
        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
        waitForElementAndClick(CLOSE_ARTICLE_BUTTON,
                "Cannot find button to close article",
                5
        );
        } else{
            System.out.println("Method closeArticle() does nothing for the platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void waitForArticleByTitlePresent(String name_of_article) {
        String articleXpath = getArticleXpathByName(name_of_article);
        waitForElementPresent(
                articleXpath,
                "Cannot find article title",
                15
        );
    }

    public void waitForArticleByNamePresent(String data) {
        String articleXpath = getArticleXpathByName(data);
        waitForElementPresent(
                articleXpath,
                "Cannot find article by data = " + data,
                15
        );
    }
    /* TEMPLATES METHODS */

    public String getArticleXpathByName(String data) {
        String result = MY_ARTICLE_TPL.replace("{ARTICLE_DATA}", data);
        return result;
    }
    /* TEMPLATES METHODS */

}

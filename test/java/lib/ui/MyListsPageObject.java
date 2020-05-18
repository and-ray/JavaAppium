package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

import static java.lang.Thread.sleep;

abstract public class MyListsPageObject extends MainPageObject {

    protected static String
            BUTTON_TO_OPEN_BOOKMARK_OPTIONS,
            FOLDER_BY_NAME_TPL,
            ARTICLE_BY_NAME_TPL,
            BUTTON_TO_OPEN_SAVED_ARTICLES,
            CLOSE_OVERLAY,
            REMOVE_FROM_SAVED_BUTTON,
            ARTICLE_BY_TITLE_TPL;

    public MyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void openFolderByName(String name_of_folder) {
        String name_of_folderXpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                name_of_folderXpath,
                "Cannot find created folder by name" + name_of_folder,
                5
        );
    }

    public void swipeByArticleToDelete(String article_title) throws InterruptedException {
        this.waitForArticleToAppearByTitle(article_title);
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
        this.swipeElementToTheLeft(
                article_title_xpath,
                "Cannot find saved article with title " + article_title
        );
        } else {
            String remove_locator = getRemoveButtonByTitle(article_title);
            sleep(3000);
            waitForElementAndClick(
                    remove_locator,
                    "Cannot click button to remove article from saved",
                    10
            );

        }

        if (Platform.getInstance().isIOS()){
            clickElementByTheRightUpperCorner(article_title_xpath,
                    "Cannot find saved article ");
        }

        if (Platform.getInstance().isMW()){
            driver.navigate().refresh();
        }
        sleep(3000);
        this.waitForArticleToDisappearByTitle(article_title);
    }

    public void waitForArticleToDisappearByTitle(String article_title) {
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(
                article_title_xpath,
                "Saved article still presents with title " + article_title, 10
        );
    }

    public void waitForArticleToAppearByTitle(String article_title) {
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPresent(
                article_title_xpath,
                "Cannot find saved article by title " + article_title, 15
        );
    }

    public void waitForArticleToAppearByName(String name) {
        String article_title_xpath = getSavedArticleXpathByName(name);
        this.waitForElementPresent(
                article_title_xpath,
                "Cannot find saved article by name " + name, 15
        );
    }

    public String getTextFromArticleName(){
        System.out.println("ARTICLE_BY_NAME_TPL = " + ARTICLE_BY_NAME_TPL);
       return waitForElementAndGetAttribute(ARTICLE_BY_NAME_TPL,
               "outerText", "Cannot get article name", 5);
    }

    public void openBookmarks() {
        this.waitForElementAndClick(
                BUTTON_TO_OPEN_BOOKMARK_OPTIONS,
                "Cannot find button to open bookmark options",
                5);
    }

    public void openSavedArticles() {
        if (Platform.getInstance().isMW()){
            tryClickElementWithFewAttempts(
                    BUTTON_TO_OPEN_SAVED_ARTICLES,
                    "Cannot find button to open article lists",
                    5
            );
        }
        else {
        this.waitForElementAndClick(
                BUTTON_TO_OPEN_SAVED_ARTICLES,
                "Cannot find button to open saved articles",
                5);
    }
    }

    public void addArticleToExistingReadingList(String name_of_reading_list) {
        openFolderByName(name_of_reading_list);
    }

    public void closeOverlay(){
        waitForElementAndClick(CLOSE_OVERLAY, "overlay not found", 15);
    }

    /* TEMPLATES METHODS */

    public String getFolderXpathByName(String name_of_folder) {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    public String getSavedArticleXpathByTitle(String article_title) {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    public String getSavedArticleXpathByName(String article_name) {
        return ARTICLE_BY_NAME_TPL.replace("{ARTICLE_NAME}", article_name);
    }

    public String getRemoveButtonByTitle(String article_title) {
        return REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}", article_title);
    }
    /* TEMPLATES METHODS */

}

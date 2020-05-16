package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTest extends CoreTestCase {

    private static final String name_of_reading_list = "MyFirstArticleList";
    private static final String
            login = "Qa.automation332211",
    password = "qwaqwa321";

    @Test
    public void testSaveFirstArticleToMyList() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring("Java (programming language)");

        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.waitForTitleElement();
        String articleTitle = articlePageObject.getArticleTitle();
        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        MyListsPageObject myListsPageObject = MyListPageObjectFactory.get(driver);

        if (Platform.getInstance().isAndroid()) {
            myListsPageObject.openBookmarks();
            articlePageObject.addArticleToNewList(name_of_reading_list);
            navigationUI.openMyLists();
            myListsPageObject.openFolderByName(name_of_reading_list);
            myListsPageObject.waitForArticleToAppearByTitle(name_of_reading_list);
        } else if (Platform.getInstance().isIOS()){
            articlePageObject.addArticlesToMySaved();
            articlePageObject.closeArticle();
            searchPageObject.clickCancelSearch();
            myListsPageObject.openSavedArticles();
            myListsPageObject.closeOverlay();
        } else{
            articlePageObject.addArticlesToMySaved();
            AuthorizationPageObject auth = new AuthorizationPageObject(driver);
            auth.clickAuthorizationButton();
            auth.enterLoginData(login, password);
            auth.submitForm();
            articlePageObject.waitForTitleElement();
            assertEquals("we are not on the same page after login",
                    articleTitle,
                    articlePageObject.getArticleTitle()
            );
            articlePageObject.addArticlesToMySaved();
        }
        myListsPageObject.swipeByArticleToDelete(articleTitle);
    }

    @Test
    public void testSaveTwoArticlesDeleteOneCheckOtherTitle() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.waitForSearchResult("Java (programming language)");
        searchPageObject.clickByArticleWithSubstring("Java (programming language)");
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.waitForTitleElement();
        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        MyListsPageObject myListsPageObject = MyListPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            myListsPageObject.openBookmarks();
            articlePageObject.addArticleToNewList(name_of_reading_list);
            navigationUI.moveBack();
        } else {
            articlePageObject.addArticlesToMySaved();
            articlePageObject.closeArticle();
        }
        searchPageObject.clickByArticleWithSubstring("JavaScript");

        if (Platform.getInstance().isAndroid()) {
            myListsPageObject.openBookmarks();
            myListsPageObject.addArticleToExistingReadingList(name_of_reading_list);
            navigationUI.openMyLists();
            myListsPageObject.openFolderByName(name_of_reading_list);

            articlePageObject.waitForArticleByTitlePresent("JavaScript");
            articlePageObject.waitForArticleByTitlePresent("Java (programming language)");
        } else {
            articlePageObject.addArticlesToMySaved();
            articlePageObject.closeArticle();
            searchPageObject.clickCancelSearch();
            myListsPageObject.openSavedArticles();
            myListsPageObject.closeOverlay();
            articlePageObject.waitForArticleByNamePresent("Java (programmin");
            articlePageObject.waitForArticleByNamePresent("JavaScript");
        }
        myListsPageObject.swipeByArticleToDelete("Java (programming language)");
        myListsPageObject.waitForArticleToDisappearByTitle("Java (programming language)");
        myListsPageObject.waitForArticleToAppearByTitle("JavaScript");
    }
}

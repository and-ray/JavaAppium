package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSSearchPageObject extends SearchPageObject {
    static {

        SEARCH_INIT_ELEMENT = "xpath://*[@name='Search Wikipedia']";
        SEARCH_INPUT = "xpath://*[@name='Search Wikipedia']";
        SEARCH_CANCEL_BUTTON = "id:Cancel";
        SEARCH_RESULT_BY_SUBSTRING_TPL =
                "xpath://*[contains(@name,'{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeLink";
        SEARCH_RESULT_ELEMENT_WITH_TITLE = "xpath://XCUIElementTypeLink[contains(@name,'{SUBSTRING}')]";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@name='No results found']";
    }

    public IOSSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}

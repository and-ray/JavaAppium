package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
    static {

        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_CANCEL_BUTTON = "css:button.cancel";
        SEARCH_RESULT_BY_SUBSTRING_TPL =
                "xpath://a[contains(@data-title,'{SUBSTRING}')]";
        SEARCH_RESULT_BY_TITLE_AND_DESCRIPTION_TPL =
                "xpath://ul[contains(@class,'page-list')]/li[@title='{TITLE}']//div[@class='wikidata-description'][contains(text(),'{DESCRIPTION}')]";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        SEARCH_RESULT_ELEMENT_WITH_TITLE = "xpath://ul[@class='page-list']/li[@title='{SUBSTRING}']";
        SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";
    }

    public MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
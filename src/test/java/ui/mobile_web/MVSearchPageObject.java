package ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.SearchPageObject;

public class MVSearchPageObject extends SearchPageObject {
  static {
    SEARCH_INIT_ELEMENT = "css:button#searchIcon";
    SEARCH_INPUT = "css:form>input[type='search']";
    SEARCH_CANCEL_BUTTON = "css:button.cancel";
    SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class,'wikidata-description')][contains(text(),'{SUBSTRING}')]";
    SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
    SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";
    SEARCH_ARTICLE_TITLE = "id:org.wikipedia:id/page_list_item_title";
    SEARCH_RESULT_BY_SUBSTRING_TITLE_DESC_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@resource-id='org.wikipedia:id/page_list_item_title/@text='{TITLE}' and @resource-id='org.wikipedia:id/page_list_item_description/@text='{DESC}']";
  }

  public MVSearchPageObject(RemoteWebDriver driver) {
    super(driver);
  }
}

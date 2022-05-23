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
    SEARCH_ARTICLE_TITLE = "xpath://li[contains(@class,'page-summary')]//h3[contains(@text(),'{TITLE}')]";
    SEARCH_RESULT_BY_SUBSTRING_TITLE_DESC_TPL = "xpath://li[contains(@class,'page-summary')]//h3[contains(@text(),'{TITLE}'] | //div[contains(@class,'wikidata-description')][contains(text(),'{DESC}')]";
  }

  public MVSearchPageObject(RemoteWebDriver driver) {
    super(driver);
  }
}

package ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.MyListsPageObject;

public class MVMyListPageObject extends MyListsPageObject {
  static {
    ARTICLE_BY_TITLE_TPL = "xpath://ul[contains(@class,'watchlist')]//h3[contains(@text(),'{TITLE}')]";
    REMOVE_FROM_SAVED_BUTTON = "xpath://ul[contains(@class,'watchlist')]//h3[contains(@text(),'{TITLE}')]/../../div[contains(@class,'watched')]";
  }

  public MVMyListPageObject(RemoteWebDriver driver) {
    super(driver);
  }
}

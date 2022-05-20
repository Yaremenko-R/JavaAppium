package ui.ios;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.MyListsPageObject;

public class IOSMyListsPageObject extends MyListsPageObject {

  static {
    ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{TITLE}')]";
  }

  public IOSMyListsPageObject(RemoteWebDriver driver) {
    super(driver);
  }
}

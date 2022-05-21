package ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.ArticlePageObject;

public class MVArticlePageObject extends ArticlePageObject {
  static {
    TITLE = "css:#content h1";
    FOOTER_ELEMENT = "css:footer";
    OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#ca-watch";
    OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:#ca-watch";
  }

  public MVArticlePageObject(RemoteWebDriver driver) {
    super(driver);
  }
}

package ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.NavigationUI;

public class MVNavigationUI extends NavigationUI {
  static {
    MY_LISTS_LINK = "xpath://*[@id=\"p-personal\"]/li[2]/a/span[2]";
    OPEN_NAVIGATION = "xpath://*[@id='mw-mf-main-menu-button']";
    MOBILE_VIEW_LINK = "css:#footer-places-mobileview > a";
  }

  public MVNavigationUI(RemoteWebDriver driver) {
    super(driver);
  }
}

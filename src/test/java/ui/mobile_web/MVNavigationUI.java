package ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.NavigationUI;

public class MVNavigationUI extends NavigationUI {
  static {
    MY_LISTS_LINK = "css:a[data-event-name='watchlist']";
    OPEN_NAVIGATION = "css:#mv-mf-main-menu-button";
  }

  public MVNavigationUI(RemoteWebDriver driver) {
    super(driver);
  }
}

package ui.android;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.NavigationUI;

public class AndroidNavigationUI extends NavigationUI {

  static {
    MY_LISTS_LINK = "xpath://android.widget.FrameLayout[@content_desc='My lists']";
  }

  public AndroidNavigationUI(RemoteWebDriver driver) {
    super(driver);
  }
}

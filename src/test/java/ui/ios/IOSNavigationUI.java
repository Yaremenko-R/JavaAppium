package ui.ios;

import org.openqa.selenium.remote.RemoteWebDriver;
import ui.NavigationUI;

public class IOSNavigationUI extends NavigationUI {

  static {
    MY_LISTS_LINK = "id:Saved";
  }

  public IOSNavigationUI(RemoteWebDriver driver) {
    super(driver);
  }
}

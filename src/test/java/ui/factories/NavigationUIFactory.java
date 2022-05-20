package ui.factories;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.NavigationUI;
import ui.android.AndroidNavigationUI;
import ui.ios.IOSNavigationUI;
import ui.mobile_web.MVNavigationUI;

public class NavigationUIFactory {
  public static NavigationUI get(RemoteWebDriver driver) {
    if (Platform.getInstance().isAndroid()) {
      return new AndroidNavigationUI(driver);
    } else if (Platform.getInstance().isIOS()) {
      return new IOSNavigationUI(driver);
    } else {
      return new MVNavigationUI(driver);
    }
  }
}

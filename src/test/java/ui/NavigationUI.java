package ui;

import io.qameta.allure.Step;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject {
  protected static String
          MY_LISTS_LINK,
          OPEN_NAVIGATION,
          MOBILE_VIEW_LINK;

  public NavigationUI(RemoteWebDriver driver) {
    super(driver);
  }

  @Step("Open navigation menu")
  public void openNavigation() {
    if (Platform.getInstance().isMW()) {
      this.waitForElementAndClick(OPEN_NAVIGATION, "Cannot find menu button", 5);
    } else {
      System.out.println("Method scrollWebPageUp() does nothing for platform " + Platform.getInstance().getPlatformVar());
    }
  }

  @Step("Open My Lists")
  public void clickMyLists() {
    if (Platform.getInstance().isMW()) {
      this.tryClickElementWithFewAttempts(
              MY_LISTS_LINK,
              "Cannot find navigation button to My list",
              5);
    } else {
      this.waitForElementAndClick(
              MY_LISTS_LINK,
              "Cannot find navigation button to My list",
              5);
    }
  }

  @Step("Switching to mobile view mode after authorization")
  public void switchToMobileView() {
    if (Platform.getInstance().isMW()) {
      this.waitForElementAndClick(MOBILE_VIEW_LINK, "Cannot find 'Mobile view' link", 5);
    } else {
      System.out.println("Method switchToMobileView() does nothing for platform " + Platform.getInstance().getPlatformVar());
    }
  }
}

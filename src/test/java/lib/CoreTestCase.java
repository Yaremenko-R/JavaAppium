package lib;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.WelcomePageObject;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CoreTestCase {

  protected RemoteWebDriver driver;

  @Before
  @Step("Run driver and session")
  public void setUp() throws Exception {
    driver = Platform.getInstance().getDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    this.rotateScreenPortrait();
    this.skipWelcomePageForIOSApp();
    this.openWikiWebPageForMobileWeb();
  }

  @After
  @Step("Remove driver and session")
  public void tearDown() {
    driver.quit();
  }

  @Step("Rotate screen to portrait mode")
  protected void rotateScreenPortrait() {
    if (driver instanceof AppiumDriver) {
      AppiumDriver driver = (AppiumDriver) this.driver;
      driver.rotate(ScreenOrientation.PORTRAIT);
    } else {
      System.out.println("Method rotateScreenPortrait() does nothing for platform " + Platform.getInstance().getPlatformVar());
    }
  }

  @Step("Rotate screen to landscape mode")
  protected void rotateScreenLandscape() {
    if (driver instanceof AppiumDriver) {
      AppiumDriver driver = (AppiumDriver) this.driver;
      driver.rotate(ScreenOrientation.LANDSCAPE);
    } else {
      System.out.println("Method rotateScreenLandscape() does nothing for platform " + Platform.getInstance().getPlatformVar());
    }
  }

  @Step("Send mobile app to background(this method does nothing for Mobile Web)")
  protected void backgroundApp(int seconds) {
    if (driver instanceof AppiumDriver) {
      AppiumDriver driver = (AppiumDriver) this.driver;
      driver.runAppInBackground(Duration.ofSeconds(seconds));
    } else {
      System.out.println("Method backgroundApp() does nothing for platform " + Platform.getInstance().getPlatformVar());
    }
  }

  @Step("Skipping welcome page(IOS only)")
  private void skipWelcomePageForIOSApp() {
    if (Platform.getInstance().isIOS()) {
      WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
      WelcomePageObject.clickSkip();
    }
  }

  @Step("Open Wikipedia URL for Mobile Web(this method does nothing for IOS and Android)")
  protected void openWikiWebPageForMobileWeb() {
    if (Platform.getInstance().isMW()) {
      driver.get("https://en.m.wikipedia.org");
    } else {
      System.out.println("Method openWikiWebPageForMobileWeb() does nothing for platform " + Platform.getInstance().getPlatformVar());
    }
  }
}

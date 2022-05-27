package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import org.junit.Test;
import ui.WelcomePageObject;

public class GetStartedTest extends CoreTestCase {

  @Test
  @Features(value = {@Feature(value = "IOS Welcome page")})
  @DisplayName("Passing through welcome page")
  @Description("Passing through welcome page")
  @Step("Starting test testPassThroughWelcome")
  @Severity(value = SeverityLevel.CRITICAL)
  public void testPassThroughWelcome() {
    if (Platform.getInstance().isAndroid() || Platform.getInstance().isMW()) {
      return;
    }

    WelcomePageObject WelcomePage = new WelcomePageObject(driver);

    WelcomePage.waitForLearnMoreLink();
    WelcomePage.clickNextButton();

    WelcomePage.waitForNewWaysToExploreText();
    WelcomePage.clickNextButton();

    WelcomePage.waitForAddOrEditPreferredLangText();
    WelcomePage.clickNextButton();

    WelcomePage.waitForLearnMoreAboutDataCollectedText();
    WelcomePage.clickGetStartedButton();
  }
}

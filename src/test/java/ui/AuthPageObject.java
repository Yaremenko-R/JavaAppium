package ui;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthPageObject extends MainPageObject {
  private static final String
          LOGIN_BUTTON = "xpath://*[@id='p-personal']/li/a/span[2]",
          LOGIN_INPUT = "css:input[name='wpName']",
          PASSWORD_INPUT = "css:input[name='wpPassword']",
          SUBMIT_BUTTON = "css:button#wpLoginAttempt";

  public AuthPageObject(RemoteWebDriver driver) {
    super(driver);
  }

  @Step("Clicking authorization button")
  public void clickAuthButton() {
    this.waitForElementPresent(LOGIN_BUTTON, "Cannot find login button", 5);
    this.waitForElementAndClick(LOGIN_BUTTON, "Cannot find and click login button", 5);
  }

  @Step("Entering login data")
  public void enterLoginData(String login, String password) {
    this.waitForElementAndSendKeys(LOGIN_INPUT, login, "Cannot find and put a login to the login input ", 5);
    this.waitForElementAndSendKeys(PASSWORD_INPUT, password, "Cannot find and put a password to the password input ", 5);
  }

  @Step("Clicking submit button")
  public void submitForm() {
    this.waitForElementAndClick(SUBMIT_BUTTON, "Cannot find and click submit button", 5);
  }

}

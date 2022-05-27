package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import org.junit.Assert;
import org.junit.Test;
import ui.ArticlePageObject;
import ui.SearchPageObject;
import ui.factories.ArticlePageObjectFactory;
import ui.factories.SearchPageObjectFactory;

@Epic("Tests for testing application conditions")
public class ChangeAppConditionsTests extends CoreTestCase {
  @Test
  @Features(value = {@Feature(value = "Screen orientation")})
  @DisplayName("Changing the orientation of the screen")
  @Description("Changing the orientation of the screen with search results to portrait mode")
  @Step("Starting test testChangingScreenOrientationOnSearchResults")
  @Severity(value = SeverityLevel.CRITICAL)
  public void testChangingScreenOrientationOnSearchResults() {
    if (Platform.getInstance().isMW()) {
      return;
    }
    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
    ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
    String title_before_rotation = ArticlePageObject.getArticleTitle();
    this.rotateScreenLandscape();
    String title_after_rotation = ArticlePageObject.getArticleTitle();

    Assert.assertEquals(
            "Article title has been changed after rotation",
            title_before_rotation,
            title_after_rotation);

    this.rotateScreenPortrait();
    String title_after_second_rotation = ArticlePageObject.getArticleTitle();

    Assert.assertEquals(
            "Article title has been changed after rotation",
            title_before_rotation,
            title_after_second_rotation);
  }

  @Test
  @Features(value = {@Feature(value = "Working in Background")})
  @DisplayName("Checking search of the article in background")
  @Description("Checking search results after returning application from background")
  @Step("Starting test testCheckSearchArticleInBackground")
  @Severity(value = SeverityLevel.CRITICAL)
  public void testCheckSearchArticleInBackground() {
    if (Platform.getInstance().isMW()) {
      return;
    }
    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.waitForSearchResult("Object-oriented programming language");
    this.backgroundApp(2);
    SearchPageObject.waitForSearchResult("Object-oriented programming language");
  }
}

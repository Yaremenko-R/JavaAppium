package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import org.junit.Assert;
import org.junit.Test;
import ui.ArticlePageObject;
import ui.SearchPageObject;
import ui.factories.ArticlePageObjectFactory;
import ui.factories.SearchPageObjectFactory;

@Epic("Tests for articles")
public class ArticleTests extends CoreTestCase {

  @Test
  @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
  @DisplayName("Compare article title with expected one")
  @Description("We search an article about Java and compare title")
  @Step("Starting test testCompareArticleTitle")
  @Severity(value = SeverityLevel.BLOCKER)
  public void testCompareArticleTitle() {
    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

    ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
    ArticlePageObject.waitForTitleElement();
    String article_title = ArticlePageObject.getArticleTitle();

    ArticlePageObject.takeScreenshot("article_page");

    Assert.assertEquals(
            "Unexpected title",
            "Java (programming language)",
            article_title);
  }

  @Test
  @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
  @DisplayName("Compare article title with expected v.2")
  @Description("We search an article about Java and compare title not waiting title to appear")
  @Step("Starting test testAssertArticleTitleWithNoWait")
  @Severity(value = SeverityLevel.CRITICAL)
  public void testAssertArticleTitleWithNoWait() {
    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

    ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
    ArticlePageObject.getArticleTitleNoWait();
  }

  @Test
  @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
  @DisplayName("Swipe article to the footer")
  @Description("We open an article and swipe it to the footer")
  @Step("Starting test testSwipeArticle")
  @Severity(value = SeverityLevel.NORMAL)
  public void testSwipeArticle() {
    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

    ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
    ArticlePageObject.waitForTitleElement();
    ArticlePageObject.swipeToFooter();
  }
}

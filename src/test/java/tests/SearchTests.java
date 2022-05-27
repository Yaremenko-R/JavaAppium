package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import org.junit.Assert;
import org.junit.Test;
import ui.SearchPageObject;
import ui.factories.SearchPageObjectFactory;

@Epic("Tests for search testing")
public class SearchTests extends CoreTestCase {
  @Test
  @Features(value = {@Feature(value = "Search")})
  @DisplayName("Article search testing")
  @Description("Searching article by keyword")
  @Step("Starting test testSearch")
  @Severity(value = SeverityLevel.BLOCKER)
  public void testSearch() {
    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.waitForSearchResult("bject-oriented programming language");
  }

  @Test
  @Features(value = {@Feature(value = "Search")})
  @DisplayName("Asserting element text")
  @Description("Asserting element has expected text")
  @Step("Starting test testTextCheck")
  @Severity(value = SeverityLevel.CRITICAL)
  public void testTextCheck() {
    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.assertElementText("Search Wikipedia");
  }

  @Test
  @Features(value = {@Feature(value = "Search")})
  @DisplayName("Testing Cancel search button")
  @Description("Testing Cancel search button")
  @Step("Starting test testCancelSearch")
  @Severity(value = SeverityLevel.CRITICAL)
  public void testCancelSearch() {
    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.waitForCancelButtonToAppear();
    SearchPageObject.clickCancelSearch();
    SearchPageObject.waitForCancelButtonToDisappear();
  }

  @Test
  @Features(value = {@Feature(value = "Search")})
  @DisplayName("Testing Cancel search button")
  @Description("Testing Cancel search button by counting search results")
  @Step("Starting test testCancelSearch2")
  @Severity(value = SeverityLevel.CRITICAL)
  public void testCancelSearch2() {
    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

    Assert.assertTrue(
            "We found too few results",
            amount_of_search_results > 1
    );

    SearchPageObject.clickCancelSearch();
    int amount_of_search_results_after_canceling_search = SearchPageObject.getAmountOfFoundArticles();

    Assert.assertEquals("Search result is still present on a page", 0, amount_of_search_results_after_canceling_search);
  }

  @Test
  @Features(value = {@Feature(value = "Search")})
  @DisplayName("Article search testing by title and description")
  @Description("Searching article by title and description")
  @Step("Starting test testSearchByTitleAndDesc")
  @Severity(value = SeverityLevel.NORMAL)
  public void testSearchByTitleAndDesc() {
    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.waitForElementByTitleAndDescription("ava (programming language)", "bject-oriented programming language");
    int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

    Assert.assertTrue(
            "We found too few results",
            amount_of_search_results >= 3
    );
  }

  @Test
  @Features(value = {@Feature(value = "Search")})
  @DisplayName("Searching results correctness checking")
  @Description("Searching results correctness checking")
  @Step("Starting test testSearchResultsCheck")
  @Severity(value = SeverityLevel.NORMAL)
  public void testSearchResultsCheck() {
    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
    String search_line = "JAVA";
    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine(search_line);
    SearchPageObject.checkingSearchResultsCorrectness(search_line);
  }

  @Test
  @Features(value = {@Feature(value = "Search")})
  @DisplayName("Checking of not empty search results")
  @Description("Checking of not empty search results")
  @Step("Starting test testAmountOfNotEmptySearch")
  @Severity(value = SeverityLevel.NORMAL)
  public void testAmountOfNotEmptySearch() {
    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

    SearchPageObject.initSearchInput();
    String search_line = "Linkin Park Discography";
    SearchPageObject.typeSearchLine(search_line);
    int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

    Assert.assertTrue(
            "We found too few results",
            amount_of_search_results > 0
    );
  }

  @Test
  @Features(value = {@Feature(value = "Search")})
  @DisplayName("Checking of empty search results")
  @Description("Checking of empty search results")
  @Step("Starting test testAmountOfNotEmptySearch")
  @Severity(value = SeverityLevel.NORMAL)
  public void testAmountOfEmptySearch() {
    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

    SearchPageObject.initSearchInput();
    String search_line = "fasdfassdfggdgdg";
    SearchPageObject.typeSearchLine(search_line);
    SearchPageObject.waitForEmptyResultsLabel();
    SearchPageObject.assertThereIsNoResultOfSearch();
  }
}

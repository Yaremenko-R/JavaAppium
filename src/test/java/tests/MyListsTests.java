package tests;

import lib.CoreTestCase;
import lib.Platform;
import org.junit.Assert;
import org.junit.Test;
import ui.*;
import ui.factories.ArticlePageObjectFactory;
import ui.factories.MyListsPageObjectFactory;
import ui.factories.NavigationUIFactory;
import ui.factories.SearchPageObjectFactory;

public class MyListsTests extends CoreTestCase {
  private static final String
          name_of_folder = "Learning programming",
          login = "MilaAfina",
          pass = "Adeloida0";

  @Test
  public void testSaveFirstArticleToMyList() {
    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

    ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
    ArticlePageObject.waitForTitleElement();
    String article_title = ArticlePageObject.getArticleTitle();

    if (Platform.getInstance().isAndroid()) {
      ArticlePageObject.addArticleToMyList(name_of_folder);
    } else if (Platform.getInstance().isIOS()) {
      ArticlePageObject.addArticleToMySaved();
    } else {
      NavigationUI NavigationUI = NavigationUIFactory.get(driver);
      NavigationUI.openNavigation();
      AuthPageObject Auth = new AuthPageObject(driver);
      Auth.clickAuthButton();
      Auth.enterLoginData(login, pass);
      Auth.submitForm();
      NavigationUI.switchToMobileView();

      ArticlePageObject.waitForTitleElement();
      Assert.assertEquals("We are not on the same page after login", article_title, ArticlePageObject.getArticleTitle());
      ArticlePageObject.addArticleToMySaved();
    }

    ArticlePageObject.closeArticle();

    NavigationUI NavigationUI = NavigationUIFactory.get(driver);
    NavigationUI.openNavigation();
    NavigationUI.clickMyLists();

    MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
    if (Platform.getInstance().isAndroid()) {
      MyListsPageObject.openFolderByName(name_of_folder);
    }
    MyListsPageObject.swipeByArticleToDelete(article_title);
  }

  @Test
  public void testSaveTwoArticles() {
    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

    SearchPageObject.initSearchInput();
    String search_line = "Java";
    SearchPageObject.typeSearchLine(search_line);
    SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

    ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

    ArticlePageObject.waitForTitleElement();
    String article_title1 = ArticlePageObject.getArticleTitle();

    if (Platform.getInstance().isAndroid()) {
      ArticlePageObject.addArticleToMyList(name_of_folder);
    } else if (Platform.getInstance().isIOS()) {
      ArticlePageObject.addArticleToMySaved();
    } else {
      NavigationUI NavigationUI = NavigationUIFactory.get(driver);
      NavigationUI.openNavigation();
      AuthPageObject Auth = new AuthPageObject(driver);
      Auth.clickAuthButton();
      Auth.enterLoginData(login, pass);
      Auth.submitForm();
      NavigationUI.switchToMobileView();

      ArticlePageObject.waitForTitleElement();
      Assert.assertEquals("We are not on the same page after login", article_title1, ArticlePageObject.getArticleTitle());
      ArticlePageObject.addArticleToMySaved();
    }

    ArticlePageObject.closeArticle();

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine(search_line);
    SearchPageObject.clickByArticleWithSubstring("igh-level programming language");

    ArticlePageObject.waitForTitleElement();
    String article_title2 = ArticlePageObject.getArticleTitle();

    if (Platform.getInstance().isAndroid()) {
      ArticlePageObject.addArticleToMyList(name_of_folder);
    } else {
      ArticlePageObject.addArticleToMySaved();
    }

    ArticlePageObject.closeArticle();

    NavigationUI NavigationUI = NavigationUIFactory.get(driver);
    NavigationUI.openNavigation();
    NavigationUI.clickMyLists();

    MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);

    if (Platform.getInstance().isAndroid()) {
      MyListsPageObject.openFolderByName(name_of_folder);
    }
    MyListsPageObject.swipeByArticleToDelete(article_title1);
    MyListsPageObject.waitForArticleToAppearByTitle(article_title2);
    SearchPageObject.clickByArticleWithSubstring("igh-level programming language");
    String article_title2_after = ArticlePageObject.getArticleTitle();

    Assert.assertEquals(
            "Title of the article in the list '" + name_of_folder + "' is not matching",
            article_title2,
            article_title2_after);
  }
}

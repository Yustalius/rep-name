package ru.bulgakov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class YandexResultsSearchPage {

  private final SelenideElement closeWindow = $(".DistributionButtonClose");

  public YandexResultsSearchPage closeDefaultBrowserSelectWindow() {
    closeWindow.click();

    return this;
  }

  // Кликаем по ссылке и возвращаем WelcomePage — подходит только для перехода на bulgakov qa
  public WelcomePage openLink(String webSiteName) {
    $(byText(webSiteName)).click();

    return new WelcomePage();
  }

  // Кликаем по ссылке и возвращаем WikiPage — отдельный метод конкретно для Википедии
  public WikiPage openWikiLink(String webSiteName) {
    $(byText(webSiteName)).click();

    return new WikiPage();
  }

/* Универсальный метод: кликаем по ссылке и возвращаем любой page object,
   который передали через параметр-класс (generic).
   Не нужно плодить отдельные методы под каждый сайт — один метод на все случаи.
   Пример вызова: .openLinkAs("ru.wikipedia.org", WikiPage.class)*/
  public <T> T openLinkAs(String webSiteName, Class<T> pageClass) {
    $(byText(webSiteName)).click();

    try {
      return pageClass.getDeclaredConstructor().newInstance();
    } catch (Exception e) {
      throw new RuntimeException("Не получилось создать объекта класса: " + pageClass.getName(), e);
    }
  }

}

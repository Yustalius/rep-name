package ru.bulgakov.mentor.qa;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.bulgakov.mentor.pages.WelcomePage;
import ru.bulgakov.mentor.pages.WikiPage;
import ru.bulgakov.mentor.pages.YandexSearchPage;
import ru.bulgakov.webshop.TestBase;

import static com.codeborne.selenide.Selenide.*;

public class SearchTest extends TestBase {
  @Test
  @DisplayName("Проверка 47к")
  @Tag("POSITIVE")
  void mentroingPriceShouldBe47000Test() {
    Configuration.timeout = 5000; //прогрузка элементов
    Configuration.pageLoadTimeout = 5000;//прогрузка страницы

    YandexSearchPage yandexPage = new YandexSearchPage();
    WelcomePage welcomePage = new WelcomePage();
    // Цепочка до клика по ссылке
    open("https://ya.ru/");
    yandexPage.search("bulgakov qa")
        .submit()
        .closeDefaultBrowserSelectWindow()
        .openLink("ivanbulgakovqa.ru");

    // Сайт открылся в новой вкладке — переключаемся на неё прямо в тесте
    switchTo().window(1);

    // Продолжаем работу с WelcomePage уже на новой вкладке
    welcomePage
        .openStudySection()
        .clickTryQaMentor()
        .clickPayment()
        .switchToPayment(2)
        .checkMentorPrice("47 000");
  }

  // Тест с отдельным методом openWikiLink — простой вариант исправления
  @Test
  void birthDateShouldBe25December1642Year() {
    Configuration.timeout = 20000; //прогрузка элементов
    Configuration.pageLoadTimeout = 20000;//прогрузка страницы
    Configuration.browserSize = "1920x1080";

    open("https://ya.ru/", YandexSearchPage.class)
        .search("Исаак ньютон")
        .submit()
        .closeDefaultBrowserSelectWindow()
        .openWikiLink("ru.wikipedia.org")
        .switchToWiki(1)
        .checkPersonBirthDate("25 декабря 1642");
  }

  // Тот же тест, но через generic-метод openLinkAs — улучшенный вариант
  @Test
  void birthDateGenericPageObjectTest() {
    Configuration.timeout = 20000;
    Configuration.pageLoadTimeout = 20000;
    Configuration.browserSize = "1920x1080";

    open("https://ya.ru/", YandexSearchPage.class)
        .search("Исаак ньютон")
        .submit()
        .closeDefaultBrowserSelectWindow()
        .openLinkAs("ru.wikipedia.org", WikiPage.class)
            .switchToWiki(1)
        .checkPersonBirthDate("25 декабря 1642");
  }
}
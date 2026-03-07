package ru.bulgakov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.switchTo;


public class WikiPage {
  private final SelenideElement datePlacement = $$("[data-wikidata-property-id='P569'] span.wikidata-snak span.nowrap").get(0).$("span");

  // Переключаемся на вкладку по индексу (0 — первая вкладка, 1 — вторая и т.д.)
  // Используем Selenide switchTo().window() под капотом, чтобы не прерывать цепочку вызовов
  public WikiPage switchToWiki(int index) {
    switchTo().window(index);
    return this;
  }

  // Проверяем дату рождения — передаём ожидаемое значение аргументом, а не хардкодим
  public WikiPage checkPersonBirthDate(String expectedDate) {
    datePlacement.shouldHave(text(expectedDate));
    return this;
  }

}

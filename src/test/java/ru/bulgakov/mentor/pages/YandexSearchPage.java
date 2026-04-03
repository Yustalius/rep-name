package ru.bulgakov.mentor.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;


public class YandexSearchPage {
  private final SelenideElement searchInput = $("#text"),
                                submitButton = $("[type=submit]");

    @Step("Ввод данных в поиск {query}")
  public YandexSearchPage search(String query) {
    searchInput.setValue(query); //яндекс поиск
    return this;
  }

  @Step("Поиск результата")
  public YandexResultsSearchPage submit() {
    submitButton.click();
    return new YandexResultsSearchPage();
  }
}

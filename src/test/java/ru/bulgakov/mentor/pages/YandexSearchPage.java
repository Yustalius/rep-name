package ru.bulgakov.mentor.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;


public class YandexSearchPage {
  private final SelenideElement searchInput = $("#text"),
                                submitButton = $("[type=submit]");

  public YandexSearchPage search(String query) {
    searchInput.setValue(query); //яндекс поиск
    return this;
  }

  public YandexResultsSearchPage submit() {
    submitButton.click();
    return new YandexResultsSearchPage();
  }
}

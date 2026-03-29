package ru.bulgakov.mentor.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PaymentPage {
  private final SelenideElement pricePlacement = $(".styles-module-scss-module__t92_WG__price h2");

  // Переключаемся на вкладку по индексу, не прерывая цепочку
  public PaymentPage switchToPayment(int index) {
    switchTo().window(index);
    return this;
  }

  // Проверяем цену — передаём ожидаемое значение аргументом, а не хардкодим
  public PaymentPage checkMentorPrice(String expectedPrice) {
    pricePlacement.shouldHave(text(expectedPrice));
    return this;
  }
}

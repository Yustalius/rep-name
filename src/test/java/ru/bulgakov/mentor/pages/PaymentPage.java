package ru.bulgakov.mentor.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PaymentPage {
  private final SelenideElement pricePlacement = $(".styles-module-scss-module__t92_WG__price h2");

  // Переключаемся на вкладку по индексу, не прерывая цепочку
  @Step("Переход на страничку оплаты")
  public PaymentPage switchToPayment(int index) {
    switchTo().window(index);
    return this;
  }

  // Проверяем цену — передаём ожидаемое значение аргументом, а не хардкодим
  @Step("Проверка цены менторства {expectedPrice}")
  public PaymentPage checkMentorPrice(String expectedPrice) {
    pricePlacement.shouldHave(text(expectedPrice));
    return this;
  }
}

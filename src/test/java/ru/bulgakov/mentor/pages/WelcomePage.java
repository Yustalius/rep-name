package ru.bulgakov.mentor.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class WelcomePage {
  private final SelenideElement tryQaMentorButton = $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a"),
                                payButtonText = $(byText("Бегу оплачивать")),
                                priceMenuButton = $$(".t-menu__list li").last();

    @Step("Открытие учебной секции")
  public WelcomePage openStudySection() {
    priceMenuButton.click();
    return this;
  }

    @Step("Нажатие на 'Попробовать ментора'")
  public WelcomePage clickTryQaMentor() {
    tryQaMentorButton.click();
    return this;
  }

    @Step("Нажатие на 'Оплата'")
  public PaymentPage clickPayment() {
    payButtonText.click();

    return new PaymentPage();
  }
}
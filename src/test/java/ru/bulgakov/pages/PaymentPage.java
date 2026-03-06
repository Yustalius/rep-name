package ru.bulgakov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PaymentPage {
    private final SelenideElement pricePlacement =  $(".styles-module-scss-module__t92_WG__price h2");
    private final String price =  "48 000";


    public PaymentPage checkMentorPrice() {
        switchTo().window(2);
        pricePlacement.shouldHave(text(price)); // страница оплаты

return this;
    }
}

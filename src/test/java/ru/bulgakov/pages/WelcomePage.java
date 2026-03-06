package ru.bulgakov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class WelcomePage {
    private final SelenideElement tryQaMentorButton =  $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a");
    private final SelenideElement payButtonText =  $(byText("Бегу оплачивать"));


    public WelcomePage enterWelcomePage() {

        sleep(3000);
        switchTo().window(1);
        $$(".t-menu__list li").last().click(); // welcome page for study.
        tryQaMentorButton.click(); //xpath
        return this;
    }

    public WikiPage locateWiki () {

        return new WikiPage();
    }

    public PaymentPage clickPayment () {
        payButtonText.click();

        return new PaymentPage();
    }
}
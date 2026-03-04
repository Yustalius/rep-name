package ru.bulgakov.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class WelcomePage {


    public WelcomePage clickPrice() {
        sleep(3000);


        switchTo().window(1);
        $$(".t-menu__list li").last().click(); // welcome page for study.
        $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a").click(); //xpath
        $(byText("Бегу оплачивать")).click();

        switchTo().window(2);
        $(".styles-module-scss-module__t92_WG__price h2").shouldHave(text("47 000")); // страница оплаты

return this;
    }
}
// Welcome Page
//Payment Page
//Последний метод verifyPage
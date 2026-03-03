package ru.bulgakov.qa;



import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest {
@Test
    void mentroingPriceShouldBe47000Test() {
    Configuration.timeout = 100000; //прогрузка элементов
    Configuration.pageLoadTimeout = 100000;//прогрузка страницы

    /*
     * Тест-кейс -проверить, что предоплата 47к
     * 1.открыть поисковик
     * 2.ввести данные сайта (булгаков ква)
     * 3.кнопка поисковика
     * 4. найти нужный сайт, click
     * 5. нажать на стоимость
     * 6. нажать на "Вкатиться"
     * 7. нажать на "Бегу оплачивать"
     * 8. 47k
     *
     * */
    Configuration.holdBrowserOpen = true;
    open("https://ya.ru/");
    $("#text").setValue("bulgakov qa"); //яндекс поиск
    $("[type=submit]").click();
$(".DistributionButtonClose").click(); //поисковая выдача
$(byText("ivanbulgakovqa.ru")).click();
sleep(3000);


    switchTo().window(1);
    $$(".t-menu__list li").last().click(); // welcome page for study.
    $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a").click(); //xpath
    $(byText("Бегу оплачивать")).click();

    switchTo().window(2);
$(".styles-module-scss-module__t92_WG__price h2").shouldHave(text("47 000")); // страница оплаты
}}


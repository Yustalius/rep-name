package ru.bulgakov.qa;



import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.bulgakov.pages.YandexResultsSearchPage;
import ru.bulgakov.pages.YandexSearchPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest {
@Test
@DisplayName("Проверка 47к")
@Tag("POSITIVE")
    void mentroingPriceShouldBe47000Test() {
    Configuration.timeout = 100000; //прогрузка элементов
    Configuration.pageLoadTimeout = 100000;//прогрузка страницы


    Configuration.holdBrowserOpen = true;
    open("https://ya.ru/", YandexSearchPage.class)
            .search("bulgakov qa")
            .submit()
            .closeDefaultBrowserSelectWindow()
            .openLink("ivanbulgakovqa.ru")
            .clickPrice();

}}


package ru.bulgakov.mentor.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class YandexResultsSearchPage {

    private final SelenideElement closeWindow = $(".DistributionButtonClose");


        @Step("Закрытие попапа о дефолтном браузере яндекс")
    public YandexResultsSearchPage closeDefaultBrowserSelectWindow() {
        closeWindow.click();

        return this;
    }

    // Кликаем по ссылке и возвращаем WelcomePage — подходит только для перехода на bulgakov qa
    @Step("Открытие странички bulgakov.qa")
    public WelcomePage openLink(String webSiteName) {
        $(byText(webSiteName)).click();

        return new WelcomePage();
    }

    // Кликаем по ссылке и возвращаем WikiPage — отдельный метод конкретно для Википедии
    @Step("Открытие странички википедии")
    public WikiPage openWikiLink(String webSiteName) {
        $(byText(webSiteName)).click();

        return new WikiPage();
    }

    /* Универсальный метод: кликаем по ссылке и возвращаем любой page object,
       который передали через параметр-класс (generic).
       Не нужно плодить отдельные методы под каждый сайт — один метод на все случаи.
       Пример вызова: .openLinkAs("ru.wikipedia.org", WikiPage.class)*/
    @Step("Открытие странички")
    public <T> T openLinkAs(String webSiteName, Class<T> pageClass) {
        $(byText(webSiteName)).click();

        try {
            return pageClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Не получилось создать объекта класса: " + pageClass.getName(), e);
        }
    }

}

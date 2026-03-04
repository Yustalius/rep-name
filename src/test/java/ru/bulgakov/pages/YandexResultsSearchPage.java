package ru.bulgakov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class YandexResultsSearchPage {

        private final SelenideElement closeWindow = $(".DistributionButtonClose");

        public YandexResultsSearchPage closeDefaultBrowserSelectWindow() {
            closeWindow.click();

            return this;
        }

        public WelcomePage openLink(String webSiteName) {
            $(byText(webSiteName)).click();

            return WelcomePage;
        }







}

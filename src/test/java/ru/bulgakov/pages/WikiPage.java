package ru.bulgakov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class WikiPage {
private final SelenideElement datePlacement = $$("[data-wikidata-property-id='P569'] span.wikidata-snak span.nowrap").get(0).$("span");
    //   $(".cdx-message__content a").shouldHave(text(date));

private final String date = "25 декабря 1642";

    public WikiPage checkPersonBirthDate() {
        datePlacement.shouldHave(text(date));
    return this;
    }


}

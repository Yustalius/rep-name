package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsWelcomePage {

    private final SelenideElement registerButton = $("a.ico-register");
    private final SelenideElement signInButton = $("a.ico-login");
    private final ElementsCollection headerLinks = $$("div.header-links ul li a");
    private final ElementsCollection headbarMenuButtons = $$("ul.top-menu li a");
    private final SelenideElement desktopsButton = $(byText("Desktops"));

    public WsRegistrationPage openRegistration() {
        registerButton.click();

        return new WsRegistrationPage();
    }

    public WsLoginPage entryLoginPanel() {
        signInButton.click();
        return new WsLoginPage();
    }

    public WsWelcomePage checkUserLoggedIn(String email) {
        headerLinks.get(0).shouldHave(text(email));
        return this;
    }

    public WsWelcomePage hoverComputerMenu() {
        headbarMenuButtons.get(1).hover();
        return this;
    }

    public WsCatalogPage clickComputerButton() {
        desktopsButton.click();
        return new WsCatalogPage();
    }
}

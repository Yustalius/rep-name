package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsWelcomePage {

private final SelenideElement registerButton =  $("a.ico-register");
private final SelenideElement signInButton  =  $("a.ico-login");
private final ElementsCollection headerLinks =  $$("div.header-links ul li a");

    public WsRegistrationPage openRegistration(){
        registerButton.click();

        return new WsRegistrationPage();
    }

    public WsLoginPage entryLoginPanel() {
        signInButton.click();
        return new WsLoginPage() ;
    }
    public WsWelcomePage checkUserLoggedIn(String email) {
        headerLinks.get(0).shouldHave(text(email));
        return this;
    }
}

package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsLoginPage {
    private final SelenideElement pageTitle  =  $("div.page-title h1");
    private final SelenideElement emailInput = $("input#Email");
    private final SelenideElement passwordInput = $("input#Password");
    private final SelenideElement rememberMeCheckbox = $("input#RememberMe");
    private final SelenideElement loginButton =  $("input.login-button");


    public WsLoginPage verifySignIn() {
        pageTitle.shouldHave(text("Welcome, Please Sign In!"));
        return this;
    }

    @Step("Ввести электронную почту {email}")
    public WsLoginPage enterEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Ввести пароль {password}")
    public WsLoginPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public WsLoginPage rememberMeCheck() {
        rememberMeCheckbox.click();
        return this;
    }

    @Step("Подтверждение авторизации")
    public WsWelcomePage submitLogin() {
        loginButton.click();
        return new WsWelcomePage();
    }

    @Step("Появление сообщения  с ошибкой валидации почты")
    public WsLoginPage verifyValidatiionErrorMessage() {
        $("span.field-validation-error").shouldBe(visible);
        return this;
    }


    public WsWelcomePage login(String email, String password, boolean rememberMe) {
enterEmail(email).enterPassword(password);

if (rememberMe) {
    rememberMeCheck();
}

        return submitLogin();
    }
}

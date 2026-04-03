package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsRegistrationPage {
    private final SelenideElement maleGenderRadio  =  $("input#gender-male");
    private final SelenideElement pageTitle  =  $("div.page-title h1");
    private final SelenideElement firstNameInput = $("input#FirstName");
    private final SelenideElement lastNameInput = $("input#LastName");
    private final SelenideElement emailInput = $("input#Email");
    private final SelenideElement passwordInput = $("input#Password");
    private final SelenideElement confirmPasswordInput = $("input#ConfirmPassword");
    private final SelenideElement submitRegistrationButton =  $("input#register-button");
    private final SelenideElement resultText =  $("div.result");


    @Step("Быстрая регистрация")
    public WsWelcomePage register(String firstname, String lastname, String email, String password) {
                selectMaleGender()
                .enterFirstName(firstname)
                .enterLastName(lastname)
                .enterEmail(email)
                .enterPassword(password)
                .enterConfirmPassword(password)
                .submitRegistration()
                .checkRegistrationCompleted();

        return new WsWelcomePage();
    }
    @Step("Подтверждение нахождения на страничке регистрации")
    public WsRegistrationPage verifyRegisterOpening() {
        pageTitle.shouldHave(text("Register"));
        return this;
    }
    @Step("Выбор мужского пола")
    public WsRegistrationPage selectMaleGender() {
        maleGenderRadio.click();
        return this;
    }

    @Step("Ввод имени {firstName}")
    public WsRegistrationPage enterFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }
    @Step("Ввод фамилии {lastName}")
    public WsRegistrationPage enterLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }
    @Step("Ввод электронной почты {email}")
    public WsRegistrationPage enterEmail(String email) {
        emailInput.setValue(email);
        return this;
    }
    @Step("Ввод пароля {password}")
    public WsRegistrationPage enterPassword (String password) {
        passwordInput.setValue(password);
        return this;
    }
    @Step("Ввод повторного подтверждающего пароля ")
    public WsRegistrationPage enterConfirmPassword(String password) {
        confirmPasswordInput.setValue(password);
        return this;
    }
    @Step("Нажатие на подтверждение регистрации")
    public WsRegistrationPage submitRegistration() {
        submitRegistrationButton.click();
        return this;
    }
    @Step("Сообщение о успешной регистрации")
    public WsWelcomePage checkRegistrationCompleted() {
        resultText.shouldHave(text("Your registration completed"));
        return new WsWelcomePage();
    }
}

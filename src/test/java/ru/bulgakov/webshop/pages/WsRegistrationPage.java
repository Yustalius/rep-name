package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.SelenideElement;

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

    public WsRegistrationPage verifyRegisterOpening() {
        pageTitle.shouldHave(text("Register"));
        return this;
    }

    public WsRegistrationPage selectMaleGender() {
        maleGenderRadio.click();
        return this;
    }

    public WsRegistrationPage enterFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }
    public WsRegistrationPage enterLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }
    public WsRegistrationPage enterEmail(String email) {
        emailInput.setValue(email);
        return this;
    }
    public WsRegistrationPage enterPassword (String password) {
        passwordInput.setValue(password);
        return this;
    }
    public WsRegistrationPage enterConfirmPassword(String password) {
        confirmPasswordInput.setValue(password);
        return this;
    }
    public WsRegistrationPage submitRegistration() {
        submitRegistrationButton.click();
        return this;
    }
    public WsWelcomePage checkRegistrationCompleted() {
        resultText.shouldHave(text("Your registration completed"));
        return new WsWelcomePage();
    }
}

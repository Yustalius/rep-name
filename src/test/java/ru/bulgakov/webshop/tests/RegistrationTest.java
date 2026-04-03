package ru.bulgakov.webshop.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.bulgakov.webshop.TestBase;
import ru.bulgakov.webshop.pages.WsWelcomePage;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static ru.bulgakov.webshop.config.Config.WEB_SHOP_URL;

public class RegistrationTest extends TestBase {
    private static final Faker  faker = new Faker();



    @Test
    @Tag("positive")
    @Severity(CRITICAL)
    @DisplayName("Успешная регистрация нового пользователя")
    @Owner("Kirill S.")
    @Link("TASK-220")
    @Epic("Authorization")
    @Story("Регистрация пользователя")
    @Feature("Authorization")
    @Description("Создаем пользователя через интерфейс")
    void registartionTest(){
        String password = faker.harryPotter().character() + faker.number().positive();
        String email = faker.internet().emailAddress();

        open(WEB_SHOP_URL, WsWelcomePage.class)
                .openRegistration()
                .verifyRegisterOpening()
                .selectMaleGender()
                .enterFirstName(faker.name().firstName())
                .enterLastName(faker.name().lastName())
                .enterEmail(email)
                .enterPassword(password)
                .enterConfirmPassword(password)
                .submitRegistration()
                .checkRegistrationCompleted()
                .checkUserLoggedIn(email);

    }
}

package ru.bulgakov.webshop.tests;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bulgakov.webshop.TestBase;
import ru.bulgakov.webshop.pages.WsWelcomePage;

import static com.codeborne.selenide.Selenide.*;
import static ru.bulgakov.webshop.config.Config.WEB_SHOP_REGISTRATION_URL;
import static ru.bulgakov.webshop.config.Config.WEB_SHOP_URL;

public class LoginTest extends TestBase {
    private static final Faker faker = new Faker();
    private String email;
    private String password;

    @BeforeEach
    void beforeAll(){
         password = faker.harryPotter().character() + faker.number().positive();
         email = faker.internet().emailAddress();

        open(WEB_SHOP_REGISTRATION_URL, ru.bulgakov.webshop.pages.WsRegistrationPage.class)
                .register(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        email,
                        password)
                .checkUserLoggedIn(email);

        clearBrowserLocalStorage();
        clearBrowserCookies();
    }

    @Test
    void succesLoginTest(){

        open(WEB_SHOP_URL, WsWelcomePage.class)
                .entryLoginPanel()
                .verifySignIn()
                .enterEmail(email)
                .enterPassword(password)
                .rememberMeCheck()
                .submitLogin()
                .checkUserLoggedIn(email);




        sleep(50000);

    }
}

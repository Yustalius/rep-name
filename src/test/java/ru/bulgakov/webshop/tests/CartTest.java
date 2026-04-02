package ru.bulgakov.webshop.tests;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bulgakov.mentor.pages.WelcomePage;
import ru.bulgakov.webshop.TestBase;
import ru.bulgakov.webshop.pages.WsCartPage;
import ru.bulgakov.webshop.pages.WsProductPage;
import ru.bulgakov.webshop.pages.WsWelcomePage;
import ru.bulgakov.webshop.steps.AuthSteps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.bulgakov.webshop.config.Config.WEB_SHOP_URL;

public class CartTest extends TestBase {
    private static final Faker faker = new Faker();
    private final AuthSteps authSteps = new AuthSteps();
    private String itemQuantity = "2";
    private Integer index = 1;


    @BeforeEach
    void beforeEach() {
        authSteps.registerNewUser();
    }

    @Test
    void POaddItemCartTest() {

        WsProductPage productPage = new WsProductPage();

        open(WEB_SHOP_URL, WsWelcomePage.class)
                .hoverComputerMenu()
                .clickComputerButton()
                .selectCertainProduct()
                .changeProccessorType(index);

                 String itemName = $("[itemprop=name]").getText();
                 String itemPrice = $("[itemprop=price]").getText();
                 String processorPrice = $$("dl dd ul").get(0).$$("li label").get(index).getText();

                 productPage.inputItemQuantity(itemQuantity)
                .submitToCart()
                .verifyNotificationSuccessMessage()
                .checkHeadbarCartItemQuantity(itemQuantity)
                .enterCartMenu()
                .verifyItemName(itemName)
                .verifyCartItemQuantity(itemQuantity)
                .verifyCartValue(itemPrice, itemQuantity, processorPrice);
    }
    @Test
    void addItemToCartTest() {
        open(WEB_SHOP_URL);
        //hoverComputerMenu
        $$("ul.top-menu li a").get(1).hover();
        //Click Desktops
        $(byText("Desktops")).click();
        //click First product
        $$("div.product-grid div").get(0).click();

        String itemName = $("[itemprop=name]").getText();
        String itemPrice = $("[itemprop=price]").getText();
        String itemQuantity = "2";

        //ItemQuantityInput
        $("input.qty-input").setValue(itemQuantity);
        //AddToCart
        //notificationSuccessMessage
        //checkHeadbarCartItemQuantity
        //ChangeProccessorType
        $$("dl dd ul").get(0).$$("li input").get(0).click();
        //ClickCartButton
        $("input.add-to-cart-button").click();
        $("span.cart-qty").shouldHave(text("(" + itemQuantity + ")"));

        $("div.bar-notification.success").shouldBe(visible);
        $("a.ico-cart").click();
        //CheckItemName
        $("a.product-name").shouldHave(text(itemName));
        //CheckCartItemQuantity
        String itemQuantityInCart = $("input.qty-input").getAttribute("value");
        assertEquals(itemQuantity, itemQuantityInCart);
        //CheckCartValue
        $("span.product-subtotal").shouldHave(text(String.valueOf
                (Float.parseFloat(itemPrice) * Float.parseFloat(itemQuantity))));
    }
}

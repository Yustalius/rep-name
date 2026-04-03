package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WsCartPage {
    // TO DO PROCESSOR private final ElementsCollection headbarMenuButtons  =  $$("ul.top-menu li a");
    private final SelenideElement cartItemName  = $("a.product-name");
    private final SelenideElement cartItemQuantity  = $("input.qty-input");
    private final SelenideElement cartSubtotal  = $("span.product-subtotal");



    //WELCOME PAGE -> CATALOG PAGE -> PRODUCT PAGE -> CART PAGE

    //CARTPAGE
    @Step("Подтверждение наименования товара {itemName}")
    public WsCartPage verifyItemName(String itemName) {
        cartItemName.shouldHave(text(itemName));
        return this;
    }
    @Step("Подтверждение количество товара {itemQuantity}")
    public WsCartPage verifyCartItemQuantity (String itemQuantity) {
        String itemQuantityInCart = cartItemQuantity.getAttribute("value");
        assertEquals(itemQuantity, itemQuantityInCart);
        return this;
    }

    @Step("Подтверждение цены товара")
    public WsCartPage verifyCartValue(String itemPrice, String itemQuantity, String processorPrice) {

        float processorValue = 0f;
        Pattern pattern = Pattern.compile("[-+]?\\d*\\.?\\d+");
        Matcher matcher = pattern.matcher(processorPrice);

        if (matcher.find()) {
            processorValue = Float.parseFloat(matcher.group());
            System.out.println(processorValue); // 15.0
        } else {
            System.out.println("slow processor"); // 15.0
        }
        float price = Float.parseFloat(itemPrice);
        float quantity = Float.parseFloat(itemQuantity);
        float expectedTotal = (price+processorValue) * quantity ;


        cartSubtotal.shouldHave(text(String.valueOf(expectedTotal)));
        return this;
    }


}

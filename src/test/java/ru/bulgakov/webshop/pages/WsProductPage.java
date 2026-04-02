package ru.bulgakov.webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsProductPage {
    private final SelenideElement catalogItemName  =  $("[itemprop=name]");
    private final SelenideElement catalogItemPrice  =  $("[itemprop=price]");
    private final SelenideElement quantityInput  = $("input.qty-input");
    private final SelenideElement addCartButton  = $("input.add-to-cart-button");
    private final SelenideElement successNotification  = $("div.bar-notification.success");
    private final SelenideElement headbarItemQuantity  = $("span.cart-qty");
    private final SelenideElement cartButton  = $("a.ico-cart");

    // TO DO PROCESSOR private final ElementsCollection headbarMenuButtons  =  $$("ul.top-menu li a");


    //WELCOME PAGE -> CATALOG PAGE -> PRODUCT PAGE -> CART PAGE

    //PRODUCT
    public WsProductPage inputItemQuantity(String itemQuantity) {
        quantityInput.setValue(itemQuantity);
        return this;
    }
    public WsProductPage submitToCart() {
        addCartButton.click();
        return this;
    }
    public WsProductPage verifyNotificationSuccessMessage() {
        successNotification.shouldBe(visible);
        return this;
    }
    public WsProductPage checkHeadbarCartItemQuantity(String itemQuantity) {
        headbarItemQuantity.shouldHave(text("(" + itemQuantity + ")"));
        return this;
    }
    public WsProductPage changeProccessorType(int index) {
        $$("dl dd ul").get(0).$$("li input").get(index).click();
        return this;
    }
    public WsCartPage enterCartMenu() {
        cartButton.click();
        return new WsCartPage();
    }

}

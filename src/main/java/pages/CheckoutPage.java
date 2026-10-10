package pages;

import dataHelper.Data;
import dataHelper.ProductData;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage extends BasePage {
    public CheckoutPage() {
        $("#cart_items").shouldBe(visible).shouldHave(text("Address Details"), text("Review Your Order"));
    }

    public CheckoutPage shouldHaveAddresses(Data.RegistrationData data) {
        for (String id : new String[]{"#address_delivery", "#address_invoice"}) {
            var address = $(id).shouldBe(visible);
            address.$(".address_firstname").shouldHave(exactText("Mr. " + data.getFirstName() + " " + data.getLastName()));
            var lines = address.$$(".address_address1");
            lines.get(0).shouldHave(exactText(data.getCompany()));
            lines.get(1).shouldHave(exactText(data.getAddress1()));
            lines.get(2).shouldHave(exactText(data.getAddress2()));
            address.$(".address_city").shouldHave(text(data.getCity()), text(data.getState()), text(data.getZipCode()));
            address.$(".address_country_name").shouldHave(exactText("Israel"));
            address.$(".address_phone").shouldHave(exactText(data.getPhoneNumber()));
        }
        return this;
    }

    public CheckoutPage shouldContain(ProductData product, int quantity) {
        var row = $("#product-" + product.getId());
        row.$(".cart_description h4").shouldHave(exactText(product.getName()));
        row.$(".cart_price").shouldHave(exactText(product.getPrice()));
        row.$(".cart_quantity button").shouldHave(exactText(String.valueOf(quantity)));
        row.$(".cart_total_price").shouldHave(exactText(product.totalFor(quantity)));
        return this;
    }

    public PaymentPage placeOrder(String comment) {
        $("textarea[name='message']").setValue(comment);
        $("a[href='/payment']").click();
        return new PaymentPage();
    }
}

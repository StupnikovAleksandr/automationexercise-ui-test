package pages;

import dataHelper.ProductData;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CartPage extends BasePage {
    public CartPage() {
        $("#cart_items").shouldBe(visible);
        $(".breadcrumbs").shouldHave(text("Shopping Cart"));
    }

    public CartPage shouldContain(ProductData product, int quantity) {
        var row = $("#product-" + product.getId()).shouldBe(visible);
        row.$(".cart_description h4").shouldHave(exactText(product.getName()));
        row.$(".cart_price").shouldHave(exactText(product.getPrice()));
        row.$(".cart_quantity button").shouldHave(exactText(String.valueOf(quantity)));
        row.$(".cart_total_price").shouldHave(exactText(product.totalFor(quantity)));
        return this;
    }

    public CartPage shouldHaveProductCount(int count) {
        $("#cart_info_table tbody").$$("tr").shouldHave(size(count));
        return this;
    }

    public CartPage removeProduct(ProductData product) {
        $("#product-" + product.getId()).$(".cart_quantity_delete").click();
        $("#product-" + product.getId()).shouldNot(exist);
        return this;
    }

    public SignupLoginPage proceedToCheckoutAsGuest() {
        $(".check_out").click();
        $("#checkoutModal").shouldBe(visible).$("a[href='/login']").click();
        return new SignupLoginPage();
    }

    public CheckoutPage proceedToCheckout() {
        $(".check_out").click();
        return new CheckoutPage();
    }
}

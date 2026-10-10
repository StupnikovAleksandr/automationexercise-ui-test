package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AddedToCartModal {
    public AddedToCartModal() {
        $("#cartModal").shouldBe(visible);
    }

    public void continueShopping() {
        $("#cartModal .close-modal").click();
        $("#cartModal").shouldNotBe(visible);
    }

    public CartPage viewCart() {
        $("#cartModal a[href='/view_cart']").click();
        return new CartPage();
    }
}

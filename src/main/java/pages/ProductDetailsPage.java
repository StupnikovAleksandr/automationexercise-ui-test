package pages;

import dataHelper.ProductData;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage() {
        $(".product-information").shouldBe(visible);
    }

    public ProductDetailsPage shouldShowDetails(ProductData expected) {
        var info = $(".product-information");
        info.$("h2").shouldHave(exactText(expected.getName()));
        info.$("span span").shouldHave(exactText(expected.getPrice()));
        info.shouldHave(text("Category:"), text("Availability:"), text("Condition:"), text("Brand:"));
        for (String label : new String[]{"Category", "Availability", "Condition", "Brand"}) {
            info.$$("p").findBy(text(label + ":"))
                    .shouldHave(matchText(label + ":\\s*\\S.*"));
        }
        return this;
    }

    public AddedToCartModal addToCart(int quantity) {
        $("#quantity").setValue(String.valueOf(quantity));
        $("button.cart").click();
        return new AddedToCartModal();
    }

    public ProductDetailsPage submitReview(String name, String email, String review) {
        $("a[href='#reviews']").shouldHave(text("Write Your Review"));
        $("#name").setValue(name);
        $("#email").setValue(email);
        $("#review").setValue(review);
        $("#button-review").click();
        $("#review-section").shouldBe(visible).shouldHave(text("Thank you for your review."));
        return this;
    }
}

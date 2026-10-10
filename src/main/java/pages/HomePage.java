package pages;

import dataHelper.ProductData;
import pages.components.ProductList;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HomePage extends BasePage {
    public HomePage() {
        $("#slider").shouldBe(visible);
    }

    public HomePage shouldBeLoggedIn() {
        $("header a[href='/delete_account']").shouldBe(visible);
        $("header a[href='/logout']").shouldBe(visible);
        $("header").shouldHave(text("Logged in as"));
        return this;
    }

    public HomePage shouldBeLoggedInAs(String name) {
        shouldBeLoggedIn();
        $("header li a b").shouldHave(exactText(name));
        return this;
    }

    public SignupLoginPage logout() {
        $("header a[href='/logout']").click();
        return new SignupLoginPage();
    }

    public ProductList products() {
        return new ProductList($(".features_items"));
    }

    public ProductData recommendedProduct() {
        var section = $(".recommended_items");
        section.scrollIntoView(false).$("h2").shouldHave(text("RECOMMENDED ITEMS"));
        section.hover();
        var card = section.$(".item.active .product-image-wrapper");
        return new ProductData(card.$(".add-to-cart").getAttribute("data-product-id"),
                card.$("p").getText(), card.$("h2").getText());
    }

    public AddedToCartModal addRecommendedProduct(ProductData product) {
        $(".recommended_items .item.active .add-to-cart[data-product-id='" + product.getId() + "']").click();
        return new AddedToCartModal();
    }

    public HomePage scrollUpUsingArrow() {
        $("#scrollUp").shouldBe(visible).click();
        return this;
    }

    public HomePage scrollToTop() {
        executeJavaScript("window.scrollTo(0, 0)");
        return this;
    }

    public HomePage shouldShowHeroInViewport() {
        $("#slider .item.active h2").shouldHave(text("Full-Fledged practice website for Automation Engineers"));
        $("#slider").shouldBe(visible);
        // Visibility alone does not prove that the page has scrolled to the top.
        com.codeborne.selenide.Selenide.Wait().until(driver ->
                ((Number) executeJavaScript("return window.pageYOffset")).longValue() < 100);
        return this;
    }
}

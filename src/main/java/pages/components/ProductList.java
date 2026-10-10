package pages.components;

import com.codeborne.selenide.SelenideElement;
import dataHelper.ProductData;
import pages.AddedToCartModal;
import pages.ProductDetailsPage;
import java.util.List;
import java.util.stream.Collectors;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;

public class ProductList {
    private final SelenideElement root;

    public ProductList(SelenideElement root) {
        this.root = root;
    }

    public ProductList shouldBeVisible() {
        root.$$(".product-image-wrapper").shouldHave(sizeGreaterThan(0));
        root.$(".product-image-wrapper").shouldBe(visible);
        return this;
    }

    public ProductData product(int index) {
        var card = root.$$(".product-image-wrapper").get(index);
        return new ProductData(card.$(".add-to-cart").getAttribute("data-product-id"),
                card.$(".productinfo p").getText(), card.$(".productinfo h2").getText());
    }

    public List<ProductData> allProducts() {
        shouldBeVisible();
        return java.util.stream.IntStream.range(0, root.$$(".product-image-wrapper").size())
                .mapToObj(this::product).collect(Collectors.toList());
    }

    public ProductList shouldMatchSearch(String query) {
        shouldBeVisible();
        root.$$(".productinfo p").shouldHave(allMatch("names contain " + query,
                element -> element.getText().toLowerCase().contains(query.toLowerCase())));
        return this;
    }

    public ProductDetailsPage viewProduct(int index) {
        root.$$(".product-image-wrapper").get(index).$("a[href^='/product_details/']")
                .scrollIntoView(false).click();
        return new ProductDetailsPage();
    }

    public AddedToCartModal addToCart(int index) {
        var card = root.$$(".product-image-wrapper").get(index);
        card.scrollIntoView(false).hover();
        card.$(".product-overlay .add-to-cart").shouldBe(visible).click();
        return new AddedToCartModal();
    }
}

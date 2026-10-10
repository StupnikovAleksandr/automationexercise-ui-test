package pages;

import pages.components.ProductList;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ProductsPage extends BasePage {
    public ProductsPage() {
        $(".features_items h2.title").shouldBe(visible).shouldHave(text("ALL PRODUCTS"));
        products().shouldBeVisible();
    }

    public ProductList products() {
        return new ProductList($(".features_items"));
    }

    public ProductsPage search(String query) {
        $("#search_product").setValue(query);
        $("#submit_search").click();
        $(".features_items h2.title").shouldHave(text("SEARCHED PRODUCTS"));
        return this;
    }

    public FilteredProductsPage selectCategory(String group, String category) {
        return new CatalogSidebar().selectCategory(group, category);
    }

    public FilteredProductsPage selectBrand(String brand) {
        return new CatalogSidebar().selectBrand(brand);
    }
}

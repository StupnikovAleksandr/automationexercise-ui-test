package pages;

import pages.components.ProductList;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class FilteredProductsPage extends BasePage {
    public FilteredProductsPage(String heading) {
        $(".features_items h2.title").shouldBe(visible).shouldHave(text(heading));
        new ProductList($(".features_items")).shouldBeVisible();
    }

    public FilteredProductsPage selectCategory(String group, String category) {
        return new CatalogSidebar().selectCategory(group, category);
    }

    public FilteredProductsPage selectBrand(String brand) {
        return new CatalogSidebar().selectBrand(brand);
    }
}

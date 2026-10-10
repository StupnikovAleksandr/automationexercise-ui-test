package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CatalogSidebar {
    public FilteredProductsPage selectCategory(String group, String category) {
        $(".left-sidebar").shouldBe(visible);
        $("a[href='#" + group + "']").click();
        $("#" + group).$$("a").findBy(text(category)).shouldBe(visible).click();
        return new FilteredProductsPage(group + " - " + category + " PRODUCTS");
    }

    public FilteredProductsPage selectBrand(String brand) {
        $(".brands_products").shouldBe(visible).$$("a").findBy(text(brand)).click();
        return new FilteredProductsPage("BRAND - " + brand + " PRODUCTS");
    }
}

import dataHelper.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductTest extends BaseTest {
    @Test
    @DisplayName("TC08: Verify All Products and product detail page")
    void viewProductDetails() {
        var products = homePage.openProductsPage().products();
        var expected = products.product(0);
        products.viewProduct(0).shouldShowDetails(expected);
    }

    @Test
    @DisplayName("TC09: Search Product")
    void searchProducts() {
        homePage.openProductsPage().search("Blue Top").products().shouldMatchSearch("Blue Top");
    }

    @Test
    @DisplayName("TC18: View Category Products")
    void switchProductCategories() {
        new pages.CatalogSidebar().selectCategory("Women", "Tops")
                .selectCategory("Men", "Jeans");
    }

    @Test
    @DisplayName("TC19: View Brand Products")
    void switchProductBrands() {
        homePage.openProductsPage().selectBrand("Polo").selectBrand("H&M");
    }

    @Test
    @DisplayName("TC21: Add review on product")
    void submitProductReview() {
        homePage.openProductsPage().products().viewProduct(0)
                .submitReview(Data.generateRandomName(), Data.generateRandomEmail(),
                        "Useful product for UI automation practice.");
    }
}

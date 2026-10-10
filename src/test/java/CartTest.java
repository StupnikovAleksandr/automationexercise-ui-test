import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest {
    @Test
    @DisplayName("TC12: Add Products in Cart")
    void addTwoProductsAndVerifyTotals() {
        var products = homePage.openProductsPage().products();
        var first = products.product(0);
        var second = products.product(1);
        products.addToCart(0).continueShopping();
        products.addToCart(1).viewCart().shouldHaveProductCount(2)
                .shouldContain(first, 1).shouldContain(second, 1);
    }

    @Test
    @DisplayName("TC13: Verify Product quantity in Cart")
    void addMultipleUnitsOfProduct() {
        var expected = homePage.products().product(0);
        homePage.products().viewProduct(0).addToCart(4).viewCart()
                .shouldHaveProductCount(1).shouldContain(expected, 4);
    }

    @Test
    @DisplayName("TC17: Remove Products From Cart")
    void removeProductFromCart() {
        var products = homePage.openProductsPage().products();
        var first = products.product(0);
        var second = products.product(1);
        products.addToCart(0).continueShopping();
        products.addToCart(1).viewCart().removeProduct(first)
                .shouldHaveProductCount(1).shouldContain(second, 1);
    }

    @Test
    @DisplayName("TC20: Search Products and Verify Cart After Login")
    void preserveSearchedProductsInCartAfterLogin() {
        var account = createAccount();
        homePage.logout().openHomePage();
        var productsPage = homePage.openProductsPage().search("Blue Top");
        var products = productsPage.products().shouldMatchSearch("Blue Top");
        var expected = products.allProducts();
        for (int i = 0; i < expected.size(); i++) {
            products.addToCart(i).continueShopping();
        }
        var cart = productsPage.openCartPage().shouldHaveProductCount(expected.size());
        expected.forEach(product -> cart.shouldContain(product, 1));
        var cartAfterLogin = cart.openSignupLoginPage().login(account.credentials()).openCartPage()
                .shouldHaveProductCount(expected.size());
        expected.forEach(product -> cartAfterLogin.shouldContain(product, 1));
    }

    @Test
    @DisplayName("TC22: Add to cart from Recommended items")
    void addRecommendedProductToCart() {
        var expected = homePage.recommendedProduct();
        homePage.addRecommendedProduct(expected).viewCart()
                .shouldHaveProductCount(1).shouldContain(expected, 1);
    }
}

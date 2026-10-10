import dataHelper.Data;
import dataHelper.ProductData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckoutPage;
import java.nio.file.Files;
import static org.junit.jupiter.api.Assertions.*;

public class CheckoutTest extends BaseTest {
    private ProductData addProductToCart() {
        var products = homePage.products();
        var product = products.product(0);
        products.addToCart(0).viewCart().shouldContain(product, 1);
        return product;
    }

    private CheckoutPage checkout(TestAccount account, ProductData product) {
        return homePage.openCartPage().proceedToCheckout()
                .shouldHaveAddresses(account.registration).shouldContain(product, 1);
    }

    @Test
    @DisplayName("TC14: Place Order - Register while Checkout")
    void registerDuringCheckoutAndPlaceOrder() {
        var product = addProductToCart();
        var signupPage = new CartPage().proceedToCheckoutAsGuest();
        var account = newAccount();
        homePage = registerAccount(signupPage, account);
        checkout(account, product).placeOrder("Please deliver during the day.")
                .pay(Data.newPaymentData());
        deleteAccount(homePage);
    }

    @Test
    @DisplayName("TC15: Place Order - Register before Checkout")
    void registerBeforeCheckoutAndPlaceOrder() {
        var account = createAccount();
        var product = addProductToCart();
        checkout(account, product).placeOrder("New account order.").pay(Data.newPaymentData());
        deleteAccount(homePage);
    }

    @Test
    @DisplayName("TC16: Place Order - Login before Checkout")
    void loginBeforeCheckoutAndPlaceOrder() {
        var account = createAccount();
        homePage = homePage.logout().login(account.credentials()).shouldBeLoggedInAs(account.signup.getName());
        var product = addProductToCart();
        checkout(account, product).placeOrder("Existing account order.").pay(Data.newPaymentData());
        deleteAccount(homePage);
    }

    @Test
    @DisplayName("TC23: Verify address details in checkout page")
    void verifyDeliveryAndBillingAddresses() {
        var account = createAccount();
        var product = addProductToCart();
        checkout(account, product);
        deleteAccount(homePage);
    }

    @Test
    @DisplayName("TC24: Download Invoice after purchase order")
    void downloadInvoiceAfterPurchase() throws Exception {
        var product = addProductToCart();
        var signupPage = new CartPage().proceedToCheckoutAsGuest();
        var account = newAccount();
        homePage = registerAccount(signupPage, account);
        var confirmation = checkout(account, product).placeOrder("Invoice download test.")
                .pay(Data.newPaymentData());
        var invoice = confirmation.downloadInvoice();
        assertTrue(invoice.isFile(), "Invoice must be downloaded");
        assertTrue(invoice.length() > 0, "Invoice must not be empty");
        var content = Files.readString(invoice.toPath());
        assertTrue(content.contains(account.registration.getFirstName() + " " + account.registration.getLastName()),
                "Invoice must identify the buyer");
        assertTrue(content.contains("Your total purchase amount is " + product.totalFor(1).replace("Rs. ", "") + "."),
                "Invoice must contain the order total");
        deleteAccount(confirmation.continueShopping());
    }
}

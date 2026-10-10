package pages;

import pages.components.Subscription;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    public HomePage openHomePage() {
        $("header a[href='/']").click();
        return new HomePage();
    }

    public SignupLoginPage openSignupLoginPage() {
        $("header a[href='/login']").click();
        return new SignupLoginPage();
    }

    public ProductsPage openProductsPage() {
        $("header a[href='/products']").click();
        return new ProductsPage();
    }

    public CartPage openCartPage() {
        $("header a[href='/view_cart']").click();
        return new CartPage();
    }

    public ContactPage openContactPage() {
        $("header a[href='/contact_us']").click();
        return new ContactPage();
    }

    public TestCasesPage openTestCasesPage() {
        $("header a[href='/test_cases']").click();
        return new TestCasesPage();
    }

    public Subscription subscription() {
        return new Subscription();
    }

    public boolean isLoggedIn() {
        return $("header a[href='/logout']").exists();
    }

    public HomePage deleteAccount() {
        $("header a[href='/delete_account']").click();
        $("[data-qa='account-deleted']").shouldBe(visible).shouldHave(text("ACCOUNT DELETED!"));
        $("[data-qa='continue-button']").click();
        return new HomePage();
    }
}

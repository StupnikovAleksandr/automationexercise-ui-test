package pages;

import java.io.File;
import java.io.FileNotFoundException;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class OrderConfirmationPage extends BasePage {
    public OrderConfirmationPage() {
        $("[data-qa='order-placed']").shouldBe(visible).shouldHave(text("ORDER PLACED!"));
        $("#form").shouldHave(text("Congratulations! Your order has been confirmed!"));
    }

    public File downloadInvoice() throws FileNotFoundException {
        return $("a[href^='/download_invoice/']").download();
    }

    public HomePage continueShopping() {
        $("[data-qa='continue-button']").click();
        return new HomePage();
    }
}

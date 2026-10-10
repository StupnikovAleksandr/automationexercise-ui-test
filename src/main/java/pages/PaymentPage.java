package pages;

import dataHelper.Data;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class PaymentPage extends BasePage {
    public PaymentPage() {
        $("[data-qa='name-on-card']").shouldBe(visible);
    }

    public OrderConfirmationPage pay(Data.PaymentData data) {
        $("[data-qa='name-on-card']").setValue(data.getName());
        $("[data-qa='card-number']").setValue(data.getCardNumber());
        $("[data-qa='cvc']").setValue(data.getCvc());
        $("[data-qa='expiry-month']").setValue(data.getMonth());
        $("[data-qa='expiry-year']").setValue(data.getYear());
        $("[data-qa='pay-button']").click();
        return new OrderConfirmationPage();
    }
}

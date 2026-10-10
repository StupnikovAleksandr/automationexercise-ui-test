package pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class Subscription {
    public Subscription shouldBeVisible() {
        $("footer").scrollIntoView(false);
        $("footer h2").shouldBe(visible).shouldHave(text("SUBSCRIPTION"));
        return this;
    }

    public Subscription subscribe(String email) {
        shouldBeVisible();
        $("#susbscribe_email").setValue(email);
        $("#subscribe").click();
        $("#success-subscribe").shouldBe(visible)
                .shouldHave(text("You have been successfully subscribed!"));
        return this;
    }
}

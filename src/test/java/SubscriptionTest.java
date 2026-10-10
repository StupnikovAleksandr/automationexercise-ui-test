import dataHelper.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SubscriptionTest extends BaseTest {
    @Test
    @DisplayName("TC10: Verify Subscription in home page")
    void subscribeFromHomePage() {
        homePage.subscription().subscribe(Data.generateRandomEmail());
    }

    @Test
    @DisplayName("TC11: Verify Subscription in Cart page")
    void subscribeFromCartPage() {
        homePage.openCartPage().subscription().subscribe(Data.generateRandomEmail());
    }
}

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ScrollTest extends BaseTest {
    @Test
    @DisplayName("TC25: Scroll Up using Arrow and Scroll Down")
    void scrollUpUsingArrow() {
        homePage.subscription().shouldBeVisible();
        homePage.scrollUpUsingArrow().shouldShowHeroInViewport();
    }

    @Test
    @DisplayName("TC26: Scroll Up without Arrow and Scroll Down")
    void scrollUpWithoutArrow() {
        homePage.subscription().shouldBeVisible();
        homePage.scrollToTop().shouldShowHeroInViewport();
    }
}

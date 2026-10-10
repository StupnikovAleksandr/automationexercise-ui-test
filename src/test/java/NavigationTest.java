import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NavigationTest extends BaseTest {
    @Test
    @DisplayName("TC07: Verify Test Cases Page")
    void openTestCasesPage() {
        homePage.openTestCasesPage();
    }
}

package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class TestCasesPage extends BasePage {
    public TestCasesPage() {
        $("h2.title").shouldBe(visible).shouldHave(text("Test Cases"));
        $("a[href='#collapse1']").shouldBe(visible).shouldHave(text("Register User"));
    }
}

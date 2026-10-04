package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final SelenideElement checkOpenHomePage = $("#slider");
    private final SelenideElement HeaderBTMRegisterPage = $(".fa.fa-lock");

    public MainPage checkOpenHomePage() {
        checkOpenHomePage.shouldBe(Condition.visible);
        return this;
    }

    public SingUpLoginPage clickRegisterAndLoginPage() {
        HeaderBTMRegisterPage.click();
        return new SingUpLoginPage();
    }
}






package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {


    private final SelenideElement HeaderBTMDeleteAccount = $(".fa.fa-trash-o");
    private SelenideElement btmAccountDelete = $(".btn.btn-primary");
    private SelenideElement accountDelited = $(".title.text-center");


    //чекаем стр хоум авторизированным юзероом
    public HomePage() {
        HeaderBTMDeleteAccount.shouldBe(visible);
    }

    public void deleteAccount() {
        HeaderBTMDeleteAccount.click();
        accountDelited.shouldHave(text("ACCOUNT DELETED!"));
        btmAccountDelete.click();
        new MainPage().checkOpenHomePage();
    }
    public void checkAuthUser() {
        HeaderBTMDeleteAccount.shouldBe(visible);
    }
}

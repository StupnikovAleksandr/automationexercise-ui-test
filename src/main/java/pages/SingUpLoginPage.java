package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import dataHelper.Data;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static dataHelper.Data.loginFailed;

public class SingUpLoginPage {
    //For TC-1 and accert to TC-2
    private final SelenideElement checkSingUpForm = $(".signup-form");
    private final SelenideElement checkLoginForm = $(".login-form");
    private final SelenideElement fieldName = $("input[placeholder='Name']");
    private final SelenideElement fieldEmailAddress = $("input[data-qa='signup-email']");
    private final SelenideElement clickSingUp = $("button[data-qa='signup-button']");

    //For TC-2
    private final SelenideElement loginEmail = $("input[data-qa='login-email']");
    private final SelenideElement loginPassword = $("input[placeholder='Password']");
    private final SelenideElement loginBtm = $("button[data-qa='login-button']");

    //For TC-3
    private final SelenideElement EmailAdderssAlredyFiled = $(".signup-form");
    private final SelenideElement EmailAddressOrPassFiled = $(".login-form");
    public SingUpLoginPage() {
        checkSingUpForm.shouldBe(visible);
        checkLoginForm.shouldBe(visible);
    }


    public RegisterPage FillNameAndEmailAddressAndClickSingUP(Data.SingFill logFill) {
        fieldName.setValue(logFill.getName());
        fieldEmailAddress.setValue(logFill.getEmail());
        clickSingUp.click();
        return new RegisterPage();
    }

    // Создал акк, чисто для этого теста
    public HomePage AuthUsers(Data.AuthUsers authUsers) {
        loginEmail.setValue(authUsers.getEmail());
        loginPassword.setValue(authUsers.getPassword());
        loginBtm.click();
        return new HomePage();
    }

    public void handlingErrorSignIN(Data.SingFill singFill) {
        fieldName.setValue(singFill.getName());
        fieldEmailAddress.setValue(singFill.getEmail());
        clickSingUp.click();
    }
    public void handlingErrorLogIN(Data.AuthUsers loginFailed) {
        loginEmail.setValue(loginFailed.getEmail());
        loginPassword.setValue(loginFailed.getPassword());
        loginBtm.click();
    }
    public void ErrorSignUpEmailAddress() {
        EmailAdderssAlredyFiled.shouldHave(text("Email Address already exist!"));
    }

    public void LogINErrorEmailOrPass() {
        EmailAddressOrPassFiled.shouldHave(text("Your email or password is incorrect!"));
    }










}

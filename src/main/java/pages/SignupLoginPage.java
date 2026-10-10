package pages;

import com.codeborne.selenide.SelenideElement;
import dataHelper.Data;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SignupLoginPage extends BasePage {
    private final SelenideElement signupForm = $(".signup-form");
    private final SelenideElement loginForm = $(".login-form");
    private final SelenideElement signupName = $("[data-qa='signup-name']");
    private final SelenideElement signupEmail = $("[data-qa='signup-email']");
    private final SelenideElement signupButton = $("[data-qa='signup-button']");
    private final SelenideElement loginEmail = $("[data-qa='login-email']");
    private final SelenideElement loginPassword = $("[data-qa='login-password']");
    private final SelenideElement loginButton = $("[data-qa='login-button']");

    public SignupLoginPage() {
        signupForm.shouldBe(visible).shouldHave(text("New User Signup!"));
        loginForm.shouldBe(visible).shouldHave(text("Login to your account"));
    }

    public RegistrationPage signup(Data.SignupData data) {
        submitSignup(data);
        return new RegistrationPage();
    }

    public SignupLoginPage submitSignup(Data.SignupData data) {
        signupName.setValue(data.getName());
        signupEmail.setValue(data.getEmail());
        signupButton.click();
        return this;
    }

    public HomePage login(Data.Credentials credentials) {
        submitLogin(credentials);
        return new HomePage().shouldBeLoggedIn();
    }

    public SignupLoginPage submitLogin(Data.Credentials credentials) {
        loginEmail.setValue(credentials.getEmail());
        loginPassword.setValue(credentials.getPassword());
        loginButton.click();
        return this;
    }

    public SignupLoginPage shouldShowEmailAlreadyExistsError() {
        signupForm.shouldHave(text("Email Address already exist!"));
        return this;
    }

    public SignupLoginPage shouldShowInvalidCredentialsError() {
        loginForm.shouldHave(text("Your email or password is incorrect!"));
        return this;
    }
}

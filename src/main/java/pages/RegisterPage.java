package pages;

import com.codeborne.selenide.SelenideElement;
import dataHelper.Data;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class RegisterPage {
    private SelenideElement registerForm = $(".login-form");
    private SelenideElement accountCreated = $(".title.text-center");
    private SelenideElement btmAccountCreated = $(".btn.btn-primary");

    //    Enter Account Information
    private final SelenideElement checkBoxTitleMR = $("#id_gender1");
    private final SelenideElement checkBoxTitleMRS = $("#id_gender2"); //женщина
    private final SelenideElement fillName = $("#name");
    private final SelenideElement fillPassword = $("#password");
    private final SelenideElement fillDAYOfBirth = $("select[id='days'] option[value='3']");//подумать как рандомно выбирать число
    private final SelenideElement fillMONTHSOfBirth = $("select[id='months'] option[value='6']");//подумать как рандомно выбирать число
    private final SelenideElement fillYEARSOfBirth = $("option[value='2008']");//подумать как рандомно выбирать число
    private final SelenideElement checkBoxNewsletter = $("#newsletter");
    private final SelenideElement checkBoxUniform = $("#optin");
    //Address Information
    private final SelenideElement fillFirstName = $("#first_name");
    private final SelenideElement fillLastName = $("#last_name");
    private final SelenideElement fillCompany = $("#company");
    private final SelenideElement fillAddress1 = $("#address1");
    private final SelenideElement fillAddress2 = $("#address2");
    private final SelenideElement filCountry = $("option[value='Israel']"); //подумать как выбрать рандомно страну
    private final SelenideElement fillState = $("#state"); // государтсов
    private final SelenideElement fillCity = $("#city");
    private final SelenideElement fillZipCode = $("#zipcode");
    private final SelenideElement fillPhoneNumber = $("#mobile_number");

    private final SelenideElement pressCreateAccount = $("button[data-qa='create-account']");


    public RegisterPage() {
        registerForm.shouldHave(text("ENTER ACCOUNT INFORMATION"));
    }

    public void CheckHappyRegistrationAccount() {
        accountCreated.shouldHave(text("ACCOUNT CREATED!"));
        btmAccountCreated.click();
    }


    public HomePage FillRegisterUsers(Data.RegisterFill registerFill) {
        checkBoxTitleMR.click();
        fillName.setValue(registerFill.getName());
        fillPassword.setValue(registerFill.getPassword());
        fillDAYOfBirth.click();
        fillMONTHSOfBirth.click();
        fillYEARSOfBirth.click();
        checkBoxNewsletter.click();
        checkBoxUniform.click();
        fillFirstName.setValue(registerFill.getFirstName());
        fillLastName.setValue(registerFill.getLastName());
        fillCompany.setValue(registerFill.getCompany());
        fillAddress1.setValue(registerFill.getAddress1());
        fillAddress2.setValue(registerFill.getAddress2());
        filCountry.click();
        fillState.setValue(registerFill.getState());
        fillCity.setValue(registerFill.getCity());
        fillZipCode.setValue(registerFill.getZipCode());
        fillPhoneNumber.setValue(registerFill.getPhoneNumber());
        pressCreateAccount.click();
        CheckHappyRegistrationAccount();
        return new HomePage();

    }
}


//public LoginPage setUsername(String username) {
//    usernameInput.setValue(username);
//    return this;

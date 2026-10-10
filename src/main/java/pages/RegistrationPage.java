package pages;

import com.codeborne.selenide.SelenideElement;
import dataHelper.Data;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage extends BasePage {
    private final SelenideElement registerForm = $(".login-form");
    private final SelenideElement accountCreated = $("[data-qa='account-created']");
    private final SelenideElement continueButton = $("[data-qa='continue-button']");
    private final SelenideElement maleTitle = $("#id_gender1");
    private final SelenideElement nameInput = $("#name");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement birthDay = $("#days");
    private final SelenideElement birthMonth = $("#months");
    private final SelenideElement birthYear = $("#years");
    private final SelenideElement newsletterCheckbox = $("#newsletter");
    private final SelenideElement offersCheckbox = $("#optin");
    private final SelenideElement firstNameInput = $("#first_name");
    private final SelenideElement lastNameInput = $("#last_name");
    private final SelenideElement companyInput = $("#company");
    private final SelenideElement address1Input = $("#address1");
    private final SelenideElement address2Input = $("#address2");
    private final SelenideElement countrySelect = $("#country");
    private final SelenideElement stateInput = $("#state");
    private final SelenideElement cityInput = $("#city");
    private final SelenideElement zipCodeInput = $("#zipcode");
    private final SelenideElement phoneNumberInput = $("#mobile_number");
    private final SelenideElement createAccountButton = $("button[data-qa='create-account']");

    public RegistrationPage() {
        registerForm.shouldBe(visible).shouldHave(text("ENTER ACCOUNT INFORMATION"));
    }

    public HomePage register(Data.RegistrationData data) {
        maleTitle.click();
        nameInput.setValue(data.getName());
        passwordInput.setValue(data.getPassword());
        birthDay.selectOptionByValue("3");
        birthMonth.selectOptionByValue("6");
        birthYear.selectOptionByValue("2008");
        newsletterCheckbox.setSelected(true);
        offersCheckbox.setSelected(true);
        firstNameInput.setValue(data.getFirstName());
        lastNameInput.setValue(data.getLastName());
        companyInput.setValue(data.getCompany());
        address1Input.setValue(data.getAddress1());
        address2Input.setValue(data.getAddress2());
        countrySelect.selectOptionByValue("Israel");
        stateInput.setValue(data.getState());
        cityInput.setValue(data.getCity());
        zipCodeInput.setValue(data.getZipCode());
        phoneNumberInput.setValue(data.getPhoneNumber());
        createAccountButton.click();
        accountCreated.shouldBe(visible).shouldHave(text("ACCOUNT CREATED!"));
        continueButton.click();
        return new HomePage().shouldBeLoggedIn();

    }
}

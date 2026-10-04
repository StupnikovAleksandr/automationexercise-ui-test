import com.codeborne.selenide.Configuration;
import dataHelper.Data;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.MainPage;
import pages.SingUpLoginPage;

import static com.codeborne.selenide.Selenide.*;

class LoginTest {

    @BeforeAll
    static void setUp() {
//        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://automationexercise.com/";
    }

    //Test Case 1: Register User
    @Test
    void registerAndDeleteUserAccount() {
        open("/");
        var mainPage = new MainPage();
        mainPage.checkOpenHomePage();
        mainPage.clickRegisterAndLoginPage();
        var singUpLoginPage = new SingUpLoginPage();
        var singFill = Data.singUP();
        var registerPage = singUpLoginPage.FillNameAndEmailAddressAndClickSingUP(singFill);
        var registerFill = Data.generateRegisterFill();
        registerPage.FillRegisterUsers(registerFill);
        var homePage = new HomePage();
        homePage.deleteAccount();
    }
    //    Test Case 2: Login User with correct email and password

    @Test
    void AuthUser() {
        open("/");
//        var mainPage = new MainPage();
//        mainPage.checkOpenHomePage();
//        mainPage.clickRegisterAndLoginPage();
//        var singUpLoginPage = new SingUpLoginPage();
//        var loginFill = Data.loginFill();
//        var authUser = singUpLoginPage.AuthUsers(loginFill);
//        authUser.deleteAccount();
        MainPage mainPage = new MainPage();
        mainPage.checkOpenHomePage();
        mainPage.clickRegisterAndLoginPage();
        SingUpLoginPage singUpLoginPage = new SingUpLoginPage();
        Data.AuthUsers signIN = Data.signIN();
        HomePage authUser = singUpLoginPage.AuthUsers(signIN);
        authUser.checkAuthUser();
    }


    //Test Case 3: Login User with incorrect email and password
    @Test
    void ErrorIncorrectPassOrEmailTest() {
        open("/");
        MainPage mainPage = new MainPage();
        mainPage.checkOpenHomePage();
        mainPage.clickRegisterAndLoginPage();
        SingUpLoginPage singUpLoginPage = new SingUpLoginPage();
        Data.AuthUsers loginFailed = Data.loginFailed();
        singUpLoginPage.handlingErrorLogIN(loginFailed);
        singUpLoginPage.LogINErrorEmailOrPass();
    }
    // Test Case 4: Logout User








    //Test Case 5: Register User with existing email
    @Test
    void ErrorEmailForSignIn() {
        open("/");
        MainPage mainPage = new MainPage();
        mainPage.checkOpenHomePage();
        mainPage.clickRegisterAndLoginPage();
        SingUpLoginPage singUpLoginPage = new SingUpLoginPage();
        Data.SingFill singFill = Data.existingUseFailed();
        singUpLoginPage.handlingErrorSignIN(singFill);
        singUpLoginPage.ErrorSignUpEmailAddress();
    }

    }











//    @Test
//    void shouldFailLogin() {
//        var loginPage = new LoginPage();
//        var notRegistratedUser = DataHelper.generateRandomUser();
//        var verificationPage = loginPage.validLogin(notRegistratedUser);
//        verificationPage.errorNotificationVisible();
//    }

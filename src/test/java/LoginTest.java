import dataHelper.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    @Test
    @DisplayName("TC02: Login User with correct email and password")
    void loginAndDeleteAccount() {
        var account = createAccount();
        var loggedInHome = homePage.logout().login(account.credentials())
                .shouldBeLoggedInAs(account.signup.getName());
        deleteAccount(loggedInHome);
    }

    @Test
    @DisplayName("TC03: Login User with incorrect email and password")
    void rejectLoginWithInvalidCredentials() {
        homePage.openSignupLoginPage().submitLogin(Data.invalidCredentials())
                .shouldShowInvalidCredentialsError();
    }

    @Test
    @DisplayName("TC04: Logout User")
    void loginAndLogout() {
        var account = createAccount();
        homePage.logout().login(account.credentials())
                .shouldBeLoggedInAs(account.signup.getName()).logout();
    }
}

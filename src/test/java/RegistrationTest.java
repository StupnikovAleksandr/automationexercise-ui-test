import dataHelper.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationTest extends BaseTest {
    @Test
    @DisplayName("TC01: Register User")
    void registerAndDeleteUserAccount() {
        var account = newAccount();
        deleteAccount(registerAccount(homePage.openSignupLoginPage(), account));
    }

    @Test
    @DisplayName("TC05: Register User with existing email")
    void rejectSignupWithExistingEmail() {
        var account = createAccount();
        homePage.logout().submitSignup(new Data.SignupData(Data.generateRandomName(), account.signup.getEmail()))
                .shouldShowEmailAlreadyExistsError();
    }
}

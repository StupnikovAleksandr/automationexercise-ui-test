import com.codeborne.selenide.Configuration;
import dataHelper.Data;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.HomePage;
import pages.SignupLoginPage;
import static com.codeborne.selenide.Selenide.*;

public abstract class BaseTest {
    protected HomePage homePage;
    private TestAccount accountToDelete;

    @BeforeAll
    static void configureBrowser() {
        Configuration.baseUrl = System.getProperty("baseUrl", "https://automationexercise.com");
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        Configuration.browserSize = "1440x1000";
        // External advertising resources must not block a ready application DOM.
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    void openHomePage() {
        open("/");
        homePage = new HomePage();
    }

    protected TestAccount newAccount() {
        var registration = Data.newRegistrationData();
        var signup = new Data.SignupData(registration.getName(), Data.generateRandomEmail());
        return new TestAccount(signup, registration);
    }

    protected HomePage registerAccount(SignupLoginPage page, TestAccount account) {
        var registeredHome = page.signup(account.signup).register(account.registration);
        accountToDelete = account;
        return registeredHome.shouldBeLoggedInAs(account.signup.getName());
    }

    protected TestAccount createAccount() {
        var account = newAccount();
        homePage = registerAccount(homePage.openSignupLoginPage(), account);
        return account;
    }

    protected void deleteAccount(HomePage page) {
        homePage = page.deleteAccount();
        accountToDelete = null;
    }

    @AfterEach
    void cleanup() {
        try {
            if (accountToDelete != null) {
                open("/");
                var home = new HomePage();
                if (!home.isLoggedIn()) {
                    home = home.openSignupLoginPage().login(accountToDelete.credentials());
                }
                home.deleteAccount();
            }
        } finally {
            closeWebDriver();
        }
    }

    protected static class TestAccount {
        final Data.SignupData signup;
        final Data.RegistrationData registration;

        TestAccount(Data.SignupData signup, Data.RegistrationData registration) {
            this.signup = signup;
            this.registration = registration;
        }

        Data.Credentials credentials() {
            return new Data.Credentials(signup.getEmail(), registration.getPassword());
        }
    }
}

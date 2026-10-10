package pages;

import java.io.File;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ContactPage extends BasePage {
    public ContactPage() {
        $(".contact-form h2").shouldBe(visible).shouldHave(text("GET IN TOUCH"));
    }

    public ContactPage submit(String name, String email, String subject, String message, File attachment) {
        $("[data-qa='name']").setValue(name);
        $("[data-qa='email']").setValue(email);
        $("[data-qa='subject']").setValue(subject);
        $("[data-qa='message']").setValue(message);
        $("input[name='upload_file']").uploadFile(attachment);
        $("[data-qa='submit-button']").click();
        confirm();
        $(".contact-form .status").shouldBe(visible)
                .shouldHave(text("Success! Your details have been submitted successfully."));
        return this;
    }

    public HomePage returnHome() {
        $("#form-section a[href='/']").click();
        return new HomePage();
    }
}

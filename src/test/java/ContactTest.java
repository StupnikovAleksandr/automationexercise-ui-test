import dataHelper.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.Objects;

public class ContactTest extends BaseTest {
    @Test
    @DisplayName("TC06: Contact Us Form")
    void submitContactFormWithAttachment() throws Exception {
        var attachment = new File(Objects.requireNonNull(getClass().getResource("/contact-attachment.txt")).toURI());
        homePage.openContactPage().submit(Data.generateRandomName(), Data.generateRandomEmail(),
                "UI automation practice", "Automated test of the contact form.", attachment)
                .returnHome();
    }
}

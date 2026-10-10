package dataHelper;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public final class Data {

    private Data() {
    }

    private static final Faker faker = new Faker(new Locale("en"));

    @Value
    public static class SignupData {
        String name;
        String email;
    }
    @Value
    public static class Credentials {
        String email;
        String password;
    }
    public static Credentials existingUserCredentials() {
        return new Credentials(
                existingUserEmail(),
                existingUserPassword()
        );
    }
    public static Credentials invalidCredentials() {
        return new Credentials(
                generateRandomEmail(),
                generateRandomPassword()
        );
    }
    public static SignupData newSignupData() {
        return new SignupData(
                generateRandomName(),
                generateRandomEmail()
        );

    }
    public static SignupData existingEmailSignupData() {
        return new SignupData(
                generateRandomName(),
                existingUserEmail()
        );
    }

    @Value
    public static class RegistrationData {
        String name;
        String password;
        String firstName;
        String lastName;
        String company;
        String address1;
        String address2;
        String state;
        String city;
        String zipCode;
        String phoneNumber;
    }

    public static RegistrationData newRegistrationData() {
        return new RegistrationData(
                generateRandomName(),
                generateRandomPassword(),
                generateRandomFirstName(),
                generateRandomLastName(),
                generateRandomCompanyName(),
                generateRandomAddress(),
                generateRandomAddress(),
                generateRandomState(),
                generateRandomCity(),
                generateRandomZipCode(),
                generateRandomPhoneNumber()
        );
    }

    @Value
    public static class PaymentData {
        String name;
        String cardNumber;
        String cvc;
        String month;
        String year;
    }

    public static PaymentData newPaymentData() {
        return new PaymentData(generateRandomFirstName() + " " + generateRandomLastName(),
                "4111111111111111", "123", "12",
                String.valueOf(java.time.Year.now().getValue() + 2));
    }

    public static String generateRandomName() {
        return faker.name().username();
    }

    public static String generateRandomEmail() {
        return "ui." + java.util.UUID.randomUUID() + "@example.com";
    }

    public static String generateRandomPassword() {
        return faker.internet().password();
    }

    // Shared fixture account: login tests must not delete it.
    public static String existingUserPassword() {
        return "2151253167rqwfcf";
    }
    public static String existingUserEmail() {
        return "guz.tcrbzaoksk@tularegion.ru";
    }

    public static String generateRandomFirstName() {
        return faker.name().firstName();
    }

    public static String generateRandomLastName() {
        return faker.name().lastName();
    }

    public static String generateRandomState() {
        return faker.address().state();
    }

    public static String generateRandomCity() {
        return faker.address().city();
    }

    public static String generateRandomZipCode() {
        return faker.address().zipCode();
    }

    public static String generateRandomPhoneNumber() {
        return faker.numerify("##########");
    }

    public static String generateRandomCompanyName() {
        return faker.company().name();
    }

    public static String generateRandomAddress() {
        return faker.address().fullAddress();
    }

}

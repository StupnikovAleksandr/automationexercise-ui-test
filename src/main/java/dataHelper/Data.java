package dataHelper;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class Data {

    private static final Faker faker = new Faker(new Locale("en"));


    @Value
    public static class  SingFill {
        String Name;
        String Email;
    }
    @Value
    public static class AuthUsers {
        String Email;
        String Password;
    }
    public static AuthUsers signIN() {
        return new AuthUsers(
                hardCodeEmail(),
                hardCodePassword()
        );
    }
        public static AuthUsers loginFailed() {
            return new AuthUsers(
                    generateRandomEmail(),
                    generateRandomPassword()
            );
    }
    public static SingFill singUP() {
        return new SingFill(
                generateRandomName(),
                generateRandomEmail()
        );

    }
    public static SingFill existingUseFailed() {
        return new SingFill(
                generateRandomName(),
                hardCodeEmail()
        );
    }

    @Value
    public static class RegisterFill {
        //        String Title;
        String Name;
        String Password;
        //        String DAYOfBirth;
//        String MONTHSOfBirth;
//        String YEARSOfBirth;
//        String CheckBoxNewsletter;
//        String CheckBoxUniform;
        String FirstName;
        String LastName;
        String Company;
        String Address1;
        String Address2;
        //        String Country;
        String State;
        String City;
        String ZipCode;
        String PhoneNumber;
    }

    public static RegisterFill generateRegisterFill() {
        return new RegisterFill(
                generateRandomName(),
                generateRandomPassword(),
                generateRandomFirstName(),
                generateRandomLastName(),
                generateRandomCompanyName(),
                generateRandomCompanyAddress1and2(),
                generateRandomCompanyAddress1and2(),
                generateRandomState(),
                generateRandomCity(),
                generateRandomZipCode(),
                generateRandomPhoneNumber()
        );
    }

    public static String generateRandomName() {
        return faker.name().username();
    }

    public static String generateRandomEmail() {
        return faker.internet().emailAddress();
    }


    public static String generateRandomPassword() {
        return faker.internet().password();
    }

    //REAL USER FOR TC-2!!! NOT DELETE!
    public static String hardCodePassword() {
        return "2151253167rqwfcf";
    }
    //REAL USER FOR TC-2!!! NOT DELETE!
    public static String hardCodeEmail() {
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

    public static String generateRandomCompanyAddress1and2() {
        return faker.address().fullAddress();
    }


}
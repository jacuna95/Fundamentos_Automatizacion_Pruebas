package PageObjects;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {

    public Utils() {

    }

    public static String generateRandomEmails() {
        String emailRandom = RandomStringUtils.randomAlphabetic(8);
        return (emailRandom + "@hotmail.com");
    }

}

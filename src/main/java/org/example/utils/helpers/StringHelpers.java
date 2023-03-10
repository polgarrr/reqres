package org.example.utils.helpers;

import java.math.BigInteger;
import java.security.SecureRandom;

public class StringHelpers {

    public static boolean stringNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static String generateRandomString() {
        return new BigInteger(130, new SecureRandom()).toString(32);
    }
}

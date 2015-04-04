package nyc.c4q.ac21.ac20150322;

/**
 * Created by sufeizhao on 3/22/15.
 * Access Code 2.1
 * ASCII.java
 * methods to check if a letter is uppercase or lowercase
 * method for Caesar Cipher encoder & decoder
 */

public class ASCII {

    public static boolean isUppercaseLetter(char c) {
        int code = (int) c;

        if (code >= 65 && code <= 90)
            return true;
        else
            return false;
    }

    public static boolean isLowercaseLetter(char c) {
        int code = (int) c;

        if (code >= 97 && code <= 122)
            return true;
        else
            return false;
    }

    public static String rot13Encode(String message, int rot) {
        String encodedMessage = "";
        int rotation = rot % 26;

        for (int i = 0; i < message.length(); i++) {
            char currentLetter = message.charAt(i);
            int currentAscii = (int) currentLetter;
            int output;

            if (isUppercaseLetter(currentLetter)) {
                output = currentAscii + rotation;
                if (output > 90)
                    output = 64 + (output - 90);
                encodedMessage += (char) output;
            } else if (isLowercaseLetter(currentLetter)) {
                output = currentAscii + rotation;
                if (output > 122)
                    output = 96 + (output - 122);
                encodedMessage += (char) output;
            } else {
                encodedMessage += currentLetter;
            }
        }
        return encodedMessage;
    }

    public static String rot13Decode(String message, int rot) {
        String encodedMessage = "";
        int rotation = rot % 26;

        for (int i = 0; i < message.length(); i++) {
            char currentLetter = message.charAt(i);
            int currentAscii = (int) currentLetter;
            int output;

            if (isUppercaseLetter(currentLetter)) {
                output = currentAscii - rotation;
                if (output < 65)
                    output = 90 - (64 - output);
                encodedMessage += (char) output;
            } else if (isLowercaseLetter(currentLetter)) {
                output = currentAscii - rotation;
                if (output < 97)
                    output = 122 - (96 - output);
                encodedMessage += (char) output;
            } else {
                encodedMessage += currentLetter;
            }
        }
        return encodedMessage;
    }

    public static void main(String[] args) {
        int rot = 5;
        String message = "I want food";
        System.out.println(rot13Encode(message, rot));

        String code = rot13Encode(message, rot);
        System.out.println(rot13Decode(code, rot));
    }
}

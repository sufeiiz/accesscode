package nyc.c4q.sufeiiz;

/**
 * Taken from Alex S.
 * package nyc.c4q.ac21.romancalc;
 * Access Code 2.1
 * Code to convert to and from Roman numerals.
 */

public class RomanNumerals {
    /**
     * Formats a number in Roman numerals.
     * @param value
     *   The value to format.  Must be between 1 and 3999.
     * @return
     *   The value in Roman numerals.
     */
    public static String format(int value) {
        if (value < 1 || value >= 4000) {
            System.err.println("value out of range");
            return "error";
        }

        String result = "";
        while (value >= 1000) {
            result += "M";
            value -= 1000;
        }
        if (value >= 900) {
            result += "CM";
            value -= 900;
        }
        if (value >= 500) {
            result += "D";
            value -= 500;
        }
        if (value >= 400) {
            result += "CD";
            value -= 400;
        }
        while (value >= 100) {
            result += "C";
            value -= 100;
        }
        if (value >= 90) {
            result += "XC";
            value -= 90;
        }
        if (value >= 50) {
            result += "L";
            value -= 50;
        }
        if (value >= 40) {
            result += "XL";
            value -= 40;
        }
        while (value >= 10) {
            result += "X";
            value -= 10;
        }
        if (value >= 9) {
            result += "IX";
            value -= 9;
        }
        if (value >= 5) {
            result += "V";
            value -= 5;
        }
        if (value >= 4) {
            result += "IV";
            value -= 4;
        }
        while (value > 0) {
            result += "I";
            value -= 1;
        }

        return result;
    }

    /**
     * Parses a number in Roman numerals.
     * @param number
     *   The number to parse.
     * @return
     *   The value, or -1 if the number isn't in Roman numerals.
     */
    public static int parse(String number) {
        int value = 0;
        int length = number.length();
        // Loop through characters in the string.
        for (int i = 0; i < length; ) {
            // Look at the next character.
            char c = number.charAt(i);
            // Also look at the following character, but be careful that we
            // might be at the end of the string.
            char n;
            if (i < length - 1)
                n = number.charAt(i + 1);
            else
                // Use a character that won't match anything below.
                n = '?';

            // Accumulate value based on the next character or two characters.
            // If we use one character, advance i by one; if we use two
            // characters, advance i by two.
            if (c == 'M') {
                value += 1000;
                i += 1;
            }
            else if (c == 'C' && n == 'M') {
                value += 900;
                i += 2;
            }
            else if (c == 'D') {
                value += 500;
                i += 1;
            }
            else if (c == 'C' && n == 'D') {
                value += 400;
                i += 2;
            }
            else if (c == 'C') {
                value += 100;
                i += 1;
            }
            else if (c == 'X' && n == 'C') {
                value += 90;
                i += 2;
            }
            else if (c == 'L') {
                value += 50;
                i += 1;
            }
            else if (c == 'X' && n == 'L') {
                value += 40;
                i += 2;
            }
            else if (c == 'X') {
                value += 10;
                i += 1;
            }
            else if (c == 'I' && n == 'X') {
                value += 9;
                i += 2;
            }
            else if (c == 'V') {
                value += 5;
                i += 1;
            }
            else if (c == 'I' && n == 'V') {
                value += 4;
                i += 2;
            }
            else if (c == 'I') {
                value += 1;
                i += 1;
            }
            else {
                System.err.println("not Roman numeral: " + number);
                return -1;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        // For each value in the range we support, convert to Roman numerals and back.
        for (int i = 1; i < 4000; ++i) {
            final String rn = format(i);
            final int j = parse(rn);
            System.out.format("%4d = %-15s = %4d\n", i, rn, j);
            // The value should be the same!
            if (i != j)
                System.err.println("ERROR!");
        }
    }
}
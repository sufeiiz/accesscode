package nyc.c4q.sufeiiz;

import java.util.Scanner;

/**
 * Created by sufeizhao on 3/21/15.
 * Access Code 2.1
 * CaesarCipher.java
 * Class for Encoding and Decoding CaesarCiphers.
 * You are given a class called CaesarCipher with static methods encode and decode
 * Being amateur codebreakers, we want to know if two distinct looking ciphers correspond to the same input message.
 * Write a function called codeBreaker, which accepts two cipher strings and returns a boolean value which tells
 * us whether they are actually the same input message encoded using two different offsets.
 * There are multiple ways to do this. Try to come up with as many solutions as you can.
 */

public class CaesarCipher {

    public static String decode(String enc, int offset) {
        return encode(enc, 26-offset);
    }

    public static String encode(String enc, int offset) {
        offset = offset % 26 + 26;
        StringBuilder encoded = new StringBuilder();
        for (char i : enc.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    encoded.append((char) ('A' + (i - 'A' + offset) % 26 ));
                } else {
                    encoded.append((char) ('a' + (i - 'a' + offset) % 26 ));
                }
            } else {
                encoded.append(i);
            }
        }
        return encoded.toString();
    }

    public static boolean codeBreaker(String cipher1, String cipher2) {
        String message;
        boolean answer = false;

        // encode cipher1, keep cipher2 the same and compare each time we encode
        for (int i=1; i<26; i++) {
            message = encode(cipher1, i);
            if (cipher2.equals(message)) {
                answer = true;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string to encode");

        String input = sc.nextLine();
        String encoded = CaesarCipher.encode(input, 25);
        System.out.println(encoded);

        String decoded = CaesarCipher.decode(encoded, 25);
        System.out.println(decoded);

        System.out.println(codeBreaker("abcde", "zabcd"));

    }
}

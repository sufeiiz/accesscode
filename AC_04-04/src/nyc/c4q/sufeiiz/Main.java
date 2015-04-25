package nyc.c4q.sufeiiz;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String alarm = input.next();

        if (alarm.matches("[0-2]?\\d:[0-5]\\d[a|A|p|P][m|M]")) {
            System.out.println("yay");
        } else
            System.out.println("boo");
    }
}

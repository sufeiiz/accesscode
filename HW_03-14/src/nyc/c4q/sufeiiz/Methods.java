package nyc.c4q.sufeiiz;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by sufeizhao on 3/12/15.
 */
public class Methods {

    // Saves ASCII pic of monkey to be called upon in the game.
    public static void monkeyPic() {
        System.out.println("    .-.     \n" +
                "  c(O_O)c   \n" +
                " ,'.---.`,  \n" +
                "/ /|_|_|\\ \\ \n" +
                "| \\_181_/ | \n" +
                "'. `---' .` \n" +
                "  `-...-' \n");
    }

    // Saves ASCII pic to signify end of game.
    public static void gameOver() {
        System.out.println("  ___   __   _  _  ____     __   _  _  ____  ____ \n" +
                " / __) / _\\ ( \\/ )(  __)   /  \\ / )( \\(  __)(  _ \\\n" +
                "( (_ \\/    \\/ \\/ \\ ) _)   (  O )\\ \\/ / ) _)  )   /\n" +
                " \\___/\\_/\\_/\\_)(_/(____)   \\__/  \\__/ (____)(__\\_)\n");
    }

    // Saves ASCII pic of treasure
    public static void treasure() {
        System.out.println("        /\\____;;___\\\n" +
                "       | /         /\n" +
                "       `. ())oo() .\n" +
                "        |\\(%()*^^()^\\\n" +
                "       %| |-%-------|\n" +
                "      % \\ | %  ))   |\n" +
                "      %  \\|%________|\n" +
                "       %%%%");
    }

    // Saves ASCII pic for winner message
    public static void thanks() {
        System.out.println(" ____ _  _  __  __ _ __ _ ____    ____ __ ____    ____ __    __  _  _ __ __ _  ___ _   \n" +
                "(_  _/ )( \\/ _\\(  ( (  / / ___)  (  __/  (  _ \\  (  _ (  )  / _\\( \\/ (  (  ( \\/ __/ \\  \n" +
                "  )( ) __ /    /    /)  (\\___ \\   ) _(  O )   /   ) __/ (_//    \\)  / )(/    ( (_ \\_/  \n" +
                " (__)\\_)(_\\_/\\_\\_)__(__\\_(____/  (__) \\__(__\\_)  (__) \\____\\_/\\_(__/ (__\\_)__)\\___(_) ");
    }

    public static void prompt() {
        Scanner input = new Scanner(System.in);
        String answer;
        boolean loop = true;

        // Prompt start of game
        System.out.println("You find yourself standing in front of a teleportation device. It can take you anywhere in the world.\n" +
                "Are you brave enough to go on this mysterious adventure? ");
        while (loop) {
            answer = input.next();
            if (answer.equalsIgnoreCase("yes")) {
                System.out.println("\nYou step into the time machine and pressed the big green \"Go\" button.");
                break;
            } else if (answer.equalsIgnoreCase("no")) {
                System.out.println("\nCome back when you are ready.");
                return;
            } else {
                System.err.println("Please enter Yes or No.");
            }
        }
    }

    public static void ending() {
        Scanner input = new Scanner(System.in);
        char finalAnswer;
        boolean loop = true;

        // Choice to become philanthropist or dictator
        System.out.println("Congratulation! You won! Now what will you do with your winnings?" +
                "A. Donate it all to charity and help end world hunger.\n" +
                "B. Use it for world domination!");
        while (loop) {
            finalAnswer = input.next().toUpperCase().charAt(0);
            if (finalAnswer == 'A') {
                System.out.println(":)");
                gameOver();
                break;
            } else if (finalAnswer == 'B') {
                System.out.println(":(");
                gameOver();
                break;
            } else {
                System.err.println("Please choose A or B.");
            }
        }
    }

//    public static void restart() {
//        Scanner input = new Scanner(System.in);
//        String answer;
//
//        System.out.println("Would you like to try again? ");
//        answer = input.next();
//        if (answer.equalsIgnoreCase("yes")) {
//            continue;
//        } else if (answer.equalsIgnoreCase("no")) {
//            return;
//        } else {
//            System.err.println("Please enter yes or no.");
//        }
//    }
}

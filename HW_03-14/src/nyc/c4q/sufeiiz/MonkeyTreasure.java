package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 3/8/15.
 * Access Code 2.1
 * Monkey Treasure Game
 */

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import static nyc.c4q.sufeiiz.Methods.*;

public class MonkeyTreasure {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();
        String answer;
        char finalAnswer;
        int winPercent, passcode;
        boolean loop = true, monkey = false;

        prompt();

        // Level 1
        System.out.println("FLASH! BOING! BOOM! ZAP!\n" +
                "The machine starts shaking, you hold on tightly while you travel through the dimensions of space.");
        monkeyPic();
        System.out.println("A crazy mutant monkey appears! He's banging on the window of the time machine. He's about to break in!\n" +
                "What do you do? Fight, Capture, or Run?");

        while (loop) {
            answer = input.next();
            if (answer.equalsIgnoreCase("fight")) { // 75% change of passing Level 1
                winPercent = random.nextInt(4);
                if (winPercent <= 2) {
                    System.out.println("\n\"AHHHHH!\" You attack the crazy monkey with all you've got!\n" +
                            "BAM! You karate chop him. Then you run for your life.");
                    break;
                } else {
                    System.out.println("\n\"AHHHHH!\" You attack the crazy monkey with all you've got!" +
                    "The monkey is too strong! He eats you alive. You died.");
                    gameOver();
                    return;
                }
            } else if (answer.equalsIgnoreCase("capture")) { // 25% chance of passing Level 1 (but capturing monkey can help you later in game)
                winPercent = random.nextInt(4);
                if (winPercent <= 2) {
                    System.out.println("\nThe monkey is too strong! You were unable to capture him. He eats you alive. You died.");
                    gameOver();
                    return;
                } else {
                    System.out.println("\nYou find some rope inside the machine. Just as the monkey breaks in, you tie down his limbs.\n" +
                            "Phew! That was close. You look around and realize you're in the jungle. You decide to explore a little.");
                    monkey = true;
                    break;
                }
            } else if (answer.equalsIgnoreCase("run")) { // 100% chance of passing Level 1
                System.out.println("\nJust as the monkey breaks in, you duck under him and run as fast as you can.");
                break;
            } else {
                System.err.println("Please enter Fight, Capture, or Run.");
            }
        }

        // Level 2
        while (loop) {
            if (monkey) { // Skip to level 3 if monkey was captured
                break;
            } else {
                System.out.println("As you're running for your life, you see an abandoned ATV. You hop on and slammed on the gas pedal.\n" +
                        "But the monkey is hot on your tail! You see a few things within arms reach that you can throw at him.\n" +
                        "What should you throw? A banana, a turtle, or a mushroom?");
                while (loop) {
                    answer = input.next();
                    if (answer.equalsIgnoreCase("banana")) { // 100% chance of passing level 2
                        System.out.println("\nYou grab a banana off a tree and throw it behind you.\n" +
                                "The monkey stopped chasing you to eat the banana!\n" +
                                "You finally catch your breath and realize you're in a jungle. You decide to explore a little.");
                        break;
                    } else if (answer.equalsIgnoreCase("turtle")) { // 0% (Do not hurt poor helpless animals!)
                        System.out.println("\nYou grab a helpless turtle off a rock and throw it behind you.\n" +
                                "You missed! The monkey grabs you off the ATV and eats you alive. You died.");
                        gameOver();
                        return;
                    } else if (answer.equalsIgnoreCase("mushroom")) { // 50% chance of passing level 2
                        winPercent = random.nextInt(2);
                        if (winPercent == 0) {
                            System.out.println("\nYou yank a mushroom off the ground and throw it behind you.\n" +
                                    "The Monkey stopped chasing you to eat the mushroom!\n" +
                                    "You finally catch your breath and realize you're in a jungle. You decide to explore a little.");
                            break;
                        } else {
                            System.out.println("\nYou yank a mushroom off the ground and throw it behind you.\n" +
                                    "The soft mushroom hits him on the head, angering him even more!\n" +
                                    "The monkey grabs you off the ATV and eats you alive. You died.");
                            gameOver();
                            return;
                        }
                    } else {
                        System.err.println("Please enter banana, turtle, or mushroom.");
                    }
                }
                break;
            }
        }

        // Level 3
        System.out.println("You come across a cave door. The inscription reads: \"Enter the three digit passcode to proceed.\"");
        while (loop) {
            try {
                passcode = input.nextInt();
            }
            catch (InputMismatchException e) { // Catches error if user inputs String instead of int
                passcode = 0;
                input.next();
            }

            if (passcode == 181) { // Found inside the Monkeys mouth when he first appeared
                System.out.println("\nThe walls creak as they slowly open. Inside, you find a treasure box! It must be worth billions of dollars!");
                treasure();
                break;
            } else if (passcode > 999) {
                System.err.println("Your passcode is too long. Please try again.");
            } else if (passcode < 99) {
                System.err.println("Your passcode is too short. Please try again.");
            } else {
                System.err.println("Please try again.\n" +
                        "Enter the three digit passcode. Hint: Monkey See Monkey Do.");
            }
        }

        // Ending
        System.out.println("Congratulation! You won! Now what will you do with your winnings?\n" +
                "A. Donate it all to charity and help end world hunger.\n" +
                "B. Use it for world domination!");
        while (loop) {
            finalAnswer = input.next().toUpperCase().charAt(0);
            if (finalAnswer == 'A') {
                System.out.println("\n You successfully ended world hunger. You saved the world!");
                thanks();
                break;
            } else if (finalAnswer == 'B') {
                System.out.println("\nMUAHAHAHA You are now the ruler of the world!");
                thanks();
                break;
            } else {
                System.err.println("Please choose A or B.");
            }
        }
    }
}

package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 3/7/15.
 */

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class FortuneTeller {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        Random answer = new Random();

        String[] fortuneAnswers = {
                "I believe so.\n",
                "Definitely not.\n",
                "Ask again later. \n",
                "Pay me dollar and I will tell you. \n",
                "I'm not telling you that.. \"Young grasshopper\".\n",
                "Yes yes yes!\n",
                "I think so...\n",
                "Maybe later\n"
        };


        boolean loop = true;

        while (loop) {
            System.out.println("Ask me a question, or type \"exit\" to leave:");
            String exit = input.nextLine();
            if (exit.equals("exit")) {
                loop = false;
            } else {
                //System.out.println("Ask me a question: ");
                //String question = input.nextLine();
                int index = answer.nextInt(7);
                System.out.println(fortuneAnswers[index]);
                //Runtime.getRuntime().exec("clear");

            }
        }
    }
}

package nyc.c4q.sufeiiz;

import java.util.Queue;
import java.util.Random;
import java.util.Stack;

/**
 * Created by sufeizhao on 10/15/15.
 */
public class InClassProblems {
    /* Stream Problem - asked in interview
       Given a stream of numbers, generate a random number from the stream. You are allowed to use
       only O(1) space and the input is in the form of stream, so can’t store the previously seen numbers. */
    public static int randomNum(int[] stream) {
        Random random = new Random(stream.length);
        return stream[random.nextInt()];
    }

    /* Recursive Stack Sort
       Given a stack, sort it using recursion. Use of any loop constructs like while, for..etc is not allowed.
       We can only use the following ADT functions on Stack S: */
    public static void sortStack(Stack<Object> stack) {
        if (stack.isEmpty())
            return;

        Object top = stack.peek();
        stack.pop();

        insert(top);

    }

    public static void insert(Object a) {

    }

    /* Recursive Queue Reversal
       Given a queue, reverse it using recursion. Use of any loop constructs like while, for..etc is not
       allowed. We can only use the following ADT functions on Queue Q: */
    public static Queue reverseQueue(Queue queue) {}

    /* Implement Merge Sort */

    /* Longest Substring ­ second one is a google question
       1. Given a string, find the length of the longest substring without repeating characters. For example,
       the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For
       "bbbbb" the longest substring is "b", with the length of 1. */
    public static String longestSubstring(String string) {
        String substring;


    }

    /* 2. Given a string, find the longest substring that contains only k unique characters. For example, given
            "abcbbbbcccbdddadacb"
       for k = 2 the longest substring is "bcbbbbcccb".
       for k = 1 the longest substring is “bbbb”.
       Good implementation: O(k*N) N = string.length
       Best implementation: O(N) */

    /* Remove Nth node from end of Linked List ­ asked in interview
       Given a linked list, remove the nth node from the end of list and return its head. For example, given
       linked list 1­>2­>3­>4­>5 and n = 2, the result is 1­>2­>3­>5. You DO NOT know the length of the linked list */

    /* LastFM Ranking ­ take home interview
       The attached utf­8 encoded text file contains the favorite musical artists of 1000 users from LastFM.
       Each line is a list of up to 50 artists, formatted as follows:
            ● Radiohead, Pulp, Morrissey, Delays, Stereophonics, Blur, Suede, Sleeper, The La's, Super Furry Animals
            ● Band of Horses, Iggy Pop, The Velvet Underground, Radiohead, The Decemberists, Morrissey, Television
       Write a program that, using this file as input, produces a list of pairs of artists which appear
       TOGETHER in at least fifty different lists. For example, in the above sample, Radiohead and
       Morrissey appear together twice, but every other pair appears only once. Your program should
       output the pair list to stdout in the same form as the input.
            eg.: Artist Name 1, Artist Name 2
       You MAY return an approximate solution, i.e. lists which appear at least 50 times with high
       probability, as long as you explain why this tradeoff improves the performance of the algorithm.
       Please include, either in comments or in a separate file, a brief description of the run­time and
       space complexity of your algorithm.*/
}

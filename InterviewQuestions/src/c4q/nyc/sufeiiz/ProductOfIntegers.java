package c4q.nyc.sufeiiz;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by sufeizhao on 11/12/15.
 */
public class ProductOfIntegers {
    /*
    * You have a list of integers, and for each index you want to find the product of every integer except
    * the integer at that index. Write a function get_products_of_all_ints_except_at_index() that takes a list
    * of integers and returns a list of the products.
    * Do not use division in your solution.
    * */

    public static ArrayList<Integer> productExceptAtIndex(ArrayList<Integer> nums) {
        ArrayList<Integer> products = new ArrayList<Integer>();
        ArrayList<Integer> productBeforeIndex = new ArrayList<Integer>();
        ArrayList<Integer> productAfterIndex = new ArrayList<Integer>();

        // populate productBeforeIndex
        for (int i = 0; i < nums.size(); i++) {
            if (i == 0)
                productBeforeIndex.add(1);
            else
                productBeforeIndex.add(productBeforeIndex.get(i - 1) * nums.get(i - 1));
        }

        // populate productAfterIndex
        Stack<Integer> stack = new Stack<Integer>();
        for (int j = nums.size() - 1; j >= 0; j--) {
            if (j == nums.size() - 1)
                stack.push(1);
            else
                stack.push(stack.peek() * nums.get(j + 1));
        }

        while (!stack.isEmpty()) {
            productAfterIndex.add(stack.pop());
        }

        // populate products
        for (int k = 0; k < productBeforeIndex.size(); k++) {
            products.add(productBeforeIndex.get(k) * productAfterIndex.get(k));
        }

        return products;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(7);
        nums.add(3);
        nums.add(4);

        productExceptAtIndex(nums);
        System.out.println(productExceptAtIndex(nums));
    }
 }

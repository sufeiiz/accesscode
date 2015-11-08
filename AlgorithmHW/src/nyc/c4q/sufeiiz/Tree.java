package nyc.c4q.sufeiiz;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Tree {
    static String expression = "a b + c d e + * *"; //postfix
    static String operators = "+-*/%";

    public static Node binaryTree(String expression) {
        Stack<Node> stack = new Stack<Node>();
        Node node;
        String symbol;

        Scanner scan = new Scanner(expression);

        while (scan.hasNext()) {
            symbol = scan.next();
            node = new Node(symbol);

            if (operators.contains(symbol)) {
                node.right = stack.pop();
                node.left = stack.pop();
            }

            stack.push(node);
        }

        if (stack.size() != 1)
            throw new IllegalStateException("Invalid stack");

        return stack.pop();
    }

    public static void printPostfix(Node node) {
        if (node == null) return;

        printPostfix(node.left);
        printPostfix(node.right);
        System.out.println(node.symbol);
    }

    public static void printPrefix(Node node) {
        if (node == null) return;

        System.out.println(node.symbol);
        printPrefix(node.left);
        printPrefix(node.right);
    }

    public static void printInfix(Node node) {
        if (node == null) return;

        printInfix(node.left);
        System.out.println(node.symbol);
        printInfix(node.right);
    }

    public static void printBreadth(Node root) {
        if (root == null) return;

        Queue<Node> queue = new ArrayDeque<Node>();
        Node node;
        queue.add(root);

        while (!queue.isEmpty()) {
            node = queue.remove();
            System.out.println(node.symbol);

            if (node.left != null)
                queue.add(node);
            if (node.right != null)
                queue.add(node);
        }
    }

    public static Node formBST() {
        Node ten = new Node("10");
        Node five = new Node("5");
        Node twelve = new Node("12");
        Node two = new Node("2");
        Node six = new Node("6");
        Node three = new Node("3");
        Node four = new Node("4");

        ten.left = five;
        ten.right = twelve;
        five.left = two;
        five.right = six;
        two.right = three;
        three.right = four;

        return ten;
    }

    public static Node find(Node node, int data) {
        if (node == null) return null;
        else if (data == Integer.parseInt(node.symbol))
            return node;
        else if (data < Integer.parseInt(node.symbol))
            find(node.left, data);
        else
            find(node.right, data);

        return null;
    }

    public static int findMin(Node node) {
        if (node == null)
            throw new IllegalArgumentException("Null node");

        Node current = node;
        while (current.left != null) {
            current = current.left;
        }

        return Integer.parseInt(current.symbol);
    }

    public static int findMax(Node node) {
        if (node == null)
            throw new IllegalArgumentException("Null node");
        if (node.right == null)
            return Integer.parseInt(node.symbol);
        else
            return findMax(node.right);
    }

    public static void insert(Node root, Node newData) {
        if (root == null)
            root = newData;
        else if (Integer.parseInt(newData.symbol) < Integer.parseInt(root.symbol))
            if (root.left == null)
                root.left = newData;
            else
                insert(root.left, newData);
        else if (Integer.parseInt(newData.symbol) > Integer.parseInt(root.symbol))
            if (root.right == null)
                root.right = newData;
            else
                insert(root.right, newData);
    }

    public static int findHeight(Node root) {
        if (root == null || (root.left == null && root.right == null))
            return 0;
        else {
            int heightLeft = 1 + findHeight(root.left);
            int heightRight = 1 + findHeight(root.right);

            return Math.max(heightLeft, heightRight);
        }
    }

    public static boolean isBST(Node root) {
        if (root.left != null)
            return isBST(root.left) || root.left.num <= root.num;
        else if (root.right != null)
            return isBST(root.right) || root.right.num >= root.num;
        else
            return isBST(root.left) || isBST(root.right);
    }

    public static void main(String[] args) {
        Node node = binaryTree(expression);
        printPostfix(node);
        printPrefix(node);
        printInfix(node);
        System.out.println(findHeight(node));
    }

}

class Node {
    Node left;
    Node right;
    String symbol;
    int num;

    public Node(String s) {
        this.symbol = s;
    }
}

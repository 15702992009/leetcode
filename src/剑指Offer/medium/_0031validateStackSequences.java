package 剑指Offer.medium;

import java.util.Stack;

public class _0031validateStackSequences {
    class Solution {

    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        for (int val : pushed) {
            stack.push(val);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {4, 5, 3, 2, 1};
        boolean b1 = validateStackSequences(a, b);
        System.out.println(b1);
    }
}

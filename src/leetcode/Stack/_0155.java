package leetcode.Stack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _0155 {
    class MinStack {
        List<Integer> stack = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            stack.add(x);
            min = Math.min(x, min);
        }

        public void pop() {
            if (stack.isEmpty()) throw new RuntimeException("empty stack");
            if (stack.get(stack.size() - 1) == min) {
                min = Integer.MAX_VALUE;
                stack.remove(stack.size() - 1);
                for (Integer integer : stack) {
                    min = Math.min(integer, min);
                }
            } else stack.remove(stack.size() - 1);

        }

        public int top() {
            return stack.get(stack.size() - 1);
        }

        public int getMin() {
            return min;
        }

        @Test
        public void test() {
            MinStack minstack = new MinStack();
            minstack.push(2);
            minstack.push(0);
            minstack.push(3);
            minstack.push(0);
            int min1 = minstack.getMin();
            minstack.pop();
            int min2 = minstack.getMin();
            minstack.pop();
            int min3 = minstack.getMin();
            minstack.pop();
            int min4 = minstack.getMin();
            System.out.println(min4);
        }
    }

}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


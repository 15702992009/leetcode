package swordToOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class _0030MinStack {
    class MinStack {
        private Stack<Integer> stack = new Stack<>();
        private int min = Integer.MAX_VALUE;
        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            //先压先前最小值
            //再压一个当前最小值，保证最小值一直存在
            if(x <= min){
                stack.push(min);
                min = x;
            }

            stack.push(x);
        }

        public void pop() {
            if(stack.pop() == min){
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min;
        }
    }


}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */


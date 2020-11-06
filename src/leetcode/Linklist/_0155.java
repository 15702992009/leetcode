package leetcode.Linklist;

import java.util.Stack;

/**
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 */
public class _0155 {
/**
 * 复习deque和stack API
 *
 */

}
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> helper;

    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<>();
        helper=new Stack<>();
        helper.push(Integer.MAX_VALUE);
}

    public void push(int x) {
        stack.push(x);
        if (helper.peek()>=x){
            helper.push(x);
        }
    }

    public void pop() {
        Integer pop = stack.pop();
        if (helper.peek().equals(pop)){
            helper.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return helper.peek();
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
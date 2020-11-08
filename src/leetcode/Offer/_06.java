package leetcode.Offer;


import java.util.ArrayList;
import java.util.Stack;



public class _06 {
    public int[] reversePrint(ListNode head) {
        ListNode p=head;
        Stack<ListNode> stack=new Stack();
        while (p!=null){
            stack.push(p);
            p=p.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;

    }
}

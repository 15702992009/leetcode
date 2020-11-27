package leetcode.Offer;

import leetcode.swordToOffer.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class _54 {
    int count;
    int result = -1;

    public int kthLargest(TreeNode root, int k) {
        count = k;
        kthLargest(root);
        return result;
    }

    public void kthLargest(TreeNode root) {
        if (Objects.nonNull(root)) {
            kthLargest(root.right);
            if (count == 1) {
                result = root.val;
                count--;
                return;
            }
            count--;
            kthLargest(root.left);
        }
    }

    /**
     * feidiedai
     *
     * @param root
     * @param k
     * @return
     */

    public int kthLargestB(TreeNode root, int k) {
        int count = 1;
        Stack<TreeNode> stack = new Stack<>();
        while (Objects.nonNull(root) || !stack.empty()) {
            while (Objects.nonNull(root)) {
                stack.push(root);
                root = root.right;
            }
            TreeNode pop = stack.pop();
            if (count == k) {
                return pop.val;
            }
            count++;
            root = pop.left;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(12 / 10);
    }


    class CQueue {
        Queue stack1;
        Queue stack2;

        public CQueue() {
            stack1 = new LinkedList();
            stack2 = new LinkedList();
        }

        public void appendTail(int value) {
            stack1.add(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.add(stack1.poll());
                }
            }
            if (stack2.isEmpty()) return -1;
            else
                return (int) stack2.poll();
        }
    }
}

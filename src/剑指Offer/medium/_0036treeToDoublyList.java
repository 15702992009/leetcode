package 剑指Offer.medium;

import java.util.*;

/**
 * 前驱节点
 * 当前节点
 * 要改变的节点
 */
public class _0036treeToDoublyList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }


    class Solution {
        Queue<Node> nodeList = new LinkedList<>();

        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            helper(root);

            Node dum = nodeList.peek();
            while (!nodeList.isEmpty()) {
                Node a = nodeList.poll();
                Node b = nodeList.peek();
                if (b != null) {
                    a.right = b;
                    b.left = a;
                } else {
                    a.right = dum;
                    dum.left = a;
                }
            }
            return dum;

        }

        public void helper(Node root) {
            if (root == null) return;
            helper(root.left);
            nodeList.add(root);
            helper(root.right);
        }

    }

    /**
     * official solve
     */
    class SolutionPlus {
/*        Node pre, head;
        public Node treeToDoublyList(Node root) {
            if(root == null) return null;
            dfs(root);
            head.left = pre;
            pre.right = head;
            return head;
        }
        void dfs(Node cur) {
            if(cur == null) return;
            dfs(cur.left);
            if(pre != null) pre.right = cur;
            else head = cur;
            cur.left = pre;
            pre = cur;
            dfs(cur.right);
        }*/


        Node pre, head;

        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            dfs(root);
            pre.right = head;
            head.left = pre;
            return head;
        }

        /**
         * 结束条件：
         *
         * @param cur
         */
        void dfs(Node cur) {
            if (cur == null) return;
            dfs(cur.left);
            if (pre != null) pre.right = cur;
            else head = cur;
            cur.left = pre;
            pre = cur;
            dfs(cur.right);

        }
    }


}

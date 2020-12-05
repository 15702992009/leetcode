package 剑指Offer.medium;

import java.util.*;

public class _0032levelOrder {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();

            if (root == null) return null;
            queue.add(root);
            while (!queue.isEmpty()) {

                LinkedList<Integer> tmp = new LinkedList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {

                    TreeNode node = queue.poll();
                    if (res.size() % 2 == 0) { //odd tmp
                        tmp.addLast(node.val);
                    } else {
                        tmp.addFirst(node.val);
                    }
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }

                res.add(tmp);
            }
            return res;
        }
    }

}

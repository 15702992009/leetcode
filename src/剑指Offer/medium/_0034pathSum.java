package 剑指Offer.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题34. 二叉树中和为某一值的路径（回溯法，清晰图解）
 */
public class _0034pathSum {
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
        List<List<Integer>> res = new ArrayList<>();

        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            helper(root, sum);
            return res;
        }

        public void helper(TreeNode node, int sum) {
            if (node == null) return;
            path.addLast(node.val);
            sum -= node.val;
            if (sum == 0 && node.left == null && node.right == null) {
                res.add(new LinkedList<>(path));
            }
            helper(node.left, sum);
            helper(node.right, sum);
            path.removeLast();
        }
    }

}

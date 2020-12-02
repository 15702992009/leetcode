package leetcode.Tree;

import swordToOffer.TreeNode;

public class _0101 {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return recur(root, root);
        }

        public boolean recur(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            return recur(left.left, right.right) && recur(left.right, right.left);
        }
    }

}




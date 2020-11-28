package leetcode.swordToOffer;

import java.util.Map;

public class _0068 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        /**
         * Binary tree
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root==null||root==p||root==q) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left==null&&right==null) return null;
            if (left==null) return right;
            if (right==null) return left;
            return root;
        }

        /**
         * Binary search tree
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor_BST(TreeNode root, TreeNode p, TreeNode q) {
            while(root != null) {
                if(root.val < p.val && root.val < q.val) // p,q 都在 root 的右子树中
                    root = root.right; // 遍历至右子节点
                else if(root.val > p.val && root.val > q.val) // p,q 都在 root 的左子树中
                    root = root.left; // 遍历至左子节点
                else break;
            }
            return root;
        }

    }
}

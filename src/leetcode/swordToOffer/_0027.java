package leetcode.swordToOffer;


import java.util.Stack;

public class _0027 {
    /**
     *
     * 方法一：递归法
     *
     */
    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if(root == null) return null;
            TreeNode tmp = root.left;

            root.left = mirrorTree(root.right);
            root.right = mirrorTree(tmp);
            return root;
        }
    }

    /**
     *
     */
    class Solution1 {
        public TreeNode mirrorTree(TreeNode root) {
            if(root == null) return null;
            Stack<TreeNode> stack = new Stack<>() {{ add(root); }};
            while(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if(node.left != null) stack.add(node.left);
                if(node.right != null) stack.add(node.right);
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
            }
            return root;
        }
    }


}

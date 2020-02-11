package leetcode.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 考察二叉树的中序遍历：左 根 右 的顺序
 * 三种遍历方法的考查顺序一致，得到的结果却不一样，原因在于：
 *
 * 先序：考察到一个节点后，即刻输出该节点的值，并继续遍历其左右子树。(根左右)
 *
 * 中序：考察到一个节点后，将其暂存，遍历完左子树后，再输出该节点的值，然后遍历右子树。(左根右)
 *
 * 后序：考察到一个节点后，将其暂存，遍历完左右子树后，再输出该节点的值。(左右根)
 *
 * 
 */
public class _0094 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class MySolution {
        Stack<Integer> stack=new Stack<>();
        List<Integer> ans=new ArrayList<Integer>();
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root==null) return ans;
            midTravel(root);
            return ans;
        }
        public void midTravel(TreeNode node){
            stack.push(node.val);
            if (node.left!=null) midTravel(node.left);
            ans.add(stack.pop());
            if (node.right!=null) midTravel(node.right);
            return;
        }
    }

}
package leetcode.Tree;

import leetcode.swordToOffer.TreeNode;

public class _0101 {

}
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return helper(root.left,root.right);
    }
    public boolean helper(TreeNode t1,TreeNode t2){
        boolean flag=true;
        boolean flag1=true;

        if(t1==null&&t2==null) return true;
        else if ( t1==null&&t2!=null) return false;
        else if ( t2==null&&t1!=null) return false;
        else if (t1.val!=t2.val)
            return false;


        flag=helper(t1.right,t2.left);
        flag1=helper(t1.left,t2.right);
        if(flag==true&&flag1==true)
            return true;

        return false;
    }
}
package leetcode.Queue;

import java.util.*;

public class _0103 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
            if (root == null) return list;
            Queue<TreeNode> queue = new LinkedList();
            queue.offer(root);
            int flag = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> inside = new ArrayList();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    inside.add(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                if (flag == 1) {
                    Collections.reverse(inside);
                    list.add(inside);
                    flag = 0;
                } else {
                    list.add(inside);
                    flag = 1;
                }
            }
            return list;
        }
    }
}

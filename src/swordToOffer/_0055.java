package swordToOffer;


import java.util.*;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 */
public class _0055 {


    class Solution {
        int deepth = 0;
        int ans = 0;

        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            helper(root);
            return ans;
        }

        public void helper(TreeNode root) {
            deepth++;

            if (root == null) {
                --deepth;
                return;
            }
            ans = Math.max(deepth, ans);

            helper(root.left);
            helper(root.right);

            --deepth;
        }

        //========================================================================
        public int maxDepth1(TreeNode root) {
            if (root == null) return 0;

            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
//========================================================================

        /**
         * 方法二：层序遍历（BFS）
         * 树的层序遍历 / 广度优先搜索往往利用 队列 实现。
         * 关键点： 每遍历一层，则计数器 +1+1 ，直到遍历完成，则可得到树的深度。
         * 算法解析：
         * 特例处理： 当 root​ 为空，直接返回 深度 00 。
         * 初始化： 队列 queue （加入根节点 root ），计数器 res = 0。
         * 循环遍历： 当 queue 为空时跳出。
         * 初始化一个空列表 tmp ，用于临时存储下一层节点；
         * 遍历队列： 遍历 queue 中的各节点 node ，并将其左子节点和右子节点加入 tmp；
         * 更新队列： 执行 queue = tmp ，将下一层节点赋值给 queue；
         * 统计层数： 执行 res += 1 ，代表层数加 11；
         * 返回值： 返回 res 即可。
         *
         * @param root
         * @return
         */
        public int maxDepth2(TreeNode root) {

            if (root == null) return 0;
            List<TreeNode> queue = new LinkedList<>() {
                {
                    add(root);
                }
            }, tmp;
            int res = 0;
            while (!queue.isEmpty()) {
                tmp = new LinkedList<>();
                for (TreeNode node : queue) {
                    if (node.left != null) tmp.add(node.left);
                    if (node.right != null) tmp.add(node.right);
                }
                queue = tmp;
                res++;
            }
            return res;
        }

        public int maxDepth3(TreeNode root) {
            if (root == null) return 0;
            //BFS
            List<TreeNode> queues = new LinkedList<>();
            int ans = 0;

            queues.add(root);
            List<TreeNode> tmp = new LinkedList<>();

            while (!queues.isEmpty()) {
                //
                tmp = new LinkedList<>();

                for (TreeNode queue : queues) {
                    if (queue.left != null) tmp.add(queue.left);
                    if (queue.right != null) tmp.add(queue.right);
                }

                queues = tmp;
                ++ans;
            }
            return ans;
        }

    }

//    剑指 Offer 55 - II. 平衡二叉树


    class SolutionII {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        public boolean isBalanced(TreeNode root) {
            countDeepth(root, 0);
            return max - min <= 1;
        }

        int countDeepth(TreeNode treeNode, int depth) {
            if (treeNode == null) return depth;

            depth++;
            countDeepth(treeNode.left, depth);
            countDeepth(treeNode.right, depth);
            if (treeNode.left == null && treeNode.right == null) {
                //save depth
                if (depth>max) max=depth;
                if (depth<min) min=depth;
            }
            depth--;
            return depth;
        }
    }
}

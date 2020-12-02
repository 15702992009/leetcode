package 剑指Offer.easy;

/*


 */
public class _0053_search_3 {
    /**
     * my solution
     */
    class Solution {
        int cnt = 0;

        /**
         * 二分查找
         *
         * @param nums
         * @param target
         * @return
         */
        public int search(int[] nums, int target) {
            int hi = nums.length - 1;
            helper(nums, target, 0, hi);
            return cnt;
        }

        /**
         * @param nums
         * @param low
         * @param hi
         * @return
         */
        public void helper(int[] nums, int target, int low, int hi) {
            if (low <= hi) {
                int mid = low + (hi - low) / 2;
                if (nums[mid] == target) {
                    cnt++;
                    helper(nums, target, low, mid - 1);
                    helper(nums, target, mid + 1, hi);
                } else if (nums[mid] < target) {
                    helper(nums, target, mid + 1, hi);
                } else {
                    helper(nums, target, low, mid - 1);
                }
            }
        }
    }

    /**
     * official solution
     */
    class SolutionB {
        int cnt = 0;    // 计数器count

        public int search(int[] nums, int target) {
            // 初始化low = 0, high = nums.length - 1
            helper(nums, target, 0, nums.length - 1);
            return cnt;
        }

        // 根据算法设计分3种情况
        public void helper(int[] nums, int target, int low, int high) {
            if (low <= high) {
                int mid = (high - low) / 2 + low;
                if (nums[mid] == target) {
                    cnt++;      // 计数一次
                    helper(nums, target, low, mid - 1);
                    helper(nums, target, mid + 1, high);
                } else if (nums[mid] > target) {
                    helper(nums, target, low, mid - 1);
                } else {
                    helper(nums, target, mid + 1, high);
                }
            }
        }

    }


}

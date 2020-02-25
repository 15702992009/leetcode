package leetcode.Array.medium;

public class FindFirstAndLastPositionOfElementInSortedArray {
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;
        //[lo,mid) [mid,hi)
        while (lo < hi) {
            int mid = (hi + lo) / 2;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                hi = mid;
            } else {
                // TODO :细节lo=mid+1；
                lo = mid + 1;
            }
        }
        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        int leftIdx = extremeInsertionIndex(nums, target, true);
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }
        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;
        return targetRange;
    }
}

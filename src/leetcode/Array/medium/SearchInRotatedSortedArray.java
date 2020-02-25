package leetcode.Array.medium;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return -1;
        int len= nums.length;
        int i=0;
        while (i<=len/2){
            if (nums[i]==target) return i;
            if (nums[len-i-1]==target) return len-i-1;
            i++;
        }
        return -1;
    }
}

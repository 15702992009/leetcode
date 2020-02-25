package leetcode.Array.medium;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int[] index = new int[2];  //index[0]存值，index[1]存该值对应的坐标，默认值
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index[0] = nums[i];
                index[1] = i;
                for (int j = i + 1; j < nums.length; j++) {   //找出[i,length)中大于nums[i-1]的最小数,更新index
                    if (nums[j] > nums[i - 1] && nums[j] < index[0]) {  //大于nums[i-1] 小于nums[i]的最小数（index默认值就是nums[i]的参数）
                        index[0] = nums[j];
                        index[1] = j;
                    }
                }
                int tem = nums[i - 1];
                nums[i - 1] = nums[index[1]];
                nums[index[1]] = tem;
                Arrays.sort(nums, i, nums.length);
                break;
            }
            if (i == 1) {
                Arrays.sort(nums);
            }
        }
    }
}

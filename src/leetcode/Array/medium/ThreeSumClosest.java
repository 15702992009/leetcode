package leetcode.Array.medium;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length;i++){
            int start=i+1,end=nums.length-1;
            while(start<end){
                int sum=nums[i]+nums[start]+nums[end];
                if(Math.abs(sum-target)<Math.abs(ans-target))
                    ans=sum;
                if(sum>target)
                    end--;
                else if(sum<target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }
}

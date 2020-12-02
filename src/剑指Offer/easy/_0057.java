package 剑指Offer.easy;

import java.util.ArrayList;
import java.util.List;

/**
 *  i<= limit
 *  attention :  the title explains the result is continues integer sequence
 *    sum=0;
 *
 */

public class _0057 {
    class Solution {
        public int[][] findContinuousSequence(int target) {
            List<int[]> vec=new ArrayList<>();
            int limit = (target - 1) / 2;
            int sum=0;
            // i<=limit
            for (int i = 1; i <= limit; i++) {
                for (int j = i; ; j++) {
                    sum+=j;
                    if (sum>target){
                        sum=0;
                        break;
                    }
                    else if (sum==target){
                        int[] res=new int[j-i+1];
                        for (int k = i; k < j; k++) {
                            res[k-i]=k;
                        }
                        vec.add(res);
                        // clear sum value
                        sum=0;
                        break;
                    }
                    else ;
                }
            }
            return vec.toArray(new int[vec.size()][]);
        }





        public int[] twoSum(int[] nums, int target) {
            int hi = nums.length-1;
            int lo=0;
            int[] res= new int[2];
            while (lo<hi){
                int sum=nums[lo]+nums[hi];
                if (sum>target) --hi;
                else if (sum<target) ++lo;
                else {
                    res[0]=nums[lo];
                    res[1]=nums[hi];
                    break;
                }
            }
            return res;
        }
    }
}

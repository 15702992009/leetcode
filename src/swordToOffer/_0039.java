package swordToOffer;

import java.util.HashMap;

public class _0039 {
    class Solution {
        public int majorityElement(int[] nums) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int size = nums.length / 2;
            for (int num : nums) {
                hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
                if (hashMap.get(num)>size) return num;
            }
            return -1;
        }
    }

    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}

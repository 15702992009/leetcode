package leetcode.HashTable;

import java.util.Hashtable;

public class _0001 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int i = 0;
            Hashtable<Integer, Integer> hashtable = new Hashtable<>();
            for (int num : nums) {
                if (hashtable.containsKey(target - num)) {
                    return new int[]{hashtable.get(target - num), i};
                } else {
                    hashtable.put(num, i++);
                }
            }
            return new int[]{};
        }
    }

}


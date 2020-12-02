package swordToOffer;

import java.util.HashSet;
import java.util.Set;

public class _0061 {
    class Solution {
        public boolean isStraight(int[] nums) {
            int max=0,min=14;
         Set<Integer> sets=new HashSet<>();
            for (int num : nums) {
                if (num==0) continue;
                if (sets.contains(num)) return false;
                sets.add(num);
                if (num>max) max=num;
                if (num<min) min=num;
            }
            return max-min<5;
        }
    }

}

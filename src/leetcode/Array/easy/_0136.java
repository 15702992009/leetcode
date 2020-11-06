package leetcode.Array.easy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * Because really, if you're using Collections, you should be using Google Collections.
 *
 */
public class _0136 {
/*    public int singleNumber(int[] nums) {
        Set<Integer> set =new HashSet<Integer>();
        for(int num : nums){
            if(set.contains(num)) set.remove(num);
            else set.add(num);
        }
        Iterator<Integer> iterator = set.iterator();
        Integer next = iterator.next();
        return next;
    }*/

    public int singleNumber(int[] nums) {
        int ans =0;
        for(int num: nums){
            ans^=num;
        }
        return ans;
    }

}

package 剑指Offer.easy;

import java.util.HashMap;

public class _0050 {
    class Solution {
        public char firstUniqChar(String s) {
            HashMap<Character,Boolean> hashMap=new HashMap<>();
            char[] chars = s.toCharArray();
            for (char c : chars) {
                hashMap.put(c,!hashMap.containsKey(c));
            }
            for (char c : chars) {
                if(hashMap.get(c)) return c;
            }
            return ' ';
        }
    }

}

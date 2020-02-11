package leetcode.Stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * valid parentheses
 * 思路：
 * 1. 括号匹配问题可以用stack处理，用hashMap保存括号，遍历给定字符串
 */


public class _0020 {
    class Solution {
        HashMap<Character, Character> hashMap = new HashMap<Character, Character>();

        {
            hashMap.put('(', ')');
            hashMap.put('[', ']');
            hashMap.put('{', '}');
        }

        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<Character>();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                if (hashMap.containsKey(s.charAt(i))) {
                    stack.push(s.charAt(i));
                    if (stack.size() > len / 2)
                        return false;
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character tmp = stack.peek();
                    if (s.charAt(i) == hashMap.get(tmp)) stack.pop();
                    else return false;
                }
            }
            return stack.isEmpty();
        }
    }

}
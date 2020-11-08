package leetcode.swordToOffer;

/**
 *面试题58 - II. 左旋转字符串（切片 / 列表 / 字符串，清晰图解）
 * 本题做法较多，本文主要介绍 “字符串切片” ， “列表遍历拼接” ， “字符串遍历拼接” 三种方法。
 */
public class _0058 {
    class Solution {
        /**
         * 方法一：字符串切片
         * @param s
         * @param n
         * @return
         */
        public String reverseLeftWords(String s, int n) {
            return  s.substring(n,s.length())+s.substring(0,n);
        }

        /**
         * stringBuilder 拼接方法
         * @param s
         * @param n
         * @return
         */
        public String reverseLeftWords1(String s, int n) {
            int  length =s.length();
            StringBuilder stringBuilder=new StringBuilder();
            for (int i = n; i < length; i++) {
                stringBuilder.append(s.charAt(i));
            }
            for (int i = 0; i < n; i++) {
                stringBuilder.append(s.charAt(i));
            }
            return stringBuilder.toString();
        }
    }
}

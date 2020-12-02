package 剑指Offer.easy;

import java.util.Stack;

/**
 * String.trim()
 * Java ： 以空格为分割符完成字符串分割后，若两单词间有 x > 1x>1 个空格，则在单词列表 strsstrs 中，此两单词间会多出 x - 1x−1 个 “空单词” （即 "" ）。
 * 解决方法：倒序遍历单词列表，并将单词逐个添加至 StringBuilder ，遇到空单词时跳过。
 */
public class _0058I {
    /**
     *  方法一：
     *          库函数
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        String[] strings = s.split(" ");

        Stack<String> stack = new Stack<>();

        for (String string : strings) {
            if (string.equals("")) continue;
            String trim = string.trim();
            stack.push(trim);
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty())
            builder.append(stack.pop()).append(" ");
        return builder.toString().trim();

    }


    class Solution {
        public String reverseWords(String s) {
            s = s.trim(); // 删除首尾空格
            int j = s.length() - 1, i = j;
            StringBuilder res = new StringBuilder();
            while(i >= 0) {
                while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
                res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
                while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
                j = i; // j 指向下个单词的尾字符
            }
            return res.toString().trim(); // 转化为字符串并返回
        }
    }


    public static void main(String[] args) {
        String s = reverseWords("a good   example");
        System.out.println(s);
    }

}

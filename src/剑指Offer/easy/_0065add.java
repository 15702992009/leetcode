package 剑指Offer.easy;

/*

面试题65. 不用加减乘除做加法（位运算，清晰图解）

 */
public class _0065add {

    class Solution {
        public int add(int a, int b) {
            while (b != 0) { // 当进位为 0 时跳出
                int c = (a & b) << 1;  // c = 进位
                a ^= b; // a = 非进位和
                b = c; // b = 进位
            }
            return a;
        }
    }


}

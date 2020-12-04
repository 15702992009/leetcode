package 剑指Offer.medium;

public class _0064 {
    class Solution {

        public int sumNums(int n) {
            boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
            return n;

        }

    }
}

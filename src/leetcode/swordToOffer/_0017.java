package leetcode.swordToOffer;

public class _0017 {
    class Solution {
        public int[] printNumbers(int n) {
            //10^n -1
            int end=(int) Math.pow(10,n)-1;
            int[] res=new int[end];
            for (int i = 0; i < end; i++) {
                res[i]=i+1;
            }
            return res;

        }
    }
}

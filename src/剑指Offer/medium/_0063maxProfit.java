package 剑指Offer.medium;

/**
 * 分类： 动态规划
 */
public class _0063maxProfit {

    class Solution {
        public int maxProfit(int[] prices) {
            int min = Integer.MAX_VALUE, res = 0;
            for (int price : prices) {
                min = Math.min(price, min);
                res = Math.max(res, price - min);
            }
            return res;
        }
    }
}

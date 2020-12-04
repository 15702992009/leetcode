package 剑指Offer.medium;

/**
 * 分类： 动态规划
 */
public class _0047maxValue {

    class Solution {

        public int maxValue(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            //why +1
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    //注意grid i-1 j-1
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
                }
            }
            return dp[m][n];
        }


        public int maxValue1(int[][] grid) {
            int row = grid.length;
            int column = grid[0].length;
            //dp[i][j]表示从grid[0][0]到grid[i - 1][j - 1]时的最大价值
            int[][] dp = new int[row + 1][column + 1];
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= column; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
                }
            }
            return dp[row][column];
        }
    }

}

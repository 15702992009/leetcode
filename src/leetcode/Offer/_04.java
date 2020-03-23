package leetcode.Offer;

public class _04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows=matrix.length;
        int cols=matrix[0].length;
        int row=0;
        int col=cols-1;
        while(row<rows&&col>=0){
            if(target==matrix[row][col])
                return true;
            else if(matrix[row][col]>target)
                col--;
            else
                row++;
        }
        return false;
    }
}

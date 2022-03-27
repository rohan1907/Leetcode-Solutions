class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        dp[0] = matrix[0]; // row 0 is the same
        for(int i=1; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                dp[i][j] = matrix[i][j] + getMinFromAbove(dp, i, j, rows, cols);
            }
        }
        int minSum = Integer.MAX_VALUE;
        for(int sum: dp[rows-1]) {
            minSum = Math.min(minSum, sum);
        }
        return minSum;
    }
    public int getMinFromAbove(int[][] dp, int i, int j, int rows, int cols) {
        int minVal = Integer.MAX_VALUE;
        int leftUp = getVal(dp, i-1, j-1, rows, cols);
        int up = getVal(dp, i-1, j, rows, cols);
        int rightUp = getVal(dp, i-1, j+1, rows, cols);
        minVal = Math.min(Math.min(leftUp, up), rightUp);
        return minVal;
    }
    public int getVal(int[][] dp, int i, int j, int rows, int cols) {
        if(i < 0 || j < 0 || i >= rows || j >= cols) {
            return Integer.MAX_VALUE;
        }
        return dp[i][j];
    }
}
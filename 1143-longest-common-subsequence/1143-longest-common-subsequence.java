class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length(), m = text2.length();
        int dp[][] = new int[n+1][m+1];
        char arr1[] = text1.toCharArray();
        char arr2[] = text2.toCharArray();
        
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0) dp[i][j] =0;
                else if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
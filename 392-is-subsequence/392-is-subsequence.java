class Solution {
    public boolean isSubsequence(String s, String t) {
        int len1=s.length(), len2=t.length();
        int dp[][] = new int[len1+1][len2+1];
        
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return len1 == dp[len1][len2];
    }
}
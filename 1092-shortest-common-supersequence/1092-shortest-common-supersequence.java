class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n=str2.length();
        
        int dp[][] = new int[m+1][n+1];
        
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int i=m;
        int j=n;
        StringBuilder str = new StringBuilder();
        while(i>0 && j>0) {
            if(dp[i][j] == dp[i-1][j]) {
                str.append(str1.charAt(i-1));
                i--;
            } else if(dp[i][j] == dp[i][j-1]) {
                str.append(str2.charAt(j-1));
                j--;
            } else {
                str.append(str1.charAt(i-1));
                i--;
                j--;
            }
        }
        while(i-- > 0) {
            str.append(str1.charAt(i));
        }
        while(j-- > 0) {
            str.append(str2.charAt(j));
        }
        return str.reverse().toString();
        
    }
}
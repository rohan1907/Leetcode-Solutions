// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution obj = new Solution();
            long ans = obj.findRank(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long findRank(String S)
    {
        // Code here
        
        int n = S.length();
        int ans[] = new int[n];
        char arr[] = new char[n];
        char s[] = new char[n];
        for(int i = 0; i<n; i++){
            arr[i] = S.charAt(i);
            s[i] = S.charAt(i);
        }
        //sorted
        Arrays.sort(s);
        
        for(int i = 0;i<n;i++){
            char ch = arr[i];
            int c = 0;
            for(int j = 0;j<s.length;j++){
                if(s[j]==ch){
                    s[j] = '('; //take any Character other than alphabets
                    break;
                }
                if(s[j]!='('){
                    c++;
                }
            }
            ans[i] = c;
        }
        
        long f = 0;
        long res = 0;
        for(int i = ans.length-1;i>=0;i--){
            res += (long)ans[i]*fact(f);
            f++;
        }
        return res+1;
    }
    public long fact(long n){
        if(n==0){
            return 1;
        }else{
          return n*fact(n-1); 
        }
    }
}
// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String print(String st, int i, int j){
        return st.substring(i,j+1);
    }
     static String longestPalin(String S){
        int n = S.length();
       int end = 1, start =0;
      for(int i =0; i<n;i++){
          int l = i-1, h = i;
          while(l>=0 && h<n && S.charAt(l)==S.charAt(h))
           {
               if(h-l+1>end){
                   start = l;
                   end = h-l+1;
               }
               l--;
               h++;
           }
           l = i-1;
           h = i+1;
            while(l>=0 && h<n && S.charAt(l)==S.charAt(h))
           {
               if(h-l+1>end){
                   start = l;
                   end = h-l+1;
               }
               l--;
               h++;
           }
      }
      String str = print(S, start, start + end-1);
      return str;
        
    }
}
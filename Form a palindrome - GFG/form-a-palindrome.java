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
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
   int[][] arr;
   int findMinInsertions(String S){
       // code here
       arr = new int[S.length()][S.length()];
       String S2 = new StringBuilder(S).reverse().toString();
       
       return S.length()-lcs(S, S2, S.length()-1, S2.length()-1);
   }
   
   int lcs(String s1, String s2, int i, int j)
   {
       if(i<0 || j<0) return 0;
       if(arr[i][j] != 0) return arr[i][j];
       if(s1.charAt(i)==s2.charAt(j)) 
       {
           return arr[i][j] = (1 + lcs(s1, s2, i-1, j-1));
       }
       
       return arr[i][j] = Math.max(lcs(s1, s2, i-1, j), lcs(s1, s2, i, j-1));
   }
}
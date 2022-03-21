// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine();
            String B = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.minRepeats(A,B));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int minRepeats(String A, String B) {
        // code here
        int ct=1;
       int n = A.length(), m= B.length();
       StringBuilder s = new StringBuilder(A);
       
       while(ct<m/n+1 && s.indexOf(B)<0){
           s.append(A);
           ct++;
       }
       if(s.indexOf(B)<0){
           return -1;
       }
       return ct;
    }
};
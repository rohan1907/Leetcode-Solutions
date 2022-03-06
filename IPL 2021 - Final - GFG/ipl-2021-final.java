// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    static int findMaxLen(String S) {
        // code here
        Stack<Integer> st = new Stack<>();
        int i=0, ans=0, curr =0;
        
        while(i<S.length()){
            if(S.charAt(i) == '('){
                st.push(curr);
                curr=0;
            } else{
                if(st.size() == 0)
                    curr=0;
                else{
                    curr = curr+st.pop()+2;
                    ans = Math.max(ans,curr);
                }
            }
            i++;
        }
        return ans;
    }
};
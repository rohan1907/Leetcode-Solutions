// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();
			
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.increasingNumbers(N);
            for(int num : ans){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    private static ArrayList<Integer> output = new ArrayList<>();
    
    static ArrayList<Integer> increasingNumbers(int N){
        // code here
        output.clear();
        
        if (N == 1) output.add(0);
        followUp(0, 0, new char[N]);
        
        return output;
    }
    
    private static void followUp(int start, int index, char[] ch) {
        if (index == ch.length) {
            output.add(Integer.parseInt(String.valueOf(ch)));
            return;
        }
        
        for (int i = start+1 ; i < 10 ; i++) {
            ch[index] = (char)('0' + i);
            followUp(i, index+1, ch);
        }
    }
}
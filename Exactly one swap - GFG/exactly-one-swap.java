// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            long ans = ob.countStrings(S); 
            System.out.println(ans);
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long countStrings(String S) 
    { 
        // code here
        long a[]=new long[26];
        int y=0;
        long l=S.length();
        for(int i=0;i<l;i++)
        {
            char ch=S.charAt(i);
            a[ch-'a']++;
        }
        long sum=0;
       // System.out.println(Arrays.toString(a));
        long ans=(l*(l-1))/2;
       // System.out.println(ans);
        for(int i=0;i<26;i++)
        {
            if(a[i]>=2)
            {
                long l1=(a[i]*(a[i]-1))/(long)2;
                sum+=l1;
                y++;
            }
            
        }
        ans-=sum;
        if(sum>0)
        ans+=1;
        return ans;
    }
}
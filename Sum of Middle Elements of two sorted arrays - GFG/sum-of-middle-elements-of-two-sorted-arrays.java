// { Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

  public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] ar1 = new int[n], ar2 = new int[n];
            String[] inputLine = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                ar1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                ar2[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().findMidSum(ar1, ar2, n));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    int findMidSum(int[] ar1, int[] ar2, int n) {
        // code here
            int i=0;
            int j=0;
            
            if(n==1)
            {
                return ar1[0]+ar2[0];
            }
            int mid = (n*2)/2;
            int c=0;
            int sum=0;
            int flag=0;
            while(i<n && j<n)
            {
                if(ar1[i]<=ar2[j])
                {
                    if(c==mid-1)
                    {
                        sum += ar1[i];
                    }
                    else if(c==mid)
                    {
                        sum+= ar1[i];
                        flag=1;
                        break;
                    }
                    i++;
                    c++;
                }
                else if (ar1[i]>ar2[j])
                {
                    if(c==mid-1)
                    {
                        sum+=ar2[j];
                    }
                    else if(c==mid)
                    {
                        sum+=ar2[j];
                        flag=1;
                        break;
                    }
                    j++;
                    c++;
                }
            }
            
            if(flag==0 && ar1[n-1]<=ar2[0])
            {
                sum+=ar2[0];
            }
            else if(flag==0 && ar2[n-1]<=ar1[0])
            {
                sum+=ar1[0];
            }
            return sum;
    }
}
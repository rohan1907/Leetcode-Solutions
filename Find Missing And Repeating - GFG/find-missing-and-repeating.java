// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solve {
    
    int[] findTwoElement(int arr[], int n) {
        
        
      int[]a=new int[n+1];
      int repeat=0;
      for(int i=0;i<n;i++)
      {
          if(a[arr[i]]==0)
          {
              a[arr[i]]=1;
          }
          else
          {
              repeat=arr[i];
          }
      }
      int absent=0;
       
      for(int i=1;i<=n;i++)
      {
          if(a[i]==0)
          {
              absent=i;
              break;
          }
      }
      int b[]=new int[2];
      b[0]=repeat;
      b[1]=absent;
      return b;
        
        
        
    }
}
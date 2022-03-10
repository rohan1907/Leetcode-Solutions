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
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.sevenSegments(S,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static String sevenSegments(String S, int n) {
        // code here
        int arr1[]={6,2,5,5,4,5,6,3,7,5};
        int sum=0;
        for(int i=0;i<n;i++){
            int ch=S.charAt(i)-'0';
            sum+=arr1[ch];
        }
        int arr[]=new int[n];
        Arrays.fill(arr,2);
         sum-=n*2;
         int i1=0;
        while(sum>=4&&i1<n){
            arr[i1]+=4;
            sum-=4;
            i1++;
        }
        int j=n-1;
        while(sum>0&&j>=0){
           int req=7-arr[j];
           req=Math.min(req,sum);
            arr[j]+=req;
            sum-=req;
            j--;
        }
        String s="";
        for(int i=0;i<n;i++){
            if(arr[i]==6) s+=0;
            else if(arr[i]==2) s+=1;
            else if(arr[i]==5) s+=2;
            else if(arr[i]==4) s+=4;
            else if(arr[i]==3) s+=7;
            else s+=8;
        }
        return s.trim();
    }
};
// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    static class FastReader{ 
		BufferedReader br; 
		StringTokenizer st; 
  
		public FastReader(){ 
			br = new BufferedReader(new InputStreamReader(System.in)); 
		} 
  
		String next(){ 
			while (st == null || !st.hasMoreElements()){ 
				try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
			} 
			return st.nextToken(); 
		} 
  
		String nextLine(){ 
			String str = ""; 
			try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
			return str; 
		} 
		
		int nextInt(){
		    return Integer.parseInt(next());
		}
	}
	
    public static void main(String args[])throws IOException
    {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i = 0;i < n;i++)
                arr[i] = sc.nextInt();
            int q = sc.nextInt();
            int queries[] = new int[2*q];
            for(int i = 0;i < 2*q;i++)
                queries[i] = sc.nextInt();
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.querySum(n, arr, q, queries);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < ans.size();i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
        // code here
    List<Integer> querySum(int n, int arr[], int q, int queries[])
   {
       List<Integer> sumList = new ArrayList<Integer>();
       for(int j = 0; j < queries.length; j+=2){
           int left = queries[j];
           int right = queries[j+1];
           sumList.add(findSumFromLR(arr, left, right));
       }
       
       return sumList;
   }
   
   int findSumFromLR(int arr[], int left, int right) {
       int sum = 0;
       
       for(int i = left-1; i <= right - 1; i++) {
           sum+= arr[i];
       }
       return sum;
   }
}
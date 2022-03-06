// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out = new PrintWriter(System.out);
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
        	int N = Integer.parseInt(br.readLine()); 
        	int[] Arr = new int[N];
        	String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
        	for(int i=0; i<N; i++)
        	{
        		Arr[i] = Integer.parseInt(strs[i]); 
        	}
        	

            Solution ob = new Solution();
			int[] ans = ob.farNumber(N,Arr);
  
            for(int i=0; i<ans.length; i++)
                out.print(ans[i] + " ");
            out.println();

            t--;
        }
        out.flush();
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    
    private static int bin_search(int x, int arr[], int s_arr[])
    {
        int low = x+1;
        int high = arr.length-1;
        
        while(low<=high)
        {
            int mid = (low+high)/2;
            
            if(arr[s_arr[mid]]<arr[x])
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        
        if(high==x) return -1;
        
        return s_arr[high];
        
        
    }
    
    static int[] farNumber(int n, int arr[])
	{    
	    int suffix_arr[] = new int[n];
	    
	    suffix_arr[n-1] = n-1;
	    
	    for(int i=n-2; i>=0; i--)
	    {
	        if(arr[i]<arr[suffix_arr[i+1]])
	        {
	            suffix_arr[i] = i;
	        }
	        else
	        {
	            suffix_arr[i] = suffix_arr[i+1];
	        }
	        
	    }
	    
	    int ans[] = new int[n];
	    
	    for(int i=0; i<n; i++)
	    {
	        ans[i] = bin_search(i, arr, suffix_arr);
	    }
	    
	    
	    return ans;
	    
        
	}
} 
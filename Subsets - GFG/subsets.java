// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    ArrayList<Integer> A = new ArrayList<Integer>();
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		        A.add(arr[i]);
		        
		    }
		   
		   
		    
		    ArrayList <ArrayList<Integer>> res = new Solution().subsets(A);
		    for (int i = 0; i < res.size (); i++)
		    {
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		          System.out.print(res.get(i).get(j)+" ");
		        }
		        System.out.println();
		      
		    }
		    //System.out.println();
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static class MIN implements Comparator<ArrayList<Integer>>
    {
        public int compare(ArrayList<Integer> a,ArrayList<Integer> b)
        {
            for(int i=0;i<Math.min(a.size(),b.size());i++)
            {
                if(a.get(i)>b.get(i)) return 1;
                else if(a.get(i)<b.get(i)) return -1;
                else continue;
            }
            return a.size()-b.size();
        }
    }
    
    // static HashSet<ArrayList<Integer>> map;
    static void helper(ArrayList<Integer> temp,int ind , ArrayList<Integer> A, ArrayList<ArrayList<Integer>> res){
        if(ind == A.size()){
            res.add(new ArrayList<>(temp));
            if(temp.size()-1 >= 0)
            	temp.remove(temp.size()-1);
            return;
        }
        ArrayList<Integer> t1 = temp;
        t1.add(A.get(ind));
        helper(temp,ind + 1,A, res);
        helper(t1,ind  + 1,A, res);
    }
    
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> superSet){
        //code here
	    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	    ArrayList<Integer> t1 = new ArrayList<>();
	    helper(t1,0,superSet, res);
	    Collections.sort(res,new MIN());
        return res;
    }
}
// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.HashMap; 
import java.util.HashSet; 

class GFG{
	public static void main(String args[]) throws IOException { 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
       		int rows=sc.nextInt();
       		int columns=sc.nextInt();
			
			int matrix[][]=new int[rows][columns];
          
        	for(int i=0; i<rows;i++){            
            	for(int j=0; j<columns;j++){
                	matrix[i][j]=sc.nextInt();
            	}
         	}

			Solution x = new Solution();
			if (x.ValidCorner(matrix)) 
				System.out.println("Yes"); 
			else
				System.out.println("No"); 
			t--;
		}
	} 
}
	


// } Driver Code Ends


//User function Template for Java

public class Solution { 
	static boolean ValidCorner(int matrix[][]) 
	{ 
	    // Your code goes here
	    for(int i=0;i<matrix.length;i++)
           for(int j=0;j<matrix[i].length;j++)
               if(matrix[i][j]==1)
                   for(int r=j+1;r<matrix[i].length;r++)
                       if(matrix[i][r]==1)
                           for(int x=i+1;x<matrix.length;x++)
                               if(matrix[x][j]==1 && matrix[x][r]==1)
                                   return true;
       return false;
	}
}
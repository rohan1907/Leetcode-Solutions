// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" "); 
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            
            int[][] mat = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String St[] = read.readLine().split(" "); 
                for(int j=0; j<M; j++)
                {
                    mat[i][j] = Integer.parseInt(St[j]);
                }
            }
            
            Solution ob = new Solution();
            int[][] before = ob.computeBeforeMatrix(N,M,mat);
            for(int i=0; i<N;i++){
                for(int j = 0; j<M;j++){
                    out.print(before[i][j]);
                    out.print(' ');
                    
                }
                out.println();
            }
        }
        out.flush();
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    public int[][] computeBeforeMatrix(int n, int m,int[][] after ){
        // Code here
    int before[][] = new int[n][m];
      before[0][0] = after[0][0];
      for(int i=1; i<m; i++)
         before[0][i] = after[0][i]-after[0][i-1];
         
      for(int j=1; j<n; j++)
         before[j][0] = after[j][0]-after[j-1][0];  
         
      int psum=0;
      for(int i=1; i<n; i++){
         psum = before[i][0];
         for(int j=1; j<m; j++){
            before[i][j] = after[i][j] - (after[i-1][j] + psum);
            psum += before[i][j];
        } 
      }
      return before;
    }
}
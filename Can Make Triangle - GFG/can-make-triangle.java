// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 

class FastReader{ 
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
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
}

class GFG{
    public static void main(String args[]) throws IOException { 
        FastReader read = new FastReader();
        int t = read.nextInt();
        PrintWriter out = new PrintWriter(System.out);
        while(t-- > 0){
            int N = read.nextInt();
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = read.nextInt();

            Solution ob = new Solution();
            int ans[] = ob.canMakeTriangle(A, N); 
            for (int i=0;i<ans.length;i++) 
                out.print(ans[i]+" "); 
            out.println();
        }
        out.flush();
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int[] canMakeTriangle(int arr[], int n) 
   { 
       // code here
       int[] ans = new int[n-2];
       Arrays.fill(ans, -1);
       for(int i = 0;i<n-2;i++) {
           if(arr[i]+arr[i+1] > arr[i+2] 
           && arr[i]+arr[i+2] > arr[i+1]
           && arr[i+1]+arr[i+2] > arr[i]) ans[i] = 1;
           else ans[i] = 0;
       }
       return ans;
   }
}
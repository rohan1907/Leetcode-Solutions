// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            int numbers[]= new int[N];
            for(int i = 0; i < N; i++)
                numbers[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            long ans = ob.countPairs(N, X, numbers); 
            System.out.println(ans);
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long countPairs(int n, int x, int numbers[]) 
    { 
        Map<String, Integer> mp=new HashMap<>();
        for(int i: numbers){
            mp.put(Integer.toString(i), mp.getOrDefault(Integer.toString(i),0)+1);
        }
        String st=Integer.toString(x);
        long cnt=0;
        
        for(int i=1;i<st.length();i++){
            String fs=st.substring(0,i);
            String ss=st.substring(i);
            if(mp.containsKey(fs) && mp.containsKey(ss)){
                if(fs.equals(ss)){
                    int k=mp.get(fs);
                    cnt+=(long)(k*(k-1));
                }else{
                    cnt+=(long)(mp.get(fs)*mp.get(ss));
                }
            }
        }
        return cnt;
    }
}
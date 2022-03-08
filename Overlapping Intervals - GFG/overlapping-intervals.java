// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    public int[][] overlappedInterval(int[][] Intervals)
    {
        // Code here // Code here
        Arrays.sort(Intervals, (a,b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> a = new ArrayList<int[]>();
       a.addAll(Arrays.asList(Intervals));
       
       int i = 0;
       while(true){
           if(i >= a.size()-1){
               break;
           }
           if(a.get(i)[1]>= a.get(i+1)[0]){
               
               if(a.get(i)[1]>=a.get(i+1)[1]){
                   a.remove(i+1);
               }else{
                   int[] newArr = new int[2];
                   newArr[0] = a.get(i)[0];
                   newArr[1] = a.get(i+1)[1];
                   
                   a.remove(i+1);
                   a.remove(i);
                   a.add(i, newArr);
               }
           }else{
               i++;
           }
       }
       int[][] ans = new int[a.size()][2];
       for(int j = 0; j < a.size(); j++){
           ans[j][0] = a.get(j)[0];
           ans[j][1] = a.get(j)[1];
       }
       return ans;
    }
}
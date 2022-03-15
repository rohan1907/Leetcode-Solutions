// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}

// } Driver Code Ends


class Solution {
    static Set<String> result;
    public List<String> find_permutation(String S) {
        // Code here
        result = new TreeSet<>();
        generatePermutations(S, "");
        return new ArrayList<>(result);
    }
    public void generatePermutations(String input, String output) {
        
        if(input.length() == 0) {
            result.add(output);
        }
        
        for(int i=0; i<input.length(); i++) {
            String newInput = input.substring(0, i) + input.substring(i+1);
            String newOutput = output + input.charAt(i);
            generatePermutations(newInput, newOutput);
        }
    }
}
// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
         List<Integer> pointers = Arrays.asList(-1, -1, -1);
        int smallest = -1;
        for (int i = 0; i < S.length(); i++) {
            // set the curr char in pointer
            // subtracting '0' converts to int
            pointers.set(S.charAt(i)-'0', i);
            int min = Collections.min(pointers);
            int max = Collections.max(pointers);
            // if min is -1, missing a char, keep looking
            if (min > -1) {
                int size = max - min + 1;
                // if we havent found a smallest yet, set it to size.
                if (smallest == -1) {
                    smallest = size;
                } else {
                    // otherwise, get the min of the two.
                    smallest = Math.min(smallest, size);
                }
                if (smallest == 3) return smallest; // can break here early
            }
        }
        return smallest;
    }
};

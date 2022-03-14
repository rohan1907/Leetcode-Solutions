class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = Integer.MIN_VALUE;
        int prev = values[0]+0;
        
        for(int j=1;j<values.length;j++){
            ans = Math.max(ans, prev+values[j]-j);
            prev = Math.max(prev, values[j]+j);
        }
        return ans;
    }
}
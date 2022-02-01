class Solution {
    public int maxProfit(int[] prices) {
        int minimal = Integer.MAX_VALUE, profit=0;
        for(int ele:prices){
            if(ele<minimal) minimal = ele;
            if(ele-minimal>profit) profit = ele-minimal;
        }
        return profit;
    }
}
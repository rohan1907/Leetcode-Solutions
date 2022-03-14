class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int currBuy = prices[0];
        for(int i=0;i<prices.length;i++){
            if(prices[i] > currBuy){
                profit += prices[i] - currBuy;
                currBuy = prices[i];
            }else{
                currBuy = prices[i];
            }
        }
        return profit;
    }
}
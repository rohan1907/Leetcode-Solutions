

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] t = new int[coins.length+1][amount+1];
        for(int j=0;j<amount+1;j++){
          t[0][j] = Integer.MAX_VALUE - 1;
        }
        for(int i=0;i<coins.length+1;i++){
          t[i][0] = 0;
        }
        for(int i=1;i<coins.length+1;i++){
          for(int j=1;j<amount+1;j++){
            if(j>=coins[i-1]){
              t[i][j] = Math.min(t[i-1][j], 1+t[i][j-coins[i-1]]);
            }else{
              t[i][j] = t[i-1][j];
            }
          }
        }
        return t[coins.length][amount] ==Integer.MAX_VALUE - 1? -1: t[coins.length][amount];
      }
}
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n==1)
            return cost[0];
        if(n == 2)
            return Math.min(cost[0],cost[1]);
        int f1=cost[0], f2=cost[1];
        
        for(int i=2;i<cost.length;i++){
            int cst = cost[i] + Math.min(f1, f2);
            f1 = f2;
            f2 = cst;
        }
        return Math.min(f1,f2);
    }
}
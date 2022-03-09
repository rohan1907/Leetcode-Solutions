class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0],nums[1]);
        
        int rob1 = 0, rob2=0;
        
        for(int i=0;i<nums.length;i++){
            int curr = nums[i]+rob1 > rob2 ? nums[i]+rob1 : rob2;
            rob1 = rob2;
            rob2 = curr;
        }
        return rob2;
    }
}
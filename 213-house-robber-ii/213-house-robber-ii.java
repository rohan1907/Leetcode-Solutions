class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return nums[0]>nums[1] ? nums[0]:nums[1];
        
        
        int rob1 = robHouse(0,nums.length-1,nums);
        int rob2 = robHouse(1, nums.length, nums);
        return rob1>rob2 ? rob1:rob2;
    }
    public int robHouse(int i, int j, int[] nums){
        int rob1 = 0, rob2 = 0;
        for(int k= i;k<j;k++){
            int curr = Math.max(nums[k]+rob1, rob2);
            rob1 = rob2;
            rob2 = curr;
        }
        return rob2;
    }
    
}
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        int maxLen = 0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0) count--;
            else count++;
            if(!map.containsKey(count)){
                map.put(count,i);
            }
            
            else if(map.containsKey(count)){
                maxLen = Math.max(maxLen, i - map.get(count));
            }
            
            
        }
        return maxLen;
    }
}
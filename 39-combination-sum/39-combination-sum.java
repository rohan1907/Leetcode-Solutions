class Solution {
    
    List<List<Integer>> ans;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        int n=candidates.length;
        ArrayList<Integer> li = new ArrayList<>();
        helper(0,n, target,candidates, li);
        return ans;
    }
    
    void helper(int ind, int n, int target,int[] candidates, ArrayList<Integer> li){
        if(target == 0){
            ans.add(new ArrayList(li));
            return;
        }
        if(ind>=n || target<0)
            return;
        
        
        
        li.add(candidates[ind]);
        helper(ind, n, target-candidates[ind], candidates, li);
        li.remove(li.size()-1);
        helper(ind+1, n, target, candidates, li);
            
    }
}
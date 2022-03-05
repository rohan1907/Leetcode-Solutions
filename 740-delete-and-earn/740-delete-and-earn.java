class Solution {
    public int deleteAndEarn(int[] nums) {
        
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int ele: nums){
            mp.put(ele,mp.getOrDefault(ele,0)+1);
        }
        
        List<Integer> st = new ArrayList<Integer>(mp.keySet());
        Collections.sort(st);
        int earn1 = 0, earn2 = 0;
        for(int i=0; i<st.size();i++){
            int ele = st.get(i);
            int currEarn = ele*mp.get(ele);
            if (i>0 && st.get(i) == st.get(i-1)+1){
                int temp = earn2;
                earn2 = Math.max(currEarn+earn1, earn2);
                earn1 = temp;
            }
            else{
                int tmp = earn2;
                earn2 = earn2+currEarn;
                earn1 = tmp;
            }
        }
        return earn2;
    }
}
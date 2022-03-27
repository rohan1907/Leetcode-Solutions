class Solution {
    public int numTrees(int n) {
        int ans=1;
        for(int i=0;i<n;i++){
            ans*=(4*i+2)/(i+2.);
        }
        return ans;
    }
    // long ncr(int n, int r){
    //     int ans = 1;
    //     for(int i=0;i<r;i++){
    //         ans*=n-i;
    //         ans/=i+1;
    //     }
    //     return ans;
    // }
    
}


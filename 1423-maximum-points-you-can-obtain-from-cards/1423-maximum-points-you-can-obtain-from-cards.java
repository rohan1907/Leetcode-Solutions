class Solution {
    public int maxScore(int[] cardPoints, int k) {
    int left=0,right=0;
    for(int i=cardPoints.length-1;i>=cardPoints.length-k;i--) {
        right+=cardPoints[i];
    }
    int result = right;
    int i=-1;
    int j=cardPoints.length-k-1;
    for(int m=1;m<=k;m++) {
        i++;j++;
        left+=cardPoints[i];
        right-=cardPoints[j];
        result = Math.max(result, left+right);
    }
    return result;
    }
}